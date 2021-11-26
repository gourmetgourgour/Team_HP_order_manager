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
	int prDeliver2;
    
    public void read(Scanner scan) {
        prCode = scan.next();
        System.out.print(prCode);
        prType = scan.next();
        System.out.print(prType);
        prName = scan.next();
        System.out.print(prName);
        prPrice = scan.nextInt();
        System.out.print(prPrice);
        prStock = scan.nextInt();
        System.out.print(prStock);
        prSize = scan.next();
        System.out.print(prSize);
        prMeta = scan.next();
        System.out.print(prMeta);
        prColor = scan.next();
        System.out.print(prColor);
        prDesc = scan.next();
        System.out.print(prDesc);
        primg = scan.next();
        System.out.print(primg);
        prDeliver = scan.nextInt();
        System.out.println(prDeliver);
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
	public String getinfo() {
		String kwd;
		kwd = prCode +"	" + prType +"	" + prName +"	" + prPrice +" " + prStock +"	" + prSize +"	" + prMeta +"	" + prColor +"	" + prDesc +"	"+ primg +"	" + prDeliver +"	" + prDeliver2;
		
		return kwd;
		
	}


}
