package shoppingMall;

import java.awt.*;

import javax.swing.*;

public class MainGUI {
	static JPanel menuPanel = new JPanel();
	static JPanel products = new JPanel();
	static JPanel leftView = new JPanel();
	static JFrame mainFrame = new JFrame("행복한 판매팀");
	static Container mainPane = mainFrame.getContentPane();
	static JPanel basketpanel = new JPanel();
	
	
	static void addComponentsToPane() {
		GuiMenu guimenu = new GuiMenu();
		GuiUppermenu upmenu = new GuiUppermenu();
		ProductGui productgui = new ProductGui();
		BasketGui basket = new BasketGui();
		guimenu.addMenu();
		upmenu.addMenu();
		basket.addBasket();
		productgui.addproduct();
		mainPane.add(menuPanel, BorderLayout.LINE_END);
		mainPane.add(basketpanel);
		basketpanel.setVisible(false);
		mainPane.add(leftView);
	}
	private static void createAndShowGUI() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1200, 700);
		mainFrame.setLocationRelativeTo(null);
		MainGUI.addComponentsToPane();
		
		mainFrame.setVisible(true);
	}
	public static void main(String[] args) {
		MainGUI.createAndShowGUI();
	}
}