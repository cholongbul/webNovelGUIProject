package WebNovelGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Dialog extends JFrame{

	private String Label1;
	private String Label2;

	public Dialog(String text) {
		
		
		setBounds(0, 0, 600, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(87, 215, 294, 23);
		getContentPane().add(comboBox);
		comboBox.setVisible(false);
		
		
		//À§
		JLabel Label1 = new JLabel("\u314B\u314B\u314B\u314B\u314B\u314B\u314B\u314B\u314B\u314B");
		Label1.setFont(new Font("±Ã¼­Ã¼", Font.BOLD, 16));
		Label1.setBounds(87, 181, 294, 15);
		getContentPane().add(Label1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DefaultPanel.imgpath + "DialogPepe.gif"));
		lblNewLabel.setBounds(12, 10, 533, 151);
		getContentPane().add(lblNewLabel);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialog frame = new Dialog("ejatkdml");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	}
	
