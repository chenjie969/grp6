package sql;

import java.io.Serializable;

public class user  implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private int provinceId;
	private province province;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public province getProvince() {
		return province;
	}
	public void setProvince(province province) {
		this.province = province;
	}

}
