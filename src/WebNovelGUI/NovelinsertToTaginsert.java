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
		setTitle("연재처 등록");
		setResizable(false);
		getContentPane().setLayout(null);
		
		mgr = new Mgrs();
		gbean = new Beans();
		sbean = new Beans();
		psbean = new Beans();
		ntag_name = new JTextField();
		//태그 이름 라벨
		JLabel lblNewLabel = new JLabel("태그 이름");
		lblNewLabel.setBounds(15, 5, 285, 15);
		getContentPane().add(lblNewLabel);
		//태그이름 텍스트
		ntag_name.setBounds(15, 25, 300, 20);
		getContentPane().add(ntag_name);
		ntag_name.setColumns(10);
		
		//태그 설명 라벨
		JLabel lblNewLabel_1 = new JLabel("태그 설명");
		lblNewLabel_1.setBounds(15, 50, 294, 15);
		getContentPane().add(lblNewLabel_1);
		
		//태그 설명
		REMARK = new JTextField();
		REMARK.setColumns(30);
		REMARK.setBounds(15, 70, 300, 20);
		getContentPane().add(REMARK);
		
		lblNewLabel_2 = new JLabel("부모 태그 설정");
		lblNewLabel_2.setBounds(15, 95, 300, 15);
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
		comboBox.setBounds(15, 115, 300, 20);
		getContentPane().add(comboBox);
		

		

		confirmbtn = new JButton("확인");
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
				}
			}
		});
		
		confirmbtn.setBounds(72, 155, 97, 23);
		getContentPane().add(confirmbtn);
		
		cancelbtn = new JButton("취소");
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
