package com.feicuiedu.User;

import java.util.Scanner;
/**
 * 取款
 * @author majingyi
 *
 */
public class Withdrawa {

	public void withdrawal(User user) {
		
		Scanner scanner = new Scanner(System.in);
		boolean bln = false;
		while (true) {
			System.out.println("请输入取款金额:");
			double amount = scanner.nextDouble();
			if (amount < 0 | amount % 100 != 0) {
				System.out.println("金额必须大于0且是100的整数倍,请重新输入");
				bln = true;
			} else if (amount > user.getBalance()) {
				System.out.println("余额不足,请重新输入:");
				bln = true;
			} else {
				double balance = user.getBalance();
				user.setBalance(balance - amount);
				System.out.println("取款成功,当前余额为:" + user.getBalance());
				String flow = "您取出了" + balance + "元";
				
				while (true) {
					System.out.println("1.继续取款           2.返回");
					String input = scanner.next();
					if (input.equals("1")) {
						

					} else if (input.equals("2")) {
						UserService us = new UserService();
						us.userService(user);
					} else {
						System.out.println("输入错误,请重新输入:");
					}
				}
			}
		}

	}



}
