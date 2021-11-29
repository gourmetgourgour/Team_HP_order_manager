package shoppingMall;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;


import store.*;


public class BasketGui {	
		ActionListener Listener = new ButtonListener();
		
		JButton clearBasket = new JButton("장바구니 비우기");
		JButton payButton = new JButton("결제하기");
		
//		JTextField orderInfo = new JTextField("배송예정일: 2021/11/30, 총 가격: 99000");
		
	void addBasket() {
		JPanel basketlabels = new JPanel();
		basketlabels.setPreferredSize(new Dimension(900, 800));
		basketlabels.setLayout(new GridLayout(20,1));
//		for(int i=0; i<od.orderedItemList.size();i++) {
//			JLabel products = new JLabel();
//			products.setPreferredSize(new Dimension(600,100));
//			ImageIcon productimg = getImg(od.orderedItemList.get(i).primg, 60);
//			JButton primage = new JButton(productimg);
//			primage.setSize(new Dimension(60, 60));
//			products.add(BorderLayout.LINE_START, primage);
//		}
		clearBasket.addActionListener(Listener);
		payButton.addActionListener(Listener);
		
		
		
		
		MainGUI.basketpanel.setBounds(20, 30, 1000, 630);
		
		MainGUI.basketpanel.add(clearBasket);
		MainGUI.basketpanel.add(payButton);
	}
	

	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if(buttonName.equals("결제하기")) {
				JOptionPane.showMessageDialog(null, "결제하시겠습니까? 아직미완성ㅠ");
			}
			else if(buttonName.equals("장바구니 비우기"))
				JOptionPane.showMessageDialog(null, "주문내역을 비울 기능, 미완성");
			
		}
	}
	ImageIcon getImg(String imgnum, int num) {
		ImageIcon pruductImg = new ImageIcon("./images/"+imgnum);
		Image img = pruductImg.getImage();
		Image changeImg= img.getScaledInstance(num,num, Image.SCALE_SMOOTH);	
		ImageIcon productimg = new ImageIcon(changeImg);
		return productimg;
	}
}
