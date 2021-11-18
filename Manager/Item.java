package store;

import mgr.Manageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import facade.UIData;

public class Item implements Manageable, UIData {
    public String prCode;
	public String prType;
	public String  prName;
	public int prPrice;
	public int prStock;
	public String prSize;
	public String prMeta;
	public String prColor;
	public String prDesc;
	public String primg;
	public int prDeliver;
    

    public void read(Scanner scan) {

        prCode = scan.next();
        System.out.print(prCode+" ");
        prType = scan.next();
        System.out.print(prType+" ");
        prName = scan.next();
        System.out.print(prName+" ");
        prPrice = scan.nextInt();
        System.out.print(prPrice+" ");
        prStock = scan.nextInt();
        System.out.print(prStock+" ");
        prSize = scan.next();
        System.out.print(prSize+" ");
        prMeta = scan.next();
        System.out.print(prMeta+" ");
        prColor = scan.next();
        System.out.print(prColor+" ");
        prDesc = scan.next(); 
        System.out.print(prDesc+" ");
        primg = scan.next();
        System.out.print(primg+".jpg ");
        prDeliver = scan.nextInt();
        System.out.print(prDeliver+" \n");
        
       
    }
    
    public boolean matches(String kwd) {
        if (prCode.contains(kwd))
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

    public void print() { // Item
    	System.out.printf("%s %s %s %d %d %s %s %s %s %d",
			prCode, prType, prName, prPrice, prStock, prSize, prMeta, prColor, prDesc, prDeliver );
	System.out.println();
         
    }
    

	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
	}
	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		String[] texts = new String[7];
		texts[0] = prCode;
		texts[1] = prName;
		texts[2] = ""+prPrice;
		texts[3] = prSize;
		texts[4] = ""+prStock;
		texts[5] = ""+prColor;
		texts[6] = ""+prDeliver;
		return texts;
	}
	public int getSubtotal2(int index) {
		// TODO Auto-generated method stub
		int subtotal = 0;
		subtotal = prPrice * index; 
		
		return subtotal;
	}
}
