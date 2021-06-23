package WebNovelGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tagtab extends DefaultPanel {
	private JTextField textField;
	private Vector<Beans> vlist1;
	private Vector<String> bntn;
	private Mgrs mgr;
	private Beans bbean;
	private JTextArea tagcon;
	private JList list;
	private boolean flag;
	private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;


	public Tagtab(String presentID) {
		super(presentID);
		mgr = new Mgrs();
		bntn = new Vector<String>();
		getContentPane().setBackground(Color.WHITE);

		JPanel Showpanel = new JPanel();
		Showpanel.setBounds(179, 98, 593, 453);
		Showpanel.setBackground(Color.WHITE);
		getContentPane().add(Showpanel);
		Showpanel.setLayout(null);

		vlist1 = mgr.getbigNoveltag();
		bntn.addElement("��з�");
		for (int i = 0; i < vlist1.size(); i++) {

			String bntname = vlist1.get(i).getntag_name();
			bntn.addElement(bntname);
		}
		
		comboBox = new JComboBox(bntn);
		comboBox.setBounds(87, 1, 85, 23);
		Showpanel.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(87+97, 1, 85, 23);
		Showpanel.add(comboBox_1);
		comboBox_1.addItem("�ߺз�");

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(87+97+97, 1, 85, 23);
		Showpanel.add(comboBox_2);
		comboBox_2.addItem("�Һз�");

		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(87+97+97+97, 1, 85, 23);
		Showpanel.add(comboBox_3);
		comboBox_3.addItem("���з�");



		tagcon = new JTextArea();

		JLabel tagTab = new JLabel("�±׼���");
		tagTab.setOpaque(true);
		tagTab.setBackground(new Color(102, 102, 255));
		tagTab.setBounds(12, 52, 569, 21);
		Showpanel.add(tagTab);

		tagcon.setBounds(12, 73, 569, 64);
		tagcon.setBackground(new Color(204, 204, 255));
		tagcon.setEditable(false);

		Showpanel.add(tagcon);

		list = new JList();

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					String selectednovel = (String) list.getSelectedValue(); 
					NovelInfo novelInfo = new NovelInfo(presentID, selectednovel);
					novelInfo.setVisible(true);}
				}
			
		});

		JLabel novelTab = new JLabel("��ǰ ���");
		novelTab.setOpaque(true);
		novelTab.setBackground(new Color(102, 102, 255));
		novelTab.setBounds(12, 142, 569, 21);
		Showpanel.add(novelTab);

		list.setBounds(12, 163, 569, 229);
		list.setBackground(new Color(204, 204, 255));
		Showpanel.add(list);

		JButton AddBtn = new JButton("�±� �߰�");
		AddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TagInsert TagInsert = new TagInsert(presentID);
				TagInsert.setVisible(true);
			}
		});
		AddBtn.setFocusable(false);
		AddBtn.setBorderPainted(false);
		AddBtn.setBounds(468, 405, 97, 23);
		Showpanel.add(AddBtn);
		comboBox.addActionListener(action1);
		comboBox_1.addActionListener(action2);
		comboBox_2.addActionListener(action3);
		comboBox_3.addActionListener(action4);


	} // �����ڳ�
	
	ActionListener action1 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (comboBox.getSelectedIndex() != 0) {
				int snid = mgr.getntag_id((String) comboBox.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());// �±� ���� â�� �±� ���� �߰�
				Vector<Beans> vlist2 = new Vector<Beans>();
				vlist2 = mgr.getsmallNoveltag(snid);
				comboBox_1.removeAllItems(); // �ߺз� �±׹ڽ� ����
				comboBox_1.addItem("�ߺз�");
				for (int i = 0; i < vlist2.size(); i++) {
					String sntname = vlist2.get(i).getntag_name();
					comboBox_1.addItem(sntname);
				} // �ߺз� �±׹ڽ� ������ ��з��� �°� �߰�
			} else {
				comboBox_1.removeAllItems();
				comboBox_1.addItem("�ߺз�");
				tagcon.setText("");
			}
			if (comboBox.getSelectedIndex() != 0 && comboBox_1.getSelectedIndex() == 0) {
				int snid = mgr.getntag_id((String) comboBox.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			} 	
		
		
		}

	};

	ActionListener action2 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (comboBox_1.getSelectedIndex() != 0) {
				int snid = mgr.getntag_id((String) comboBox_1.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Vector<Beans> vlist2 = new Vector<Beans>();
				vlist2 = mgr.getsmallNoveltag(snid);
				comboBox_2.removeAllItems();
				comboBox_2.addItem("�Һз�");
				for (int i = 0; i < vlist2.size(); i++) {
					String sntname = vlist2.get(i).getntag_name();
					comboBox_2.addItem(sntname);
				}
				flag = true;
			} else {
				comboBox_2.removeAllItems();
				comboBox_2.addItem("�Һз�");
			}
			
			if(comboBox_1.getSelectedIndex() != 0 && comboBox_2.getSelectedIndex() == 0) {
				int snid = mgr.getntag_id((String) comboBox_1.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			} else if (comboBox_1.getSelectedIndex()==0&&comboBox.getSelectedIndex()!=0) {
				int snid = mgr.getntag_id((String) comboBox.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			}

		}// �������̵� ��
	};// ������ ������ ��

	ActionListener action3 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (comboBox_2.getSelectedIndex() != 0) {
				int snid = mgr.getntag_id((String) comboBox_2.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Vector<Beans> vlist2 = new Vector<Beans>();
				vlist2 = mgr.getsmallNoveltag(snid);
				comboBox_3.removeAllItems();
				comboBox_3.addItem("���з�");
				for (int i = 0; i < vlist2.size(); i++) {
					String sntname = vlist2.get(i).getntag_name();
					comboBox_3.addItem(sntname);
				}
				flag = true;
			} else {
				comboBox_3.removeAllItems();
				comboBox_3.addItem("���з�");
			}
			
			if (comboBox_2.getSelectedIndex() != 0 && comboBox_3.getSelectedIndex() == 0) {
				int snid = mgr.getntag_id((String) comboBox_2.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			} else if (comboBox_2.getSelectedIndex()==0 && comboBox_1.getSelectedIndex()!=0) {
				int snid = mgr.getntag_id((String) comboBox_1.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			}
		}// �������̵� ��
	};// ������ ������ ��
	
	ActionListener action4 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			if (comboBox_3.getSelectedIndex() != 0) {
				int snid = mgr.getntag_id((String) comboBox_3.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			
			}else if(comboBox_3.getSelectedIndex()==0&&comboBox_2.getSelectedIndex()!=0) {
				int snid = mgr.getntag_id((String) comboBox_2.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			}
		}
	};


}

	


