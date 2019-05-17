package sql;

import java.io.Serializable;

public class zbuser implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//机构id
	private String name;//机构名称
	private int age;//用户id
	private String faddress;//地址
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFaddress() {
		return faddress;
	}
	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}
	
}
