package shoppingMall;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ProductGui {
	JPanel productPanel = new JPanel();
	JScrollPane scroll = new JScrollPane(productPanel, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	void addproduct() {	
		productPanel.setPreferredSize(new Dimension(1000,950));
		productPanel.setLayout(new GridLayout(3,4, 20, 20));

		for(int i=0; i<12; i++) {
			String imgnum = Integer.toString(i+1);
			ImageIcon pruductImg = new ImageIcon("./images/"+imgnum+".jpg");
			Image img = pruductImg.getImage();
			Image changeImg= img.getScaledInstance(150,150, Image.SCALE_SMOOTH);	
			ImageIcon productimg = new ImageIcon(changeImg);
			
			JButton product = new JButton(productimg);
			product.setBackground(Color.white);
			productPanel.add(product);
		}
		
		scroll.setPreferredSize(new Dimension(1000, 550));
		MainGUI.leftView.add(scroll);
		
	}
	
	
}