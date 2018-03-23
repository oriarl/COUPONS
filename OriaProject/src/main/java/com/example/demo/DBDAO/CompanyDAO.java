package com.example.demo.DBDAO;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Company;
import com.example.demo.entities.Coupon;
import com.example.demo.exceptions.CompaniesNotFoundException;
import com.example.demo.exceptions.CompanyExistException;
import com.example.demo.exceptions.CompanyNotFoundException;
import com.example.demo.exceptions.CouponsNotFoundException;
/***
 * Data Access Object for Company
 * @author Oria
 *
 */
@Service
public interface CompanyDAO {

	/***
	 * Creating new Company
	 * @param company
	 * @throws CompanyExistException
	 */
	void createCompany(Company company)throws CompanyExistException;

	/***
	 * Removing Company by ID
	 * @param companyId
	 * @throws CompanyNotFoundException
	 */
	void removeCompany(int companyId)throws CompanyNotFoundException;

	/***
	 * Updating Company set only password & email by ID
	 * @param password
	 * @param email
	 * @param companyId
	 * @throws CompanyNotFoundException
	 */
	void updateCompany(String password , String email , int companyId)throws CompanyNotFoundException;

	/***
	 * Get Company by ID
	 * @param companyId
	 * @return Company
	 * @throws CompanyNotFoundException
	 */
	Company getCompany(int companyId)throws CompanyNotFoundException;

	/***
	 * Get all Companies
	 * @return ArrayList<Company>
	 * @throws CompaniesNotFoundException
	 */
	ArrayList<Company> getAllCompanies()throws CompaniesNotFoundException;

	/***
	 * Get all Coupons
	 * @param companyId
	 * @return ArrayList<Company>
	 * @throws CouponsNotFoundException
	 * @throws CompanyNotFoundException
	 */
	ArrayList<Coupon> getCoupons(int companyId)throws CouponsNotFoundException , CompanyNotFoundException;

	/***
	 * Login method for Company
	 * @param compName
	 * @param password
	 * @return true if exist
	 */
	boolean login(String compName, String password);

}