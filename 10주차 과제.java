package swing;
import java.awt.*;
import javax.swing.*;


public class gui extends JFrame {
	static JLabel center;
	static guiLabel[] ContentLabel;

	public static void main(String[] args) {
		gui label = new gui();
		label.createAndShowGUI();
	}

	void addComponentsToPane() {
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		String[] places = new String[] {"제주도", "설악산", "남해안", "울릉도"};

		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());

		center = new JLabel("제주도:0 설악산:0 남해안:0 울릉도:0");
		center.setHorizontalAlignment(JLabel.CENTER);
		center.setPreferredSize(new Dimension(300,40));
		pane.add(center, BorderLayout.CENTER);

	
		top.setLayout(new GridLayout(1,2));
		bottom.setLayout(new GridLayout(1,2));

		ContentLabel = new guiLabel[4];
		for (int i = 0 ; i < 4 ; i++) {
			ContentLabel[i] = new guiLabel();
			ContentLabel[i].addComponents(places[i], i);
			if(i < 2) 
				top.add(ContentLabel[i]);
			else
				bottom.add(ContentLabel[i]);	
		}

		pane.add(top, BorderLayout.NORTH);
		pane.add(bottom, BorderLayout.SOUTH);
	}

	static void setCount() {
		String setCountText = "";

		for(int i = 0 ; i< 4; i++) {
			setCountText = setCountText + ContentLabel[i].returnCountString() + " ";
		}
		center.setText(setCountText);
	}

	
	void createAndShowGUI() {
		setTitle("객체지향프로그래밍 스윙 과제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane();
		pack();
		setVisible(true);		
	}

}



=====
  
package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class guiLabel extends JLabel implements MouseListener {
	String place;
	int count;
	int index;
	int[] colors = new int[4];

	void addComponents(String text, int index) {
		this.place = text;
		this.index = index;
		if (index < 2) {
			this.colors[index] += 65;
			this.colors[index+1] += 65;
		} else {
			this.colors[0] = 40*index;
			this.colors[1] = 20*index;
			this.colors[2] = this.colors[3] = 60*index ;
		}

		this.setForeground(Color.BLUE);
		this.setBackground(new Color(this.colors[0], this.colors[1], this.colors[2]));
		
		setForeground(new Color((int) (Math.random() * 255),
				(int) (Math.random() * 255), (int) (Math.random() * 255)));
		setBackground(new Color((int) (Math.random() * 255),
				(int) (Math.random() * 255), (int) (Math.random() * 255)));

		Dimension dim = new Dimension(100, 100);
		this.setText(this.place);
		this.setHorizontalAlignment(0);
		this.setPreferredSize(dim);
		this.addMouseListener(this);
		this.setOpaque(true);
	}

	String returnCountString() {
		return this.place + ":" + this.count;
	}


	public void mouseClicked(MouseEvent e) {
		if (this.index < 3) {
			this.colors[this.index] += 40;
			this.colors[this.index+1] += 40;

		} else {
			this.colors[this.index-2] += 40;
			this.colors[this.index-3] += 40;
		}

		for (int n = 0; n < 3; ++n) {
			if (this.colors[n] > 255) {
				this.colors[n] = this.colors[n]-255;
			}
		}

		this.setBackground(new Color(this.colors[0], this.colors[1], this.colors[2]));
		JOptionPane.showMessageDialog(null, this.place + "를 선택하셨습니다.");
		++this.count;
		gui.setCount();
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
	
	



}
