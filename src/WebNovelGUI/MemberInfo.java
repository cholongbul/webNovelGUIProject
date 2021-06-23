package WebNovelGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemberInfo extends DefaultPanel {

	Formchange fc = new Formchange();

	public MemberInfo(String presentID, String presentM_name) {
		super(presentID);
		getContentPane().setLayout(null);

		Mgrs mgr = new Mgrs();
		Beans bean = new Beans();

		// 현재 등장인물 이름으로 빈즈 세팅
		bean = mgr.getMembers(presentM_name);
		
		String presentM_name2 = bean.getm_name();

		JPanel SetShowPanel = new JPanel();
		SetShowPanel.setLayout(null);
		SetShowPanel.setBackground(Color.WHITE);
		SetShowPanel.setBounds(179, 98, 593, 453);
		getContentPane().add(SetShowPanel);

		JPanel Member1 = new JPanel();
		Member1.setBackground(Color.WHITE);
		Member1.setBounds(0, 0, 593, 453);
		SetShowPanel.add(Member1);

		// 소설 선택 박스

		JComboBox NovelComboBox = new JComboBox();
		NovelComboBox.setEnabled(false);
		NovelComboBox.setBounds(24, 345, 200, 23);

		mgr.getNoveltitle();
		for (int i = 0; i < mgr.getNoveltitle().size(); i++) {
			String Title = mgr.getNoveltitle().get(i).getm_name();
			NovelComboBox.addItem(Title);
		}
		
		Beans Novelbean = new Beans();

		Novelbean = mgr.getNovel(bean.getn_id());
		NovelComboBox.setSelectedItem(Novelbean.gettitle());
		Member1.add(NovelComboBox);

		

		// 컴펌 버튼
		JButton ConfirmBtn_2 = new JButton("\uD655\uC778");
		ConfirmBtn_2.setBounds(447, 430, 97, 23);
		ConfirmBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MemberTab MemberTab = new MemberTab(presentID);
				MemberTab.setVisible(true);
			}
		});
		Member1.setLayout(null);
		Member1.add(ConfirmBtn_2);

		JLabel MemberName_1 = new JLabel("\uC774\uB984");
		MemberName_1.setBounds(236, 41, 57, 15);
		Member1.add(MemberName_1);

		JLabel Age_2 = new JLabel("\uB098\uC774");
		Age_2.setBounds(236, 91, 57, 15);
		Member1.add(Age_2);

		JLabel AgeGrade_1 = new JLabel("\uC131\uBCC4");
		AgeGrade_1.setBounds(236, 66, 57, 15);
		Member1.add(AgeGrade_1);

		// 소설 사진

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(24, 41, 200, 280);

		int N_id = bean.getn_id() - 1;

		lblNewLabel_1.setIcon(new ImageIcon(DefaultPanel.imgpath + "img00000" + N_id + ".jpg"));
		Member1.add(lblNewLabel_1);

		// 이름 라벨

		JLabel MemberNameLabel = new JLabel(presentM_name2);
		MemberNameLabel.setEnabled(false);
		MemberNameLabel.setBounds(285, 41, 304, 15);
		Member1.add(MemberNameLabel);

		// 나이 라벨

		JLabel AgeLabel = new JLabel(Integer.toString(bean.getage()));
		AgeLabel.setEnabled(false);
		AgeLabel.setBounds(285, 91, 304, 15);
		Member1.add(AgeLabel);

		JLabel lblNewLabel_2_1 = new JLabel("\uB4F1\uC7A5\uC778\uBB3C \uC18C\uAC1C");
		lblNewLabel_2_1.setBounds(24, 434, 103, 15);
		Member1.add(lblNewLabel_2_1);

		// 성별 라벨

		JLabel GenderLabel = new JLabel(fc.gender(bean.getgender()));
		GenderLabel.setEnabled(false);
		GenderLabel.setBounds(285, 66, 304, 15);
		Member1.add(GenderLabel);

		JButton ModifyButton = new JButton("\uC218\uC815");
		ModifyButton.setBounds(334, 430, 97, 23);
		Member1.add(ModifyButton);

		ModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MemberModify MemberModify = new MemberModify(presentID,presentM_name2);
				MemberModify.setVisible(true);
			}
		});

		// 프로필 텍스트 에리어

		JTextArea profile = new JTextArea(bean.getprofil());
		profile.setEditable(false);
		profile.setCaretPosition(0);

		String str = bean.getprofil();

		profile.setText(str);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(profile);
		scrollPane.setBounds(236, 141, 357, 180);
		Member1.add(scrollPane);
		
		JTextArea TagArea = new JTextArea();
		TagArea.setText("#\uD0DC\uADF8");
		TagArea.setBounds(236, 345, 357, 75);
		Member1.add(TagArea);
		
		JLabel TagLabel = new JLabel("\uD0DC\uADF8");
		TagLabel.setBounds(236, 331, 57, 15);
		Member1.add(TagLabel);
		
		JButton TagButton = new JButton("\uD0DC\uADF8\uCD94\uAC00");
		TagButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				TagInsert TagInsert = new TagInsert(presentID);
				TagInsert.setVisible(true);
			}
		});
		TagButton.setBounds(266, 330, 90, 15);
		Member1.add(TagButton);

	}
}