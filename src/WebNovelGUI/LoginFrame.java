package WebNovelGUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame implements ActionListener, ItemListener {

	private JPanel LoginFrame;
	private JPanel LoginFrame_1;
	private Register Register;
	private MainPanel MainPanel;
	private JTextField IDTF;
	private JButton LoginBtn;
	private JButton JoinBtn;
	private JLabel FWFindLabel;
	private JTextField PWTF;
	private Login l;
	private BufferedReader in;
	private PrintWriter out;
	int port = 8001;
	String serverip = "10.100.105.64";
	String id;
	Socket sock;

	public LoginFrame() {

		LoginFrame = new JPanel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		LoginFrame_1 = new JPanel();
		LoginFrame_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(LoginFrame_1);
		setLocationRelativeTo(null);
		LoginFrame_1.setBackground(Color.WHITE);
		LoginFrame_1.setLayout(null);
		Register = new Register();

		Toolkit tk = Toolkit.getDefaultToolkit();
		Image cursorimage = tk.getImage(DefaultPanel.imgpath + "Cursor5.png");// 커서로 사용할 이미지
		Point point = new Point(0, 0);
		Cursor cursor = tk.createCustomCursor(cursorimage, point, "haha");
		LoginFrame_1.setCursor(cursor);

		Font font = new Font("맑은고딕", Font.PLAIN, 10);

		IDTF = new JTextField();
		IDTF.addActionListener(this);

		IDTF.setBounds(342, 296, 150, 20);
		LoginFrame_1.add(IDTF);
		IDTF.setColumns(10);
		setResizable(false);

		LoginBtn = new JButton("로그인");
		LoginBtn.setBackground(Color.WHITE);
		LoginBtn.setBounds(377, 395, 88, 23);
		LoginBtn.setBorderPainted(false);
		LoginBtn.setFocusable(false);
		LoginFrame_1.add(LoginBtn);

		LoginBtn.addActionListener(this);

		JoinBtn = new JButton("Sign Up");
		JoinBtn.setFont(new Font("굴림", Font.BOLD, 12));
		JoinBtn.setForeground(Color.BLUE);
		JoinBtn.setBackground(Color.WHITE);
		JoinBtn.setBounds(377, 465, 97, 23);
		JoinBtn.setBorderPainted(false);
		JoinBtn.setFocusable(false);
		LoginFrame_1.add(JoinBtn);

		JoinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Register.setVisible(true);
			}
		});

		FWFindLabel = new JLabel("forgot password");
		FWFindLabel.setBounds(384, 370, 96, 15);
		FWFindLabel.setFont(font);
		LoginFrame_1.add(FWFindLabel);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(0, 0, 179, 561);
		LoginFrame_1.add(panel);

		JPanel Square = new JPanel();
		Square.setBackground(new Color(255, 105, 180));
		Square.setBounds(0, 0, 30, 30);
		panel.add(Square);

		JPanel Square2 = new JPanel();
		Square2.setBackground(new Color(218, 112, 214));
		Square2.setBounds(30, 0, 30, 30);
		panel.add(Square2);

		JPanel Square3 = new JPanel();
		Square3.setBackground(new Color(255, 140, 0));
		Square3.setBounds(0, 30, 30, 30);
		panel.add(Square3);

		JPanel Square4 = new JPanel();
		Square4.setBackground(new Color(255, 105, 180));
		Square4.setBounds(754, 531, 30, 30);
		LoginFrame_1.add(Square4);

		JPanel Square6 = new JPanel();
		Square6.setBackground(new Color(218, 112, 214));
		Square6.setBounds(724, 531, 30, 30);
		LoginFrame_1.add(Square6);

		JPanel Square5 = new JPanel();
		Square5.setBackground(new Color(255, 140, 0));
		Square5.setBounds(754, 501, 30, 30);
		LoginFrame_1.add(Square5);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DefaultPanel.imgpath + "mark3.jpg"));
		lblNewLabel_1.setBounds(191, 10, 477, 237);
		LoginFrame_1.add(lblNewLabel_1);

		PWTF = new JPasswordField();
		PWTF.addActionListener(this);
		PWTF.setColumns(10);
		PWTF.setBounds(342, 340, 150, 20);
		LoginFrame_1.add(PWTF);

		JLabel lblDontHaveAccount = new JLabel("Don't have account?");
		lblDontHaveAccount.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblDontHaveAccount.setBounds(380, 451, 112, 15);
		LoginFrame_1.add(lblDontHaveAccount);

		JLabel IDLB = new JLabel("ID Label");
		IDLB.setIcon(new ImageIcon(DefaultPanel.imgpath + "ID.png"));
		IDLB.setBounds(300, 290, 30, 30);
		LoginFrame_1.add(IDLB);

		JLabel PWLB = new JLabel("PW Label");
		PWLB.setIcon(new ImageIcon(DefaultPanel.imgpath + "PW.png"));
		PWLB.setBounds(300, 340, 30, 30);
		LoginFrame_1.add(PWLB);

		JCheckBox ShowBox = new JCheckBox("New check box");
		ShowBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					((JPasswordField) PWTF).setEchoChar('*');
					ShowBox.setIcon(new ImageIcon(DefaultPanel.imgpath + "Hide.png"));
				} else {
					((JPasswordField) PWTF).setEchoChar((char) 0);
					ShowBox.setIcon(new ImageIcon(DefaultPanel.imgpath + "Show.png"));
				}
			}
		});
		ShowBox.setForeground(Color.WHITE);
		ShowBox.setIcon(new ImageIcon(DefaultPanel.imgpath + "Show.png"));
		ShowBox.setOpaque(false);
		ShowBox.setBackground(Color.WHITE);
		ShowBox.setFocusable(false);
		ShowBox.setBorderPainted(false);
		ShowBox.setBounds(490, 335, 36, 30);
		LoginFrame_1.add(ShowBox);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == IDTF) {
			PWTF.requestFocus();
		}
		try {
			if (e.getSource() == PWTF || e.getSource() == LoginBtn) {
				if (sock == null) {
					sock = new Socket(serverip, port);
					in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
					out = new PrintWriter(sock.getOutputStream(), true);
				}
				// 로그인 로직
				out.println(WebNovelprotocol.LOGIN + ":" + IDTF.getText() + ";" + PWTF.getText());
				String line = in.readLine();
				int idx = line.indexOf(':');
				String cmd = line.substring(0, idx);
				String data = line.substring(idx + 1);
				if (cmd.equals(WebNovelprotocol.LOGIN) && data.equals("T")) {
					dispose();
					MainPanel = new MainPanel(IDTF.getText());
					MainPanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	}

}
