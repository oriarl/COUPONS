package com.example.demo.DBDAO;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.CouponType;
import com.example.demo.entities.Company;
import com.example.demo.entities.Coupon;
import com.example.demo.exceptions.CompaniesNotFoundException;
import com.example.demo.exceptions.CompanyExistException;
import com.example.demo.exceptions.CompanyNotFoundException;
import com.example.demo.exceptions.CouponsNotFoundException;
/***
 * Data Base Data Access Object for Company
 * @author Oria
 *
 */
@Service
public class CompanyDBDAO  implements CompanyDAO{
	
	// Object's members
	@Autowired
	private CompanyRepo compRepo;
	
	@Autowired
	private CouponRepo coupRepo;

	/**
	 * Creating new Company
	 */
	@Override
	public void createCompany(Company company) throws CompanyExistException {
		compRepo.save(company);
	}

	/***
	 * Removing Company by ID
	 */
	@Override
	public void removeCompany(int companyId) throws CompanyNotFoundException {
		compRepo.delete(companyId);
	}

	/***
	 * Updating Company Set only password & email by ID
	 * @param password
	 * @param email
	 * @param companyId
	 */
	@Override
	public void updateCompany(String password, String email, int companyId) throws CompanyNotFoundException {
		compRepo.updateCompany(password, email, companyId);
	}

	/***
	 * Get Company by ID
	 */
	@Override
	public Company getCompany(int companyId) throws CompanyNotFoundException {
		return compRepo.findOne(companyId);
	}

	/***
	 * Get Company by Name
	 * @param companyName
	 * @return Company
	 */
	public Company getCompanyByName(String companyName)
	{
		return compRepo.findBycompanyName(companyName);
	}
	
	/***
	 * Get Company by name & password
	 * @param compnyName
	 * @param password
	 * @return Company
	 */
	public Company getCompanyByNameAndPassword(String companyName , String password)
	{
		return compRepo.findBycompanyNameAndPassword(companyName, password);
	}
	
	/***
	 * Get All Companies
	 */
	@Override
	public ArrayList<Company> getAllCompanies() throws CompaniesNotFoundException {
		return (ArrayList<Company>) compRepo.findAll();
	}

	/***
	 * Get Company Coupon by ID
	 * @param companyId
	 * @return Coupon
	 */
	public Coupon getCompanyCoupon(int couponId , int companyId)
	{
		return coupRepo.findByidAndCompanyId(couponId, companyId);
	}
	
	/***
	 * Get All Company's Coupons
	 */
	@Override
	public ArrayList<Coupon> getCoupons(int companyId) throws CouponsNotFoundException ,CompanyNotFoundException {
		return coupRepo.findByCompanyId(companyId);
	}
	
	/***
	 * Get Company's Coupons by type
	 * @param type
	 * @param companyId
	 * @return ArrayList<Coupon>
	 * @throws CouponsNotFoundException
	 * @throws CompanyNotFoundException
	 */
	public ArrayList<Coupon> getCompanyCouponsByType(CouponType type , int companyId)throws CouponsNotFoundException , CompanyNotFoundException
	{
		return coupRepo.findBytypeAndCompanyId(type, companyId);
	}

	/***
	 * Login Method for Company return boolean
	 */
	@Override
	public boolean login(String compName, String password) {
		Company check = compRepo.findBycompanyNameAndPassword(compName, password);
		// Checking if exist
		if(check == null)
		{
			return false;
		}
		
		return true;
	}

	
}