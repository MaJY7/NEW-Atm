package com.feicuiedu.Admin;

import java.util.Scanner;

public class AdminLogin {

	Scanner scanner = new Scanner(System.in);
	
	public void adminLogin() {
		
		Administrator administrator = new Administrator();
		
		while(true) {
			
			System.out.println("请输入账号：");
			String getAdmAccount = scanner.next();
			
			if(getAdmAccount.length() == 3 && getAdmAccount.equals(administrator.getAdmAccount())) {
				
				if(getAdmAccount.equals(administrator.getAdmAccount())){
					
					System.out.println("请输入密码：");
					String getAdmPassword = scanner.next();
					
					if(getAdmPassword.equals(administrator.getAdmPassword())) {
						
						System.out.println("登陆成功！");
						AdminService adminService = new AdminService();
						adminService.adminService();
					}
					else {
						System.out.println("密码错误");
					}
				}
				else {
					System.out.println("账号不存在！");
				}
			}
			else {
				System.out.println("账号长度错误！");
			}
		}
	}

}
