package WebNovelGUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ModifyUser extends JFrame {

	private JPanel ModifyUser;
	private LoginFrame LoginFrame;
	private JTextField IDTF;
	private JTextField PWTF;
	private JTextField PWRTF;
	private JTextField NameTF;
	private JTextField EmailTF;
	private JLabel GenderLabel;
	private JLabel BirthLabel;
	private JButton ConfirmBtn;
	private JButton CancelBtn;
	private JPanel panel;
	private JPanel Square;
	private JPanel Square2;
	private JPanel Square3;
	private JPanel Square4;
	private JPanel Square6;
	private JPanel Square5;
	private JLabel IconLabel;
	private JComboBox<String> GenderBox, YearBox, MMBox, DDBox, ImageComboBox;
	private Mgrs mgr;
	private Beans ubean;
	private boolean flag=false;

	public ModifyUser(String presentID) {
		mgr = new Mgrs();
		ubean = new Beans();
		ubean = mgr.getUsers(presentID);

		ModifyUser = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		ModifyUser.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ModifyUser);
		setLocationRelativeTo(null);
		ModifyUser.setBackground(Color.WHITE);
		ModifyUser.setLayout(null);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Image cursorimage = tk.getImage(DefaultPanel.imgpath + "Cursor5.png");// 커서로 사용할 이미지
		Point point = new Point(0, 0);
		Cursor cursor = tk.createCustomCursor(cursorimage, point, "haha");
		ModifyUser.setCursor(cursor);

		JLabel IDLabel = new JLabel("ID");
		IDLabel.setHorizontalAlignment(SwingConstants.LEFT);
		IDLabel.setBounds(251, 76, 57, 15);
		ModifyUser.add(IDLabel);

		IDTF = new JTextField();
		IDTF.setBounds(382, 73, 116, 21);
		IDTF.setText(presentID);
		IDTF.setEditable(false);
		ModifyUser.add(IDTF);
		IDTF.setColumns(10);

		JLabel PWLabel = new JLabel("PW");
		PWLabel.setBounds(251, 116, 57, 15);
		ModifyUser.add(PWLabel);

		PWTF = new JTextField();
		PWTF.setColumns(10);
		PWTF.setText(ubean.getpwd());
		PWTF.setEditable(false);
		PWTF.setBounds(382, 113, 116, 21);
		ModifyUser.add(PWTF);

		JLabel PWRLabel = new JLabel("");
		PWRLabel.setBounds(251, 156, 57, 15);
		ModifyUser.add(PWRLabel);

		PWRTF = new JTextField();
		PWRTF.setColumns(10);
		PWRTF.setEditable(false);
		PWRTF.setBounds(382, 153, 116, 21);
		ModifyUser.add(PWRTF);

		JLabel NameLabel = new JLabel("이름");
		NameLabel.setBounds(251, 196, 57, 15);
		ModifyUser.add(NameLabel);

		NameTF = new JTextField();
		NameTF.setColumns(10);
		NameTF.setText(ubean.getu_name());
		NameTF.setEditable(false);
		NameTF.setBounds(382, 193, 116, 21);
		ModifyUser.add(NameTF);

		JLabel EmailLabel = new JLabel("E-Mail");
		EmailLabel.setBounds(251, 236, 57, 15);
		ModifyUser.add(EmailLabel);
		EmailTF = new JTextField();
		EmailTF.setText(ubean.getemail());
		EmailTF.setEditable(false);
		EmailTF.setColumns(10);
		EmailTF.setBounds(382, 233, 116, 21);
		ModifyUser.add(EmailTF);

		GenderLabel = new JLabel("성별");
		GenderLabel.setBounds(251, 273, 57, 15);
		ModifyUser.add(GenderLabel);

		BirthLabel = new JLabel("생년월일");
		BirthLabel.setBounds(251, 313, 57, 15);
		ModifyUser.add(BirthLabel);

		ConfirmBtn = new JButton("확인");
		ConfirmBtn.setBackground(Color.WHITE);
		ConfirmBtn.setBounds(292, 403, 97, 23);
		ConfirmBtn.setBorderPainted(false);
		ConfirmBtn.setFocusable(false);
		ModifyUser.add(ConfirmBtn);

		ConfirmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ubean.setu_id(IDTF.getText());
				ubean.setpwd(PWTF.getText());
				ubean.setemail(EmailTF.getText());
				ubean.setIcon(ImageComboBox.getSelectedIndex());
				
				mgr.updateUsers(ubean);
				dispose();
				MainPanel m = new MainPanel(presentID);
				m.setVisible(true);
			}
		});

		CancelBtn = new JButton("취소");
		CancelBtn.setBackground(Color.WHITE);
		CancelBtn.setBounds(401, 403, 97, 23);
		CancelBtn.setBorderPainted(false);
		CancelBtn.setFocusable(false);
		ModifyUser.add(CancelBtn);

		CancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				MainPanel m = new MainPanel(presentID);
				m.setVisible(true);
			}
		});

		String Gender[] = { "남", "여" };

		GenderBox = new JComboBox<String>(Gender);
		GenderBox.setSelectedIndex(ubean.getgender());
		GenderBox.setEnabled(false);
		GenderBox.setBounds(382, 269, 116, 23);
		ModifyUser.add(GenderBox);

		String[] Year = new String[100];
		for (int i = 0; i < Year.length; i++) {
			Year[i] = Integer.toString(1920 + i);
		}
		YearBox = new JComboBox<String>(Year);
		Formchange f = new Formchange();
		int byear = Integer.parseInt(f.dateToYMD(ubean.getbirth(), "Y")); 
		YearBox.setSelectedIndex(byear-1920);
		YearBox.setEnabled(false);
		YearBox.setBounds(382, 309, 116, 23);
		YearBox.setSelectedIndex(90);
		ModifyUser.add(YearBox);

		String MM[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

		int bmon = Integer.parseInt(f.dateToYMD(ubean.getbirth(), "M")); 
		MMBox = new JComboBox<String>(MM);
		MMBox.setSelectedIndex(bmon-1);
		MMBox.setEnabled(false);
		MMBox.setBounds(382, 340, 57, 23);
		ModifyUser.add(MMBox);

		String[] DD = new String[31];
		for (int j = 0; j < DD.length; j++) {
			DD[j] = Integer.toString(j + 1);
		}
		int bday = Integer.parseInt(f.dateToYMD(ubean.getbirth(), "D")); 
		DDBox = new JComboBox<String>(DD);
		DDBox.setSelectedIndex(bday-1);
		DDBox.setEnabled(false);
		DDBox.setBounds(441, 340, 57, 23);
		ModifyUser.add(DDBox);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(0, 0, 179, 561);
		ModifyUser.add(panel);

		Square = new JPanel();
		Square.setBackground(new Color(255, 105, 180));
		Square.setBounds(0, 0, 30, 30);
		panel.add(Square);

		Square2 = new JPanel();
		Square2.setBackground(new Color(218, 112, 214));
		Square2.setBounds(30, 0, 30, 30);
		panel.add(Square2);

		Square3 = new JPanel();
		Square3.setBackground(new Color(255, 140, 0));
		Square3.setBounds(0, 30, 30, 30);
		panel.add(Square3);

		Square4 = new JPanel();
		Square4.setBackground(new Color(255, 105, 180));
		Square4.setBounds(754, 531, 30, 30);
		ModifyUser.add(Square4);

		Square6 = new JPanel();
		Square6.setBackground(new Color(218, 112, 214));
		Square6.setBounds(725, 531, 30, 30);
		ModifyUser.add(Square6);

		Square5 = new JPanel();
		Square5.setBackground(new Color(255, 140, 0));
		Square5.setBounds(754, 501, 30, 30);
		ModifyUser.add(Square5);

		

		

		JLabel lblNewLabel_1 = new JLabel("\uB0B4 \uC815\uBCF4");
		lblNewLabel_1.setBounds(251, 34, 57, 15);
		ModifyUser.add(lblNewLabel_1);

		JButton ConfirmBtn_1 = new JButton("\uBCC0\uACBD");
		ConfirmBtn_1.setFocusable(false);
		ConfirmBtn_1.setBorderPainted(false);
		ConfirmBtn_1.setBackground(new Color(245, 245, 245));
		ConfirmBtn_1.setBounds(182, 116, 65, 15);
		ModifyUser.add(ConfirmBtn_1);
		
		ConfirmBtn_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!flag) {
					PWTF.setEditable(flag);
					flag =! flag;
				} else {
					PWTF.setEditable(flag);
					flag =! flag;}
			}
		});

		JButton ConfirmBtn_1_2 = new JButton("\uBCC0\uACBD");
		ConfirmBtn_1_2.setFocusable(false);
		ConfirmBtn_1_2.setBorderPainted(false);
		ConfirmBtn_1_2.setBackground(new Color(245, 245, 245));
		ConfirmBtn_1_2.setBounds(182, 236, 65, 15);
		ModifyUser.add(ConfirmBtn_1_2);
		
		ConfirmBtn_1_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!flag) {
					EmailTF.setEditable(flag);
					flag =! flag;
				} else {
					EmailTF.setEditable(flag);
					flag =! flag;}
			}
		});
		
		ImageIcon ImageIcon[] = { new ImageIcon(DefaultPanel.imgpath+"Angel.png"),
				new ImageIcon(DefaultPanel.imgpath+"Santa.png"),
				new ImageIcon(DefaultPanel.imgpath+"Snow.png"),
				new ImageIcon(DefaultPanel.imgpath+"Elf.png"),
				new ImageIcon(DefaultPanel.imgpath+"pepe.png"),
				new ImageIcon(DefaultPanel.imgpath+"Girl.png"),
				new ImageIcon(DefaultPanel.imgpath+"ninetail.gif"),
				new ImageIcon(DefaultPanel.imgpath+"girl1.png"),
				new ImageIcon(DefaultPanel.imgpath+"girl2.png"),
				new ImageIcon(DefaultPanel.imgpath+"girl3.png")
				};
		
		String Char[] = { "Angel", "Santa", "Snow", "Elf","Pepe","Girl","ninetail","girl1","girl2","girl3"};
		
		JLabel Icon = new JLabel();
		Beans bean = new Beans();
		Mgrs mgr = new Mgrs();
		
		bean = mgr.getUsers(presentID);
		int index = bean.getIcon();
		
		Icon.setIcon(ImageIcon[index]);
		
		panel.add(Icon);

		IconLabel = new JLabel();
		IconLabel.setBounds(510, 76, 160, 175);
		ModifyUser.add(IconLabel);

		ImageComboBox = new JComboBox(Char);

		ImageComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = ImageComboBox.getSelectedIndex();
				IconLabel.setIcon(ImageIcon[index]);
			}
		});
		ImageComboBox.setEnabled(true);
		ImageComboBox.setBounds(510, 269, 160, 23);
		ImageComboBox.setSelectedIndex(index);
		
		ModifyUser.add(ImageComboBox);

	}
}
