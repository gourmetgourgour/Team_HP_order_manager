package store;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import mgr.Factory;
import mgr.Manageable;

public class Order implements Manageable {
	public int orderId;
	public User user;
	public String address;
	public String orderDate;
	 public String deliveryDate;
	 public String phonenumber;
	 public int total;
	 public ArrayList<Item> orderedItemList = new ArrayList<>();
	 public ArrayList<Integer> orderedItemCount = new ArrayList<>();
	
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
		System.out.printf("[주문아이디:%2d] 주문날짜 : %s 배송예정일 :  %s 사용자: %s "
				, orderId, orderDate, deliveryDate, user.userId);
		System.out.printf(" - 주문금액:%5d\n", total);
		if (!bDetail)
			return;
		for (int i = 0; i < orderedItemList.size(); i++) {
			System.out.printf("\t(%2d개)", orderedItemCount.get(i));
			orderedItemList.get(i).print();
		}
	}
	public void orderCreate(User user) {
		
		//myOrderList.add GUI 에서 된걸 그대로 불러와서 orderCreate 메소드가 오더를 추가해서 업데이트 
		
		orderId = store.User.myOrderList.size()+1001;
		address = user.address;
		LocalDate alpha = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyymmdd");
		String formattedString = alpha.format(formatter);
		orderDate = formattedString;
		orderedItemList = (ArrayList<Item>) user.myShoppingCart.clone();
		orderedItemCount = (ArrayList<Integer>) user.myShoppingCart.clone();
		int beta = Integer.parseInt(orderDate);
		int gamma = beta + Cart.cartInDeliver;
		
		deliveryDate = Integer.toString(gamma); 
		phonenumber = user.phoneNum;
		user.addOrder(this);
		fileUpdate();
	}
	public void fileUpdate(){
		Store.itemMgr.writeAll("products2.txt", new Factory<Item>() {
			public Item create() {
				return new Item();
			}
		});
		Store.orderMgr.writeAll("order2.txt", new Factory<Order>() {
			public Order create() {
				return new Order();
			}
		});
				
	}
/*
	@Override
	public void write(String filename) {
		 File file = new File(filename);
		 
		 FileWriter writer = new FileWriter(filename); 
		 for(String m: arr) {
		   writer.write(str + System.lineSeparator());
		 }
		 
		 String alpha = 
		 String output = System.out.println(alpha+beta+gamma++"e"+delta+) 
		 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		// TODO Auto-generated method stub
		try {
			if(file.isFile() && file.canWrite()){
                //쓰기
                bufferedWriter.write(output);
                //개행문자쓰기
                bufferedWriter.newLine();                
                bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	} */
	
}
