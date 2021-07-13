package in.coder.pojo;

import java.io.InputStream;
import java.sql.Blob;

public class Food {
	
	private int foodId;
	private String foodName,foodType;
	private double foodPrice;
	InputStream foodImage;
	Blob foodImg;
	
	

	public Blob getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(Blob foodImg) {
		this.foodImg = foodImg;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	


	public InputStream getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(InputStream foodImage) {
		this.foodImage = foodImage;
	}
	
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodType=" + foodType + ", foodPrice="
				+ foodPrice + ", foodImage=" + foodImage + ", foodImg=" + foodImg + "]";
	}

	

}

