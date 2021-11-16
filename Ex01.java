import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex01 {

	public static void main(String[] args) {
		Dimension dim = new Dimension(400,150);
		
		JFrame frame = new JFrame("행복한 판매팀");
		frame.setLocation(200,400);
		frame.setPreferredSize(dim);
		
		String header[] = {"제품명", "수량", "가격", "배송지"};
		String contents[][] = {
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""}
		};
		JTable table = new JTable(contents, header);
		JScrollPane scrollpane =new JScrollPane(table);
		
		frame.add(scrollpane);
		
		System.out.println(table.getColumnName(0));
		
		frame.pack();
		frame.setVisible(true);
	}

}
