package WebNovelGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Novelinsert2 extends DefaultPanel {
	private JTextField titleField, imgField;
	private JTextArea tagcon, storyArea;
	private JRadioButton puboxbtn[];
	private JCheckBox mediaBox[];
	private JLabel titlelabel, taglabel;
	private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
	private Vector<Beans> vlist1;
	private Vector<String> bntn;
	private Beans taggingbean;
	private Mgrs mgr;
	private JList addtaglist;
	private DefaultListModel taglist;
	private Novelinsert ni;
	private NovelinsertToTaginsert ntt;

	public Novelinsert2() {}

	public Novelinsert2(String presentID, Novelinsert ni) {
		super(presentID);
		// ��ü
		this.ni = ni;
		ntt = new NovelinsertToTaginsert(this);
		mgr = new Mgrs();
		bntn = new Vector<String>();
		taggingbean = new Beans();
		taglist = new DefaultListModel();
		// �г�
		getContentPane().setBackground(Color.WHITE);
		JPanel Showpanel = new JPanel();
		Showpanel.setBounds(179, 83, 593, 453);
		Showpanel.setBackground(Color.WHITE);
		getContentPane().add(Showpanel);
		Showpanel.setLayout(null);

		// ���� ��
		titlelabel = new JLabel("��ǰ�� �´� �±׸� �߰����ּ���");
		titlelabel.setBounds(60, 0, 200, 22);
		Showpanel.add(titlelabel);

		vlist1 = mgr.getbigNoveltag();// ��з� �±� ��������
		bntn.addElement("��з�");
		for (int i = 0; i < vlist1.size(); i++) {

			String bntname = vlist1.get(i).getntag_name();
			bntn.addElement(bntname);
		} // ��з� �±� ��������
			// �±� ���� �޺��ڽ�
		comboBox = new JComboBox(bntn);// ��з� �±� �ֱ�
		comboBox.setBounds(60, 23, 85, 23);
		Showpanel.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(60 + 97, 23, 85, 23);
		Showpanel.add(comboBox_1);
		comboBox_1.addItem("�ߺз�");

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(60 + 97 + 97, 23, 85, 23);
		Showpanel.add(comboBox_2);
		comboBox_2.addItem("�Һз�");

		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(60 + 97 + 97 + 97, 23, 85, 23);
		Showpanel.add(comboBox_3);
		comboBox_3.addItem("���з�");
		// �±� ���� �޺��ڽ�
		// �޺��ڽ����� ������ �������� ��ǰ �±� â�� �߰�
		JButton insertBtn = new JButton("�߰�");
		insertBtn.addActionListener(new ActionListener() {// �߰� ��ư �׼�
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != 0 && comboBox_1.getSelectedIndex() == 0) {// ���� ��з� �ڽ��� ���õǾ��ְ� �ߺз�
																								// �ڽ��� ���õǾ����� �ʴٸ�
					int snid = mgr.getntag_id((String) comboBox.getSelectedItem());// �޺��ڽ� ������ �±��� id
					Beans addtagbean = new Beans();
					addtagbean = mgr.getNoveltag(snid); // ������ �±��� �̸� �� ���
					taglist.addElement(addtagbean.getntag_name());
					addtaglist.setModel(taglist);
				} // ��ǰ�±� â�� ������ �±� �̸� �߰�
				if (comboBox_1.getSelectedIndex() != 0 && comboBox_2.getSelectedIndex() == 0) {// ���� �ߺз� �ڽ��� ���õǾ��ְ� �Һз�
																								// �ڽ��� ���õǾ����� �ʴٸ�
					int snid = mgr.getntag_id((String) comboBox_1.getSelectedItem());// �޺��ڽ� ������ �±��� id
					Beans addtagbean = new Beans();
					addtagbean = mgr.getNoveltag(snid);
					taglist.addElement(addtagbean.getntag_name());// ����Ʈ �𵨿� �±� �̸� �߰�
					addtaglist.setModel(taglist);
				} // ��ǰ�±� â�� ������ �±� �̸� ����Ʈ �� �߰�
				if (comboBox_2.getSelectedIndex() != 0 && comboBox_3.getSelectedIndex() == 0) {// ���� �Һз� �ڽ��� ���õǾ��ְ� ���з�
																								// �ڽ��� ���õǾ����� �ʴٸ�
					int snid = mgr.getntag_id((String) comboBox_2.getSelectedItem());// �޺��ڽ� ������ �±��� id
					Beans addtagbean = new Beans();
					addtagbean = mgr.getNoveltag(snid);
					taglist.addElement(addtagbean.getntag_name());// ����Ʈ �𵨿� �±� �̸� �߰�
					addtaglist.setModel(taglist);
				} // ��ǰ�±� â�� ������ �±� �̸� �߰�
				if (comboBox_3.getSelectedIndex() != 0) {// ���� ���з� �ڽ��� ���õǾ��ִٸ�
					int snid = mgr.getntag_id((String) comboBox_3.getSelectedItem());// �޺��ڽ� ������ �±��� id
					Beans addtagbean = new Beans();
					addtagbean = mgr.getNoveltag(snid);
					taglist.addElement(addtagbean.getntag_name());// ����Ʈ �𵨿� �±� �̸� �߰�
					addtaglist.setModel(taglist);
				} // ��ǰ�±� â�� ������ �±� �̸� �߰�

			}
		});
		insertBtn.setBounds(60 + 97 + 97 + 97 + 97, 23, 100, 23);
		Showpanel.add(insertBtn);

		// ã�� �±װ� ���ٸ�
		taglabel = new JLabel("ã�� �±װ� ���ٸ�");
		taglabel.setBounds(60 + 97 + 97 + 75, 46, 182, 23);
		Showpanel.add(taglabel);

		JButton inserttagBtn = new JButton("�±� �߰�");
		inserttagBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ntt.setVisible(true);	

			}
		});
		inserttagBtn.setBounds(60 + 97 + 97 + 97 + 97, 48, 100, 23);
		Showpanel.add(inserttagBtn);
		// �±� ����â
		tagcon = new JTextArea();

		JLabel tagTab = new JLabel("�±׼���");
		tagTab.setOpaque(true);
		tagTab.setBackground(new Color(102, 102, 255));
		tagTab.setBounds(24, 75, 557, 22);
		Showpanel.add(tagTab);

		tagcon.setBounds(24, 97, 557, 64);
		tagcon.setBackground(new Color(204, 204, 255));
		tagcon.setEditable(false);

		Showpanel.add(tagcon);
		// ��ǰ �±� ��� ��
		JLabel novelTab = new JLabel("��ǰ �߰� �±� ���");
		novelTab.setOpaque(true);
		novelTab.setBackground(new Color(102, 102, 255));
		novelTab.setBounds(24, 165, 557, 22);
		Showpanel.add(novelTab);

		// ��ǰ �߰� �±� â ����Ʈ
		addtaglist = new JList();
		addtaglist.setBounds(24, 187, 560, 216);
		addtaglist.setBackground(new Color(204, 204, 255));
		Showpanel.add(addtaglist);
		// �Ϸ��ư
		JButton novelinsertBtn = new JButton("�Ϸ�");
		novelinsertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();// â �ݱ�
				mgr.insertNovel(ni.nbean);// �����ͺ��̽��� ��ǰ �� �߰�
				int n_id = mgr.getn_id(ni.titleField.getText()); // �߰��� ��ǰ�� ���̵� ��������
				FileUpload2 f2 = new FileUpload2();
				try {
					f2.saveFile(ni.imgfile, DefaultPanel.imgpath, Integer.toString(n_id) + ".jpg");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ni.nbean.setn_image(Integer.toString(n_id) + ".jpg");
				mgr.updateNovel(ni.nbean);
				for (int i = 0; i < ni.postingbeanlist.size(); i++) {
					ni.postingbeanlist.get(i).setn_id(n_id);
					mgr.insertWebPosting(ni.postingbeanlist.get(i));
				}// �������̺� �߰�
				if (ni.mediabeanlist.size() != 0) {
					for (int i = 0; i < ni.mediabeanlist.size(); i++) {
						ni.mediabeanlist.get(i).setn_id(n_id);// �̵��� üũ�ڽ� üũ�� ���ڸ�ŭ ��ǰ ���̵� �߰�
						mgr.insertmediamix(ni.mediabeanlist.get(i));
					}// �̵�����̺� ������ �߰�
				}
				for (int i = 0; i < taglist.size(); i++) {
					String tagname = (String) taglist.get(i);
					taggingbean.setn_id(n_id);// �߰��� �±׸�ŭ ��ǰ ���̵� �߰�
					taggingbean.setntag_id(mgr.getntag_id(tagname)); // �߰��� �±׸�ŭ �±� ���̵��߰�
					mgr.insertn_tagging(taggingbean); // �±� ���̺� �߰�
				}
				Beans aingbean = new Beans();
				aingbean.seta_id(mgr.geta_id(ni.authorField.getText()));// ��ǰ_�۰��� �۰� ���̵� �߰�
				aingbean.setn_id(n_id);// ��ǰ_�۰��� ��ǰ ���̵��߰�
				mgr.insertAuthoring(aingbean);// ��ǰ_�۰����̺� �߰�
				if(ni.puboxbtn[0].isSelected()) {
				ni.publishingbean.setn_id(n_id);
				mgr.insertPUBLISHING(ni.publishingbean);}// �������̺� �߰�
				
				NovelTab novelTab2 = new NovelTab(presentID); // �뺧������
				novelTab2.setVisible(true);
			}
		});

		novelinsertBtn.setBounds(467, 411, 97, 23);
		Showpanel.add(novelinsertBtn);

		JButton novelcancel2Btn = new JButton("���");
		novelcancel2Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NovelTab novelTab2 = new NovelTab(presentID);
				novelTab2.setVisible(true);
			}
		});
		novelcancel2Btn.setBounds(249, 411, 97, 23);
		Showpanel.add(novelcancel2Btn);

		JButton tagerase = new JButton("�±� ����");
		tagerase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = addtaglist.getSelectedIndex();
				taglist.removeElementAt(i);
				addtaglist.setModel(taglist);

			}
		});
		tagerase.setBounds(358, 411, 97, 23);
		Showpanel.add(tagerase);

		comboBox.addActionListener(action1);
		comboBox_1.addActionListener(action2);
		comboBox_2.addActionListener(action3);
		comboBox_3.addActionListener(action4);


	}// ������

	ActionListener action1 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (comboBox.getSelectedIndex() != 0) {
				int snid = mgr.getntag_id((String) comboBox.getSelectedItem());// �޺��ڽ� ������ �±��� id
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
			} else {
				comboBox_2.removeAllItems();
				comboBox_2.addItem("�Һз�");
			}

			if (comboBox_1.getSelectedIndex() != 0 && comboBox_2.getSelectedIndex() == 0) {
				int snid = mgr.getntag_id((String) comboBox_1.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			} else if (comboBox_1.getSelectedIndex() == 0 && comboBox.getSelectedIndex() != 0) {
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
			} else {
				comboBox_3.removeAllItems();
				comboBox_3.addItem("���з�");
			}

			if (comboBox_2.getSelectedIndex() != 0 && comboBox_3.getSelectedIndex() == 0) {
				int snid = mgr.getntag_id((String) comboBox_2.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			} else if (comboBox_2.getSelectedIndex() == 0 && comboBox_1.getSelectedIndex() != 0) {
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

			} else if (comboBox_3.getSelectedIndex() == 0 && comboBox_2.getSelectedIndex() != 0) {
				int snid = mgr.getntag_id((String) comboBox_2.getSelectedItem());// �޺��ڽ� ������ �±��� id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			}
		}
	};

}// Ŭ����
