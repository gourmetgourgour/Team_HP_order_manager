package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LabelTripDemo extends JPanel {
 private static LabelTripDemo tripDemoPanel = null;
 JFrame frame = null;
 public MyLabel[] banners = null;
 static JLabel message = null;

 public static LabelTripDemo GetInstance() {
  if (tripDemoPanel == null) {
   tripDemoPanel = new LabelTripDemo();
  }

  return tripDemoPanel;
 }

 public LabelTripDemo() {
  super(new BorderLayout());
  String[] texts = new String[]{"고은아", "김희찬", "이예진", "주지호", "최병훈"};
  this.banners = new MyLabel[5];
  JPanel startPanel = new JPanel(new GridLayout(1, 2));
  JPanel endPanel = new JPanel(new GridLayout(1, 2));

  for (int i = 0; i < 5; ++i) {
   this.banners[i] = new MyLabel(texts[i], i);
   if (i < 2) {
    startPanel.add(this.banners[i]);
   } else {
    endPanel.add(this.banners[i]);
   }
  }

  this.add(startPanel, "First");
  message = new JLabel("고은아:0 김희찬:0 이예진:0 주지호:0 최병훈:0");
  message.setHorizontalAlignment(0);
  message.setPreferredSize(new Dimension(300, 40));
  message.setBackground(Color.WHITE);
  message.setOpaque(true);
  this.add(message, "Center");
  this.add(endPanel, "Last");
 }

 void setCountMessage() {
  String messageText = "";

  for (int i = 0; i < 4; ++i) {
   messageText = messageText + this.banners[i].getMessage() + " ";
  }

  message.setText(messageText);
 }

 private static void createAndShowGUI() {
  JFrame frame = new JFrame("ColorChooserDemo2");
  frame.setDefaultCloseOperation(3);
  tripDemoPanel = new LabelTripDemo();
  tripDemoPanel.setOpaque(true);
  frame.setContentPane(tripDemoPanel);
  tripDemoPanel.frame = frame;
  frame.pack();
  frame.setVisible(true);
 }

 public static void main(String[] args) {
      LabelTripDemo LTD = new LabelTripDemo();
      LTD.createAndShowGUI();
   }
}



=============
  
  
  
  
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
	int[] colors = new int[3];

	MyLabel(String text, int index) {
		this.place = text;
		this.index = index;
		if (index < 3) {
			this.colors[index] += 20;
		} else {
			this.colors[0] = this.colors[1] = this.colors[2] = 20;
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
			this.colors[0] = this.colors[1] = this.colors[2] = this.colors[0] + 20;
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
