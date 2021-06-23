package WebNovelGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class DataInsert extends DefaultPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	
	public DataInsert(String presentID) {
		super(presentID);

		JPanel Showpanel = new JPanel();
		Showpanel.setBounds(179, 98, 593, 453);
		Showpanel.setBackground(Color.WHITE);
		getContentPane().add(Showpanel);
		Showpanel.setLayout(null);
		
		JButton ConfirmBtn = new JButton("\uD655\uC778");
		ConfirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPanel MainPanel = new MainPanel(presentID);
				MainPanel.setVisible(true);
			}
		});
		ConfirmBtn.setBounds(467, 411, 97, 23);
		Showpanel.add(ConfirmBtn);
		
		JLabel IMGlabel = new JLabel("");
		IMGlabel.setIcon(new ImageIcon(DefaultPanel.imgpath+"\uC18C\uC124\uD45C\uC9C0.jpg"));
		IMGlabel.setOpaque(true);
		IMGlabel.setBackground(Color.WHITE);
		IMGlabel.setBounds(12, 22, 200, 280);
		Showpanel.add(IMGlabel);
		
		JLabel Title = new JLabel("\uC81C\uBAA9");
		Title.setBounds(224, 22, 57, 15);
		Showpanel.add(Title);
		
		JLabel Author = new JLabel("\uC791\uAC00");
		Author.setBounds(224, 47, 57, 15);
		Showpanel.add(Author);
		
		JLabel PlatForm = new JLabel("\uC5F0\uC7AC\uCC98");
		PlatForm.setBounds(224, 72, 57, 15);
		Showpanel.add(PlatForm);
		
		JLabel Publisher = new JLabel("\uCD9C\uD310\uC0AC");
		Publisher.setBounds(224, 97, 57, 15);
		Showpanel.add(Publisher);
		
		JLabel AgeGrade = new JLabel("\uC774\uC6A9\uB4F1\uAE09");
		AgeGrade.setBounds(224, 122, 57, 15);
		Showpanel.add(AgeGrade);
		
		JLabel Complete = new JLabel("\uC644\uACB0");
		Complete.setBounds(224, 147, 57, 15);
		Showpanel.add(Complete);
		
		JLabel Start = new JLabel("\uC2DC\uC791\uC77C");
		Start.setBounds(224, 172, 57, 15);
		Showpanel.add(Start);
		
		JLabel End = new JLabel("\uC885\uB8CC\uC77C");
		End.setBounds(224, 197, 57, 15);
		Showpanel.add(End);
		
		JLabel History = new JLabel("\uC791\uD488\uC774\uB825");
		History.setBounds(224, 222, 57, 15);
		Showpanel.add(History);
		
		JLabel Vote = new JLabel("\uD3C9\uAC00");
		Vote.setBounds(224, 247, 57, 15);
		Showpanel.add(Vote);
		
		JLabel Add = new JLabel("\uCD94\uAC00\uBC14\uB78C");
		Add.setBounds(224, 272, 57, 15);
		Showpanel.add(Add);
		
		JTextArea PlotTA = new JTextArea("\uC904\uAC70\uB9AC");
		PlotTA.setBounds(12, 312, 200, 89);
		Showpanel.add(PlotTA);
		
		JTextArea TagTA = new JTextArea("\uD0DC\uADF8\uD45C");
		TagTA.setBounds(224, 312, 353, 89);
		Showpanel.add(TagTA);
		
		textField = new JTextField();
		textField.setBounds(273, 22, 304, 15);
		Showpanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(273, 47, 304, 15);
		Showpanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(273, 72, 304, 15);
		Showpanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(273, 97, 304, 15);
		Showpanel.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(273, 147, 304, 15);
		Showpanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(273, 172, 304, 15);
		Showpanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(273, 194, 304, 15);
		Showpanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(273, 219, 304, 15);
		Showpanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(273, 247, 304, 15);
		Showpanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(273, 272, 304, 15);
		Showpanel.add(textField_10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(273, 118, 304, 23);
		Showpanel.add(comboBox);
		
	
	}
}
