package com.feicuiedu;

import java.util.Scanner;

import com.feicuiedu.Admin.AdminLogin;
import com.feicuiedu.User.UserLogin;

public class Atm {

	public static void main(String[] args) {
	
		Atm at = new Atm();
		at.atm();
	}



	public void atm() {
		while(true) {
			System.out.println("欢迎使用ATM");
			System.out.println("选择登陆模式：1.管理员登陆  2.用户登陆");
			
			Scanner scanner = new Scanner(System.in);
			String index = scanner.next();
			
			if(index.equals("1")) {
				AdminLogin admLogin = new AdminLogin();
				admLogin.adminLogin();
				
			}else if(index.equals("2")) {
				UserLogin userLogin = new UserLogin();
				userLogin.userLogin();
			}
		}
	}
}
