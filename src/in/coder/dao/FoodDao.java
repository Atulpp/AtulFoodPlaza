package in.coder.dao;

import java.util.List;

import in.coder.pojo.Food;

public interface FoodDao
{
	
	boolean addFood(Food f);
	boolean updateFood(Food f);
	boolean deleteFoodById(int foodId);
	List<Food> searchName(String filter,String food);
	List<Food> searchType(String filter,String food);
	
	List<Food> displayAllFood();
	Food displayFoodById(int foodId);
	

}
