package shoppingMall;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ProductGui {
	JPanel productPanel = new JPanel();
	
	void addproduct() {	
		productPanel.setPreferredSize(new Dimension(1050,550));
		productPanel.setLayout(new GridLayout(3,4));
		productPanel.setBackground(Color.black);
		for(int i=0; i<12; i++) {
			String imgnum = Integer.toString(i+1);
			ImageIcon pruductImg = new ImageIcon("./images/"+imgnum+".jpg");
			Image img = pruductImg.getImage();
			Image changeImg= img.getScaledInstance(150,150, Image.SCALE_SMOOTH);	
			ImageIcon productimg = new ImageIcon(changeImg);
			
			JButton product = new JButton(productimg);
			productPanel.add(product);
		}
		JScrollPane scroll = new JScrollPane(productPanel, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		MainGUI.leftView.setBackground(Color.white);
		MainGUI.leftView.add(productPanel);
		
	}
	
	
}
