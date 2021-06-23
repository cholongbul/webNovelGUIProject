package WebNovelGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class NovelTab extends DefaultPanel {

	private JTextField searchfield;
	private JList novellist;
	private Mgrs mgr;
	private Vector<Beans> vlist;
	private JScrollPane InfoScrollpane;
	private JList searchlist;
	private JComboBox searchcombob;

	public NovelTab(String presentID) {
		super(presentID);
		mgr = new Mgrs();

		getContentPane().setBackground(Color.WHITE);

		JPanel Showpanel = new JPanel();
		Showpanel.setBounds(179, 98, 593, 453);
		Showpanel.setBackground(Color.WHITE);
		getContentPane().add(Showpanel);
		Showpanel.setLayout(null);

		searchfield = new JTextField();
		searchfield.setBounds(144, 0, 261, 21);
		Showpanel.add(searchfield);
		searchfield.setColumns(10);
		searchlist = new JList();
		JPanel searchpanel = new JPanel();
		searchpanel.setLayout(null);
		searchpanel.setBackground(new Color(255, 0, 0, 0));
		Showpanel.add(searchpanel);
		searchfield.addKeyListener(new KeyListener() {
			// 작가 검색 기능
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if (searchcombob.getSelectedIndex() == 0) {
						Mgrs mgr = new Mgrs();
						Vector<Beans> vlist = new Vector<Beans>();
						vlist = mgr.getSearchListnovel(searchfield.getText());// 검색 메소드, 검색 목록 리턴
						if (vlist.size() == 0 || searchfield.getText().equals("")) {
							searchpanel.setVisible(false);
						} // 만약 검색 결과가 없거나 텍스트 창이 공백이라면 검색 결과를 안 보이게
						else {// 검색 결과가 존재하면
							DefaultListModel searchlistmodel = new DefaultListModel();
							for (int i = 0; i < vlist.size(); i++) {
								searchlistmodel.addElement(vlist.get(i).gettitle());
							}
							searchpanel.setVisible(true); // 검색리스트 보이게
							searchlist.setModel(searchlistmodel);
							searchlist.setBounds(1, 1, 296, 19 * vlist.size()); // 검색 결과양에 따라 리스트 길이 조정
							searchpanel.setBounds(144, 21, 261, 17 * vlist.size() + 1); // 검색 패널 위치 조정
							searchpanel.add(searchlist);
							searchlist.setFixedCellHeight(17);
							searchlist.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
							searchlist.setVisible(true);
							searchfield.addKeyListener(new KeyListener() {

								@Override
								public void keyReleased(KeyEvent e) {
									if (e.getKeyCode() == 40) {
										searchlist.requestFocus();
										searchlist.setSelectedIndex(0);
									}
								}

								@Override
								public void keyPressed(KeyEvent arg0) {
								}

								@Override
								public void keyTyped(KeyEvent arg0) {
								}

							});
							searchlist.addKeyListener(new KeyListener() {
								@Override
								public void keyReleased(KeyEvent e) {
									if (e.getKeyCode() == 10) { // 엔터키를 누르면 텍스트 창에 입력
										String s = (String) searchlistmodel.get(searchlist.getSelectedIndex());
										searchfield.setText(s);
										searchpanel.setVisible(false); // 검색 패널 안 보이게

									}
								}

								@Override
								public void keyPressed(KeyEvent e) {
								}

								@Override
								public void keyTyped(KeyEvent e) {
								}
							});
							searchlist.addMouseListener(new MouseAdapter() {

								@Override
								public void mouseClicked(MouseEvent e) {
									String s = (String) searchlistmodel.get(searchlist.getSelectedIndex());
									searchfield.setText(s);
									searchpanel.setVisible(false);// 검색 패널 안 보이게

								}
							});
						}
					} else if (searchcombob.getSelectedIndex() == 1) {
						Mgrs mgr = new Mgrs();
						Vector<Beans> vlist = new Vector<Beans>();
						vlist = mgr.getSearchListAuthor(searchfield.getText());// 검색 메소드, 검색 목록 리턴
						if (vlist.size() == 0 || searchfield.getText().equals("")) {
							searchpanel.setVisible(false);
						} // 만약 검색 결과가 없거나 텍스트 창이 공백이라면 검색 결과를 안 보이게
						else {// 검색 결과가 존재하면
							DefaultListModel searchlistmodel = new DefaultListModel();
							for (int i = 0; i < vlist.size(); i++) {
								searchlistmodel.addElement(vlist.get(i).gettitle());
							}
							searchpanel.setVisible(true); // 검색리스트 보이게
							searchlist.setModel(searchlistmodel);
							searchlist.setBounds(1, 1, 296, 19 * vlist.size()); // 검색 결과양에 따라 리스트 길이 조정
							searchpanel.setBounds(144, 21, 261, 17 * vlist.size() + 1); // 검색 패널 위치 조정
							searchpanel.add(searchlist);
							searchlist.setFixedCellHeight(17);
							searchlist.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
							searchlist.setVisible(true);
							searchfield.addKeyListener(new KeyListener() {

								@Override
								public void keyReleased(KeyEvent e) {
									if (e.getKeyCode() == 40) {
										searchlist.requestFocus();
										searchlist.setSelectedIndex(0);
									}
								}

								@Override
								public void keyPressed(KeyEvent arg0) {
								}

								@Override
								public void keyTyped(KeyEvent arg0) {
								}

							});
							searchlist.addKeyListener(new KeyListener() {
								@Override
								public void keyReleased(KeyEvent e) {
									if (e.getKeyCode() == 10) { // 엔터키를 누르면 텍스트 창에 입력
										String s = (String) searchlistmodel.get(searchlist.getSelectedIndex());
										searchfield.setText(s);
										searchpanel.setVisible(false); // 검색 패널 안 보이게

									}
								}

								@Override
								public void keyPressed(KeyEvent e) {
								}

								@Override
								public void keyTyped(KeyEvent e) {
								}
							});
							searchlist.addMouseListener(new MouseAdapter() {

								@Override
								public void mouseClicked(MouseEvent e) {
									String s = (String) searchlistmodel.get(searchlist.getSelectedIndex());
									searchfield.setText(s);
									searchpanel.setVisible(false);// 검색 패널 안 보이게

								}
							});
						}
					}
				} // try
				catch (Exception e2) {
					e2.printStackTrace();
				}

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});

		String[] searchcombolist = { "작품", "작가" };
		searchcombob = new JComboBox();
		searchcombob.setBounds(90, 0, 54, 20);
		Showpanel.add(searchcombob);
		for (int i = 0; i < searchcombolist.length; i++) {
			searchcombob.addItem(searchcombolist[i]);
		}

		InfoScrollpane = new JScrollPane();
		JLabel novelTab = new JLabel("작품 목록");
		novelTab.setOpaque(true);
		novelTab.setBackground(new Color(102, 102, 255));
		novelTab.setBounds(12, 30, 569, 21);
		Showpanel.add(novelTab);

		String header[] = { "작품명", "작가명", "이용등급", "완결여부" };
		vlist = mgr.getNoveltablist();
		String contents[][] = new String[vlist.size()][4];
		Beans ntabbean = new Beans();
		for (int i = 0; i < vlist.size(); i++) {
			ntabbean = vlist.get(i);
			Formchange f = new Formchange();
			String ending = f.inttoendding(ntabbean.getending());
			String agelimit = f.inttoagelimit(ntabbean.getagelimit());
			for (int j = 0; j < 4; j++) {
				if (j == 0) {
					contents[i][j] = ntabbean.gettitle();
				} else if (j == 1) {
					contents[i][j] = ntabbean.geta_name();
				} else if (j == 2) {
					contents[i][j] = agelimit;
				} else if (j == 3) {
					contents[i][j] = ending;
				}

			}
		}
		DefaultTableModel mod = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		JTable noveltable = new JTable(mod);
		InfoScrollpane.setViewportView(noveltable);

		JButton SrcBtn = new JButton("검색");
		SrcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (searchcombob.getSelectedIndex() == 0) {
					String header[] = { "작품명", "작가명", "이용등급", "완결여부" };
					vlist = mgr.getNovelsearchtablist(searchfield.getText());
					String contents[][] = new String[vlist.size()][4];
					Beans ntabbean2 = new Beans();
					for (int i = 0; i < vlist.size(); i++) {
						ntabbean2 = vlist.get(i);
						Formchange f = new Formchange();
						String ending = f.inttoendding(ntabbean2.getending());
						String agelimit = f.inttoagelimit(ntabbean2.getagelimit());
						for (int j = 0; j < 4; j++) {
							if (j == 0) {
								contents[i][j] = ntabbean2.gettitle();
							} else if (j == 1) {
								contents[i][j] = ntabbean2.geta_name();
							} else if (j == 2) {
								contents[i][j] = agelimit;
							} else if (j == 3) {
								contents[i][j] = ending;
							}

						}
					}
					DefaultTableModel searmod = new DefaultTableModel(contents, header) {
						public boolean isCellEditable(int rowIndex, int mColIndex) {
							return false;
						}
					};
					noveltable.setModel(searmod);
				} else if (searchcombob.getSelectedIndex() == 1) {
					String header[] = { "작품명", "작가명", "이용등급", "완결여부" };
					vlist = mgr.getAuthorsearchtablist(searchfield.getText());
					String contents[][] = new String[vlist.size()][4];
					Beans ntabbean2 = new Beans();
					for (int i = 0; i < vlist.size(); i++) {
						ntabbean2 = vlist.get(i);
						Formchange f = new Formchange();
						String ending = f.inttoendding(ntabbean2.getending());
						String agelimit = f.inttoagelimit(ntabbean2.getagelimit());
						for (int j = 0; j < 4; j++) {
							if (j == 0) {
								contents[i][j] = ntabbean2.gettitle();
							} else if (j == 1) {
								contents[i][j] = ntabbean2.geta_name();
							} else if (j == 2) {
								contents[i][j] = agelimit;
							} else if (j == 3) {
								contents[i][j] = ending;
							}

						}
					}
					DefaultTableModel searmod = new DefaultTableModel(contents, header) {
						public boolean isCellEditable(int rowIndex, int mColIndex) {
							return false;
						}
					};
					noveltable.setModel(searmod);

				}
			}
		});
		SrcBtn.setFocusable(false);
		SrcBtn.setBorderPainted(false);
		SrcBtn.setBounds(410, 0, 60, 20);
		Showpanel.add(SrcBtn);

		noveltable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					dispose();
					String selectednovel = (String) noveltable.getModel().getValueAt(noveltable.getSelectedRow(), 0);
					NovelInfo novelInfo = new NovelInfo(presentID, selectednovel);
					novelInfo.setVisible(true);
				}
			}
		});
		noveltable.setBounds(12, 51, 569, 346);
		noveltable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		noveltable.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		noveltable.setBackground(new Color(204, 204, 255));
		Showpanel.add(noveltable);

		JButton novel_Add_btn = new JButton("추가");
		novel_Add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Novelinsert novelinsert = new Novelinsert(presentID);
				novelinsert.setVisible(true);
			}
		});
		novel_Add_btn.setBounds(358, 411, 97, 23);
		Showpanel.add(novel_Add_btn);

		JButton novel_Delete_btn = new JButton("제거");
		novel_Delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		novel_Delete_btn.setBounds(467, 411, 97, 23);
		Showpanel.add(novel_Delete_btn);

	}
}
