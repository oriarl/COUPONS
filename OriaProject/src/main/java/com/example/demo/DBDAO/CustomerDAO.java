package com.example.demo.DBDAO;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Coupon;
import com.example.demo.entities.Customer;
import com.example.demo.exceptions.CouponsNotFoundException;
import com.example.demo.exceptions.CustomerExistException;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.exceptions.CustomersNotFoundException;
/***
 * Data Access Object for Customer
 * @author Oria
 *
 */
@Service
public interface CustomerDAO {

	/***
	 * Creating new Customer
	 * @param customer
	 * @throws CustomerExistException
	 */
	void createCustomer(Customer customer)throws CustomerExistException;

	/***
	 * Removing Customer by ID
	 * @param customerId
	 * @throws CustomerNotFoundException
	 */
	void removeCustomer(int customerId)throws CustomerNotFoundException;

	/***
	 * Updating Customer set only password by ID 
	 * @param password
	 * @param customerId
	 * @throws CustomerNotFoundException
	 */
	void updateCustomer(String password , int customerId)throws CustomerNotFoundException;

	/***
	 * Get Customer by ID
	 * @param customerId
	 * @return Customer
	 * @throws CustomerNotFoundException
	 */
	Customer getCustomer(int customerId)throws CustomerNotFoundException;

	/***
	 * Get all Customers
	 * @return ArrayList<Customer>
	 * @throws CustomersNotFoundException
	 */
	ArrayList<Customer> getAllCustomers() throws CustomersNotFoundException;

	/***
	 * Get all Customer's Coupons
	 * @param customerId
	 * @return ArrayList<Coupon>
	 * @throws CouponsNotFoundException
	 * @throws CustomerNotFoundException
	 */
	ArrayList<Coupon> getCoupons(int customerId)throws CouponsNotFoundException , CustomerNotFoundException;

	/***
	 * Login method for Customers
	 * @param custName
	 * @param password
	 * @return true if exist
	 */
	boolean login(String custName, String password);

}
