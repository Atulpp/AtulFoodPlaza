package in.coder.pojo;

public class Cart {
	
	private String custEmail,foodName;
	private int cartId,foodId,foodQty;
	private double foodPrice;
	
	public String getcustEmail() {
		return custEmail;
	}
	public void setcustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getFoodQty() {
		return foodQty;
	}
	public void setFoodQty(int foodQty) {
		this.foodQty = foodQty;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	@Override
	public String toString() {
		return "Cart [custEmail=" + custEmail + ", foodName=" + foodName + ", cartId=" + cartId + ", foodId=" + foodId
				+ ", foodQty=" + foodQty + ", foodPrice=" + foodPrice + "]";
	}
	

}
