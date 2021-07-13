package in.coder.dao;

public interface LoginDao {
	
	boolean adminLogin(String username,String password);
	boolean CustLogin(String custEmail,String custPass);
	boolean changePassword(String username,String password,String npassword);

}
