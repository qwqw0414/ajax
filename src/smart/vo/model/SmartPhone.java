package smart.vo.model;

import java.io.Serializable;
import java.sql.Date;

public class SmartPhone implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String pname;
	private int amount;
	private Date pdate;
	
	public SmartPhone() {
		
	}

	public SmartPhone(String pname, int amount, Date pdate) {
		super();
		this.pname = pname;
		this.amount = amount;
		this.pdate = pdate;
	}

	@Override
	public String toString() {
		return "SmartPhone [pname=" + pname + ", amount=" + amount + ", pdate=" + pdate + "]";
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
