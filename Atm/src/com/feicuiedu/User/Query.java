package com.feicuiedu.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
/**
 * 普通用户查询查询
 * @author majingyi
 *
 */
public class Query {

	public void query(User user) {
		File file = new File("txt" + File.separator + "cc.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));// 直接读取
			HashMap<String, Object> hmap = (HashMap<String, Object>) ois.readObject();
			System.out.println(user);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}
