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
			
			//?–´?“œë¯¼ì¸ì§? ?™•?¸ -> ?–´?“œë¯¼ì´ë©? ?–´?“œë¯? ë©”ë‰´ë¡?
			admin = Store.adminMgr.find(id);
			if(admin != null) {
				if(admin.passwordMatch(pwd)) {
					AdminMenu(scan);
					continue;
				}
			}
			
			//?œ ???¸ì§? ?™•?¸ -> ?œ ??ë©? ?œ ??ë©”ë‰´ë¡?
			user = Store.userMgr.find(id);
			if(user != null) {
				if(user.passwordMatch(pwd)) {
					UserMenu(scan);
					continue;
				}
			}
			//?•„ë¬´ê²ƒ?„ ?•„?‹ˆ?¼ë©? ê³„ì† ë°˜ë³µë¬? ?Œê²?...
			System.out.println("id?? pwdë¥? ?‹¤?‹œ ?™•?¸?•´ì£¼ì„¸?š”.");
			flushLoginBuffer();
		}
						
	}
	
	void UserMenu(Scanner scan) {
		int num;
		while(user != null) {
			System.out.print("(0) ë¡œê·¸?•„?›ƒ ");
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
			System.out.print("(1)ë¬¼í’ˆì¶œë ¥ (2)?‚¬?š©?ì¶œë ¥ (3)ì£¼ë¬¸ì¶œë ¥ (4)ê²??ƒ‰ (0)ë¡œê·¸?•„?›ƒ ");
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
			System.out.print("(1)ë¬¼í’ˆê²??ƒ‰ (2)?‚¬?š©?ê²??ƒ‰ (3)ì£¼ë¬¸ê²??ƒ‰ (ê¸°í?) ì¢…ë£Œ ");
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
