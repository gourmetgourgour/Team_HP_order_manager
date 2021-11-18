package store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import facade.UIData;

import java.util.Calendar;
import mgr.Manageable;

public class Order implements Manageable, UIData {
	 
	int sellId;
	int postal;
	
	 public User ID =new User();   
	 boolean isPaid;
	 String date;
	 String deliveredOn;
	 String orderPR;
	 
	public List<OrderedItem> sellItemList=new ArrayList<>();
	static public ArrayList<Order> sellList=new ArrayList<>();
	static public int orderId=1;
	public int orderNum=orderId;
	 
	public Item item=new Item();
	 public List<OrderedItem> orderedItemList=new ArrayList<>();
	 static public ArrayList<Order> orderList=new ArrayList<>(); 

	 public void read(Scanner scan) {
		sellId = scan.nextInt();
		postal = scan.nextInt();
		Item item = null;
		this.item = (Item)Store2.itemMgr.find(item.prCode);
		 
		 
	}
	 public void read(String[] rowTexts, Item item) {
		 Scanner scan=new Scanner(System.in);
		 orderPR=rowTexts[0];
		 this.item=(Item)Store2.itemMgr.find(item.prCode);
		 sellItemList.add(new OrderedItem(this, this.item, scan));
	 }
	
	public boolean matches(String kwd) {
		if (kwd.length() == 0)
			return true;
		if (("" + orderId).equals(kwd))
		    return true;
		for (OrderedItem od: orderedItemList)
			if (od.item.matches(kwd))
				return true;
		if (ID.id.contentEquals(kwd))
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
		
		
		System.out.format("[주문아이디:%2d] ", orderId);
		if (!isPaid)
			System.out.printf(" (결재대기)");
		System.out.println();
		for (OrderedItem od: orderedItemList) {
			System.out.print("\t");	
			od.print();

		}

		
	}
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
	}
	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		String[] texts = new String[5];
		texts[0] = ""+orderId;
		texts[1] = ""+ID.userId;
		texts[2] = "1";
		texts[3] = ""+item.deliveredOn;
		return texts;
	}
}
