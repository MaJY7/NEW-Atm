package com.feicuiedu.User;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
/**
 * 普通用户登陆
 * @author majingyi
 *
 */
public class UserLogin {

	public void userLogin() {

		Scanner scanner = new Scanner(System.in);

		while (true) {

			File file = new File("txt" + File.separator + "cc.txt");

			if (file.length() == 0) {

				System.out.println("当前文件无用户，请注册！");
			} else {

				ObjectInputStream ois;
				try {
					ois = new ObjectInputStream(new FileInputStream(file));
					HashMap<String, Object> map = (HashMap<String, Object>) ois.readObject();
					if(map == null||map.isEmpty()) {
						System.out.println("无用户，请先注册！");
					}else {
						System.out.println("请输入账号或者身份证号：");
					}
					Set<String> keyset = map.keySet();
					String str = scanner.next();
					for(String key : keyset) {
						
						if(key.startsWith(str)||key.endsWith(str)) {
							Object ob = map.get(key);
							User user = (User) ob;
							String userpassword = user.getPassword();
							while(true) {
								System.out.println("请输入密码：");
								String password = user.getPassword();
								if((userpassword.equals(password))) {
									System.out.println("登陆成功！");
									UserService us = new UserService();
									us.userService(user);
								}else {
									System.out.println("密码错误，请重新输入：");
								}
							}
						}else {
							System.out.println("用户不存在");
						}
					}
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
}
