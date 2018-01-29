package com.feicuiedu.Admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.feicuiedu.User.User;

/**
 * 开户
 * 
 * @author majingyi
 *
 */
public class Open_account {

	Scanner scanner = new Scanner(System.in);
	User user = new User();
	private String address;
	private String education_Background;
	private String id;
	private String password;
	private String gender;
	private String name;
	private String account;
	private double balance = 0.0;
	private String num;
	HashMap<String,Object> hm = new HashMap<>();
	// 注册
	
	
	
	public void open_account() {
		// 姓名
		System.out.println("请输入姓名");
		this.name = scanner.next();
		while (true) {
			if (name.length() <= 10 && name.length() > 0) {
				user.setName(name);
				break;
			} else {
				System.out.println("输入有误，请重新输入！");
				
			}
		}

		// 性别
		while (true) {
			System.out.println("请输入性别(1.男，2.女)");
			String gender = scanner.next();
			if (gender.equals("1")) {
				this.num="1";
				this.gender = "男";
				break;
			} else if (gender.equals("2")) {
				this.num="2";
				this.gender = "女";
				break;
			} else {
				System.out.println("输入错误，行重新输入！！");
				
			}
		}

		// 身份证号
		while (true) {
			System.out.println("请输入身份证号：");
			this.id = scanner.next();
			if (id.matches("[0-9]{18}")) {
			
				break;
			} else if (!id.matches("[0-9]{18}")) {
				System.out.println("身份证号长度为十八位，请重新输入");

			}
		}

		// 学历
		while (true) {
			System.out.println("请输入学历：1.小学  2.中学  3.大学  4.其他");
			String education_Background = scanner.next();

			if (education_Background.equals("1")) {
				this.education_Background = "小学";
				
				break;
			} else if (education_Background.equals("2")) {
				this.education_Background = "中学";
				
				break;
			} else if (education_Background.equals("3")) {
				this.education_Background = "大学";
				
				break;
			} else if (education_Background.equals("4")) {
				this.education_Background = "其他";
				
				break;
			} else {
				System.out.println("输入错误，请重新输入：");

			}
		}

		// 地址
		while (true) {
			System.out.println("请输入联系地址：");
			this.address = scanner.next();
			if (address.length() <= 50) {
				
				break;
			} else {
				System.out.println("重新输入：");

			}
		}

		
		//密码
		while (true) {
			System.out.println("请输入密码：");
			this.password = scanner.next();
			if (password.matches("(?![0-9A-Z]+$)(?![0-9a-z]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,}$")) {
				
				break;
			} else {
				System.out.println("输入错误，请输入密码：");

			}
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		String time = sdf.format(new Date());
		String account = "370" + num + time;
		System.out.println(account);
		
		User user = new User(account, password, name, gender, id, education_Background, address, balance);
		//System.out.println(user);
		System.out.println("开户完成！");
		String key = account + id;
		//System.out.println(key);
		hm.put(key, user);
		Modify mo = new Modify();
		mo.write(hm);
		System.out.println("存入成功！");
		AdminService ads = new AdminService();
		ads.adminService();

	}
}