package WebNovelGUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DataInfo extends DefaultPanel{

	public DataInfo(String presentID) {
		super(presentID);

		getContentPane().setBackground(Color.WHITE);
		
		
		
		//������ ���̺�
		
		String columnNames[] = {"�÷���1","�÷���2"};
		String contents[][]= {{"������1","������2"},
				{"������1","������2"},
				{"������1","������2"},
				{"������1","������2"},
				{"������1","������2"},
				{"������1","������2"},
				{"������1","������2"},
				{"������1","������2"},
				{"������1","������2"},
				{"������1","������2"},
				{"������1","������2"},
				{"������1","������2"},
		};
		getContentPane().setLayout(null);
		JTable table = new JTable(contents,columnNames);
		
		//Ŭ���� �Ҽ� ������ �ѱ�
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				NovelInfo NovelInfo = new NovelInfo(presentID, "ss");
				NovelInfo.setVisible(true);
			}
		});
		table.setBounds(12, 10, 576, 370);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(179, 98, 593, 453);
		getContentPane().add(scrollPane);
		
	       
	    }
	}

