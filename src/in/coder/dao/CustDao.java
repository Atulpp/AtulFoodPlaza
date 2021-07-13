package in.coder.dao;

import java.util.List;

import in.coder.pojo.Customer;
import in.coder.pojo.Food;

public interface CustDao {
	boolean addCust(Customer c);
	boolean updateCust(Customer c);
	boolean deleteCustById(int cId);

	Customer displayCustById(int custId);
	List<Customer> displayAllCust();
	Customer searchCustomerByEmail(String custEmail);

}
