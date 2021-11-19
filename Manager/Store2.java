package store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import mgr.Factory;
import mgr.Manageable;
import mgr.Manager;

public class Store2 {
	private static Store2 store = null;
	private Store2() {}
	public static Store2 getInstance() {
		if (store == null)
			store = new Store2();
		return store;
	}
	Scanner scan = new Scanner(System.in);
	public static Manager userMgr = new Manager();
	public static Manager itemMgr = new Manager();
	public static Manager orderMgr = new Manager();
	
	public void run() {
		itemMgr.readAll("products.txt", new Factory() {
			public Manageable create() {
				return new Item();
			}
		});
		System.out.println("\n================= 판매 상품 리스트 =================");
		//itemMgr.printAll();
		itemMgr.printAll();
		System.out.print("\n물건 출력완료\n");
		userMgr.readAll("user.txt", new Factory() {
			public Manageable create() { 
				return new User();
				};
		});
		userMgr.printAll();
		System.out.print("\n유저 출력완료\n");
		
		orderMgr.readAll("order.txt", new Factory(){
			public Manageable create() { 
				return new Order();
				};
		});
		orderMgr.printAll();
		System.out.print("\n오더 출력완료\n");
		
		
		System.out.print("\n재고 수치 변경\n");
	}
	
	
	public static void main(String args[]) {
		Store2 store = new Store2();
		store.run();
	}
}
