package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyLabel extends JLabel implements MouseListener {
	String place;
	int count;
	int index;
	int[] colors = new int[4];

	MyLabel(String text, int index) {
		this.place = text;
		this.index = index;
		if (index < 4) {
			this.colors[index] += 65;
		} else {
			this.colors[0] = this.colors[1] = this.colors[2] = this.colors[3] = 60 ;
		}

		this.setForeground(Color.BLUE);
		this.setBackground(new Color(this.colors[0], this.colors[1], this.colors[2]));
		Dimension dim = new Dimension(100, 100);
		this.setText(this.place);
		this.setHorizontalAlignment(0);
		this.setPreferredSize(dim);
		this.addMouseListener(this);
		this.setOpaque(true);
	}

	String getMessage() {
		return this.place + ":" + this.count;
	}

	public void mouseClicked(MouseEvent arg0) {
		if (this.index < 3) {
			this.colors[this.index] += 20;
		} else {
			this.colors[3] = this.colors[0] = this.colors[1] = this.colors[2] = this.colors[0] + 20;
		}

		for (int n = 0; n < 3; ++n) {
			if (this.colors[n] > 255) {
				this.colors[n] = 255;
			}
		}

		this.setBackground(new Color(this.colors[0], this.colors[1], this.colors[2]));
		JOptionPane.showMessageDialog(LabelTripDemo.GetInstance().frame, this.place + "를 선택하셨습니다.");
		++this.count;
		LabelTripDemo.GetInstance().setCountMessage();
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
