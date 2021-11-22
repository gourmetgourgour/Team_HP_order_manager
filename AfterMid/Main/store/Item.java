package store;

import mgr.Manageable;
import java.util.Scanner;

public class Item implements Manageable {
    String prCode;
    String prType;
	String  prName;
	int prPrice;
	int prStock;
	String prSize;
	String prMeta;
	String prColor;
	String prDesc;
	String primg;
	int prDeliver;
    
    public void read(Scanner scan) {
        prCode = scan.next();
        prType = scan.next();
        prName = scan.next();
        prPrice = scan.nextInt();
        prStock = scan.nextInt();
        prSize = scan.next();
        prMeta = scan.next();
        prColor = scan.next();
        prDesc = scan.next();
        primg = scan.next();
        prDeliver = scan.nextInt();
    }
    
    public void print() { // Item
    	System.out.printf("%s %s %s %d %d %s %s %s %s %d",
			prCode, prType, prName, prPrice, prStock, prSize, prMeta, prColor, prDesc, prDeliver );
    	System.out.println();
    }
    
    public boolean matches(String kwd) {
        if (prName.contains(kwd))
            return true;
        if (kwd.length() > 2 && prCode.contains(kwd))
            return true;
        return false;
    }

    public boolean matches(String[] kwdArr) {
        for (String kwd : kwdArr) {
            if (!matches(kwd))
                return false;
        }
        return true;
    }

	int getSubtotal(int count) {
		return prPrice * count;
	}
}
