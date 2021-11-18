package shoppingMall;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import facade.DataEngineInterface;
import store.*;
import mgr.*;
public class ProductGui {
	JPanel productPanel = new JPanel();
	JScrollPane scroll = new JScrollPane(productPanel, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	String imgnum;
	void addproduct() {	
		productPanel.setPreferredSize(new Dimension(1000,7000));
		productPanel.setLayout(new GridLayout(25,4, 20, 20));
		for(int i=0; i<89; i++) {

			Manageable m = Store2.itemMgr.mList.get(i);
			Item itm = (Item)m;
			imgnum = itm.primg;
//			imgnum = Integer.toString(100000+i+1);
			
			ImageIcon pruductImg = new ImageIcon("./images/"+imgnum);
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