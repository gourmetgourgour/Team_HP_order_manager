package shoppingMall;

import java.awt.*;

import javax.swing.*;

public class MainGUI {
	static JPanel menuPanel = new JPanel();
	static JPanel displayPanel = new JPanel();
	static JFrame mainFrame = new JFrame("HP 쇼핑몰");
	static Container mainPane = mainFrame.getContentPane();
	static String menus [] = {"파일입력", "주문하기", "로그인", "관리자기능",}; 
	static void addComponentsToPane() {
		GuiMenu guimenu = new GuiMenu();
		guimenu.addMenu();
		guimenu.addDisplay();
		mainPane.add(displayPanel);
		mainPane.add(menuPanel, BorderLayout.LINE_END);
	}
	private static void createAndShowGUI() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1000, 600);
		mainFrame.setLocationRelativeTo(null);
		MainGUI.addComponentsToPane();
		mainFrame.setVisible(true);
	}
	public static void main(String[] args) {
		MainGUI.createAndShowGUI();
	}
}
