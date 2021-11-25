package store;

import mgr.Manageable;
import java.util.ArrayList;
import java.util.Scanner;

public class Cart implements Manageable{
	User user;
	Item item =  null;
	int prCount;
	int prAmount = 0;
	static public int cartInDeliver = 0; 
	
	ArrayList<Cart> shoppingCart = new ArrayList<>();
	ArrayList<Item> prlist = new ArrayList<Item>();
	ArrayList<Integer> prCountlist = new ArrayList<>();
	Cart cart = new Cart();
	
	 public void addProduct(String kwd, int prCount)	
	 {
		 item = (Item)Store.itemMgr.find(kwd);
		 prAmount += prCount;
		 if(item.prStock == 0)
		 {
			 store.Stock.stockChange(kwd);
			 
			 if(item.prStock == 0) {
				 System.out.print("재고부족"); 
				 return;}
			 else {
				 item.prStock -= prCount;
			 }
			 
		 }
		 else{item.prStock -= prCount;}	
		 if (cartInDeliver < item.prDeliver)
		 {
			 cartInDeliver = item.prDeliver;
		 }
		 prlist.add(item);
		 prCountlist.add(prAmount);

	 }
	 

	@SuppressWarnings("unlikely-arg-type")
	public void removeProduct(String kwd, int prCount)	
	 {
		
	 item = (Item)Store.itemMgr.find(kwd);
	 prAmount -= prCount;
	 item.prStock += prCount;
	 prCountlist.remove(prlist.get(prlist.indexOf(item)));
	 prlist.remove(item);
	 
	 }

	 
	 @SuppressWarnings("unchecked")
	public void addingcart(String userId) {
		user.userId = userId;
		
		
		user.myShoppingCart = (ArrayList<Cart>) prlist.clone();
		user.myShoppingCart = (ArrayList<Cart>) prCountlist.clone();
		user.myShoppingCart.add(this);
	 }
	    
	
	 public void removecart(String userId) {
		user.userId = userId;
		prlist.clear();
		prCountlist.clear();
		user.myShoppingCart.clear();
		
	 }
	
	
	 public void cartsendOrder(String kwd) {
		 
		 user = (User)Store.userMgr.find(kwd);;
		 Order order = new Order();
		order.orderCreate(user);
		 
		 
	 }
	
	
	
	@Override
	public void read(Scanner scan) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
