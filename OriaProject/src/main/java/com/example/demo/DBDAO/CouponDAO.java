package com.example.demo.DBDAO;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.common.CouponType;
import com.example.demo.entities.Coupon;
import com.example.demo.exceptions.CompanyNotFoundException;
import com.example.demo.exceptions.CouponExistException;
import com.example.demo.exceptions.CouponNotFoundException;
import com.example.demo.exceptions.CouponsNotFoundException;

/***
 * Data Access Object for Coupon
 * @author Oria
 *
 */
@Service
public interface CouponDAO {
	
	/***
	 * Creating new Coupon by its Company
	 * @param coupon
	 * @param companyId
	 * @throws CouponExistException
	 * @throws CompanyNotFoundException
	 */
	void createCoupon(Coupon coupon , int companyId)throws CouponExistException , CompanyNotFoundException;

	/***
	 * Removing Coupon by its Company
	 * @param couponId
	 * @param companyId
	 * @throws CouponNotFoundException
	 * @throws CompanyNotFoundException
	 */
	void removeCoupon(int couponId , int companyId)throws CouponNotFoundException , CompanyNotFoundException;

	/***
	 * Update Coupon set only endDate & price by ID & its Company
	 * @param endDate
	 * @param price
	 * @param couponId
	 * @param companyId
	 * @throws CouponNotFoundException
	 * @throws CompanyNotFoundException
	 */
	void updateCoupon(Date endDate , double price ,int couponId,  int companyId)throws CouponNotFoundException , CompanyNotFoundException;

	/**
	 * Get Coupon by ID
	 * @param couponId
	 * @return Coupon
	 * @throws CouponNotFoundException
	 */
	Coupon getCoupon(int couponId)throws CouponNotFoundException;

	/***
	 * Get all Coupons
	 * @return ArrayList<Coupon>
	 * @throws CouponsNotFoundException
	 */
	ArrayList<Coupon> getAllCoupons()throws CouponsNotFoundException;

	/***
	 * Get all Coupons by type
	 * @param type
	 * @return ArrayList<Coupon>
	 * @throws CouponNotFoundException
	 */
	ArrayList<Coupon> getCouponByType(CouponType type)throws CouponNotFoundException;

}
