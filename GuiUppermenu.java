package shoppingMall;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GuiUppermenu {
	    JPanel upperMenu = new JPanel();
		JLabel sortMenuLabel = new JLabel();
		JLabel selectedSort = new JLabel();
		String sortMenus[] = {"옷 종류", "색상", "사이즈", "소재", "빠른 배송"};
	void addMenu() {
		upperMenu.setPreferredSize(new Dimension(1050,130));
		sortMenuLabel.setPreferredSize(new Dimension(1000,55));
		sortMenuLabel.setLayout(null);
		upperMenu.setBackground(new Color(203,230,255));
		for(int i=0; i<sortMenus.length; i++) {
			JButton button = new JButton(sortMenus[i]);
			sortMenuLabel.add(button);
			int xcode = 30;										//버튼의 x값 초기위치
			xcode += i*(180);
			button.setBounds(xcode, 5, 150, 50);
			button.setBackground(new Color(232,244,255));
			if(i == 0) {
				button.setForeground(Color.black);
				}
				else if(i==1) {
					button.setForeground(Color.black);
				}
				else if(i==2) {
					button.setForeground(Color.black);
				}
				else if(i==3) {
					button.setForeground(Color.black);
				}
				else if(i==4) {
					button.setForeground(Color.black);
				}
				else if(i==5) {
					button.setForeground(Color.black);
				}					
		}
		upperMenu.add(sortMenuLabel);
		
		selectedSort.setPreferredSize(new Dimension(1000, 130));
		selectedSort.setLayout(null);
		JButton reset = new JButton("초기화");
		
		for(int i=0;i<sortMenus.length; i++) {
			int xcode = 70;										
			xcode += i*(160);

			JLabel sortLabel = new JLabel("["+sortMenus[i]+"] :");
			if(i == 0) {
			sortLabel.setForeground(new Color(223,0,104));
			}
			else if(i==1) {
				sortLabel.setForeground(new Color(223,0,104));
			}
			else if(i==2) {
				sortLabel.setForeground(new Color(223,0,104));
			}
			else if(i==3) {
				sortLabel.setForeground(new Color(223,0,104));
			}
			else if(i==4) {
				sortLabel.setForeground(new Color(223,0,104));
			}
			else if(i==5) {
				sortLabel.setForeground(new Color(223,0,104));
			}
			selectedSort.add(sortLabel);
			sortLabel.setBounds(xcode, 0, 200, 50);
		}
		selectedSort.add(reset);
		reset.setBounds(905, 0, 80, 40);
		reset.setBackground(new Color(232,244,255));
		upperMenu.add(selectedSort);
		
		MainGUI.leftView.add(upperMenu);
	}
	
	
}