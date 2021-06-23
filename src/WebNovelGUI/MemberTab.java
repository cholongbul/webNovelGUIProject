package WebNovelGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MemberTab extends DefaultPanel {
	private JTextField searchfield;
	private JList memberlist;
	private DefaultListModel<String> model =  new DefaultListModel<String>();
	
public MemberTab(String presentID) {
	super(presentID);	

	JPanel Showpanel = new JPanel();
	Showpanel.setBounds(179, 98, 593, 453);
	Showpanel.setBackground(Color.WHITE);
	getContentPane().add(Showpanel);
	Showpanel.setLayout(null);

	
	searchfield = new JTextField();
	searchfield.setBounds(144, 0, 267, 21);
	Showpanel.add(searchfield);
	searchfield.setColumns(10);
	
	JComboBox comboBox = new JComboBox();
	comboBox.setBounds(95, 0, 49, 20);
	Showpanel.add(comboBox);
	
	JButton SrcBtn = new JButton("\uAC80\uC0C9");
	SrcBtn.setBounds(410, 0, 60, 20);
	SrcBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		
		}
	});
	SrcBtn.setFocusable(false);
	SrcBtn.setBorderPainted(false);
	Showpanel.add(SrcBtn);
	
	
	JLabel novelTab = new JLabel("인물 목록");
	novelTab.setBounds(12, 30, 569, 21);
	novelTab.setOpaque(true);
	novelTab.setBackground(new Color(102, 102, 255));
	Showpanel.add(novelTab);
	
	Mgrs mgr = new Mgrs();
	Beans bean = new Beans(); 
	
	memberlist = new JList();
	
	memberlist.setBounds(12, 51, 569, 346);
	
	
	mgr.getFAQSubJect();
	
	for (int i = 0; i < mgr.getMemberMname().size(); i++) {
		String Title = mgr.getMemberMname().get(i).getm_name();
		model.addElement(Title);
	}

	memberlist = new JList(model);
	
	memberlist.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			JList list = (JList)e.getSource();
			if(e.getClickCount()==2) {
			String presentM_name = memberlist.getSelectedValue().toString();
			
			dispose();
			MemberInfo MemberInfo = new MemberInfo(presentID,presentM_name);
			MemberInfo.setVisible(true);
			}
		}
	});
	
	memberlist.setBackground(new Color(204, 204, 255));
	
	
	
	JScrollPane sp=new JScrollPane(memberlist);
	sp.setBackground(new Color(204, 204, 255));
	sp.setBounds(12, 51, 569, 346);
	sp.setViewportView(memberlist);
	Showpanel.add(sp);

	JButton AddBtn = new JButton("태그 추가");
	AddBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			TagInsert TagInsert = new TagInsert(presentID);
			TagInsert.setVisible(true);
		}
	});
	
	JButton Add = new JButton("\uCD94\uAC00");
	Add.setBounds(358, 411, 97, 23);
	Add.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			MemberInsert MemberInsert = new MemberInsert(presentID);
			MemberInsert.setVisible(true);
		}
	});
	Showpanel.add(Add);
	

	
	
	JButton Delete = new JButton("\uC0AD\uC81C");
	Delete.setBounds(467, 411, 97, 23);
	Delete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String name = (String) memberlist.getSelectedValue();
			mgr.deleteMembers(name);
			
			DefaultListModel<String> model = (DefaultListModel<String>)memberlist.getModel();
			model.removeElementAt(memberlist.getSelectedIndex());
			
			
		}
	});
	Showpanel.add(Delete);
	
	
	
}
}
