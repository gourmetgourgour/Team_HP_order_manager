package store;

import java.util.Scanner;
import mgr.*;

public class Store {
	Scanner scan = new Scanner(System.in);
	static Manager<Item> itemMgr = new Manager<>();
	static Manager<User> userMgr = new Manager<>();
	static Manager<Admin> adminMgr = new Manager<>();
	static Manager<Order> orderMgr = new Manager<>();
	
	public void run() {
		readAllManager();
		Menu menu = new Menu();
		menu.loginMenu(scan);
	}

	void readAllManager() {
		itemMgr.readAll("products.txt", new Factory<Item>() {
			public Item create() {
				return new Item();
			}
		});
		userMgr.readAll("user.txt", new Factory<User>() {
			public User create() { 
				return new User();
				}
		});
		adminMgr.readAll("admin.txt", new Factory<Admin>() {
			public Admin create() {
				return new Admin();
			}
		});
		orderMgr.readAll("order.txt", new Factory<Order>(){
			public Order create() { 
				return new Order();
				}
		});
	}
	
	public static void main(String args[]) {
		Store store = new Store();
		store.run();
	}
}
