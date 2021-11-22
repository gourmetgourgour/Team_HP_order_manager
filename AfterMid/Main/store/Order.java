package store;

import java.util.ArrayList;
import java.util.Scanner;
import mgr.Manageable;

public class Order implements Manageable {
	int orderId;
	User user;
	String address;
	String orderDate;
	String deliveryDate;
	String phonenumber;
	int total;
	ArrayList<Item> orderedItemList = new ArrayList<>();
	ArrayList<Integer> orderedItemCount = new ArrayList<>();
	
	public void read(Scanner scan) { 
		orderId = scan.nextInt();
		address = scan.next();
		String itemId = scan.next();
		Item item = null;
		while(!itemId.contentEquals("e")) {
			item = (Item)Store.itemMgr.find(itemId);
			if(item == null) {
				System.out.printf("ItemId Error: %s",  itemId);
				continue;
			}
			orderedItemList.add(item);
			orderedItemCount.add(scan.nextInt());
			itemId = scan.next();
		}
		calcTotal();
		String userId = scan.next();
		user = (User)Store.userMgr.find(userId);
		phonenumber = scan.next();
		orderDate = scan.next();
		deliveryDate = scan.next();
		user.addOrder(this);
	}
	
	void calcTotal() {
		for(int i = 0; i < orderedItemList.size() ; i++) {
			total += orderedItemList.get(i).getSubtotal(orderedItemCount.get(i));
		}
	}
	
	public boolean matches(String kwd) {
		if (user.userId.equals(kwd))
		    return true;
		if(orderDate.contentEquals(kwd))
			return true;
		for (Item item: orderedItemList)
			if (item.matches(kwd))
				return true;
		return false;
    }
	
	public boolean matches(String[] kwdArr) {
		for (String kwd: kwdArr) {
			if (!matches(kwd))
				return false;
		}
		return true;
	}
	
	public void print() {
		print(false);
	}
	
	void print(boolean bDetail) {
		System.out.printf("[ì£¼ë¬¸?•„?´?””:%2d] ì£¼ë¬¸?‚ ì§? : %s ë°°ì†¡?˜ˆ? •?¼ :  %s ?‚¬?š©?ž: %s "
				, orderId, orderDate, deliveryDate, user.userId);
		System.out.printf(" - ì£¼ë¬¸ê¸ˆì•¡:%5d\n", total);
		if (!bDetail)
			return;
		for (int i = 0; i < orderedItemList.size(); i++) {
			System.out.printf("\t(%2dê°?)", orderedItemCount.get(i));
			orderedItemList.get(i).print();
		}
	}
}
