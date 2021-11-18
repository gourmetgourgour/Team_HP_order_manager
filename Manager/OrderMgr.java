package store;

import java.util.Scanner;

import facade.UIData;
import mgr.Manageable;

public class OrderedItem implements Manageable, UIData {
	Order order;
	Item item;

	OrderedItem(Order order, Item item, Scanner scan) {
		this.item = item;
		this.order = order;
	}
	int subTotal(int index) {
		int subtotal = 0;
		subtotal = item.prPrice * index; 
		
		return subtotal;
	}
	public void print() {
		System.out.format("[%s] %d원 x %d개 = %d원\n", 
				item.prName, item.prPrice, order.sellItemList.size(), item.prPrice*order.sellItemList.size());
	}
	@Override
	public void read(Scanner scan) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String[] getUiTexts() { 
		// TODO Auto-generated method stub
		String[] texts = new String[6];
		texts[0] = ""+Order.orderId;
		texts[1] = item.prName;
		texts[2] = "1";
		texts[3] = item.prColor;
		texts[4] = order.deliveredOn;
		texts[5] = ""+item.prPrice;
		return texts;
	}
}
