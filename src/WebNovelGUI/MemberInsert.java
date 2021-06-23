package WebNovelGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberInsert extends DefaultPanel {
	private JTextField NAMETF;
	private JTextField AGETF;
	private JComboBox GENDERBOX;
	Formchange fc = new Formchange();
	private JTextArea PROFILTA;
	
	
	public MemberInsert(String presentID) {
		super(presentID);
		
		Mgrs mgr = new Mgrs();
		Beans bean = new Beans();
		
		JPanel Showpanel = new JPanel();
		Showpanel.setLayout(null);
		Showpanel.setBackground(Color.WHITE);
		Showpanel.setBounds(179, 83, 593, 453);
		getContentPane().add(Showpanel);
		
		// 소설 선택 박스

				JComboBox NovelComboBox = new JComboBox();
				NovelComboBox.setBounds(24, 345, 200, 23);

				mgr.getNoveltitle();
				for (int i = 0; i < mgr.getNoveltitle().size(); i++) {
					String Title = mgr.getNoveltitle().get(i).getm_name();
					NovelComboBox.addItem(Title);
				}
				Showpanel.add(NovelComboBox);
				

				
				
		
		JButton ConfirmBtn = new JButton("\uD655\uC778");
		ConfirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String PresentNovel = (String) NovelComboBox.getSelectedItem();
				
				Beans MemberBean = new Beans();
				
				MemberBean = mgr.getNovel(PresentNovel);
				
				bean.setm_name(NAMETF.getText());
				bean.setgender(GENDERBOX.getSelectedIndex());
				bean.setage(Integer.parseInt(AGETF.getText()));
				bean.setprofil(PROFILTA.getText());
				bean.setn_id(MemberBean.getn_id());
				
				mgr.insertMembers(bean);
				
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
		
		JLabel MemberName = new JLabel("\uC774\uB984");
		MemberName.setBounds(224, 22, 57, 15);
		Showpanel.add(MemberName);
		
		JLabel Age = new JLabel("\uB098\uC774");
		Age.setBounds(224, 72, 57, 15);
		Showpanel.add(Age);
		
		JLabel AgeGrade = new JLabel("\uC131\uBCC4");
		AgeGrade.setBounds(224, 47, 57, 15);
		Showpanel.add(AgeGrade);
		
		NAMETF = new JTextField();
		NAMETF.setColumns(10);
		NAMETF.setBounds(273, 22, 304, 15);
		Showpanel.add(NAMETF);
		
		AGETF = new JTextField();
		AGETF.setColumns(10);
		AGETF.setBounds(273, 72, 304, 15);
		Showpanel.add(AGETF);
		
		String gender[] = {"남","여","무"};
		
		GENDERBOX = new JComboBox(gender);
		GENDERBOX.setBounds(273, 47, 72, 23);
		Showpanel.add(GENDERBOX);
		
		String MemberList[] = {"인물1","인물2","인물3"
		};
		
		JLabel Age_1 = new JLabel("\uD504\uB85C\uD544\uC744 \uC785\uB825\uD558\uC138\uC6A9");
		Age_1.setForeground(Color.LIGHT_GRAY);
		Age_1.setBounds(224, 97, 135, 15);
		Showpanel.add(Age_1);
		
		
		//TextArea
		PROFILTA = new JTextArea();
		PROFILTA.setText("\uD504\uB85C\uD544\uC785\uB2C8\uB2F9");
		PROFILTA.setBounds(224, 122, 357, 180);
		Showpanel.add(PROFILTA);
		
		JLabel lblNewLabel = new JLabel("Image Label");
		lblNewLabel.setBounds(12, 22, 200, 280);
		Showpanel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\uB4F1\uC7A5\uC778\uBB3C \uC785\uB825");
		lblNewLabel_2.setBounds(12, 415, 103, 15);
		Showpanel.add(lblNewLabel_2);
	
		
		JPanel Showpanel_1 = new JPanel();
		Showpanel_1.setLayout(null);
		Showpanel_1.setBackground(Color.WHITE);
		Showpanel_1.setBounds(0, 0, 593, 453);
		Showpanel.add(Showpanel_1);
		
		JLabel TagLabel = new JLabel("\uD0DC\uADF8");
		TagLabel.setBounds(224, 315, 57, 15);
		Showpanel_1.add(TagLabel);
		
		JButton TagButton = new JButton("\uD0DC\uADF8\uCD94\uAC00");
		TagButton.setBounds(254, 314, 90, 15);
		Showpanel_1.add(TagButton);
		
		JTextArea TagArea = new JTextArea();
		TagArea.setText("#\uD0DC\uADF8");
		TagArea.setBounds(224, 329, 357, 75);
		Showpanel_1.add(TagArea);
	}
	}

