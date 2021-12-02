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
	String menus[] = { "����", "�ֹ�����", "��ٱ���", "�α׾ƿ�", };
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
			if (buttonName.equals("����")) {
				MainGUI.basketpanel.setVisible(false);
				MainGUI.leftView.setVisible(true);
			} else if (buttonName.equals("�ֹ�����")) {
				if (MainGUI.loggedinuser.myOrderList.isEmpty())
					JOptionPane.showMessageDialog(null, "������ ���� �ֹ��� �����ϴ�!");
				else {
					for (int i = 0; i < Store.orderMgr.mList.size(); i++) {
						if (Store.orderMgr.mList.get(i).matches(MainGUI.loggedinuser.userId)) {
							Order od = Store.orderMgr.mList.get(i);
							JOptionPane.showMessageDialog(null,
									"�ֹ����̵�:" + od.orderId + "\n�ֹ���¥: " + od.orderDate + "\n�ֹ��Ѿ�: " + od.total);
						} else
							continue;
					}
				}
			} else if (buttonName.equals("��ٱ���")) {
				MainGUI.basket.basketlabels.removeAll();
				MainGUI.basket.updateBasket();

				MainGUI.leftView.setVisible(false);
				MainGUI.basketpanel.setVisible(true);
			} else if (buttonName.equals("�α׾ƿ�")) {
				MainGUI.loggedinuser = null;
				MainGUI.mainFrame.setVisible(false);
				MainGUI.login.main(menus);
			}
		}
	}
}