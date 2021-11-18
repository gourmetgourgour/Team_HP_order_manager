package shoppingMall;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class BasketGui {
		String header[] = {"제품명", "수량", "가격", "배송지"};
		String contents[][] = {
				{"아디다스져지", "100", "90000원", "경기대학교"},
				{"삼선스레빠", "50", "8000원", "경희대학교"},							//오더가 들어오면 추가하는 식으로 추후 업데이트.
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"리눅스컴퓨터", "10", "2000000", "수원대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"},
				{"인텔컴퓨터", "20", "900000", "연세대학교"}
		};
		JButton clearBasket = new JButton("장바구니 비우기");
		JButton paybutton = new JButton("결제하기");
		JTable basketTable = new JTable(contents, header);
		JScrollPane scrollPane =new JScrollPane(basketTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JTextField orderInfo = new JTextField("배송예정일: 2021/11/30, 총 가격: 99000");
		
	void addBasket() {
		basketTable.setPreferredSize(new Dimension(950,700));
		scrollPane.setPreferredSize(new Dimension(1000,500));
//		MainGUI.basketpanel.setBackground(Color.white);
		MainGUI.basketpanel.setBounds(20, 30, 1000, 630);
		MainGUI.basketpanel.add(scrollPane);
		MainGUI.basketpanel.add(orderInfo);
		MainGUI.basketpanel.add(clearBasket);
		MainGUI.basketpanel.add(paybutton);
	}
}