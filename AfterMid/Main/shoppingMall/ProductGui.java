package shoppingMall;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import facade.DataEngineInterface;
import mgr.*;
import store.*;

public class ProductGui {
	LocalDate curDate = LocalDate.now();
	Font font = new Font("Serif",Font.PLAIN, 20);
	
	JPanel productPanel = new JPanel();
	JScrollPane scroll = new JScrollPane(productPanel, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JFrame productInfoframe = new JFrame("구매");
	
	String imgnum;
	LocalDate arrivalDate;
	void addproduct() {	
		productPanel.setPreferredSize(new Dimension(1000,7000));
		productPanel.setLayout(new GridLayout(25,4, 20, 20));
		for(int i=0; i<100; i++) {

			Manageable m = Store.itemMgr.mList.get(i);
			Item itm = (Item)m;
			imgnum = itm.primg;
			ImageIcon productimg =getImg(imgnum, 150);
			
			JButton product = new JButton(productimg);
			
			product.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
						 productInfo(itm);
				}
			});
			product.setBackground(Color.white);
			productPanel.add(product);
		}
		
		scroll.setPreferredSize(new Dimension(1000, 550));
		MainGUI.leftView.add(scroll);
		
	}
	
	
	void productInfo(Item item) {
		productInfoframe.setSize(800, 600);
		//왼쪽화면, 사진 및 배송예정일부터 색상까지를 담은 panel
		ImageIcon productimg = getImg(item.primg, 300);
		JButton product = new JButton(productimg);
		arrivalDate = curDate.plusDays(item.prDeliver);
		
		JPanel productInfo = new JPanel();
		productInfo.setBackground(Color.white);
		productInfo.setPreferredSize(new Dimension(350, 580));
		productInfo.add(BorderLayout.NORTH,product);
		JTextArea info = new JTextArea(
				"\n배송예정일 : " + arrivalDate + "\n\n" +
				"가격: " + Integer.toString(item.prPrice) +"\n\n" +
				"사이즈:" + item.prSize + "\n\n" +
				"소재 :" + item.prType + "\n\n" +
				"색상 :" + item.prColor);
		info.setPreferredSize(new Dimension(300, 250));
		info.setFont(font);
		productInfo.add(BorderLayout.SOUTH,info);
		productInfoframe.add(BorderLayout.LINE_START,productInfo);
		
		
		//오른쪽화면, 제품설명과 수량정하기, 장바구니에 추가까지
		JPanel addtoBasket = new JPanel();
//		addtoBasket.setBackground(Color.white);
		addtoBasket.setPreferredSize(new Dimension(450, 580));
		JTextField productName = new JTextField(item.prName);
		productName.setFont(font);
		JTextArea productDesc = new JTextArea("-------------------------------------------------------------\n\n\n"+item.prDesc+"\n\n\n-------------------------------------------------------------");
		productDesc.setLineWrap(true);
		productName.setPreferredSize(new Dimension(440, 150));
		productDesc.setFont(font);
		productDesc.setPreferredSize(new Dimension(440, 200));
		
		int count = 1;
		JLabel productUpdown = new JLabel();
		productUpdown.setPreferredSize(new Dimension(440, 200));
		JTextArea productCount = new JTextArea("\n수량 : \t[" + count + "]");
		productCount.setPreferredSize(new Dimension(240, 50));
		productCount.setFont(font);
		JButton up = new JButton("UP");
		JButton down = new JButton("DOWN");
		JButton addBasket = new JButton("장바구니에 추가");
		up.setPreferredSize(new Dimension(60,40));
		down.setPreferredSize(new Dimension(60, 40));
		up.setBackground(Color.white);
		down.setBackground(Color.white);
		addBasket.setBackground(Color.black);
		productUpdown.add(BorderLayout.LINE_START,productCount);
		productUpdown.add(up);
		productUpdown.add(down);
		
		
		
		addtoBasket.add(productName);
		addtoBasket.add(productDesc);
		addtoBasket.add(productCount);
		addtoBasket.add(productUpdown);
		
		
		productInfoframe.add(BorderLayout.LINE_END,addtoBasket);
		productInfoframe.add(addBasket);
		addBasket.setBounds(500,440,300,150);
		productInfoframe.setVisible(true);
	}
	
	
	ImageIcon getImg(String imgnum, int num) {
		ImageIcon pruductImg = new ImageIcon("./images/"+imgnum);
		Image img = pruductImg.getImage();
		Image changeImg= img.getScaledInstance(num,num, Image.SCALE_SMOOTH);	
		ImageIcon productimg = new ImageIcon(changeImg);
		return productimg;
	}
}
