package com.example.demo.DBDAO;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.CouponType;
import com.example.demo.entities.Coupon;
import com.example.demo.entities.Customer;
import com.example.demo.exceptions.CouponNotFoundException;
import com.example.demo.exceptions.CouponsNotFoundException;
import com.example.demo.exceptions.CustomerExistException;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.exceptions.CustomersNotFoundException;
/***
 * Data Base Data Access Object for Customer
 * @author Oria
 *
 */
@Service
public class CustomerDBDAO implements CustomerDAO {

	// Object's members
	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private CouponRepo coupRepo;
	
	/***
	 * Creating new Customer
	 */
	@Override
	public void createCustomer(Customer customer) throws CustomerExistException {
		custRepo.save(customer);
	}

	/***
	 * Removing Customer by ID
	 */
	@Override
	public void removeCustomer(int customerId) throws CustomerNotFoundException {
		custRepo.delete(customerId);
	}

	/***
	 * Updating Customer set only password by ID
	 * @param password
	 * @param customerId
	 */
	@Override
	public void updateCustomer(String password, int customerId) throws CustomerNotFoundException {
		custRepo.updateCustomer(password, customerId);
	}

	/***
	 * Get Customer by ID
	 */
	@Override
	public Customer getCustomer(int customerId) throws CustomerNotFoundException {
		return custRepo.findOne(customerId);
	}
	
	/***
	 * Get Customer by name
	 * @param custName
	 * @return Customer
	 */
	public Customer getCustomerByName(String custName)
	{
		return custRepo.findBycustName(custName);
	}
	
	/***
	 * Get Customer by name & password
	 * @param custName
	 * @param password
	 * @return Customer
	 */
	public Customer getCustomerByNameAndPassword(String custName, String password)
	{
		return custRepo.findBycustNameAndPassword(custName, password);
	}

	/***
	 * Get All Customers
	 */
	@Override
	public ArrayList<Customer> getAllCustomers() throws CustomersNotFoundException {
		return (ArrayList<Customer>) custRepo.findAll();
	}
	
	/**
	 * Get Customer Coupon
	 * @param couponId
	 * @param customerId
	 * @return Coupon
	 */
	public Coupon getCustomerCoupon(int couponId , int customerId)
	{
		return coupRepo.findByidAndCustomersId(couponId, customerId);
	}

	/***
	 * Get Customer's Coupons
	 */
	@Override
	public ArrayList<Coupon> getCoupons(int customerId) throws CouponsNotFoundException, CustomerNotFoundException{
		return coupRepo.findByCustomersId(customerId);
	}

	/***
	 * Get Customer's Coupons by type
	 * @param type
	 * @param customerId
	 * @return ArrayList<Coupon>
	 * @throws CustomerNotFoundException
	 * @throws CouponsNotFoundException
	 */
	public ArrayList<Coupon> getCouponsByType(CouponType type , int customerId)throws CustomerNotFoundException , CouponsNotFoundException
	{
		return coupRepo.findBytypeAndCustomersId(type, customerId);
	}
	
	/***
	 * Get Customer's Coupons by price
	 * @param price
	 * @param customerId
	 * @return ArrayList<Coupon>
	 */
	public ArrayList<Coupon> getCouponsByPrice(double price , int customerId)throws CustomerNotFoundException , CouponsNotFoundException
	{
		return coupRepo.findCustomerCouponsByPrice(customerId, price);
	}
	/***
	 * Login method for Customer return boolean
	 */
	@Override
	public boolean login(String custName, String password) {
		Customer check = custRepo.findBycustNameAndPassword(custName, password);
		// Checking if exist
		if(check == null)
		{
			return false;
		}
		return true;
	}
	
	/***
	 * Purchasing Coupon
	 * @param customerId
	 * @param coupoId
	 * @throws CustomerNotFoundException
	 * @throws CouponsNotFoundException
	 */
	public void purchaseCoupon(int customerId , int couponId)throws CustomerNotFoundException , CouponNotFoundException
	{
		custRepo.insertCustomerCoupon(customerId, couponId);
		coupRepo.updateAmount(couponId);;
	}
	
}
