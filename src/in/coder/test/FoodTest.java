
package in.coder.test;

import java.util.*;

import in.coder.dao.foodDaoImpl;
import in.coder.pojo.Food;

public class FoodTest {
	
	public static void main(String args[])
	{
	
	
			
	Food f=new Food();
	foodDaoImpl fd=new foodDaoImpl();
	
	Scanner sc=new Scanner(System.in);
	String fname;
	String fType;
	double fPrice;
	
while(true)
{
	System.out.println("Enter 1 to add food");
	System.out.println("Enter 2 to update food");
	System.out.println("Enter 3 to delete food");
	System.out.println("Enter 4 to display  food");
	System.out.println("Enter 5 to display all food");
	
	
	
	
	System.out.println("Enter Choice");
	int ch=sc.nextInt();
	
	
		
		
	
	
	switch(ch)
	{
	
	case 1:System.out.println("Enter food name");
	fname=sc.next();
	System.out.println("Enter food Type");
	fType=sc.next();
	System.out.println("Enter food Price");
	fPrice=sc.nextDouble();
	
	f.setFoodName(fname);
	f.setFoodType(fType);
	f.setFoodPrice(fPrice);
	
	boolean flag=fd.addFood(f);
	if(flag=true){
		System.out.println("Added food successfully");
	}
	else
		System.out.println("Error");
	
	break;
	
	case 2:
		System.out.println("Enter food id");
		int fId = sc.nextInt();
		System.out.println("Enter food name");
	fname=sc.next();
	System.out.println("Enter food Type");
	fType=sc.next();
	System.out.println("Enter food Price");
	fPrice=sc.nextDouble();
	
	f.setFoodId(fId);
	f.setFoodName(fname);
	f.setFoodType(fType);
	f.setFoodPrice(fPrice);
	
	boolean flag1=fd.updateFood(f);
	if(flag1=true){
		System.out.println("Updated food successfully");
	}
	else
		System.out.println("Error");
	
	
	
	
	case 3:System.out.println("Enter food id");
	fId=sc.nextInt();
	boolean flag3=fd.deleteFoodById(fId);
	
	if(flag3=true){
		System.out.println("Deleted food successfully");
	}
	else
		System.out.println("Error");
	
	
	case 4:System.out.println("Enter food id");
	fId=sc.nextInt();
	
	Food f1=fd.displayFoodById(fId);
	
	System.out.println(f1);
	break;
	case 5:List<Food> f3=fd.displayAllFood();
	
for(Food f4:f3)
{
	System.out.println(f4);
}
	}
	}
	
	}
	

}
