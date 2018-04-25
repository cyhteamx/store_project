package com.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    private String ID;
    /*public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}*/
	@Column
    private String name;
    /*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}*/
	@Column
    private String password;
    /*public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}*/
	@Column
    private int age;
    /*public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}*/
	@Column
    private String remark;
	/*public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}*/

}
