package com.feicuiedu.Admin;

import java.util.Scanner;

import com.feicuiedu.Atm;
/**
 *  
 * @author majingyi
 *
 */
public class AdminService {

	Scanner scanner = new Scanner(System.in);
	
	public void adminService() {
		System.out.println("请选择功能：1.开户  2.销户  3.修改  4.查询  9.退出登陆");
		String index = scanner.next();
		
		while(true) {
			//开户
			if(index.equals("1")) {
				Open_account open = new Open_account();
				open.open_account();				
			}//销户
			else if(index.equals("2")) {
				Closing_account clos = new Closing_account();
				clos.closing_account();
			}//修改
			else if(index.equals("3")) {
				Modification mft = new Modification();
				mft.modification();
			}//查询
			else if(index.equals("4")) {
				Query qu = new Query();
				qu.query();
			}else if(index.equals("9")) {
				Atm atm = new Atm();
				atm.atm();
			}
			else {
				System.out.println("输入错误请重新输入：");
			}
		}
	}

}
