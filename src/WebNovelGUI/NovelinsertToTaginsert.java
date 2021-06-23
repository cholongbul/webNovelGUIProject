package WebNovelGUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NovelinsertToTaginsert extends JFrame {

	private JPanel contentPane;
	private JTextField ntag_name;
	private JTextField REMARK;
	private JButton cancelbtn, confirmbtn;
	private JLabel lblNewLabel_2;
	private JComboBox comboBox;
	private Mgrs mgr;
	private Beans gbean , sbean, psbean;
	private Vector<Beans> ntaglist;
	private Vector<String> ntag_namelist;
	private Novelinsert2 novelinsert2;


	public NovelinsertToTaginsert(Novelinsert2 novelinsert2) {
		setBounds(0, 0, 350, 250);
		setLocationRelativeTo(null);
		setTitle("����ó ���");
		setResizable(false);
		getContentPane().setLayout(null);
		
		mgr = new Mgrs();
		gbean = new Beans();
		sbean = new Beans();
		psbean = new Beans();
		ntag_name = new JTextField();
		//�±� �̸� ��
		JLabel lblNewLabel = new JLabel("�±� �̸�");
		lblNewLabel.setBounds(15, 5, 285, 15);
		getContentPane().add(lblNewLabel);
		//�±��̸� �ؽ�Ʈ
		ntag_name.setBounds(15, 25, 300, 20);
		getContentPane().add(ntag_name);
		ntag_name.setColumns(10);
		
		//�±� ���� ��
		JLabel lblNewLabel_1 = new JLabel("�±� ����");
		lblNewLabel_1.setBounds(15, 50, 294, 15);
		getContentPane().add(lblNewLabel_1);
		
		//�±� ����
		REMARK = new JTextField();
		REMARK.setColumns(30);
		REMARK.setBounds(15, 70, 300, 20);
		getContentPane().add(REMARK);
		
		lblNewLabel_2 = new JLabel("�θ� �±� ����");
		lblNewLabel_2.setBounds(15, 95, 300, 15);
		getContentPane().add(lblNewLabel_2);
		ntaglist = new Vector<Beans>();
		ntaglist = mgr.getListNoveltag();
		ntag_namelist = new Vector<String>();
		ntag_namelist.addElement("-�±�-");
		for (int i = 0; i < ntaglist.size(); i++) {
			String s = ntaglist.get(i).getntag_name();
			ntag_namelist.addElement(s);			
		}
		
		
		comboBox = new JComboBox(ntag_namelist);
		comboBox.setBounds(15, 115, 300, 20);
		getContentPane().add(comboBox);
		

		

		confirmbtn = new JButton("Ȯ��");
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ntag_name.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�±� �̸��� �Է����ּ���", "�±� �Է� ����", JOptionPane.WARNING_MESSAGE);
				} else if (REMARK.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�±� ������ �Է����ּ���.", "�±� �Է� ����", JOptionPane.WARNING_MESSAGE);
				} else {
				sbean.setntag_name(ntag_name.getText());
				sbean.setremark(REMARK.getText());
				mgr.insertNoveltag(sbean);
				if(comboBox.getSelectedIndex()!=0) {
				psbean.setn_supertag(mgr.getntag_id((String)comboBox.getSelectedItem()));
				psbean.setn_subtag(mgr.getntag_id(ntag_name.getText()));
				mgr.insertn_tag_order(psbean);}
				dispose();
				}
			}
		});
		
		confirmbtn.setBounds(72, 155, 97, 23);
		getContentPane().add(confirmbtn);
		
		cancelbtn = new JButton("���");
		cancelbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		cancelbtn.setBounds(172, 155, 97, 23);
		getContentPane().add(cancelbtn);
		
			
		
	}
	

	
	

}
