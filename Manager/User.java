package store;

import mgr.Manageable;

import java.util.ArrayList;
import java.util.Scanner;


public class User implements Manageable{

    String id;
    static public int userId = 1;
    String pwd;
    int address;   
    String phoneNum;
    boolean isAdmin;
    ArrayList<Order> myOrderList = new ArrayList<>();
    
    static public ArrayList<Order> shoppingList = new ArrayList<>();
    static public ArrayList<Order> nowShoppingList = new ArrayList<>();
    @Override
    public void read(Scanner scan) {
    	id = scan.next();
    	System.out.print(id+" ");
    	pwd = scan.next();
    	System.out.print(pwd+" ");
    	address = scan.nextInt();
    	System.out.print(address+" ");
    	phoneNum = scan.next();
    	System.out.print(phoneNum+" ");
    	
    	int i; 
    	i = scan.nextInt();
    	if( i == 1)
    		isAdmin = true;
    	else
    		isAdmin = false;
    	
    	System.out.print(isAdmin+" \n");
 
    	
    }
    @Override
    public void print() { //장바구니 출력
        System.out.printf("[%s] %d %s \n", id, address, phoneNum);
        for(Order ord:shoppingList) {
            System.out.print("\t");
            ord.print(false);
        }
    }
    @Override
    public boolean matches(String kwd) {
        if (kwd.length() == 0)
            return true;
        if(kwd.contentEquals(""+id))
            return true;
        for (Order od: shoppingList)
           if (od.matches(kwd)) // 주문id에만 매치
              return true;
        return false;
    }

void addOrder(Order od) {
	myOrderList.add(od);
	
	}

}

