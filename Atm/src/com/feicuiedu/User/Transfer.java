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
 * 转账
 * @author majingyi
 *
 */
public class Transfer {

	public void transfer(User user) {
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("请输入对方账号:");
			String otheraccount = scanner.next();
			File file = new File("txt" + File.separator + "cc.txt");
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				HashMap<String, Object> hm = (HashMap<String, Object>) ois.readObject();
				Set<String> keyset = hm.keySet();

				for (String key : keyset) {
					Object obj = hm.get(key);
					User tuser = (User) obj;
					String taccount = tuser.getAccount();
					if (taccount.equals(otheraccount)) {
						while (true) {
							System.out.println("请输入转账金额:");
							double tamount = scanner.nextDouble();
							if (tamount < 0 | tamount % 100 != 0) {
								System.out.println("金额必须大于0且是100的整数倍,请重新输入");
							} else if (tamount > user.getBalance()) {
								System.out.println("余额不足,请重新输入:");
							} else {
								System.out.println("转账成功!");
								user.setBalance(user.getBalance() - tamount);
								tuser.setBalance(tuser.getBalance() + tamount);
								String flow = "您给" + otheraccount + "转了" + tamount + "元";
								
								flow = user.getName() + "给您转了" + tamount + "元";
								
								break;
							}

						}
						System.out.println("1.继续转账    2.返回");
						String str = scanner.next();
						if (str.equals("1")) {

						} else {
							UserService us = new UserService();
							us.userService(user);
						}
					} else {
						System.out.println("无此用户");
					}
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


}
