package com.feicuiedu.User;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * user 
 * @author majingyi
 *
 */
public class User implements Serializable{

	private String account;//账号
	private String password;//密码
	private String name;//姓名
	private String gender;//性别
	private String id;//身份证号
	private String education_Background;//学历
	private Double balance;//余额
	private String address;//地址
	
	private ArrayList<String> arr = new ArrayList<String>();
	
	public User(String account, String password, String name, String gender, String id, String education_Background, String address, double i) {
		this.account = account;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.id = id;
		this.education_Background = education_Background;
		this.address = address;
		this.balance = i;
	}


	public User() {
		
	}


	public String getAccount() {
		return account;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	
	public String getId() {
		return id;
	}
	
	public String getEducation_Background() {
		return education_Background;
	}
	public void setEducation_Background(String education_Background) {
		this.education_Background = education_Background;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "账号:" + account + ", 密码:" + password + ", 姓名:" + name + ", 性别:" + gender
				+ ", 身份证号:" + id + ", 学历:" + education_Background + ", 余额:"
				+ balance + ", 联系地址:" + address;
	}
	
	
}


