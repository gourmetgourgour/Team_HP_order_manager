package mgr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Manager<T extends Manageable> {
	public ArrayList<T> mList = new ArrayList<>();
	
	public T find(String kwd) {
	    for (T m: mList)
	    	if (m.matches(kwd))
	    		return m;
	    return null;
	}

	public void readAll(String filename, Factory<T> fac) {
		Scanner filein = openFile(filename);
		T m = null;
		while (filein.hasNext()) {
			m = fac.create();
			m.read(filein);
			mList.add(m);
		}
		filein.close();
	}
	
	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.println(filename + ": ?��?�� ?��?��");
			System.exit(0);
		}
		return filein;
	}

	public void printAll() {
		for (T m : mList) {
			m.print();
		}
	}
	public void searchAll(Scanner scan) {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			for (T m : mList) {
				if (m.matches(kwd))
					m.print();
			}
		}
	}

	public void writeAll(String filename, Factory<T> fac) {
		FileWriter writer;
		try {
			writer = new FileWriter(filename);
			for(T m: mList) {
				writer.write(m + System.lineSeparator());
			   
			}
			 writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		 
	}
}
