package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelTripDemo extends JPanel {
	private static LabelTripDemo stdPickPanel = null;
	JFrame frame = null;
	public MyLabel[] banners = null;
	static JLabel message = null;

	public static LabelTripDemo GetInstance() {
		if (stdPickPanel == null) {
			stdPickPanel = new LabelTripDemo();
		}

		return stdPickPanel;
	}

	public LabelTripDemo() {
		super(new BorderLayout());
		String[] texts = new String[] { "햄버거", "피자", "치킨", "족발", "짜장면" };
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
		message = new JLabel(" 햄버거:0  피자:0  치킨:0  족발:0  짜장면:0 ");
		message.setHorizontalAlignment(0);
		message.setPreferredSize(new Dimension(200, 300));
		message.setForeground(new Color((int) (Math.random() * 255),
				(int) (Math.random() * 255), (int) (Math.random() * 255)));
		message.setBackground(new Color((int) (Math.random() * 255),
				(int) (Math.random() * 255), (int) (Math.random() * 255)));
		message.setOpaque(true);
		this.add(message, "Center");
		this.add(endPanel, "Last");
	}

	void setCountMessage() {
		String messageText = "";

		for (int i = 0; i < 5; ++i) {
			messageText = messageText + this.banners[i].getMessage() + " ";
		}

		message.setText(messageText);
	}
	void setPaneColor() {
		message.setBackground(new Color((int)(Math.random() * 255),
				(int)(Math.random() * 255), (int)(Math.random() * 255)));
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("MenuPicker");
		frame.setDefaultCloseOperation(3);
		stdPickPanel = new LabelTripDemo();
		stdPickPanel.setOpaque(true);
		frame.setContentPane(stdPickPanel);
		stdPickPanel.frame = frame;
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		LabelTripDemo MP = new LabelTripDemo();
		MP.createAndShowGUI();
	}
}
