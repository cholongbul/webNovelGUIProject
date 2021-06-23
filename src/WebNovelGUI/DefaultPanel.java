package WebNovelGUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DefaultPanel extends JFrame {

	static String imgpath = "." + File.separator + "src" + File.separator + "img" + File.separator;

	public DefaultPanel() {
				
		
		
		
}
	public DefaultPanel(String presentID) {
		
		Beans bean = new Beans();
		Mgrs mgr = new Mgrs();
		
		bean = mgr.getUsers(presentID);
		
		int index = bean.getIcon();
		
		JPanel DefaultPanel = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		DefaultPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(DefaultPanel);
		setLocationRelativeTo(null);
		DefaultPanel.setBackground(Color.WHITE);
		setResizable(false);
		DefaultPanel.setLayout(null);
		
		

		Toolkit tk = Toolkit.getDefaultToolkit();
		Image cursorimage = tk.getImage(imgpath + "Cursor5.png");
		Point point = new Point(0, 0);
		Cursor cursor = tk.createCustomCursor(cursorimage, point, "haha");
		DefaultPanel.setCursor(cursor);

		JPanel Square6 = new JPanel();
		Square6.setBackground(new Color(218, 112, 214));
		Square6.setBounds(724, 531, 30, 30);
		DefaultPanel.add(Square6);

		JPanel Square4 = new JPanel();
		Square4.setBackground(new Color(255, 105, 180));
		Square4.setBounds(754, 531, 30, 30);
		DefaultPanel.add(Square4);

		JPanel Square5 = new JPanel();
		Square5.setBackground(new Color(255, 140, 0));
		Square5.setBounds(754, 501, 30, 30);
		DefaultPanel.add(Square5);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 179, 561);
		DefaultPanel.add(panel);
		panel.setLayout(null);

		JButton home_Button = new JButton("Home");
		home_Button.setBackground(new Color(204, 204, 255));
		home_Button.setFont(new Font("±¼¸²", Font.BOLD, 12));
		home_Button.setBounds(0, 167, 179, 48);
		home_Button.setFocusable(false);
		home_Button.setBorderPainted(false);
		panel.add(home_Button);

		home_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MainPanel MainPanel = new MainPanel(presentID);
				MainPanel.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				home_Button.setBackground(new Color(102, 102, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				home_Button.setBackground(new Color(204, 204, 255));
			}
		});

		JButton tag_Buttong = new JButton("TAG");
		tag_Buttong.setFont(new Font("±¼¸²", Font.BOLD, 12));
		tag_Buttong.setFocusable(false);
		tag_Buttong.setBorderPainted(false);
		tag_Buttong.setBackground(new Color(204, 204, 255));
		tag_Buttong.setBounds(0, 225, 179, 48);

		tag_Buttong.setFont(new Font("±¼¸²", Font.BOLD, 12));
		panel.add(tag_Buttong);
		tag_Buttong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Tagtab Tagtab = new Tagtab(presentID);
				Tagtab.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				tag_Buttong.setBackground(new Color(102, 102, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				tag_Buttong.setBackground(new Color(204, 204, 255));
			}
		});

		JButton btnNovel_buttong = new JButton("Novel");
		btnNovel_buttong.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnNovel_buttong.setFocusable(false);
		btnNovel_buttong.setBorderPainted(false);
		btnNovel_buttong.setBackground(new Color(204, 204, 255));
		btnNovel_buttong.setBounds(0, 283, 179, 48);
		
		btnNovel_buttong.setFont(new Font("±¼¸²", Font.BOLD, 12));
		panel.add(btnNovel_buttong);
		btnNovel_buttong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				NovelTab NovelTab = new NovelTab(presentID);
				NovelTab.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNovel_buttong.setBackground(new Color(102, 102, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNovel_buttong.setBackground(new Color(204, 204, 255));
			}
		});
		

		JButton btnFaq_1 = new JButton("\uB4F1\uC7A5\uC778\uBB3C");
		btnFaq_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFaq_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnFaq_1.setFocusable(false);
		btnFaq_1.setBorderPainted(false);
		btnFaq_1.setBackground(new Color(204, 204, 255));
		btnFaq_1.setBounds(0, 341, 179, 48);
		panel.add(btnFaq_1);
		btnFaq_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				MemberTab MemberTab = new MemberTab(presentID);
				MemberTab.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq_1.setBackground(new Color(102, 102, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFaq_1.setBackground(new Color(204, 204, 255));
			}
		});
		
		
		JButton btnFaq = new JButton("FAQ");
		btnFaq.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnFaq.setFocusable(false);
		btnFaq.setBorderPainted(false);
		btnFaq.setBackground(new Color(204, 204, 255));
		btnFaq.setBounds(0, 399, 179, 48);
		
		
		btnFaq.setFont(new Font("±¼¸²", Font.BOLD, 12));
		panel.add(btnFaq);
		btnFaq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				FAQ FAQ = new FAQ(presentID);
				FAQ.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFaq.setBackground(new Color(102, 102, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFaq.setBackground(new Color(204, 204, 255));
			}
		});
		
		panel.add(btnFaq);
		
		panel.add(btnNovel_buttong);
		
		panel.add(tag_Buttong);
		
		panel.add(home_Button);
		
		ImageIcon ImageIcon[] = { new ImageIcon(imgpath+"Angel100.png"),
				new ImageIcon(imgpath+"Santa100.png"),
				new ImageIcon(imgpath+"Snow100.png"),
				new ImageIcon(imgpath+"Elf100.png"),
				new ImageIcon(imgpath+"pepe100.png"),
				new ImageIcon(imgpath+"Girl100.png"),
				new ImageIcon(imgpath+"ninetail100.gif"),
				new ImageIcon(imgpath+"girl1100.png"),
				new ImageIcon(imgpath+"girl2100.png"),
				new ImageIcon(imgpath+"girl3100.png")
				};
		
		JLabel Icon = new JLabel();
		
		Icon.setBounds(39, 47, 100, 100);
		
		Icon.setIcon(ImageIcon[index]);
		
		panel.add(Icon);
		
		Icon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ModifyUser ModifyUser = new ModifyUser(presentID);
				ModifyUser.setVisible(true);
			}
		});
		
		JPanel Square = new JPanel();
		Square.setBounds(0, 0, 30, 30);
		Square.setBackground(new Color(255, 105, 180));
		panel.add(Square);
		
		JPanel Square2 = new JPanel();
		Square2.setBounds(30, 0, 30, 30);
		Square2.setBackground(new Color(218, 112, 214));
		panel.add(Square2);
		
		JPanel Square3 = new JPanel();
		Square3.setBounds(0, 30, 30, 30);
		Square3.setBackground(new Color(255, 140, 0));
		panel.add(Square3);
		
		
		JLabel TopLabel = new JLabel("Web-Novel \uAC80\uC0C9 \uC2DC\uC2A4\uD15C");
		TopLabel.setBounds(415, 10, 130, 24);
		DefaultPanel.add(TopLabel);
		
		JLabel ID = new JLabel("\uD604\uC7AC \uC544\uC774\uB514");
		ID.setBounds(324, 45, 116, 21);
		DefaultPanel.add(ID);
		
		JLabel IDTab = new JLabel("ID:" + presentID);
		IDTab.setOpaque(true);
		IDTab.setBackground(Color.WHITE);
		IDTab.setBounds(452, 45, 116, 21);
		DefaultPanel.add(IDTab);
		
		JButton MyInfoBtn = new JButton("\uB0B4\uC815\uBCF4");
		MyInfoBtn.setFocusable(false);
		MyInfoBtn.setBorderPainted(false);
		MyInfoBtn.setBounds(580, 44, 90, 23);
		DefaultPanel.add(MyInfoBtn);
		MyInfoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ModifyUser ModifyUser = new ModifyUser(presentID);
				ModifyUser.setVisible(true);
			}
		});
		
		JButton LogOutBtn = new JButton("\uB85C\uADF8\uC544\uC6C3");
		LogOutBtn.setFocusable(false);
		LogOutBtn.setBorderPainted(false);
		LogOutBtn.setBounds(682, 44, 90, 23);
		DefaultPanel.add(LogOutBtn);
		LogOutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LoginFrame LoginFrame = new LoginFrame();
				LoginFrame.setVisible(true);
			}
		});
	
		JButton RefreshBtn = new JButton("");
		RefreshBtn.setIcon(new ImageIcon(imgpath+"RefreshIcon.png"));
		RefreshBtn.setFocusable(false);
		RefreshBtn.setBorderPainted(false);
		RefreshBtn.setBounds(742, 7, 30, 30);
		DefaultPanel.add(RefreshBtn);
		
		RefreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revalidate();
			}
		});
		
		
		
}
};


