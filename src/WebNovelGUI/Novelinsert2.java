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
		// 객체
		this.ni = ni;
		ntt = new NovelinsertToTaginsert(this);
		mgr = new Mgrs();
		bntn = new Vector<String>();
		taggingbean = new Beans();
		taglist = new DefaultListModel();
		// 패널
		getContentPane().setBackground(Color.WHITE);
		JPanel Showpanel = new JPanel();
		Showpanel.setBounds(179, 83, 593, 453);
		Showpanel.setBackground(Color.WHITE);
		getContentPane().add(Showpanel);
		Showpanel.setLayout(null);

		// 제목 라벨
		titlelabel = new JLabel("작품에 맞는 태그를 추가해주세요");
		titlelabel.setBounds(60, 0, 200, 22);
		Showpanel.add(titlelabel);

		vlist1 = mgr.getbigNoveltag();// 대분류 태그 가져오기
		bntn.addElement("대분류");
		for (int i = 0; i < vlist1.size(); i++) {

			String bntname = vlist1.get(i).getntag_name();
			bntn.addElement(bntname);
		} // 대분류 태그 가져오기
			// 태그 담을 콤보박스
		comboBox = new JComboBox(bntn);// 대분류 태그 넣기
		comboBox.setBounds(60, 23, 85, 23);
		Showpanel.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(60 + 97, 23, 85, 23);
		Showpanel.add(comboBox_1);
		comboBox_1.addItem("중분류");

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(60 + 97 + 97, 23, 85, 23);
		Showpanel.add(comboBox_2);
		comboBox_2.addItem("소분류");

		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(60 + 97 + 97 + 97, 23, 85, 23);
		Showpanel.add(comboBox_3);
		comboBox_3.addItem("세분류");
		// 태그 담을 콤보박스
		// 콤보박스에서 선택한 아이템을 작품 태그 창에 추가
		JButton insertBtn = new JButton("추가");
		insertBtn.addActionListener(new ActionListener() {// 추가 버튼 액션
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != 0 && comboBox_1.getSelectedIndex() == 0) {// 만약 대분류 박스가 선택되어있고 중분류
																								// 박스는 선택되어있지 않다면
					int snid = mgr.getntag_id((String) comboBox.getSelectedItem());// 콤보박스 선택한 태그의 id
					Beans addtagbean = new Beans();
					addtagbean = mgr.getNoveltag(snid); // 선택한 태그의 이름 빈에 담기
					taglist.addElement(addtagbean.getntag_name());
					addtaglist.setModel(taglist);
				} // 작품태그 창에 선택한 태그 이름 추가
				if (comboBox_1.getSelectedIndex() != 0 && comboBox_2.getSelectedIndex() == 0) {// 만약 중분류 박스가 선택되어있고 소분류
																								// 박스는 선택되어있지 않다면
					int snid = mgr.getntag_id((String) comboBox_1.getSelectedItem());// 콤보박스 선택한 태그의 id
					Beans addtagbean = new Beans();
					addtagbean = mgr.getNoveltag(snid);
					taglist.addElement(addtagbean.getntag_name());// 리스트 모델에 태그 이름 추가
					addtaglist.setModel(taglist);
				} // 작품태그 창에 선택한 태그 이름 리스트 모델 추가
				if (comboBox_2.getSelectedIndex() != 0 && comboBox_3.getSelectedIndex() == 0) {// 만약 소분류 박스가 선택되어있고 세분류
																								// 박스는 선택되어있지 않다면
					int snid = mgr.getntag_id((String) comboBox_2.getSelectedItem());// 콤보박스 선택한 태그의 id
					Beans addtagbean = new Beans();
					addtagbean = mgr.getNoveltag(snid);
					taglist.addElement(addtagbean.getntag_name());// 리스트 모델에 태그 이름 추가
					addtaglist.setModel(taglist);
				} // 작품태그 창에 선택한 태그 이름 추가
				if (comboBox_3.getSelectedIndex() != 0) {// 만약 세분류 박스가 선택되어있다면
					int snid = mgr.getntag_id((String) comboBox_3.getSelectedItem());// 콤보박스 선택한 태그의 id
					Beans addtagbean = new Beans();
					addtagbean = mgr.getNoveltag(snid);
					taglist.addElement(addtagbean.getntag_name());// 리스트 모델에 태그 이름 추가
					addtaglist.setModel(taglist);
				} // 작품태그 창에 선택한 태그 이름 추가

			}
		});
		insertBtn.setBounds(60 + 97 + 97 + 97 + 97, 23, 100, 23);
		Showpanel.add(insertBtn);

		// 찾는 태그가 없다면
		taglabel = new JLabel("찾는 태그가 없다면");
		taglabel.setBounds(60 + 97 + 97 + 75, 46, 182, 23);
		Showpanel.add(taglabel);

		JButton inserttagBtn = new JButton("태그 추가");
		inserttagBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ntt.setVisible(true);	

			}
		});
		inserttagBtn.setBounds(60 + 97 + 97 + 97 + 97, 48, 100, 23);
		Showpanel.add(inserttagBtn);
		// 태그 설명창
		tagcon = new JTextArea();

		JLabel tagTab = new JLabel("태그설명");
		tagTab.setOpaque(true);
		tagTab.setBackground(new Color(102, 102, 255));
		tagTab.setBounds(24, 75, 557, 22);
		Showpanel.add(tagTab);

		tagcon.setBounds(24, 97, 557, 64);
		tagcon.setBackground(new Color(204, 204, 255));
		tagcon.setEditable(false);

		Showpanel.add(tagcon);
		// 작품 태그 목록 라벨
		JLabel novelTab = new JLabel("작품 추가 태그 목록");
		novelTab.setOpaque(true);
		novelTab.setBackground(new Color(102, 102, 255));
		novelTab.setBounds(24, 165, 557, 22);
		Showpanel.add(novelTab);

		// 작품 추가 태그 창 리스트
		addtaglist = new JList();
		addtaglist.setBounds(24, 187, 560, 216);
		addtaglist.setBackground(new Color(204, 204, 255));
		Showpanel.add(addtaglist);
		// 완료버튼
		JButton novelinsertBtn = new JButton("완료");
		novelinsertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();// 창 닫기
				mgr.insertNovel(ni.nbean);// 데이터베이스에 작품 빈 추가
				int n_id = mgr.getn_id(ni.titleField.getText()); // 추가된 작품빈 아이디 가져오기
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
				}// 연재테이블에 추가
				if (ni.mediabeanlist.size() != 0) {
					for (int i = 0; i < ni.mediabeanlist.size(); i++) {
						ni.mediabeanlist.get(i).setn_id(n_id);// 미디어빈 체크박스 체크한 숫자만큼 작품 아이디 추가
						mgr.insertmediamix(ni.mediabeanlist.get(i));
					}// 미디어테이블에 데이터 추가
				}
				for (int i = 0; i < taglist.size(); i++) {
					String tagname = (String) taglist.get(i);
					taggingbean.setn_id(n_id);// 추가한 태그만큼 작품 아이디 추가
					taggingbean.setntag_id(mgr.getntag_id(tagname)); // 추가한 태그만큼 태그 아이디추가
					mgr.insertn_tagging(taggingbean); // 태깅 태이블 추가
				}
				Beans aingbean = new Beans();
				aingbean.seta_id(mgr.geta_id(ni.authorField.getText()));// 작품_작가빈에 작가 아이디 추가
				aingbean.setn_id(n_id);// 작품_작가빈에 작품 아이디추가
				mgr.insertAuthoring(aingbean);// 작품_작가테이블에 추가
				if(ni.puboxbtn[0].isSelected()) {
				ni.publishingbean.setn_id(n_id);
				mgr.insertPUBLISHING(ni.publishingbean);}// 출판테이블 추가
				
				NovelTab novelTab2 = new NovelTab(presentID); // 노벨탭으로
				novelTab2.setVisible(true);
			}
		});

		novelinsertBtn.setBounds(467, 411, 97, 23);
		Showpanel.add(novelinsertBtn);

		JButton novelcancel2Btn = new JButton("취소");
		novelcancel2Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NovelTab novelTab2 = new NovelTab(presentID);
				novelTab2.setVisible(true);
			}
		});
		novelcancel2Btn.setBounds(249, 411, 97, 23);
		Showpanel.add(novelcancel2Btn);

		JButton tagerase = new JButton("태그 제거");
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


	}// 생성자

	ActionListener action1 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (comboBox.getSelectedIndex() != 0) {
				int snid = mgr.getntag_id((String) comboBox.getSelectedItem());// 콤보박스 선택한 태그의 id
				Vector<Beans> vlist2 = new Vector<Beans>();
				vlist2 = mgr.getsmallNoveltag(snid);
				comboBox_1.removeAllItems(); // 중분류 태그박스 리셋
				comboBox_1.addItem("중분류");
				for (int i = 0; i < vlist2.size(); i++) {
					String sntname = vlist2.get(i).getntag_name();
					comboBox_1.addItem(sntname);
				} // 중분류 태그박스 아이템 대분류에 맞게 추가
			} else {
				comboBox_1.removeAllItems();
				comboBox_1.addItem("중분류");
				tagcon.setText("");
			}
			if (comboBox.getSelectedIndex() != 0 && comboBox_1.getSelectedIndex() == 0) {
				int snid = mgr.getntag_id((String) comboBox.getSelectedItem());// 콤보박스 선택한 태그의 id
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
				int snid = mgr.getntag_id((String) comboBox_1.getSelectedItem());// 콤보박스 선택한 태그의 id
				Vector<Beans> vlist2 = new Vector<Beans>();
				vlist2 = mgr.getsmallNoveltag(snid);
				comboBox_2.removeAllItems();
				comboBox_2.addItem("소분류");
				for (int i = 0; i < vlist2.size(); i++) {
					String sntname = vlist2.get(i).getntag_name();
					comboBox_2.addItem(sntname);
				}
			} else {
				comboBox_2.removeAllItems();
				comboBox_2.addItem("소분류");
			}

			if (comboBox_1.getSelectedIndex() != 0 && comboBox_2.getSelectedIndex() == 0) {
				int snid = mgr.getntag_id((String) comboBox_1.getSelectedItem());// 콤보박스 선택한 태그의 id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			} else if (comboBox_1.getSelectedIndex() == 0 && comboBox.getSelectedIndex() != 0) {
				int snid = mgr.getntag_id((String) comboBox.getSelectedItem());// 콤보박스 선택한 태그의 id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			}

		}// 오버라이드 끝
	};// 아이템 리스터 끝

	ActionListener action3 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (comboBox_2.getSelectedIndex() != 0) {
				int snid = mgr.getntag_id((String) comboBox_2.getSelectedItem());// 콤보박스 선택한 태그의 id
				Vector<Beans> vlist2 = new Vector<Beans>();
				vlist2 = mgr.getsmallNoveltag(snid);
				comboBox_3.removeAllItems();
				comboBox_3.addItem("세분류");
				for (int i = 0; i < vlist2.size(); i++) {
					String sntname = vlist2.get(i).getntag_name();
					comboBox_3.addItem(sntname);
				}
			} else {
				comboBox_3.removeAllItems();
				comboBox_3.addItem("세분류");
			}

			if (comboBox_2.getSelectedIndex() != 0 && comboBox_3.getSelectedIndex() == 0) {
				int snid = mgr.getntag_id((String) comboBox_2.getSelectedItem());// 콤보박스 선택한 태그의 id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			} else if (comboBox_2.getSelectedIndex() == 0 && comboBox_1.getSelectedIndex() != 0) {
				int snid = mgr.getntag_id((String) comboBox_1.getSelectedItem());// 콤보박스 선택한 태그의 id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			}
		}// 오버라이드 끝
	};// 아이템 리스터 끝

	ActionListener action4 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (comboBox_3.getSelectedIndex() != 0) {
				int snid = mgr.getntag_id((String) comboBox_3.getSelectedItem());// 콤보박스 선택한 태그의 id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());

			} else if (comboBox_3.getSelectedIndex() == 0 && comboBox_2.getSelectedIndex() != 0) {
				int snid = mgr.getntag_id((String) comboBox_2.getSelectedItem());// 콤보박스 선택한 태그의 id
				Beans tagconbean = new Beans();
				tagconbean = mgr.getNoveltag(snid);
				tagcon.setText(tagconbean.getremark());
			}
		}
	};

}// 클래스
