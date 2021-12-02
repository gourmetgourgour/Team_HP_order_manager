package shoppingMall;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableCellRenderer;

import store.*;

public class AdminGui {
	static ActionListener listener = new ButtonListener();
	static public JFrame adminFrame = new JFrame("������ GUI");
	static Container pane = adminFrame.getContentPane();
	static Font font = new Font("Aharoni", Font.BOLD, 18); // �̻���Ʈ ��õ�޽��ϴ�..

	public static void main(String[] args) {
		AdminGui.createAndShowGUI();
	}

	public static void createAndShowGUI() {
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.setSize(1200, 700);
		adminFrame.setLayout(null);
		adminFrame.setLocationRelativeTo(null);
		addAdmin();
		addTable();
		pane.setBackground(new Color(157, 237, 255));
		adminFrame.setVisible(true);
	}

	static void addAdmin() {
		JButton searchproduct = new JButton("��ǰ �˻�");
		searchproduct.setForeground(Color.white);
		searchproduct.setBounds(1020, 70, 150, 150);
		searchproduct.setBackground(new Color(68, 115, 197));
		searchproduct.setFont(font);
		searchproduct.addActionListener(listener);
		pane.add(searchproduct);

		JButton searchuser = new JButton("���� �˻�");
		searchuser.setForeground(Color.white);
		searchuser.setBounds(1020, 260, 150, 150);
		searchuser.setBackground(new Color(68, 115, 197));
		searchuser.setFont(font);
		searchuser.addActionListener(listener);
		pane.add(searchuser);

		JButton logout = new JButton("�α׾ƿ�");
		logout.setForeground(Color.white);
		logout.setBounds(1020, 450, 150, 150);
		logout.setBackground(new Color(68, 115, 197));
		logout.setFont(font);
		logout.addActionListener(listener);
		pane.add(logout);

		ImageIcon logo = new ImageIcon("./images/HPLogo.png");
		Image img = logo.getImage();
		Image changeImg = img.getScaledInstance(180, 160, Image.SCALE_SMOOTH);
		ImageIcon logo2 = new ImageIcon(changeImg);
		JButton logobutton = new JButton(logo2);
		logobutton.setContentAreaFilled(false);  // ��� �� ����
		logobutton.setBorderPainted(false);

		logobutton.setBounds(500, 20, 180, 160);
		pane.add(logobutton);

	}

	static void addTable() {
		String header[] = { "��ǰ�ڵ�", "��ǰ��", "����", "�԰�����", "�԰����" };
		String contents[][] = { { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" } };
		
		JTable table = new JTable(contents, header) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
				component.setBackground(new Color(255, 255, 190));
				return component;
			}
		};  // JTable�� Cell�� ���� ������ ����
		for (int i = 0; i < Store.itemMgr.mList.size(); i++) {
			Item item = Store.itemMgr.mList.get(i);
			table.setValueAt(item.prCode, i, 0);
			table.setValueAt(item.prName, i, 1);
			table.setValueAt(Integer.toString(item.prStock), i, 2);
			table.setValueAt("�԰�����", i, 3);
			table.setValueAt("�԰����", i, 4);
		}

		table.setPreferredSize(new Dimension(800, 1000));
		JScrollPane scroll = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(150, 200, 820, 400);

		pane.add(scroll);
	}

	static class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			Item itm = null;
			User usr = null;
			String buttonName = e.getActionCommand();
			if (buttonName.equals("��ǰ �˻�")) {
				String productName = JOptionPane.showInputDialog("��ǰ �̸��� �Է��ϼ���");
				if (productName == null)
					return;
				for (int i = 0; i < Store.itemMgr.mList.size(); i++) {
					if (Store.itemMgr.mList.get(i).matches(productName)) {
						itm = Store.itemMgr.mList.get(i);
						JOptionPane.showMessageDialog(null,
								"��ǰ��: " + itm.prName + "\n��ǰ�ڵ�: " + itm.prCode + "\n������: " + itm.prStock);
					}
				}
			} else if (buttonName.equals("���� �˻�")) {
				String username = JOptionPane.showInputDialog("�������̵� �Է��ϼ���");
				if (username == null)
					return;
				for (int i = 0; i < Store.userMgr.mList.size(); i++) {
					if (Store.userMgr.mList.get(i).matches(username)) {
						usr = Store.userMgr.mList.get(i);
						JOptionPane.showMessageDialog(null, "�������̵�: " + usr.userId + "\n��й�ȣ: " + usr.pwd);
					}
				}
			} else if (buttonName.equals("�α׾ƿ�")) {
				adminFrame.dispose();
				MainGUI.login.main(null);
			}
		}
	}
}