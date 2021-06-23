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

public class Register extends JFrame {

	private JPanel Register;
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
	private JLabel lblNewLabel;
	private JComboBox<String> GenderBox, YearBox, MMBox, DDBox, IconBox;

	public Register() {

		Register = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Register.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Register);
		setLocationRelativeTo(null);
		Register.setBackground(Color.WHITE);
		Register.setLayout(null);
		

		
		Beans bean = new Beans();
		
		

		JLabel IDLabel = new JLabel("ID");
		IDLabel.setHorizontalAlignment(SwingConstants.LEFT);
		IDLabel.setBounds(251, 76, 57, 15);
		Register.add(IDLabel);

		IDTF = new JTextField();
		IDTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PWTF.requestFocus();
			}
		});
		IDTF.setBounds(382, 73, 116, 21);
		Register.add(IDTF);
		IDTF.setColumns(10);

		JLabel PWLabel = new JLabel("PW");
		PWLabel.setBounds(251, 116, 57, 15);
		Register.add(PWLabel);

		PWTF = new JTextField();
		PWTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PWRTF.requestFocus();
			}
		});
		PWTF.setColumns(10);
		PWTF.setBounds(382, 113, 116, 21);
		Register.add(PWTF);

		JLabel PWRLabel = new JLabel("PW(확인)");
		PWRLabel.setBounds(251, 156, 57, 15);
		Register.add(PWRLabel);

		PWRTF = new JTextField();
		PWRTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NameTF.requestFocus();
			}
		});
		PWRTF.setColumns(10);
		PWRTF.setBounds(382, 153, 116, 21);
		Register.add(PWRTF);

		JLabel NameLabel = new JLabel("이름");
		NameLabel.setBounds(251, 196, 57, 15);
		Register.add(NameLabel);

		NameTF = new JTextField();
		NameTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmailTF.requestFocus();
			}
		});
		NameTF.setColumns(10);
		NameTF.setBounds(382, 193, 116, 21);
		Register.add(NameTF);

		JLabel EmailLabel = new JLabel("E-Mail");
		EmailLabel.setBounds(251, 236, 57, 15);
		Register.add(EmailLabel);

		EmailTF = new JTextField();
		EmailTF.setColumns(10);
		EmailTF.setBounds(382, 233, 116, 21);
		Register.add(EmailTF);

		GenderLabel = new JLabel("성별");
		GenderLabel.setBounds(251, 273, 57, 15);
		Register.add(GenderLabel);

		BirthLabel = new JLabel("생년월일");
		BirthLabel.setBounds(251, 313, 57, 15);
		Register.add(BirthLabel);

		ConfirmBtn = new JButton("확인");
		ConfirmBtn.setBackground(Color.WHITE);
		ConfirmBtn.setBounds(292, 403, 97, 23);
		ConfirmBtn.setBorderPainted(false);
		ConfirmBtn.setFocusable(false);
		Register.add(ConfirmBtn);

		ConfirmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				Formchange f = new Formchange();
				String birth = f.itemtodate(YearBox.getSelectedItem(), MMBox.getSelectedItem(), DDBox.getSelectedItem());
				if(l.pwdcheck(PWTF.getText(), PWRTF.getText())) {
				if(l.registing(IDTF.getText(), PWTF.getText(), NameTF.getText(), 
						EmailTF.getText(), birth, GenderBox.getSelectedItem().toString(),IconBox.getSelectedIndex())) {
					
					System.out.println(IconBox.getSelectedIndex());

				dispose();
				LoginFrame = new LoginFrame();
				LoginFrame.setVisible(true);
			}}}
		});

		CancelBtn = new JButton("취소");
		CancelBtn.setBackground(Color.WHITE);
		CancelBtn.setBounds(401, 403, 97, 23);
		CancelBtn.setBorderPainted(false);
		CancelBtn.setFocusable(false);
		Register.add(CancelBtn);

		CancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame = new LoginFrame();
				LoginFrame.setVisible(true);
			}
		});

		String Gender[] = { "남", "여" };

		GenderBox = new JComboBox<String>(Gender);
		GenderBox.setBounds(382, 269, 116, 23);
		Register.add(GenderBox);

		String[] Year = new String[100];
		for (int i = 0; i < Year.length; i++) {
			Year[i] = Integer.toString(1920 + i);
		}
		YearBox = new JComboBox<String>(Year);
		YearBox.setBounds(382, 309, 116, 23);
		YearBox.setSelectedIndex(90);
		Register.add(YearBox);

		String MM[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

		MMBox = new JComboBox<String>(MM);
		MMBox.setBounds(382, 340, 57, 23);
		Register.add(MMBox);

		String[] DD = new String[31];
		for (int j = 0; j < DD.length; j++) {
			DD[j] = Integer.toString(j + 1);
		}
		DDBox = new JComboBox<String>(DD);
		DDBox.setBounds(441, 340, 57, 23);
		Register.add(DDBox);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(0, 0, 179, 561);
		Register.add(panel);

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
		Register.add(Square4);

		Square6 = new JPanel();
		Square6.setBackground(new Color(218, 112, 214));
		Square6.setBounds(725, 531, 30, 30);
		Register.add(Square6);

		Square5 = new JPanel();
		Square5.setBackground(new Color(255, 140, 0));
		Square5.setBounds(754, 501, 30, 30);
		Register.add(Square5);

		ImageIcon Icon[] = { new ImageIcon(DefaultPanel.imgpath+"Angel.png"),
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

		lblNewLabel = new JLabel(Icon[0]);
		lblNewLabel.setBounds(510, 76, 160, 175);
		Register.add(lblNewLabel);

		IconBox = new JComboBox(Char);
		Toolkit tk = Toolkit.getDefaultToolkit();
        int index = IconBox.getSelectedIndex();
		
		Image cursorimage=tk.getImage(DefaultPanel.imgpath+"Cursor5.png");//커서로 사용할 이미지
		Point point=new Point(0,0);
		Cursor cursor=tk.createCustomCursor(cursorimage, point, "haha");
		Register.setCursor(cursor); 

		IconBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Beans bean = new Beans();
				int index = IconBox.getSelectedIndex();
				lblNewLabel.setIcon(Icon[index]);
				bean.setIcon(index);
				
			}
		});
		IconBox.setBounds(510, 269, 160, 23);
		Register.add(IconBox);
		
		IconBox.setSelectedIndex(0);
		

		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel_1.setBounds(251, 34, 57, 15);
		Register.add(lblNewLabel_1);

	}
	
	
}
