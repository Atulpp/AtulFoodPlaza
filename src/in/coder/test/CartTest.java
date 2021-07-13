package in.coder.test;

import java.util.*;

import in.coder.dao.CartDaoImpl;
import in.coder.dao.foodDaoImpl;
import in.coder.pojo.Cart;
import in.coder.pojo.Food;

public class CartTest {

		
		public static void main(String args[])
		{
		
		
				
		Cart ct=new Cart();
		CartDaoImpl ctd=new CartDaoImpl();
		
		Scanner sc=new Scanner(System.in);
		int cId,fId,foodQty,cartId;
		String fname,custEmail;
		String fType;
		double fPrice;
		
	while(true)
	{
		System.out.println("Enter 1 to add cart");
		System.out.println("Enter 2 to delete cart");

		
		
		
		
		System.out.println("Enter Choice");
		int ch=sc.nextInt();
		
		
			
			
		
		
		switch(ch)
		{
		
		case 1:System.out.println("Enter Food id");
		fId=sc.nextInt();
		System.out.println("Enter Email");
		custEmail=sc.next();
		System.out.println("Enter food quantity");
		foodQty=sc.nextInt();
		
		ct.setFoodId(fId);
		ct.setcustEmail(custEmail);
		ct.setFoodQty(foodQty);
		
		boolean flag=ctd.addToCart(ct);
		if(flag=true){
			System.out.println("Added food successfully");
		}
		else
			System.out.println("Error");
		
		break;
		
		
		case 2:System.out.println("Enter cart id");
		cId=sc.nextInt();
		boolean flag3=ctd.deleteCartById(cId);
		
		if(flag3=true){
			System.out.println("Deleted food successfully");
		}
		else
			System.out.println("Error");
		
		
		
		}
		}
		
		}
		

	}

	

