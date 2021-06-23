
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
	public String[] mediastirng = { "영화", "드라마", "웹툰", "라디오 드라마", "뮤지컬" };
	public String presentID;
	private Socket sock;

	public Novelinsert() {
	}

	// 노벨 게시판에서 작품 추가 버튼을 누르면 나오는 창
	public Novelinsert(String presentID) {
		super(presentID);// 부모 패널에 현재 아이디 덧씌우기
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

		// 작품 제목 추가 라벨, 필드
		titlelabel = new JLabel("제목");
		titlelabel.setBounds(30, 15, 70, 22);
		Showpanel.add(titlelabel);

		titleField = new JTextField();
		titleField.setBounds(110, 15, 200, 22);
		Showpanel.add(titleField);
		titleField.setColumns(30);
		// 작가 라벨 추가
		authorlabel = new JLabel("작가");
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
			// 작가 검색 기능
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Mgrs mgr = new Mgrs();
					Vector<Beans> vlist = new Vector<Beans>();
					vlist = mgr.getSearchListAuthor(authorField.getText());// 검색 메소드, 검색 목록 리턴
					if (vlist.size() == 0 || authorField.getText().equals("")) {
						authorpanel.setVisible(false);
					} // 만약 검색 결과가 없거나 텍스트 창이 공백이라면 검색 결과를 안 보이게
					else {// 검색 결과가 존재하면
						DefaultListModel authorlist = new DefaultListModel();
						for (int i = 0; i < vlist.size(); i++) {
							authorlist.addElement(vlist.get(i).geta_name());
						}
						authorpanel.setVisible(true); // 검색리스트 보이게
						authorserch.setModel(authorlist);
						authorserch.setBounds(1, 1, 200, 17 * vlist.size()); // 검색 결과양에 따라 리스트 길이 조정
						authorpanel.setBounds(109, 66, 201, 17 * vlist.size() + 1); // 검색 패널 위치 조정
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
								if (e.getKeyCode() == 10) { // 엔터키를 누르면 텍스트 창에 입력
									String s = (String) authorlist.get(authorserch.getSelectedIndex());
									authorField.setText(s);
									authorpanel.setVisible(false); // 검색 패널 안 보이게

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
								authorpanel.setVisible(false);// 검색 패널 안 보이게

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
		Showpanel.add(authorField);// 작가 필드 추가
		// 연재처 라벨
		sitelabel = new JLabel("연재처");
		sitelabel.setBounds(30, 75, 70, 22);
		Showpanel.add(sitelabel);
		// 연재처 텍스트 필드
		siteField = new JTextField();
		siteField.setBounds(110, 75, 200, 22);
		siteField.setEditable(false);
		Showpanel.add(siteField);

		sitebtn = new JButton("연재처 찾기"); // 연재처 찾기 기능 액션
		sitebtn.addActionListener(this);
		sitebtn.setBounds(315, 75, 120, 22);
		Showpanel.add(sitebtn);
		// 출판유무 라벨
		puboxlabel = new JLabel("출판유무");
		puboxlabel.setBounds(30, 105, 70, 22);
		Showpanel.add(puboxlabel);
		// 출판유무 버튼
		ButtonGroup pubgroup = new ButtonGroup();
		String[] ox = { "유", "무" };

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
			// 출판 유무 버튼 액션
			@Override
			public void actionPerformed(ActionEvent e) {
				if (puboxbtn[1].isSelected()) {
					pubbox.setEnabled(false);
				} // 출판 유무 '유'선택시 출판사 선택 가능
			}
		});
		puboxbtn[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (puboxbtn[0].isSelected()) {
					pubbox.setEnabled(true);
				} // 출판유무 '무'선택시 출판사 선택 불가능
			}
		});
		// 출판사 라벨
		publabel = new JLabel("출판사");
		publabel.setBounds(30, 135, 70, 22);
		Showpanel.add(publabel);
		// 출판사 콤보박스
		pubbox = new JComboBox();
		pubbox.setBounds(110, 135, 120, 22);
		Showpanel.add(pubbox);
		pubbox.setEnabled(false);
		// 출판사 콤보박스 아이템 데이터 베이스에서 추가
		pubbox.addItem("-출판사-");
		mgr.getListPubcomp();
		for (int i = 0; i < mgr.getListPubcomp().size(); i++) {
			String pubboxname = mgr.getListPubcomp().get(i).getp_name();
			pubbox.addItem(pubboxname);
		}
		// 이용등급 라벨
		agelabel = new JLabel("이용등급");
		agelabel.setBounds(30, 165, 70, 22);
		Showpanel.add(agelabel);
		// 이용등급 콤보박스, 아이템 추가
		agebox = new JComboBox();
		agebox.addItem("이용등급");
		agebox.addItem("전체이용가");
		agebox.addItem("12세이용가");
		agebox.addItem("15세이용가");
		agebox.addItem("19세이용가");
		agebox.setBounds(110, 165, 120, 22);
		Showpanel.add(agebox);
		// 미디어믹스 라벨
		Medialabel = new JLabel("미디어믹스");
		Medialabel.setBounds(30, 195, 70, 22);
		Showpanel.add(Medialabel);

		// 미디어믹스 체크박스
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
		// 표지 이미지 추가 라벨
		novelimg = new JLabel("표지 이미지");
		novelimg.setBounds(30, 240, 70, 22);
		Showpanel.add(novelimg);
		// 표지 이미지 추가 필드
		imgField = new JTextField();
		imgField.setBounds(110, 240, 200, 22);
		Showpanel.add(imgField);
		imgField.setEditable(false);

		// 작품 이력 라벨
		historylabel = new JLabel("작품 이력(수상 실적, 특이사항)");
		historylabel.setBounds(30, 270, 500, 22);
		Showpanel.add(historylabel);
		// 작품 이력 텍스트에이리어
		historyArea = new JTextArea();
		historyArea.setBounds(30, 294, 400, 51);
		historyArea.setVisible(true);
		historyArea.setBackground(Color.LIGHT_GRAY);
		Showpanel.add(historyArea);
		// 작품 줄거리 라벨
		storylabel = new JLabel("줄거리");
		storylabel.setBounds(30, 350, 70, 22);
		Showpanel.add(storylabel);
		// 작품 줄거리 텍스트
		storyArea = new JTextArea();
		storyArea.setBounds(30, 374, 400, 66);
		storyArea.setBackground(Color.LIGHT_GRAY);
		Showpanel.add(storyArea);
		// 이미지 버튼
		imgbtn = new JButton("이미지 업로드");
		imgbtn.addActionListener(this);

		imgbtn.setBounds(320, 240, 110, 23);
		Showpanel.add(imgbtn);
		// 다음 페이지로 넘어가는 버튼
		// 다음 페이지로 넘어가는 버튼
		nextbtn = new JButton("다음");
		nextbtn.addActionListener(this);

		
		nextbtn.setBounds(440, 430, 97, 23);
		Showpanel.add(nextbtn);

	}// 생성자

	@Override
	public void actionPerformed(ActionEvent e) {
		Mgrs mgr = new Mgrs(); 
		Formchange f = new Formchange();
		if (e.getSource() == sitebtn) {
			
			if (titleField.getText().equals("")) { // 작품 제목 입력 안하면 팝업
				JOptionPane.showMessageDialog(null, "작품제목을 입력해주세요", "작품 제목 입력", JOptionPane.WARNING_MESSAGE);
			} else if (authorField.getText().equals("")) { // 작가 이름 팝업
				JOptionPane.showMessageDialog(null, "작가 이름을 입력해주세요", "작가 이름 입력", JOptionPane.WARNING_MESSAGE);
			} else if (f.authorcheck(authorField.getText())) { // 존재하지 않는 작가 팝업
				int result = JOptionPane.showConfirmDialog(null, "작가가 목록에 없습니다. 새로작가를 추가하시겠습니까?", "작가 없음",
						JOptionPane.OK_CANCEL_OPTION);

				if (result == 0) { // OK=0 , Cancel=2 리턴
					Beans abean = new Beans();
					abean.seta_name(authorField.getText());
					mgr.insertAuthor(abean);
					JOptionPane.showMessageDialog(null, "작가가 추가되었습니다", "작가 추가 완료", JOptionPane.WARNING_MESSAGE);
				}
			} else { // 연재처 입력 팝업
				webdialog = new Webdailog(this);
				webdialog.setVisible(true);
			}

		}
		if(e.getSource()==imgbtn){
			fileupload = new FileUpload2(this);
			fileupload.setVisible(true);
			
		}
		if(e.getSource()==nextbtn) {
			dispose();// 본 창 끄기
			publishingbean = new Beans();
			nbean.settitle(titleField.getText());// 작품 빈에 작품 제목 저장
			if (agebox.getSelectedIndex() != 0) {// 선택한 이용등급 숫자로 바꿔서 작품 빈에 저장
				nbean.setagelimit(agebox.getSelectedIndex() - 1);
			}
			nbean.setstoryline(storyArea.getText());// 줄거리 작품 빈에 저장
			nbean.setn_history(historyArea.getText());// 작품 이력 작품 빈에 저장
			if (pubbox.getSelectedIndex() != 0) {
				publishingbean.setp_id(mgr.getp_id((String) pubbox.getSelectedItem()));
			} // 선택한 출판사 아이디 출판 빈에 저장
			for (int i = 0; i < mediastirng.length; i++) {
				if (mediaBox[i].isSelected()) {
					mediabean.setmediamix(i);
					mediabeanlist.addElement(mediabean);
				}
			} // 미디어빈에 선택한 미디어 믹스 숫자, 내용 저장
			novelinsert2 = new Novelinsert2(presentID, this);
			novelinsert2.setVisible(true);
			
		}
	}//메소드

}
