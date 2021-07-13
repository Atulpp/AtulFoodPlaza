package in.coder.dao;

import java.util.List;

import in.coder.pojo.Ordero;

public interface OrderDao {
	
	int placeOrder(String custEmail,double finalBill);
	List<Ordero> displayAllOrder();

}
