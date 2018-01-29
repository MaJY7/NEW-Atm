package com.feicuiedu.Admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Scanner;
/**
 * 查询
 * @author majingyi
 *
 */
public class Query {

	public void query() {
		
		Scanner scanner= new Scanner (System.in);
		File file = new File("txt" + File.separator +"cc.txt");
		if(file.equals(null) || file.length() == 0) {
			
			HashMap<String,Object> map = new HashMap<>();
			System.out.println("没有用户，重新输入：");		
		}
		else {
			
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));		
				HashMap<String,Object> map = (HashMap<String,Object>) ois.readObject();
				System.out.println(map.values());
				ois.close();
				while(true) {
					System.out.println("1.返回菜单  ");
					String str = scanner.next();
					if (str.equals("1")) {
						AdminService ad=new AdminService();
						ad.adminService();
					} 
					else {

						System.out.println("输入错误,重新输入:");
					}
				}
				
			}catch (ClassNotFoundException e) {
					
				e.printStackTrace();
						
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	}

}
