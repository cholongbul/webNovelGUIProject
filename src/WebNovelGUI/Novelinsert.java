
package WebNovelGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.Socket;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Novelinsert extends DefaultPanel implements ActionListener {
	public JTextField titleField, imgField, authorField;
	public JTextArea historyArea, storyArea;
	public JRadioButton puboxbtn[];
	public JCheckBox mediaBox[];
	public JComboBox agebox, pubbox;
	private JList authorserch;
	private JLabel titlelabel, sitelabel, puboxlabel, publabel, agelabel, Medialabel, novelimg, historylabel,
			storylabel, authorlabel;
	public JButton sitebtn, imgbtn, nextbtn;
	private int mediacount;
	public Beans nbean, postingbean, publishingbean, mediabean;
	public JTextField siteField;
	public Vector<Beans> mediabeanlist;
	private Webdailog webdialog;
	private FileUpload2 fileupload;
	public Vector<Beans> postingbeanlist;
	public File imgfile;
	private Novelinsert2 novelinsert2;
	public String[] mediastirng = { "��ȭ", "���", "����", "���� ���", "������" };
	public String presentID;
	private Socket sock;

	public Novelinsert() {
	}

	// �뺧 �Խ��ǿ��� ��ǰ �߰� ��ư�� ������ ������ â
	public Novelinsert(String presentID) {
		super(presentID);// �θ� �гο� ���� ���̵� �������
		this.presentID = presentID;
		nbean = new Beans();
		mediabean = new Beans();
		mediabeanlist = new Vector<Beans>();
		Formchange f = new Formchange();
		Mgrs mgr = new Mgrs();
		getContentPane().setBackground(Color.WHITE);

		JPanel Showpanel = new JPanel();
		Showpanel.setBounds(179, 83, 593, 453);
		Showpanel.setBackground(Color.WHITE);
		Showpanel.setLayout(null);
		getContentPane().add(Showpanel);

		// ��ǰ ���� �߰� ��, �ʵ�
		titlelabel = new JLabel("����");
		titlelabel.setBounds(30, 15, 70, 22);
		Showpanel.add(titlelabel);

		titleField = new JTextField();
		titleField.setBounds(110, 15, 200, 22);
		Showpanel.add(titleField);
		titleField.setColumns(30);
		// �۰� �� �߰�
		authorlabel = new JLabel("�۰�");
		authorlabel.setBounds(30, 45, 70, 22);
		Showpanel.add(authorlabel);

		authorField = new JTextField();
		authorField.setBounds(110, 45, 200, 22);
		authorserch = new JList();
		JPanel authorpanel = new JPanel();
		authorpanel.setLayout(null);
		authorpanel.setBackground(new Color(255, 0, 0, 0));
		Showpanel.add(authorpanel);
		authorField.addKeyListener(new KeyListener() {
			// �۰� �˻� ���
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Mgrs mgr = new Mgrs();
					Vector<Beans> vlist = new Vector<Beans>();
					vlist = mgr.getSearchListAuthor(authorField.getText());// �˻� �޼ҵ�, �˻� ��� ����
					if (vlist.size() == 0 || authorField.getText().equals("")) {
						authorpanel.setVisible(false);
					} // ���� �˻� ����� ���ų� �ؽ�Ʈ â�� �����̶�� �˻� ����� �� ���̰�
					else {// �˻� ����� �����ϸ�
						DefaultListModel authorlist = new DefaultListModel();
						for (int i = 0; i < vlist.size(); i++) {
							authorlist.addElement(vlist.get(i).geta_name());
						}
						authorpanel.setVisible(true); // �˻�����Ʈ ���̰�
						authorserch.setModel(authorlist);
						authorserch.setBounds(1, 1, 200, 17 * vlist.size()); // �˻� ����翡 ���� ����Ʈ ���� ����
						authorpanel.setBounds(109, 66, 201, 17 * vlist.size() + 1); // �˻� �г� ��ġ ����
						authorpanel.add(authorserch);
						authorserch.setFixedCellHeight(17);
						authorserch.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
						authorserch.setVisible(true);
						authorField.addKeyListener(new KeyListener() {

							@Override
							public void keyReleased(KeyEvent e) {
								if (e.getKeyCode() == 40) {
									authorserch.requestFocus();
									authorserch.setSelectedIndex(0);
								}
							}

							@Override
							public void keyPressed(KeyEvent arg0) {
							}

							@Override
							public void keyTyped(KeyEvent arg0) {
							}

						});
						authorserch.addKeyListener(new KeyListener() {
							@Override
							public void keyReleased(KeyEvent e) {
								if (e.getKeyCode() == 10) { // ����Ű�� ������ �ؽ�Ʈ â�� �Է�
									String s = (String) authorlist.get(authorserch.getSelectedIndex());
									authorField.setText(s);
									authorpanel.setVisible(false); // �˻� �г� �� ���̰�

								}
							}

							@Override
							public void keyPressed(KeyEvent e) {
							}

							@Override
							public void keyTyped(KeyEvent e) {
							}
						});
						authorserch.addMouseListener(new MouseAdapter() {

							@Override
							public void mouseClicked(MouseEvent e) {
								String s = (String) authorlist.get(authorserch.getSelectedIndex());
								authorField.setText(s);
								authorpanel.setVisible(false);// �˻� �г� �� ���̰�

							}
						});
					}
				} // try
				catch (Exception e2) {
					e2.printStackTrace();
				}

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		Showpanel.add(authorField);// �۰� �ʵ� �߰�
		// ����ó ��
		sitelabel = new JLabel("����ó");
		sitelabel.setBounds(30, 75, 70, 22);
		Showpanel.add(sitelabel);
		// ����ó �ؽ�Ʈ �ʵ�
		siteField = new JTextField();
		siteField.setBounds(110, 75, 200, 22);
		siteField.setEditable(false);
		Showpanel.add(siteField);

		sitebtn = new JButton("����ó ã��"); // ����ó ã�� ��� �׼�
		sitebtn.addActionListener(this);
		sitebtn.setBounds(315, 75, 120, 22);
		Showpanel.add(sitebtn);
		// �������� ��
		puboxlabel = new JLabel("��������");
		puboxlabel.setBounds(30, 105, 70, 22);
		Showpanel.add(puboxlabel);
		// �������� ��ư
		ButtonGroup pubgroup = new ButtonGroup();
		String[] ox = { "��", "��" };

		puboxbtn = new JRadioButton[2];
		for (int i = 0; i < ox.length; i++) {
			puboxbtn[i] = new JRadioButton(ox[i]);
			pubgroup.add(puboxbtn[i]);
			Showpanel.add(puboxbtn[i]);
		}
		puboxbtn[0].setSelected(false);
		puboxbtn[1].setSelected(true);
		puboxbtn[0].setBackground(Color.white);
		puboxbtn[1].setBackground(Color.white);
		puboxbtn[0].setBounds(110, 105, 40, 22);
		puboxbtn[1].setBounds(160, 105, 40, 22);
		puboxbtn[1].addActionListener(new ActionListener() {
			// ���� ���� ��ư �׼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (puboxbtn[1].isSelected()) {
					pubbox.setEnabled(false);
				} // ���� ���� '��'���ý� ���ǻ� ���� ����
			}
		});
		puboxbtn[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (puboxbtn[0].isSelected()) {
					pubbox.setEnabled(true);
				} // �������� '��'���ý� ���ǻ� ���� �Ұ���
			}
		});
		// ���ǻ� ��
		publabel = new JLabel("���ǻ�");
		publabel.setBounds(30, 135, 70, 22);
		Showpanel.add(publabel);
		// ���ǻ� �޺��ڽ�
		pubbox = new JComboBox();
		pubbox.setBounds(110, 135, 120, 22);
		Showpanel.add(pubbox);
		pubbox.setEnabled(false);
		// ���ǻ� �޺��ڽ� ������ ������ ���̽����� �߰�
		pubbox.addItem("-���ǻ�-");
		mgr.getListPubcomp();
		for (int i = 0; i < mgr.getListPubcomp().size(); i++) {
			String pubboxname = mgr.getListPubcomp().get(i).getp_name();
			pubbox.addItem(pubboxname);
		}
		// �̿��� ��
		agelabel = new JLabel("�̿���");
		agelabel.setBounds(30, 165, 70, 22);
		Showpanel.add(agelabel);
		// �̿��� �޺��ڽ�, ������ �߰�
		agebox = new JComboBox();
		agebox.addItem("�̿���");
		agebox.addItem("��ü�̿밡");
		agebox.addItem("12���̿밡");
		agebox.addItem("15���̿밡");
		agebox.addItem("19���̿밡");
		agebox.setBounds(110, 165, 120, 22);
		Showpanel.add(agebox);
		// �̵��ͽ� ��
		Medialabel = new JLabel("�̵��ͽ�");
		Medialabel.setBounds(30, 195, 70, 22);
		Showpanel.add(Medialabel);

		// �̵��ͽ� üũ�ڽ�
		mediaBox = new JCheckBox[5];
		for (int i = 0; i < mediastirng.length; i++) {
			mediaBox[i] = new JCheckBox(mediastirng[i]);
			Showpanel.add(mediaBox[i]);
			mediaBox[i].setBackground(Color.white);
		}
		mediaBox[0].setBounds(110, 195, 70, 22);
		mediaBox[1].setBounds(180, 195, 70, 22);
		mediaBox[2].setBounds(250, 195, 70, 22);
		mediaBox[3].setBounds(110, 215, 120, 22);
		mediaBox[4].setBounds(250, 215, 80, 22);
		// ǥ�� �̹��� �߰� ��
		novelimg = new JLabel("ǥ�� �̹���");
		novelimg.setBounds(30, 240, 70, 22);
		Showpanel.add(novelimg);
		// ǥ�� �̹��� �߰� �ʵ�
		imgField = new JTextField();
		imgField.setBounds(110, 240, 200, 22);
		Showpanel.add(imgField);
		imgField.setEditable(false);

		// ��ǰ �̷� ��
		historylabel = new JLabel("��ǰ �̷�(���� ����, Ư�̻���)");
		historylabel.setBounds(30, 270, 500, 22);
		Showpanel.add(historylabel);
		// ��ǰ �̷� �ؽ�Ʈ���̸���
		historyArea = new JTextArea();
		historyArea.setBounds(30, 294, 400, 51);
		historyArea.setVisible(true);
		historyArea.setBackground(Color.LIGHT_GRAY);
		Showpanel.add(historyArea);
		// ��ǰ �ٰŸ� ��
		storylabel = new JLabel("�ٰŸ�");
		storylabel.setBounds(30, 350, 70, 22);
		Showpanel.add(storylabel);
		// ��ǰ �ٰŸ� �ؽ�Ʈ
		storyArea = new JTextArea();
		storyArea.setBounds(30, 374, 400, 66);
		storyArea.setBackground(Color.LIGHT_GRAY);
		Showpanel.add(storyArea);
		// �̹��� ��ư
		imgbtn = new JButton("�̹��� ���ε�");
		imgbtn.addActionListener(this);

		imgbtn.setBounds(320, 240, 110, 23);
		Showpanel.add(imgbtn);
		// ���� �������� �Ѿ�� ��ư
		// ���� �������� �Ѿ�� ��ư
		nextbtn = new JButton("����");
		nextbtn.addActionListener(this);

		
		nextbtn.setBounds(440, 430, 97, 23);
		Showpanel.add(nextbtn);

	}// ������

	@Override
	public void actionPerformed(ActionEvent e) {
		Mgrs mgr = new Mgrs(); 
		Formchange f = new Formchange();
		if (e.getSource() == sitebtn) {
			
			if (titleField.getText().equals("")) { // ��ǰ ���� �Է� ���ϸ� �˾�
				JOptionPane.showMessageDialog(null, "��ǰ������ �Է����ּ���", "��ǰ ���� �Է�", JOptionPane.WARNING_MESSAGE);
			} else if (authorField.getText().equals("")) { // �۰� �̸� �˾�
				JOptionPane.showMessageDialog(null, "�۰� �̸��� �Է����ּ���", "�۰� �̸� �Է�", JOptionPane.WARNING_MESSAGE);
			} else if (f.authorcheck(authorField.getText())) { // �������� �ʴ� �۰� �˾�
				int result = JOptionPane.showConfirmDialog(null, "�۰��� ��Ͽ� �����ϴ�. �����۰��� �߰��Ͻðڽ��ϱ�?", "�۰� ����",
						JOptionPane.OK_CANCEL_OPTION);

				if (result == 0) { // OK=0 , Cancel=2 ����
					Beans abean = new Beans();
					abean.seta_name(authorField.getText());
					mgr.insertAuthor(abean);
					JOptionPane.showMessageDialog(null, "�۰��� �߰��Ǿ����ϴ�", "�۰� �߰� �Ϸ�", JOptionPane.WARNING_MESSAGE);
				}
			} else { // ����ó �Է� �˾�
				webdialog = new Webdailog(this);
				webdialog.setVisible(true);
			}

		}
		if(e.getSource()==imgbtn){
			fileupload = new FileUpload2(this);
			fileupload.setVisible(true);
			
		}
		if(e.getSource()==nextbtn) {
			dispose();// �� â ����
			publishingbean = new Beans();
			nbean.settitle(titleField.getText());// ��ǰ �� ��ǰ ���� ����
			if (agebox.getSelectedIndex() != 0) {// ������ �̿��� ���ڷ� �ٲ㼭 ��ǰ �� ����
				nbean.setagelimit(agebox.getSelectedIndex() - 1);
			}
			nbean.setstoryline(storyArea.getText());// �ٰŸ� ��ǰ �� ����
			nbean.setn_history(historyArea.getText());// ��ǰ �̷� ��ǰ �� ����
			if (pubbox.getSelectedIndex() != 0) {
				publishingbean.setp_id(mgr.getp_id((String) pubbox.getSelectedItem()));
			} // ������ ���ǻ� ���̵� ���� �� ����
			for (int i = 0; i < mediastirng.length; i++) {
				if (mediaBox[i].isSelected()) {
					mediabean.setmediamix(i);
					mediabeanlist.addElement(mediabean);
				}
			} // �̵��� ������ �̵�� �ͽ� ����, ���� ����
			novelinsert2 = new Novelinsert2(presentID, this);
			novelinsert2.setVisible(true);
			
		}
	}//�޼ҵ�

}
