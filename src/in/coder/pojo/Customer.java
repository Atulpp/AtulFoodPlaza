package in.coder.pojo;

public class Customer {
	
	private int custId,custCon;
	private String custName,custAdd,custEmail,custPass;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getCustCon() {
		return custCon;
	}
	public void setCustCon(int custCon) {
		this.custCon = custCon;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAdd() {
		return custAdd;
	}
	public void setCustAdd(String custAdd) {
		this.custAdd = custAdd;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustPass() {
		return custPass;
	}
	public void setCustPass(String custPass) {
		this.custPass = custPass;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custCon=" + custCon + ", custName=" + custName + ", custAdd=" + custAdd
				+ ", custEmail=" + custEmail + ", custPass=" + custPass + "]";
	}


}
