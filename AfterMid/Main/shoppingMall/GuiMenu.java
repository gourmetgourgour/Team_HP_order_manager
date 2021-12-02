package shoppingMall;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.*;

import store.Item;
import store.Order;
import store.Store;
import java.util.*;

public class GuiMenu {
	String menus[] = { "쇼핑", "주문내역", "장바구니", "로그아웃", };
	int count = 0;

	LocalDate date = LocalDate.now();

	String now = date.toString();

	void addMenu() {
		ActionListener listener = new ButtonListener();
		MainGUI.menuPanel.setLayout(new GridLayout(5, 1, 0, 10));
		MainGUI.menuPanel.setPreferredSize(new Dimension(150, 650));
		addLogo();
		for (int i = 0; i < 4; i++) {
			String menuname = menus[i];
			JButton button = new JButton(menuname);
			button.addActionListener(listener);
			button.setBackground(new Color(153, 204, 255));
			button.setFont(new Font("Aharoni", Font.BOLD, 20));
			MainGUI.menuPanel.add(button);

		}
		MainGUI.menuPanel.setBackground(new Color(232, 244, 255));
	}

	void addLogo() {

		JButton dateinfo = new JButton(now);
		dateinfo.setBorderPainted(false);
		dateinfo.setBackground(null);
		dateinfo.setFont(new Font("Aharoni", Font.BOLD, 15));
		MainGUI.menuPanel.add(dateinfo);
	}

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if (buttonName.equals("쇼핑")) {
				MainGUI.basketpanel.setVisible(false);
				MainGUI.leftView.setVisible(true);
			} else if (buttonName.equals("주문내역")) {
				if (MainGUI.loggedinuser.myOrderList.isEmpty())
					JOptionPane.showMessageDialog(null, "고객님은 아직 주문이 없습니다!");
				else {
					for (int i = 0; i < Store.orderMgr.mList.size(); i++) {
						if (Store.orderMgr.mList.get(i).matches(MainGUI.loggedinuser.userId)) {
							Order od = Store.orderMgr.mList.get(i);
							JOptionPane.showMessageDialog(null,
									"주문아이디:" + od.orderId + "\n주문날짜: " + od.orderDate + "\n주문총액: " + od.total);
						} else
							continue;
					}
				}
			} else if (buttonName.equals("장바구니")) {
				MainGUI.basket.basketlabels.removeAll();
				MainGUI.basket.updateBasket();

				MainGUI.leftView.setVisible(false);
				MainGUI.basketpanel.setVisible(true);
			} else if (buttonName.equals("로그아웃")) {
				MainGUI.loggedinuser = null;
				MainGUI.mainFrame.setVisible(false);
				MainGUI.login.main(menus);
			}
		}
	}
}