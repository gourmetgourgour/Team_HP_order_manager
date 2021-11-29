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
		Order od = null;
//		JTextField orderInfo = new JTextField("배송예정일: 2021/11/30, 총 가격: 99000");
		
	public void addBasket() {
		
		JPanel basketlabels = new JPanel();
		basketlabels.setPreferredSize(new Dimension(500, 600));
		basketlabels.setLayout(new GridLayout(5,1, 0, 10));
		basketlabels.setBackground(Color.gray);
		
		int lastorderId = Store.orderMgr.mList.get(Store.orderMgr.mList.size()-1).orderId;
		
		
		if(!MainGUI.loggedinuser.myOrderList.isEmpty()) {
			od = MainGUI.loggedinuser.myOrderList.get(MainGUI.loggedinuser.myOrderList.size()-1);
				
		}
		for(int i=0; i<od.orderedItemList.size();i++) {
			Item itm = od.orderedItemList.get(i);
			JLabel products = new JLabel();
			products.setPreferredSize(new Dimension(600,100));
			
			JButton name = new JButton(itm.prName + "\n" + itm.prPrice);
			name.setFont(new Font("Serif",Font.BOLD, 20));
			name.setSize(new Dimension(400,120));
			name.setBackground(Color.white);
			ImageIcon productimg = getImg(itm.primg, 80);
			JButton primage = new JButton(productimg);
			primage.setSize(new Dimension(120, 120));
			primage.setBackground(Color.white);
			
			JButton address = new JButton(od.address);
			address.setPreferredSize(new Dimension(200,120));
			products.add(BorderLayout.LINE_START, primage);
			products.add(BorderLayout.CENTER, name);
			products.add(BorderLayout.LINE_END, address);
			
			basketlabels.add(products);
		}
		
		JScrollPane scroll = new JScrollPane(basketlabels,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(900, 400));
		
		clearBasket.addActionListener(Listener);
		payButton.addActionListener(Listener);
		MainGUI.basketpanel.add(scroll);
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
