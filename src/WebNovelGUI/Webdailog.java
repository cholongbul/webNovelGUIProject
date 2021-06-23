package WebNovelGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Webdailog extends JFrame {

	private JComboBox sitecombo;
	private JRadioButton endoxbtn[];
	private JComboBox<String> YearBox, MMBox, DDBox, YearBox2, MMBox2, DDBox2;
	private JList postingList;
	private JTextField numField;
	private Mgrs mgr;
	private Beans wbean, nbean, postingbean;
	private Vector<String> sitenamelist;
	private Vector<Beans> postingbeanlist;
	private ButtonGroup pubgroup;
	private DefaultListModel webcolist;
	private Novelinsert novelinsert;

	public Webdailog(Novelinsert novelinsert) {
		mgr = new Mgrs();
		wbean = new Beans();
		nbean = new Beans();
		this.novelinsert = novelinsert;
		webcolist = new DefaultListModel();
		sitenamelist = new Vector<String>();
		postingbeanlist = new Vector<Beans>();
		setBounds(0, 0, 350, 600);
		setLocationRelativeTo(null);
		setTitle("����ó ���");
		setResizable(false);
		getContentPane().setLayout(null);

		// ��
		JLabel Label1 = new JLabel("����ó�� �������ּ���");
		Label1.setFont(new Font("����", Font.BOLD, 13));
		Label1.setBounds(15, 5, 285, 15);
		getContentPane().add(Label1);

		sitecombo = new JComboBox();
		sitecombo.setBounds(15, 20, 300, 20);
		getContentPane().add(sitecombo);
		sitecombo.addItem("-����ó-");
		mgr.getListWebcompMgr();
		for (int i = 0; i < mgr.getListWebcompMgr().size(); i++) {
			String webconame = mgr.getListWebcompMgr().get(i).getw_name();
			sitecombo.addItem(webconame);
		}

		JLabel Label2 = new JLabel("�ϰ� ���θ� �������ּ���");
		Label2.setFont(new Font("����", Font.BOLD, 13));
		Label2.setBounds(15, 45, 294, 15);
		getContentPane().add(Label2);

		pubgroup = new ButtonGroup();
		String[] ox = { "�ϰ�", "�̿ϰ�" };

		endoxbtn = new JRadioButton[2];
		for (int i = 0; i < ox.length; i++) {
			endoxbtn[i] = new JRadioButton(ox[i]);
			pubgroup.add(endoxbtn[i]);
			getContentPane().add(endoxbtn[i]);
		}
		endoxbtn[0].setSelected(false);
		endoxbtn[1].setSelected(true);
		endoxbtn[0].setBounds(20, 62, 60, 22);
		endoxbtn[1].setBounds(85, 62, 80, 22);
		endoxbtn[0].addItemListener(new endoxItemListener());
		endoxbtn[1].addItemListener(new endoxItemListener());

		JLabel Label3 = new JLabel("����������� �Է����ּ���");
		Label3.setFont(new Font("����", Font.BOLD, 13));
		Label3.setBounds(15, 89, 294, 15);
		getContentPane().add(Label3);

		String[] Year = new String[100];
		for (int i = 0; i < Year.length; i++) {
			Year[i] = Integer.toString(1920 + i);
		}
		YearBox = new JComboBox<String>(Year);
		YearBox.setBounds(15, 107, 116, 23);
		YearBox.setSelectedIndex(90);
		getContentPane().add(YearBox);

		String MM[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

		MMBox = new JComboBox<String>(MM);
		MMBox.setBounds(133, 107, 57, 23);
		getContentPane().add(MMBox);

		String[] DD = new String[31];
		for (int j = 0; j < DD.length; j++) {
			DD[j] = Integer.toString(j + 1);
		}
		DDBox = new JComboBox<String>(DD);
		DDBox.setBounds(192, 107, 57, 23);
		getContentPane().add(DDBox);

		JLabel Label4 = new JLabel("������������ �Է����ּ���");
		Label4.setFont(new Font("����", Font.BOLD, 13));
		Label4.setBounds(15, 135, 294, 15);
		getContentPane().add(Label4);

		YearBox2 = new JComboBox<String>(Year);
		YearBox2.setBounds(15, 153, 116, 23);
		YearBox2.setSelectedIndex(90);
		getContentPane().add(YearBox2);

		MMBox2 = new JComboBox<String>(MM);
		MMBox2.setBounds(133, 153, 57, 23);
		getContentPane().add(MMBox2);

		DDBox2 = new JComboBox<String>(DD);
		DDBox2.setBounds(192, 153, 57, 23);
		getContentPane().add(DDBox2);

		JLabel Label5 = new JLabel("��������� ����ȭ���� �Է����ּ���(���ڸ�)");
		Label5.setFont(new Font("����", Font.BOLD, 13));
		Label5.setBounds(15, 181, 294, 15);
		getContentPane().add(Label5);

		numField = new JTextField();
		numField.setBounds(15, 199, 100, 20);
		getContentPane().add(numField);

		JLabel Label6 = new JLabel("����ó�� ��Ͽ� �߰����ּ���");
		Label6.setFont(new Font("����", Font.BOLD, 13));
		Label6.setBounds(15, 225, 294, 15);
		getContentPane().add(Label6);

		JButton ConfirmBtn = new JButton("�߰�");
		ConfirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < numField.getText().length(); i++) {
					char c = numField.getText().charAt(i);
					if (c < 48 || c > 57) {// ���ڰ� �ƴ� ���
						JOptionPane.showMessageDialog(null, "����Ƚ������ ���ڸ� �־��ּ���", "�߰� ����", JOptionPane.WARNING_MESSAGE);
						
						return;
					}
				}
				if (endoxbtn[1].isSelected()) {
					boolean flag = false;

					for (int i = 0; i < sitenamelist.size(); i++) {
						if (sitenamelist.get(i).equals((String) sitecombo.getSelectedItem())) {
							JOptionPane.showMessageDialog(null, "�̹� �Է��� ����ó�Դϴ�", "�߰� ����", JOptionPane.WARNING_MESSAGE);
							flag = false;
							break;
						} else {
							flag = true;
						} // �ߺ��Ǵ� ���ǻ� �߰� üũ
					}
					if (sitenamelist.size() == 0) {
						flag = true;
					}
					if (flag) {
						if (sitecombo.getSelectedIndex() != 0) {
							String posting = (String) sitecombo.getSelectedItem() + "  //  "
									+ (String) YearBox.getSelectedItem() + "-" + (String) MMBox.getSelectedItem() + "-"
									+ (String) DDBox.getSelectedItem();
							sitenamelist.add((String) sitecombo.getSelectedItem());
							webcolist.addElement(posting);
							postingList.setModel(webcolist);
							nbean.setending(0);
							postingbean = new Beans();
							postingbean.setstarted((String) YearBox.getSelectedItem() + "-"
									+ (String) MMBox.getSelectedItem() + "-" + (String) DDBox.getSelectedItem());
							postingbean.setended(null);
							postingbean.setw_id(mgr.getw_id((String) sitecombo.getSelectedItem()));
							postingbean.setserial(0);
							postingbeanlist.addElement(postingbean);
						} // webposting���̺��� n_ID�� ���� �������� �ʾ����� �����͸� ���� �������� �ѱ�� ���߿� ���̺� �߰�
						else {
							JOptionPane.showMessageDialog(null, "����ó�� �������ּ���.", "�߰� ����", JOptionPane.WARNING_MESSAGE);
						} // ����ó�� �����ߴ��� üũ
					} // �ߺ��Ǵ� ���ǻ� �߰� üũ �÷���
				} // �ϰ����� üũ
				else {
					boolean flag = false;
					for (int i = 0; i < sitenamelist.size(); i++) {
						if (sitenamelist.get(i).equals((String) sitecombo.getSelectedItem())) {
							JOptionPane.showMessageDialog(null, "�̹� �Է��� ����ó�Դϴ�", "�߰� ����", JOptionPane.WARNING_MESSAGE);
							flag = false;
							break;
						} else {
							flag = true;
						} // �ߺ��Ǵ� ���ǻ� �߰� üũ
					} // �ߺ��Ǵ� ���ǻ� �߰� üũ �ݺ���
					if (sitenamelist.size() == 0) {
						flag = true;
					}
					if (flag) {
						if (sitecombo.getSelectedIndex() != 0) {
							String posting = (String) sitecombo.getSelectedItem() + "  //  "
									+ (String) YearBox.getSelectedItem() + "-" + (String) MMBox.getSelectedItem() + "-"
									+ (String) DDBox.getSelectedItem() + " ~ " + (String) YearBox2.getSelectedItem()
									+ "-" + (String) MMBox2.getSelectedItem() + "-" + (String) DDBox2.getSelectedItem()
									+ " // " + numField.getText() + "ȭ";
							sitenamelist.add((String) sitecombo.getSelectedItem());
							webcolist.addElement(posting);
							postingList.setModel(webcolist);
							nbean.setending(1);
							postingbean = new Beans();
							postingbean.setstarted((String) YearBox.getSelectedItem() + "-"
									+ (String) MMBox.getSelectedItem() + "-" + (String) DDBox.getSelectedItem());
							postingbean.setended((String) YearBox2.getSelectedItem() + "-"
									+ (String) MMBox2.getSelectedItem() + "-" + (String) DDBox2.getSelectedItem());
							postingbean.setw_id(mgr.getw_id((String) sitecombo.getSelectedItem()));
							postingbean.setserial(Integer.parseInt(numField.getText()));
							postingbeanlist.addElement(postingbean);
						} else {
							JOptionPane.showMessageDialog(null, "����ó�� �������ּ���.", "�߰� ����", JOptionPane.WARNING_MESSAGE);
						} // ����ó�� �����ߴ��� üũ
					} // �ߺ��Ǵ� ���ǻ� �߰� üũ �÷���
				} // �ϰ����� üũ
			}
		});
		ConfirmBtn.setBounds(122, 245, 97, 23);

		getContentPane().add(ConfirmBtn);

		JLabel Label7 = new JLabel("���������� �����Ѵٸ� ��� �߰����ּ���");
		Label7.setFont(new Font("����", Font.BOLD, 13));
		Label7.setBounds(15, 273, 294, 15);
		getContentPane().add(Label7);

		JLabel novelTab = new JLabel("����ó ���");
		novelTab.setOpaque(true);
		novelTab.setBackground(Color.gray);
		novelTab.setBounds(15, 290, 300, 21);
		getContentPane().add(novelTab);

		postingList = new JList<String>();
		postingList.setBounds(15, 311, 300, 200);
		postingList.setBackground(Color.lightGray);
		getContentPane().add(postingList);

		JButton ConfirmBtn2 = new JButton("�Ϸ�"); // �ٽ� ��ǰ �Է�â����
		ConfirmBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String s = "";
				for (int i = 0; i < sitenamelist.size(); i++) {
					s += sitenamelist.get(i) + " // ";
				}
				novelinsert.siteField.setText(s);
				novelinsert.postingbeanlist = postingbeanlist;
				novelinsert.nbean = nbean;
			}
		});
		ConfirmBtn2.setBounds(72, 516, 97, 23);
		getContentPane().add(ConfirmBtn2);

		JButton ConfirmBtn3 = new JButton("����");
		ConfirmBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedindex = postingList.getSelectedIndex();
				webcolist.removeElementAt(selectedindex);
				sitenamelist.removeElementAt(selectedindex);
				postingList.setModel(webcolist);

			}
		});
		ConfirmBtn3.setBounds(172, 516, 97, 23);
		getContentPane().add(ConfirmBtn3);

		YearBox2.setEnabled(false);
		MMBox2.setEnabled(false);
		DDBox2.setEnabled(false);
		numField.setEnabled(false);
		numField.setBackground(Color.gray);

	}

	class endoxItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (endoxbtn[1].isSelected()) {
				YearBox2.setEnabled(false);
				MMBox2.setEnabled(false);
				DDBox2.setEnabled(false);
				numField.setEnabled(false);
				numField.setBackground(Color.gray);
			} else {
				YearBox2.setEnabled(true);
				MMBox2.setEnabled(true);
				DDBox2.setEnabled(true);
				numField.setEnabled(true);
				numField.setBackground(Color.white);

			}

		}

	}

}
