package store;

import java.util.ArrayList;
import java.util.Scanner;
import mgr.Manageable;


public class User implements Manageable{
    String userId;
    String pwd;
    String address;   
    String phoneNum;
    static ArrayList<Order> myOrderList = new ArrayList<>();
    ArrayList<Cart> myShoppingCart = new ArrayList<>();
    
    @Override
    public void read(Scanner scan) {
    	userId = scan.next();
    	pwd = scan.next();
    	address = scan.next();
    	phoneNum = scan.next();
    }
    
    @Override
    public void print() {
        System.out.printf("[%s] %s %s \n", userId, address, phoneNum);
    }
    
    @Override
    public boolean matches(String kwd) {
		if (userId.equals(kwd))
			return true;
		for (Order od: myOrderList)
			if (od.matches(kwd))
				return true;
		return false;
    }

    void addOrder(Order od) {
    	myOrderList.add(od);
	}

	public boolean passwordMatch(String password) {
		if(pwd.equals(password))
			return true;
		return false;
	}
	public String getinfo() {
		String kwd;
		kwd = userId + " " + pwd + " " + address + " " + phoneNum;
		
		return kwd;
		
	}

}

