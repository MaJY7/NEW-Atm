package com.feicuiedu.Admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.feicuiedu.User.User;

/**
 * 修改
 * 
 * @author majingyi
 *
 */
public class Modification {

	Scanner scanner = new Scanner(System.in);

	public void modification() {

		File file = new File("txt" + File.separator + "cc.txt");
		if (file == null || file.length() == 0) {

			System.out.println("无用户");
		} else {
			while (true) {
				System.out.println("请输入要修改的账号:");

				String account = scanner.next();
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					HashMap<String, Object> mp = (HashMap<String, Object>) ois.readObject();
					System.out.println(mp);
					Set<String> keyset = mp.keySet();
					boolean bln = false;
					for (String key : keyset) {
						if (key.startsWith(account)) {
							Object ob = mp.get(key);
							User temp = (User) ob;
							update(temp, file, mp);
							bln = true;
							break;
						}
					}
					if (!bln) {
						System.out.println("账号不存在");
					}
					break;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	private void update(User temp, File file, HashMap<String, Object> mp) {

		while (true) {
			
			System.out.println("请选择要修改的属性：(1.密码  2.姓名  3.学历  4.联系地址  5.身份证号  9.返回菜单)");
			String index = scanner.next();
			if (index.equals("1")) {
				System.out.println("请输入新密码：");
				String newpassword = scanner.next();
				temp.setPassword(newpassword);
			} else if (index.equals("2")) {
				System.out.println("请输入修改后的姓名:");
				String newname = scanner.next();
				temp.setName(newname);
			} else if (index.equals("3")) {
				System.out.println("请输入修改后的学历:");
				String neweducation_Background = scanner.next();
				if (neweducation_Background.equals("1")) {
					String education_Background = "小学";
					temp.setEducation_Background(education_Background);
					break;
				} else if (neweducation_Background.equals("2")) {
					String education_Background = "中学";
					temp.setEducation_Background(education_Background);
					break;
				} else if (neweducation_Background.equals("3")) {
					String education_Background = "大学";
					temp.setEducation_Background(education_Background);
					break;
				} else if (neweducation_Background.equals("4")) {
					String education_Background = "其他";
					temp.setEducation_Background(education_Background);
					break;
				} else {
					System.out.println("输入错误，请重新输入：");
				}
			} else if (index.equals("4")) {
				System.out.println("请输入修改后的地址 :");
				String newaddress = scanner.next();
				temp.setAddress(newaddress);
			} else if (index.equals("5")) {
				System.out.println("请输入修改的身份证号：");
				String newid = scanner.next();
				temp.setId(newid);
			} else if (index.equals("9")) {
				AdminService ad = new AdminService();
				ad.adminService();
				
			} else {
				System.out.println("输入错误，请重新输入：");
			}

		}

	}

}
