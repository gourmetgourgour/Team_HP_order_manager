package swing;

import components.LabelTripDemo.1;
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
		String[] texts = new String[]{"제주도", "설악산", "남해안", "울릉도"};
		this.banners = new MyLabel[4];
		JPanel startPanel = new JPanel(new GridLayout(1, 2));
		JPanel endPanel = new JPanel(new GridLayout(1, 2));

		for (int i = 0; i < 4; ++i) {
			this.banners[i] = new MyLabel(texts[i], i);
			if (i < 2) {
				startPanel.add(this.banners[i]);
			} else {
				endPanel.add(this.banners[i]);
			}
		}

		this.add(startPanel, "First");
		message = new JLabel("제주도:0 설악산:0 남해안:0 울릉도:0");
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
      SwingUtilities.invokeLater(new 1());
   }
}
