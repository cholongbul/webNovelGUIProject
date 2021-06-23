package WebNovelGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class MainPanel extends DefaultPanel{
	private JTextField textField;
	


	public MainPanel(String presentID) {
		
		super(presentID);
		JPanel Showpanel = new JPanel();
		Showpanel.setBounds(179, 98, 593, 453);
		Showpanel.setBackground(Color.WHITE);
		getContentPane().add(Showpanel);
		Showpanel.setLayout(null);
		
		JButton SrcBtn = new JButton("\uAC80\uC0C9");
		SrcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		SrcBtn.setFocusable(false);
		SrcBtn.setBorderPainted(false);
		SrcBtn.setBounds(263, 354, 97, 23);
		Showpanel.add(SrcBtn);
		
		textField = new JTextField();
		textField.setBounds(166, 283, 316, 21);
		Showpanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC790\uB3D9\uC644\uC131\uAD6C\uD604");
		lblNewLabel.setBounds(397, 330, 85, 15);
		Showpanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DefaultPanel.imgpath + "a6438d0aa7c55e82f1ed220a06f2d658.gif"));
		lblNewLabel_1.setBounds(45, 10, 506, 263);
		Showpanel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(118, 282, 49, 23);
		Showpanel.add(comboBox);
		
		
		
	}
}
