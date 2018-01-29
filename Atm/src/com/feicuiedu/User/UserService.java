package com.feicuiedu.User;

import java.util.Scanner;

import com.feicuiedu.Atm;
/**
 * 用户选项
 * @author majingyi
 *
 */
public class UserService {
	public void userService(User user) {// 普通用户操作菜单
		System.out.println("请选择操作");
		System.out.println("1.查询");
		System.out.println("2.转账");
		System.out.println("3.取款");
		System.out.println("4.存款");
		System.out.println("5.退卡");
		getexecute(user);
	}

	public void getexecute(User user) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("请输入您要进行的操作");
			String index = scanner.next();
			if (index.equals("1")) {
				Query qu = new Query();
				qu.query(user);
				System.out.println("(1.返回上一级)");
				while (true) {
					String input = scanner.next();
					if (input.equals("1")) {
						userService(user);
					} else {
						System.out.println("输入错误请重新输入");
					}
				}
			} else if (index.equals("2")) {
				Transfer tsf = new Transfer();
				tsf.transfer(user);
			} else if (index.equals("3")) {
				Withdrawa wdaa = new Withdrawa();
				wdaa.withdrawal(user);
			} else if (index.equals("4")) {
				Deposit dps = new Deposit();
				dps.deposit(user);
			} else if (index.equals("5")) {
				Atm atm = new Atm();
				atm.atm();
			} else {
				System.out.println("您的输入不正确,请重新输入");
			}
		}
	}
}