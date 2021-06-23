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
		
		
		
		//데이터 테이블
		
		String columnNames[] = {"컬럼명1","컬럼명2"};
		String contents[][]= {{"데이터1","데이터2"},
				{"데이터1","데이터2"},
				{"데이터1","데이터2"},
				{"데이터1","데이터2"},
				{"데이터1","데이터2"},
				{"데이터1","데이터2"},
				{"데이터1","데이터2"},
				{"데이터1","데이터2"},
				{"데이터1","데이터2"},
				{"데이터1","데이터2"},
				{"데이터1","데이터2"},
				{"데이터1","데이터2"},
		};
		getContentPane().setLayout(null);
		JTable table = new JTable(contents,columnNames);
		
		//클릭시 소설 정보로 넘김
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

