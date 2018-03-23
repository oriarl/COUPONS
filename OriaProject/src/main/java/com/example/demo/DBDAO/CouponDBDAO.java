package com.example.demo.DBDAO;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.CouponType;
import com.example.demo.entities.Company;
import com.example.demo.entities.Coupon;
import com.example.demo.exceptions.CompanyNotFoundException;
import com.example.demo.exceptions.CouponExistException;
import com.example.demo.exceptions.CouponNotFoundException;
import com.example.demo.exceptions.CouponsNotFoundException;

/***
 * Data Base Data Access Object for Company
 * @author Oria
 *
 */
@Service
public class CouponDBDAO implements CouponDAO {

	// Object's members
	@Autowired
	private CouponRepo coupRepo;
	@Autowired
	private CompanyRepo compRepo;
	
	/***
	 * Creating new Coupon
	 */
	@Override
	public void createCoupon(Coupon coupon, int companyId) throws CouponExistException, CompanyNotFoundException {
		Company father = compRepo.findOne(companyId);
		coupon.setCompany(father);
		coupRepo.save(coupon);
		
	}

	/***
	 * Remove Coupon
	 */
	@Override
	public void removeCoupon(int couponId, int companyId) throws CouponNotFoundException, CompanyNotFoundException {
		coupRepo.removeCoupon(couponId, companyId);
		
	}

	/***
	 * Removing all Company's Coupons
	 * @param companyId
	 * @throws CompanyNotFoundException
	 */
	public void removeAllCompanyCoupons(int companyId)throws CompanyNotFoundException
	{
		coupRepo.removeAllCompanyCoupons(companyId);
	}
	
	/***
	 * Updating Coupon Set only endDate  & price 
	 */
	@Override
	public void updateCoupon(Date endDate, double price, int couponId , int companyId)
			throws CouponNotFoundException, CompanyNotFoundException {
		coupRepo.updateCoupon(endDate, price, couponId, companyId);
		
	}

	/***
	 * Get Coupon by ID
	 */
	@Override
	public Coupon getCoupon(int couponId) throws CouponNotFoundException {
		return coupRepo.findOne(couponId);
	}

	/***
	 * Get Coupon by title
	 * @param title
	 * @return Coupon
	 */
	public Coupon getCouponByTitle(String title)
	{
		return coupRepo.findBytitle(title);
	}
	
	/***
	 * Get all Coupons
	 */
	@Override
	public ArrayList<Coupon> getAllCoupons() throws CouponsNotFoundException {
		ArrayList<Coupon> allCoupons = (ArrayList<Coupon>) coupRepo.findAll();
		return allCoupons;
	}

	/***
	 * Get All Coupons by type
	 */
	@Override
	public ArrayList<Coupon> getCouponByType(CouponType type) throws CouponNotFoundException {
		return coupRepo.findBytype(type);
	}
	
}
