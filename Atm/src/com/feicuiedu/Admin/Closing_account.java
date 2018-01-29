package com.feicuiedu.Admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 销户
 * @author majingyi
 *
 */
public class Closing_account {
		
	public void closing_account() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入要删除的账号:");
		String account = scanner.next();
		System.out.println("请输入身份证号：");
		String id = scanner.next();
		String str = account + id;
		

		try {
			File file = new File("txt" + File.separator + "cc.txt");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			HashMap<String,Object> hh = (HashMap<String,Object>)ois.readObject();
		
			if(hh.containsKey(str)) {
				
				hh.remove(str);
				System.out.println("删除成功！");
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(hh);
				ois.close();
				AdminService adm = new AdminService();
				adm.adminService();
			}
			else {
				System.out.println("账号不存在，请重新输入！");
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
