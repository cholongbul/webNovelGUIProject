package WebNovelGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberModify extends DefaultPanel {
	private JTextField NAMETF;
	private JTextField AGETF;
	private JTextArea PROFILTA;
	
	Formchange fc = new Formchange();
	
	public MemberModify(String presentID,String presentM_name) {
		super(presentID);

		Mgrs mgr = new Mgrs();
		Beans bean = new Beans();
		Formchange fc =new Formchange();

		// 현재 등장인물 이름으로 빈즈 세팅
		bean = mgr.getMembers(presentM_name);
		
		JPanel Showpanel = new JPanel();
		Showpanel.setLayout(null);
		Showpanel.setBackground(Color.WHITE);
		Showpanel.setBounds(179, 83, 593, 453);
		getContentPane().add(Showpanel);
		
		
		
		JLabel MemberName = new JLabel("\uC774\uB984");
		MemberName.setBounds(224, 22, 57, 15);
		Showpanel.add(MemberName);
		
		JLabel Age = new JLabel("\uB098\uC774");
		Age.setBounds(224, 72, 57, 15);
		Showpanel.add(Age);
		
		JLabel AgeGrade = new JLabel("\uC131\uBCC4");
		AgeGrade.setBounds(224, 47, 57, 15);
		Showpanel.add(AgeGrade);
		
		NAMETF = new JTextField(bean.getm_name());
		NAMETF.setColumns(10);
		NAMETF.setBounds(273, 22, 304, 15);
		Showpanel.add(NAMETF);
		
		AGETF = new JTextField();
		AGETF.setText(Integer.toString(bean.getage()));
		AGETF.setColumns(10);
		AGETF.setBounds(273, 72, 304, 15);
		Showpanel.add(AGETF);
		
		
		String list[] = {"남","여","무"};
		
		JComboBox comboBox = new JComboBox(list);
		
		String item = fc.gender(bean.getgender());
		
		comboBox.setSelectedItem(item);
		
		comboBox.setBounds(273, 47, 72, 23);
		Showpanel.add(comboBox);
		
		
		JLabel Age_1 = new JLabel("\uD504\uB85C\uD544\uC744 \uC785\uB825\uD558\uC138\uC6A9");
		Age_1.setForeground(Color.LIGHT_GRAY);
		Age_1.setBounds(224, 97, 135, 15);
		Showpanel.add(Age_1);
		
		String profileTF = bean.getprofil();
		
		PROFILTA = new JTextArea(profileTF);
		PROFILTA.setBounds(224, 122, 357, 180);
		Showpanel.add(PROFILTA);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DefaultPanel.imgpath+"\uB4F1\uC7A5\uC778\uBB3C \uC0AC\uC9C4.jpg"));
		lblNewLabel.setBounds(12, 22, 200, 280);
		Showpanel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\uB4F1\uC7A5\uC778\uBB3C \uC218\uC815");
		lblNewLabel_2.setBounds(12, 415, 103, 15);
		Showpanel.add(lblNewLabel_2);
		
		
		JButton ConfirmBtn = new JButton("\uD655\uC778");
		ConfirmBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				Beans Mbean = new Beans();
				
				Beans bean = new Beans();
				bean = mgr.getMembers(presentM_name);
				Mbean = mgr.getMembers(presentM_name);
				
				Mbean.setm_id(bean.getm_id());
				Mbean.setm_name(NAMETF.getText());
				Mbean.setgender(fc.gender(AGETF.getText()));
				Mbean.setage(Integer.parseInt(AGETF.getText()));
				Mbean.setprofil(PROFILTA.getText());
				Mbean.setn_id(bean.getn_id());
				
				mgr.updateMembers(Mbean);
				
				dispose();
				MemberTab MemberTab = new MemberTab(presentID);
				MemberTab.setVisible(true);
			}
		});
		ConfirmBtn.setBounds(467, 411, 97, 23);
		Showpanel.add(ConfirmBtn);
		
		JButton CancelBtn = new JButton("\uCDE8\uC18C");
		CancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				MemberTab MemberTab = new MemberTab(presentID);
				MemberTab.setVisible(true);
				
			}
		});
		CancelBtn.setBounds(337, 411, 97, 23);
		Showpanel.add(CancelBtn);
		
		JLabel TagLabel = new JLabel("\uD0DC\uADF8");
		TagLabel.setBounds(224, 312, 57, 15);
		Showpanel.add(TagLabel);
		
		JButton TagButton = new JButton("\uD0DC\uADF8\uCD94\uAC00");
		TagButton.setBounds(254, 311, 90, 15);
		Showpanel.add(TagButton);
		
		JTextArea TagArea = new JTextArea();
		TagArea.setText("#\uD0DC\uADF8");
		TagArea.setBounds(224, 326, 357, 75);
		Showpanel.add(TagArea);
		
		JComboBox NovelComboBox = new JComboBox();
		NovelComboBox.setEditable(true);
		NovelComboBox.setBounds(12, 327, 200, 23);
		Showpanel.add(NovelComboBox);
		
		validate();
	}
}