package in.coder.dao;

import java.util.List;

import in.coder.pojo.Cart;


public interface CartDao {
	
	boolean addToCart(Cart ct);
	boolean deleteCartById(int cartId);
	boolean deleteCartByEmail(String custEmail);
	
	
	List<Cart> displayCartByEmail(String custEmail);
	
	

}
