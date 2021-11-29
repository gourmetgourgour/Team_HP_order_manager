package shoppingMall;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import store.Order;


public class GuiMenu {
	String menus [] = {"쇼핑", "주문내역", "장바구니", "로그아웃",};
	Font font = new Font("Aharoni", Font.BOLD, 13);
	void addMenu() {
		ActionListener listener = new ButtonListener();
		MainGUI.menuPanel.setLayout(new GridLayout(5,1,0,10));
		MainGUI.menuPanel.setPreferredSize(new Dimension(150, 650));
		addLogo();
		for(int i=0;i<4;i++) {
			String menuname = menus[i];										
			JButton button = new JButton(menuname);
			button.addActionListener(listener);
			button.setBackground(new Color(153,204,255));
			button.setFont(font);
			MainGUI.menuPanel.add(button);
			
		}
		MainGUI.menuPanel.setBackground(new Color(232,244,255));
	}
	void addLogo() {
		ImageIcon logo = new ImageIcon("./images/logo.png");			//보노보노이미지 삽입
		Image img = logo.getImage();
		Image changeImg= img.getScaledInstance(150,110, Image.SCALE_SMOOTH);
		ImageIcon logo2 = new ImageIcon(changeImg);
		JButton logobutton = new JButton(logo2);
		logobutton.setBorderPainted(false);
		logobutton.setBackground(Color.white);
		MainGUI.menuPanel.add(logobutton);
	}
	
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if(buttonName.equals("쇼핑")) {
				MainGUI.basketpanel.setVisible(false);
				MainGUI.leftView.setVisible(true);
			}
			else if(buttonName.equals("주문내역")) {
				Order od = MainGUI.loggedinuser.myOrderList.get(0);
//				JOptionPane.showMessageDialog(null, "주문내역");
				JOptionPane.showMessageDialog(null, od.orderedItemList.get(0).prName);
				JOptionPane.showMessageDialog(null, Integer.toString(od.orderedItemCount.get(0)));
				JOptionPane.showMessageDialog(null, Integer.toString(od.orderedItemList.get(0).getSubtotal(od.orderedItemCount.get(0))));
				JOptionPane.showMessageDialog(null, MainGUI.loggedinuser.address);
			}
			else if(buttonName.equals("장바구니")) {
				MainGUI.leftView.setVisible(false);
				MainGUI.basketpanel.setVisible(true);
			}
			else if(buttonName.equals("로그아웃")) {
				MainGUI.loggedinuser = null;
				MainGUI.mainFrame.setVisible(false);
				MainGUI.login.main(menus);
			}
		}
	}
}
