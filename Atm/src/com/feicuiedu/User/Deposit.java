package com.feicuiedu.User;

import java.util.Scanner;

/**
 * 存款
 * @author majingyi
 *
 */
public class Deposit {

	public void deposit(User user) {
		
		Scanner scanner = new Scanner(System.in);
		boolean bln = false;
		while (true) {
			
			System.out.println("请输入存款金额");
			double balance = scanner.nextDouble();
			System.out.println("1.确认      2.重新输入");
			String input = scanner.next();
			if (input.equals("1")) {
				
				//判断余额大于零
				if (balance > 0 & balance % 100 == 0) {
					
					double initialbalance = user.getBalance();
					user.setBalance(initialbalance + balance);
					System.out.println("存入成功,当前余额为:" + user.getBalance());
					String flow = "您存入了" + balance + "元";
					
					System.out.println("1.继续存款           2.退出");
					while (true) {
						
						String input2 = scanner.next();
						if (input2.equals("1")) {
							
						} else if (input2.equals("2")) {
							
							UserService us = new UserService();
							us.userService(user);
						} else {
							System.out.println("输入错误,请重新输入:");
						}
					}
				} else {
					System.out.println("存入的金额必须大于0,并且只能是100的整数倍");
				}
			} else if (input.equals("2")) {
				bln = true;
			} else {
				bln = true;
			}
		}

	}

}
