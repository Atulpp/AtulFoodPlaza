package in.coder.test;

import java.util.*;

import in.coder.dao.CustDaoImpl;
import in.coder.pojo.Customer;
import in.coder.pojo.Food;


public class CustTest {
	
	public static void main(String args[])
	{
	
	
			
	Customer c=new Customer();
	CustDaoImpl cd=new CustDaoImpl();
	
	Scanner sc=new Scanner(System.in);
	String cName,cEmail,cPass;
	String cAdd;
	int cCon,cId;
	
while(true)
{
	System.out.println("Enter 1 to add Cust");
	System.out.println("Enter 2 to update Cust");
	System.out.println("Enter 3 to delete Cust");
	System.out.println("Enter 4 to display  Cust");
	System.out.println("Enter 5 to display all Cust");
	
	
	
	
	System.out.println("Enter Choice");
	int ch=sc.nextInt();
	
	
		
		
	
	
	switch(ch)
	{
	
	case 1:System.out.println("Enter Cust name");
	cName=sc.next();
	System.out.println("Enter Cust Address");
	cAdd=sc.next();
	System.out.println("Enter Cust Contact");
	cCon=sc.nextInt();
	System.out.println("Enter Cust Email");
	cEmail=sc.next();
	System.out.println("Enter Cust Password");
	cPass=sc.next();
	
	c.setCustName(cName);
	c.setCustAdd(cAdd);
	c.setCustCon(cCon);
	c.setCustEmail(cEmail);
	c.setCustPass(cPass);
	
	
	boolean flag=cd.addCust(c);
	if(flag=true){
		System.out.println("Added Cust successfully");
	}
	else
		System.out.println("Error");
	
	break;
	
	case 2:System.out.println("Enter Cust name");
		cName=sc.next();
		System.out.println("Enter Cust Address");
		cAdd=sc.next();
		System.out.println("Enter Cust Contact");
		cCon=sc.nextInt();
		System.out.println("Enter Cust Email");
		cEmail=sc.next();
		System.out.println("Enter Cust Password");
		cPass=sc.next();
		System.out.println("Enter Cust id");
		cId=sc.nextInt();
	
		c.setCustName(cName);
		c.setCustAdd(cAdd);
		c.setCustCon(cCon);
		c.setCustEmail(cEmail);
		c.setCustPass(cPass);
		c.setCustId(cId);
	
	boolean flag1=cd.updateCust(c);
	if(flag1=true){
		System.out.println("Updated Cust successfully");
	}
	else
		System.out.println("Error");
	
	break;
	case 3:System.out.println("Enter Customer id");
	cId=sc.nextInt();
	boolean flag3=cd.deleteCustById(cId);
	
	if(flag3=true){
		System.out.println("Deleted foosdsdd successfully");
	}
	else
		System.out.println("Error");
	
	break;
	
	case 4:System.out.println("Enter Customer id");
	cId=sc.nextInt();
	
	Customer c1=cd.displayCustById(cId);
	
	System.out.println(c1);
	break;
	case 5:List<Customer> c9=cd.displayAllCust();
	
for(Customer f4:c9)
{
	System.out.println(f4);
}
break;
	}
	}
	
	}
	

}



