package shoppingMall;

import java.awt.*;

import java.awt.event.*;


import javax.swing.*;


public class GuiMenu {
	String tableheader []= {"카테고리", "이름", "사이즈", "배송소요시간"};//예시입니다. 파일인풋을 읽어들이게 만들예정
	String tablecontents[][]= {
			{"아우터","청자켓", "2XL","3일"},						
			{"신발","나이키 에어맥스", "275", "2일"},
			{"바지","밴딩 조거팬츠", "28", "5일"},
	};
	void addMenu() {
		ActionListener listener = new ButtonListener();
		MainGUI.menuPanel.setBackground(Color.white);
		MainGUI.menuPanel.setLayout(new GridLayout(MainGUI.menus.length,1));
		MainGUI.menuPanel.setPreferredSize(new Dimension(200, 600));
		for(int i=0;i<MainGUI.menus.length;i++) {
			String menuname = MainGUI.menus[i];
			JButton button = new JButton(menuname);
			button.addActionListener(listener);
			MainGUI.menuPanel.add(button);
		}
		/*JButton input = new JButton("파일입력");
		JButton order = new JButton("주문하기");
		JButton login = new JButton("로그인");
		JButton admin = new JButton("관리자기능");
		MainGUI.menuPanel.add(input);
		MainGUI.menuPanel.add(order);
		MainGUI.menuPanel.add(login);
		MainGUI.menuPanel.add(admin);*/
	}
	void addDisplay() {
		MainGUI.displayPanel.setLayout(new BorderLayout());
		MainGUI.displayPanel.setPreferredSize(new Dimension(800,200));
		MainGUI.displayPanel.add(new JTextField(50),BorderLayout.NORTH);
		JTable table = new JTable(tablecontents,tableheader);
		table.setBackground(Color.LIGHT_GRAY);
		MainGUI.displayPanel.add(table,BorderLayout.CENTER);
	}
	
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if(buttonName.equals("파일입력"))
				JOptionPane.showMessageDialog(null, "파일입력");
			else if(buttonName.equals("주문하기"))
				JOptionPane.showMessageDialog(null, "주문하기");
			else if(buttonName.equals("로그인"))
				JOptionPane.showMessageDialog(null, "로그인");
			else if(buttonName.equals("관리자기능"))
				JOptionPane.showMessageDialog(null, "관리자기능");
		}
		
	}
}
