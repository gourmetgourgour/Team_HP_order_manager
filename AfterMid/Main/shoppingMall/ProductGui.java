package shoppingMall;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.*;

public class ProductGui {
	ArrayList<String> items = new ArrayList<>();
	ArrayList<String> names = new ArrayList<>();

	JPanel productPanel = new JPanel();
	JScrollPane scroll = new JScrollPane(productPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	// 1. products.txt 파일을 모두 탭으로 분리해서 arr에 저장
	// 2. arr의 2번째, 13번째, 24번째 ... get해서 names에 저장
	public String[] readProduct() throws IOException {
		File file = new File("products.txt");
		String[] splitstr = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
		String line = null;
		splitstr = null;
		while ((line = br.readLine()) != null) {
			splitstr = null;
			splitstr = line.split("\t");

			for (int i = 0; i < splitstr.length; i++) {
				splitstr[i] = splitstr[i].trim();
			}
		}
		System.out.println(splitstr);
		return splitstr;
	}

	public ArrayList<String> getName(String[] splitstr) {
		ArrayList<String> names = new ArrayList<>();
		for (int i = 2; i < splitstr.length; i += 11) {
			String name = splitstr[i];
			names.add(name);
		}
		return names;
	}
	
	public ArrayList<String> getPrice(String[] splitstr) {
		ArrayList<String> prices = new ArrayList<>();
		for(int i=3;i<splitstr.length;i+=11) {
			String price = splitstr[i];
			prices.add(price);
		}
		return prices;
	}

	void addproduct() throws IOException {
		productPanel.setPreferredSize(new Dimension(1000, 1000));
		productPanel.setLayout(new GridLayout(0, 5, 3, 3)); // row, col, hgap, vgap

		for (int i = 0; i < 12; i++) { // 바꾸기
			String imgnum = Integer.toString(i + 1);
			ImageIcon pruductImg = new ImageIcon(imgnum + ".jpg");
			Image img = pruductImg.getImage();
			Image changeImg = img.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
			ImageIcon productimg = new ImageIcon(changeImg);

			JLabel product = new JLabel(productimg);
			String[] splitstr = readProduct();
			ArrayList<String> name = getName(splitstr);
			// String name = new String("음메");
			String price = new String("3000"); // 이 부분 수정

			JButton b = new JButton(name + " " + price + "원", productimg);
			b.setHorizontalTextPosition(SwingConstants.CENTER);
			b.setVerticalTextPosition(SwingConstants.BOTTOM);
			b.setBorderPainted(false);
			b.setFocusPainted(false);
			product.setBackground(Color.white);
			b.setBackground(Color.WHITE);

			productPanel.add(b);
		}

		scroll.setPreferredSize(new Dimension(1000, 550));
		MainGUI.leftView.add(scroll);

	}

}
