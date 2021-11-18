package shoppingMall;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class BasketGui {
		ActionListener Listener = new ButtonListener();
		String header[] = {"제품명", "수량", "가격", "배송지"};
		String contents[][] = {
				{"아디다스져지", "100", "90000", "경기대학교"},
				{"삼선스레빠", "50", "8000", "경희대학교"},							//오더가 들어오면 추가하는 식으로 추후 업데이트.
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
		JButton payButton = new JButton("결제하기");
		JTable basketTable = new JTable(contents, header);
		JScrollPane scrollPane =new JScrollPane(basketTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JTextField orderInfo = new JTextField("배송예정일: 2021/11/30, 총 가격: 99000");
		
	void addBasket() {
		basketTable.setPreferredSize(new Dimension(950,700));
		basketTable.getColumnModel().getColumn(0).setPreferredWidth(40);  //JTable 의 컬럼 길이 조절
		basketTable.getColumnModel().getColumn(1).setPreferredWidth(20);
		basketTable.getColumnModel().getColumn(2).setPreferredWidth(300);
		basketTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		scrollPane.setPreferredSize(new Dimension(1000,500));
		clearBasket.addActionListener(Listener);
		payButton.addActionListener(Listener);
		MainGUI.basketpanel.setBounds(20, 30, 1000, 630);
		MainGUI.basketpanel.add(scrollPane);
		MainGUI.basketpanel.add(orderInfo);
		MainGUI.basketpanel.add(clearBasket);
		MainGUI.basketpanel.add(payButton);
	}
	

	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if(buttonName.equals("결제하기")) {
				JOptionPane.showMessageDialog(null, "결제하시겠습니까? 아직미완성ㅠ");
			}
			else if(buttonName.equals("장바구니 비우기"))
				JOptionPane.showMessageDialog(null, "주문내역을 비울 기능, 미완성");
			
		}
}
}