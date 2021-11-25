package store;

import mgr.Manageable;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Stock implements Manageable{
	String prCode2;
	int newStock;
	String tempDate;
	LocalDate StockDate;
	LocalDate testDate;
	int periodDate;
	
	ArrayList<Stock> stockChangeList = new ArrayList<>();
	
	 public void read(Scanner scan) {
	     testDate = LocalDate.now();
		 prCode2 = scan.next();
	     newStock = scan.nextInt();
	     tempDate = scan.next();
	     StockDate = LocalDate.parse(tempDate); 
	    
	     periodDate = (int) ChronoUnit.DAYS.between(testDate,StockDate);
	        System.out.print(periodDate);
	        
	    Item item = null;
		item = (Item)Store.itemMgr.find(prCode2);
		item.prDeliver2 = periodDate;
		
		stockChangeList.add(this);
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
	public void stockChange(String kwd) {
		int alpha; 
		Item item = null;
		item = (Item)Store.itemMgr.find(kwd);
		item.prDeliver = item.prDeliver2;
		Stock sInfo = null;
		sInfo = (Stock)Store.stockMgr.find(kwd);
		alpha = sInfo.newStock;
		
		item.prStock = alpha; 
		
	}
}
