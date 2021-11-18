package store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import facade.UIData;

import java.util.Calendar;
import mgr.Manageable;

public class Order implements Manageable, UIData {
	 

	int postal;
	
	 public User ID =new User();   
	 boolean isPaid;
	 String orderDate;
	 String deliveredOn;
	String orderPR;
	 
	ArrayList<Integer> itemCountList = new ArrayList<>();
	 
	public List<OrderedItem> sellItemList=new ArrayList<>();
	static public ArrayList<Order> sellList=new ArrayList<>();
	static public int orderId = 1001;
	public int sellId=orderId;
	static public ArrayList<Order> orderList=new ArrayList<>(); 

	public int total;
	Item item = null;
	String code = null;
	
	 public void read(Scanner scan) {
		 int arrayCount = 0;
		 
		sellId = scan.nextInt();
		System.out.print(sellId+" ");
		postal = scan.nextInt();
		System.out.print(postal+" ");
		
		while(true) {
			
		code =scan.next();
		System.out.print(code+"prCode \t");
			if(code.contentEquals("e"))
				break;
			
		item = (Item)Store2.itemMgr.find(code);
		sellItemList.add(new OrderedItem(this, this.item, scan));
		System.out.print("재고 :"+item.prStock+" ");
		itemCountList.add(scan.nextInt());
		
		System.out.print(itemCountList+" 배열 ");
		
		item.prStock = item.prStock - itemCountList.get(arrayCount);
		System.out.print("변경 재고 :"+item.prStock+" ");
		arrayCount++;
		}
		 if (ID == null) {
		    	System.out.println("사용자 아이디 없음: " + ID);
		    	System.exit(1);
		    }
		 for (int i = 0; i < sellItemList.size(); i++)
	    	{total += getSubtotal(i);
	    	}
		 System.out.print("제품금액 합계: "+total+" ");
		 
		 
		 
		 ID.id = scan.next();
		 System.out.print(ID.id+" ");
		 ID.phoneNum = scan.next();
		 System.out.print(ID.phoneNum+" ");
		 orderDate = scan.next();
		 System.out.print(orderDate+" ");
		 deliveredOn = scan.next();
		 System.out.print(deliveredOn+" ");
		 
		 
		 
		ID.addOrder(this);
	}
	 public void read(String[] rowTexts, Item item) {
		 Scanner scan=new Scanner(System.in);
		 orderPR=rowTexts[0];
		 this.item=(Item)Store2.itemMgr.find(item.prName);
		 sellItemList.add(new OrderedItem(this, this.item, scan));
	 }
	
	public boolean matches(String kwd) {
		if (kwd.length() == 0)
			return true;
		if (("" + sellId).equals(kwd))
		    return true;
		for (OrderedItem od: sellItemList)
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
		
		
		System.out.format("[주문아이디:%2d] ", sellId);
		if (isPaid)
			System.out.printf(" (결재대기)");
		System.out.println();
		for (OrderedItem od: sellItemList) {
			System.out.printf("\t");	
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
		texts[1] = ""+ID.id;
		texts[2] = "1";
		texts[3] = ""+item;
		return texts;
	}
	private int getSubtotal(int index) {
		int SubtotalCal = sellItemList.get(index).subTotal(itemCountList.get(index));
		System.out.print(SubtotalCal+", ");
		return SubtotalCal;
	}
}
