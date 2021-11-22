package store;

import java.util.Scanner;

public class Menu {
	Admin admin;
	User user;
	
	void loginMenu(Scanner scan) {
		while(true) {
			System.out.print("id : ");
			String id = scan.next();
			System.out.print("pwd : ");
			String pwd = scan.next();
			
			//?΄?λ―ΌμΈμ§? ??Έ -> ?΄?λ―Όμ΄λ©? ?΄?λ―? λ©λ΄λ‘?
			admin = Store.adminMgr.find(id);
			if(admin != null) {
				if(admin.passwordMatch(pwd)) {
					AdminMenu(scan);
					continue;
				}
			}
			
			//? ???Έμ§? ??Έ -> ? ??λ©? ? ??λ©λ΄λ‘?
			user = Store.userMgr.find(id);
			if(user != null) {
				if(user.passwordMatch(pwd)) {
					UserMenu(scan);
					continue;
				}
			}
			//?λ¬΄κ²? ???Όλ©? κ³μ λ°λ³΅λ¬? ?κ²?...
			System.out.println("id?? pwdλ₯? ?€? ??Έ?΄μ£ΌμΈ?.");
			flushLoginBuffer();
		}
						
	}
	
	void UserMenu(Scanner scan) {
		int num;
		while(user != null) {
			System.out.print("(0) λ‘κ·Έ?? ");
			num = scan.nextInt();
			switch(num) {
			case 0:
				flushLoginBuffer();
				break;
			default: break;
			}
		}
	}
	
	void AdminMenu(Scanner scan) {
		int num;
		while(admin != null) {
			System.out.print("(1)λ¬ΌνμΆλ ₯ (2)?¬?©?μΆλ ₯ (3)μ£Όλ¬ΈμΆλ ₯ (4)κ²?? (0)λ‘κ·Έ?? ");
			num = scan.nextInt();
			switch(num) {
			case 0:
				flushLoginBuffer();
				break;
			case 1: Store.itemMgr.printAll(); break;
			case 2: Store.userMgr.printAll(); break;
			case 3: Store.orderMgr.printAll(); break;
			case 4: searchMenu(scan); break;
			default : break;
			}
		}
	}
	
	void searchMenu(Scanner scan) {
		int num;
		while (true) {
			System.out.print("(1)λ¬Όνκ²?? (2)?¬?©?κ²?? (3)μ£Όλ¬Έκ²?? (κΈ°ν?) μ’λ£ ");
			num = scan.nextInt();
			if (num < 1 || num > 3) break;
			switch(num) {
			case 1: Store.itemMgr.searchAll(scan); break;
			case 2: Store.userMgr.searchAll(scan); break;
			case 3: Store.orderMgr.searchAll(scan); break;
			default: break;
			}
		}
	}
	
	void flushLoginBuffer() {
		user = null;
		admin = null;
	}
}
