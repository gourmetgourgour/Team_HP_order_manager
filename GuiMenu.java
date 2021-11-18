package shoppingMall;

import java.awt.*;

import java.awt.event.*;


import javax.swing.*;


public class GuiMenu {
	String menus [] = {"쇼핑", "주문내역", "장바구니", "로그아웃",};
	void addMenu() {
		ActionListener listener = new ButtonListener();
		MainGUI.menuPanel.setLayout(new GridLayout(5,1,0,10));
		MainGUI.menuPanel.setPreferredSize(new Dimension(150, 650));
		addLogo();
		for(int i=0;i<4;i++) {
			String menuname = menus[i];										//우측 메뉴버튼 추가, 색깔이안바뀜;
			JButton button = new JButton(menuname);
			button.addActionListener(listener);
			button.setBackground(Color.white);
			MainGUI.menuPanel.add(button);
			
		}
		MainGUI.menuPanel.setBackground(Color.white);
	}
	void addLogo() {
		ImageIcon logo = new ImageIcon("./images/bonobono.png");			//보노보노이미지 삽입
		Image img = logo.getImage();
		Image changeImg= img.getScaledInstance(120,100, Image.SCALE_SMOOTH);
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
			else if(buttonName.equals("주문내역"))
				JOptionPane.showMessageDialog(null, "주문내역");
			else if(buttonName.equals("장바구니")) {
				MainGUI.leftView.setVisible(false);
				MainGUI.basketpanel.setVisible(true);
			}
			else if(buttonName.equals("로그아웃"))
				JOptionPane.showMessageDialog(null, "로그아웃");
		}
		
	}
}