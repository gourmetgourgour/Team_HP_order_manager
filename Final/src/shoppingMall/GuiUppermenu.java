package shoppingMall;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*;

public class GuiUppermenu {
	JPanel upperMenu = new JPanel();

	void addMenu() {

		upperMenu.setBackground(new Color(203, 230, 255));
		upperMenu.setPreferredSize(new Dimension(1050, 200));
		ImageIcon logo = getImg("HPLogo.png", 170);
		JButton imglogo = new JButton(logo);
		imglogo.setContentAreaFilled(false);
		imglogo.setBackground(Color.white);
		imglogo.setBorderPainted(false);
		imglogo.setBounds(600, 0, 180, 180);

		upperMenu.add(imglogo);

		MainGUI.leftView.add(upperMenu);
	}

	ImageIcon getImg(String imgnum, int num) {
		ImageIcon pruductImg = new ImageIcon("./images/" + imgnum);
		Image img = pruductImg.getImage();
		Image changeImg = img.getScaledInstance(num, num, Image.SCALE_SMOOTH);
		ImageIcon productimg = new ImageIcon(changeImg);
		return productimg;
	}

}