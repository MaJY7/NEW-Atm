package com.feicuiedu.Admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.feicuiedu.User.User;

public class Modify {

	public void modify(User user) {

		File file = new File("txt" + File.separator + "cc.txt");

		try {
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			HashMap<String,Object> hm = (HashMap<String,Object>) ois.readObject();
			hm.put(getAccount() + user.getId(),user);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(hm);
			ois.close();
			oos.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	private String getAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	public void write(HashMap<String, Object> hm) {

		File file = new File("txt" + File.separator + "cc.txt");
		
		if(file == null||file.length() == 0) {
			
			
			try {
				HashMap<String,Object> map = new HashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				map.putAll(hm);
				oos.writeObject(map);
				oos.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		else {
			
			try {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				HashMap<String,Object> hp = (HashMap<String,Object>) ois.readObject();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				hp.putAll(hm);
				oos.writeObject(hp);
				ois.close();
				oos.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
