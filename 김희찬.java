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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

public class guiLabel extends JLabel implements MouseListener {
	String place;
	int count;
	int colorIndex;
	int colors[] = new int[3];


	void addComponents(String place, int colorIndex) {
		this.place = place;
		this.colorIndex = colorIndex;

		if(colorIndex < 3)
			colors[colorIndex] = colors[colorIndex] + 30;
		else
			colors[0] = colors[1] = colors[2] = 30;

		setText(this.place);
		setForeground(Color.BLUE);
		setBackground(new Color(colors[0], colors[1], colors[2]));
		setHorizontalAlignment(JLabel.CENTER);
		setPreferredSize(new Dimension(150,100));
		setOpaque(true);
		addMouseListener(this);
	}

	String returnCountString() {
		return place + ":" + count;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
		if(colorIndex < 3)
			colors[colorIndex] = colors[colorIndex] + 30;
		else {
			colors[0] = colors[1] = colors[2] = colors[0] + 30;
		}

		for(int i = 0 ; i < 3 ; i++) {
			if(colors[i] > 255)
				this.colors[i] = 255;
		}

		setBackground(new Color(colors[0], colors[1], colors[2]));
		JOptionPane.showMessageDialog(null, place + "를 선택하셨습니다.");
		count = count + 1;
		gui.setCount();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
