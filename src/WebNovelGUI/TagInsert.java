package WebNovelGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TagInsert extends DefaultPanel {

	private JPanel contentPane;
	private JTextField ntag_name;
	private JTextField REMARK;
	private JButton confirmbtn, cancelbtn;
	private JLabel lblNewLabel_2;
	private JComboBox comboBox;
	private Mgrs mgr;
	private Beans gbean , sbean, psbean;
	private Vector<Beans> ntaglist;
	private Vector<String> ntag_namelist;


	public TagInsert(String presentID) {
		super(presentID);
		mgr = new Mgrs();
		gbean = new Beans();
		sbean = new Beans();
		psbean = new Beans();
		ntag_name = new JTextField();
		ntag_name.setBounds(314, 160, 337, 38);
		getContentPane().add(ntag_name);
		ntag_name.setColumns(10);
		
		REMARK = new JTextField();
		REMARK.setColumns(10);
		REMARK.setBounds(314, 260, 337, 38);
		getContentPane().add(REMARK);
		
		JLabel lblNewLabel = new JLabel("\uD0DC\uADF8\uBA85");
		lblNewLabel.setBounds(216, 160, 86, 38);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD0DC\uADF8\uC124\uBA85");
		lblNewLabel_1.setBounds(216, 260, 86, 38);
		getContentPane().add(lblNewLabel_1);
		confirmbtn = new JButton("\uD655\uC778");
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ntag_name.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "태그 이름을 입력해주세요", "태그 입력 실패", JOptionPane.WARNING_MESSAGE);
				} else if (REMARK.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "태그 설명을 입력해주세요.", "태그 입력 실패", JOptionPane.WARNING_MESSAGE);
				} else {
				sbean.setntag_name(ntag_name.getText());
				sbean.setremark(REMARK.getText());
				mgr.insertNoveltag(sbean);
				if(comboBox.getSelectedIndex()!=0) {
				psbean.setn_supertag(mgr.getntag_id((String)comboBox.getSelectedItem()));
				psbean.setn_subtag(mgr.getntag_id(ntag_name.getText()));
				mgr.insertn_tag_order(psbean);}
				dispose();
				Tagtab Tagtab = new Tagtab(presentID);
				Tagtab.setVisible(true);}
			}
		});
		
		confirmbtn.setBounds(454, 491, 97, 23);
		getContentPane().add(confirmbtn);
		
		cancelbtn = new JButton("취소");
		cancelbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Tagtab Tagtab = new Tagtab(presentID);
				Tagtab.setVisible(true);
			}
		});
		cancelbtn.setBounds(554, 491, 97, 23);
		getContentPane().add(cancelbtn);
		
		lblNewLabel_2 = new JLabel("\uBD80\uBAA8\uD0DC\uADF8");
		lblNewLabel_2.setBounds(216, 360, 86, 38);
		getContentPane().add(lblNewLabel_2);
		ntaglist = new Vector<Beans>();
		ntaglist = mgr.getListNoveltag();
		ntag_namelist = new Vector<String>();
		ntag_namelist.addElement("-태그-");
		for (int i = 0; i < ntaglist.size(); i++) {
			String s = ntaglist.get(i).getntag_name();
			ntag_namelist.addElement(s);			
		}
		
		
		comboBox = new JComboBox(ntag_namelist);
		comboBox.setBounds(314, 360, 337, 38);
		getContentPane().add(comboBox);
		
	
		
		;
	}

}
