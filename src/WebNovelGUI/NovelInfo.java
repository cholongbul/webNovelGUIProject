package WebNovelGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NovelInfo extends DefaultPanel {
	
	private Vector<Beans> ninfolist;

	public NovelInfo(String presentID, String selectednovel) {
		super(presentID);
		Mgrs mgr = new Mgrs();
		Beans ninfobean = new Beans();
		ninfobean = mgr.getnovelifo1(selectednovel);
		//패널
		JPanel Showpanel = new JPanel();
		Showpanel.setBounds(179, 98, 593, 453);
		Showpanel.setBackground(Color.WHITE);
		getContentPane().add(Showpanel);
		Showpanel.setLayout(null);
		//이미지 라벨
		JLabel IMGlabel = new JLabel("\uC774\uBBF8\uC9C0 \uC8FC\uC18C \uC785\uB825");
		IMGlabel.setIcon(new ImageIcon(DefaultPanel.imgpath+ mgr.getn_id(selectednovel) + ".jpg"));
		IMGlabel.setOpaque(true);
		IMGlabel.setBackground(Color.WHITE);
		IMGlabel.setBounds(0, 0, 200, 280);
		Showpanel.add(IMGlabel);
		//제목 라벨
		JLabel Title = new JLabel(" 제목");
		Title.setBounds(200, 0, 63, 30);
		Title.setOpaque(true);
		Title.setBackground(new Color(180,172,246,120));
		Showpanel.add(Title);
		 
		
		JLabel TitleLabel = new JLabel(selectednovel);
		TitleLabel.setOpaque(true);
		TitleLabel.setBackground(new Color(180,172,246,120));
		TitleLabel.setBounds(263, 0, 310, 30);
		Showpanel.add(TitleLabel);
		
		JLabel Author = new JLabel(" 작가");
		Author.setBounds(200, 30, 63, 30);
		Author.setOpaque(true);
		Author.setBackground(new Color(180,172,246,96));
		Showpanel.add(Author);
		
		JLabel AuthorLabel = new JLabel(ninfobean.geta_name());
		AuthorLabel.setOpaque(true);
		AuthorLabel.setBackground(new Color(180,172,246,96));
		AuthorLabel.setBounds(263, 30, 310, 30);
		Showpanel.add(AuthorLabel);
		String platform = "";
		for (int i = 0; i < mgr.getnovelifo_webcomp(selectednovel).size(); i++) {
			platform += mgr.getnovelifo_webcomp(selectednovel).get(i).getw_name()+" // ";
		} //작품 연재처 리스트 호출
		JLabel PlatForm = new JLabel(" 연재처");
		PlatForm.setBounds(200, 60, 63, 30);
		PlatForm.setOpaque(true);
		PlatForm.setBackground(new Color(180,172,246,120));
		Showpanel.add(PlatForm);
		
		JLabel PlatFormLabel = new JLabel(platform);
		PlatFormLabel.setOpaque(true);
		PlatFormLabel.setBackground(new Color(180,172,246,120));
		PlatFormLabel.setBounds(263, 60, 310, 30);
		Showpanel.add(PlatFormLabel);
		
		JLabel Publisher = new JLabel(" 출판사");
		Publisher.setBounds(200, 90, 63, 30);
		Publisher.setOpaque(true);
		Publisher.setBackground(new Color(180,172,246,96));
		Showpanel.add(Publisher);
		String pubname = mgr.getnovelifo_pubcomp(selectednovel).getp_name();
		if(pubname==null) {
		JLabel PublisherLabel = new JLabel("출판 정보 없음");
		PublisherLabel.setOpaque(true);
		PublisherLabel.setBackground(new Color(180,172,246,96));
		PublisherLabel.setBounds(263, 90, 310, 30);
		Showpanel.add(PublisherLabel);}
		else {
			JLabel PublisherLabel = new JLabel(pubname);
			PublisherLabel.setOpaque(true);
			PublisherLabel.setBackground(new Color(180,172,246,96));
			PublisherLabel.setBounds(263, 90, 310, 30);
			Showpanel.add(PublisherLabel);
		}
		
		JLabel AgeGrade = new JLabel(" 이용등급");
		AgeGrade.setBounds(200, 120, 63, 30);
		AgeGrade.setOpaque(true);
		AgeGrade.setBackground(new Color(180,172,246,120));
		Showpanel.add(AgeGrade);
		Formchange f = new Formchange();
		JLabel AgeGradeLabel = new JLabel(f.inttoagelimit(ninfobean.getagelimit()));
		AgeGradeLabel.setOpaque(true);
		AgeGradeLabel.setBackground(new Color(180,172,246,120));
		AgeGradeLabel.setBounds(263, 120, 310, 30);
		Showpanel.add(AgeGradeLabel);
			
		JLabel Startandend = new JLabel(" 연재일");
		Startandend.setBounds(200, 150, 63, 30);
		Startandend.setOpaque(true);
		Startandend.setBackground(new Color(180,172,246,96));
		Showpanel.add(Startandend);
		
		String started = mgr.getnovelifo_started(selectednovel).getstarted();
		String ended = mgr.getnovelifo_started(selectednovel).getended();
		
		
		if(mgr.getNovel(mgr.getn_id(selectednovel)).getending()==0) {//연재중이면
		JLabel StartLabel = new JLabel(started.substring(0, 10)+"  ~ " + " 연재중");
		StartLabel.setOpaque(true);
		StartLabel.setBackground(new Color(180,172,246,96));
		StartLabel.setBounds(263, 150, 310, 30);
		Showpanel.add(StartLabel);}
		else if(mgr.getNovel(mgr.getn_id(selectednovel)).getending()==1)  {//완결이 났으면
			JLabel StartLabel = new JLabel(started.substring(0, 10)+" ~ " + ended.substring(0, 10));
			StartLabel.setOpaque(true);
			StartLabel.setBackground(new Color(180,172,246,96));
			StartLabel.setBounds(263, 150, 310, 30);
			Showpanel.add(StartLabel);
			
		}
		
		JLabel Vote = new JLabel(" 유저참여");
		Vote.setBounds(200, 180, 63, 30);
		Vote.setOpaque(true);
		Vote.setBackground(new Color(180,172,246,120));
		Showpanel.add(Vote);
		
		JLabel VoteLabel = new JLabel("");
		VoteLabel.setOpaque(true);
		VoteLabel.setBackground(new Color(180,172,246,120));
		VoteLabel.setBounds(263, 180, 310, 30);
		Showpanel.add(VoteLabel);
				
		JLabel History = new JLabel(" 작품 이력");
		History.setBounds(200, 210, 373, 30);
		History.setOpaque(true);
		History.setBackground(new Color(180,172,246,96));
		Showpanel.add(History);
		
		JTextArea HistoryLabel = new JTextArea(ninfobean.getn_history());
		HistoryLabel.setOpaque(true);
		HistoryLabel.setEditable(false);
		HistoryLabel.setBackground(new Color(180,172,246,96));
		HistoryLabel.setBounds(200, 240, 373, 40);
		Showpanel.add(HistoryLabel);
		
		JLabel Tag = new JLabel(" 작품 태그");
		Tag.setBounds(200, 280, 373, 30);
		Tag.setOpaque(true);
		Tag.setBackground(new Color(180,172,246,120));
		Showpanel.add(Tag);
		Vector<Beans> taglist = new Vector<Beans>();
		taglist = mgr.getnovelifo_tag(selectednovel);
		String tagname = "";
		for (int j = 0; j < taglist.size(); j++) {
			tagname += taglist.get(j).getntag_name() + " // "; 	
		}
		JTextArea TagArea = new JTextArea(tagname);
		TagArea.setOpaque(true);
		TagArea.setEditable(false);
		TagArea.setBackground(new Color(180,172,246,120));
		TagArea.setBounds(200, 310, 373, 85);
		Showpanel.add(TagArea);
		
		JLabel Story = new JLabel(" 줄거리");
		Story.setBounds(0, 280, 200, 30);
		Story.setOpaque(true);
		Story.setBackground(new Color(180,172,246,96));
		Showpanel.add(Story);
		
		JTextArea StoryArea = new JTextArea(ninfobean.getstoryline());
		StoryArea.setOpaque(true);
		StoryArea.setEditable(false);
		StoryArea.setBackground(new Color(180,172,246,96));
		StoryArea.setBounds(0, 310, 200, 85);
		Showpanel.add(StoryArea);
		
		
		
		JButton backpage = new JButton("뒤로 가기");
		backpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NovelTab novelTab = new NovelTab(presentID);
				novelTab.setVisible(true);
			}
		});
		backpage.setBounds(358, 411, 97, 23);
		Showpanel.add(backpage);
		


		
		JButton Delete = new JButton("작품 수정");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		Delete.setBounds(467, 411, 97, 23);
		Showpanel.add(Delete);		
		
	
	}
	
}
	
	

