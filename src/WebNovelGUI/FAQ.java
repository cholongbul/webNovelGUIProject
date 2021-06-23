package WebNovelGUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FAQ extends DefaultPanel {

	JLabel listLabel;
	private JList FAQList;
	private DefaultListModel<String> model = new DefaultListModel<String>();

	public FAQ(String presentID) {
		super(presentID);

		JPanel Showpanel = new JPanel();
		Showpanel.setBackground(Color.WHITE);
		Showpanel.setBounds(179, 98, 593, 453);
		getContentPane().add(Showpanel);
		Showpanel.setLayout(null);
		
		JTextArea textArea = new JTextArea("´äº¯");
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		textArea.setBounds(12, 209, 569, 234);
		Showpanel.add(textArea);

		Mgrs mgr = new Mgrs();
		Beans bean = new Beans();
		
		mgr.getFAQSubJect();
		
		for (int i = 0; i < mgr.getFAQSubJect().size(); i++) {
			String subject = mgr.getFAQSubJect().get(i).getsubject();
			model.addElement(subject);
		}


		FAQList = new JList<String>(model);
		FAQList.setBounds(203, 133, 253, 373);
		FAQList.setBounds(12, 72, 251, 371);
		FAQList.setBackground(new Color(204, 204, 255));

		FAQList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Beans AnswerBean= new Beans();
				
				int SubjectIndex = FAQList.getSelectedIndex()+1;
				
				AnswerBean = mgr.getFAQAnswer(SubjectIndex);
				
				String TAtext = AnswerBean.getanswer();
				
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				
				
				textArea.setText(TAtext);


				
				
				
				}
		});


		JScrollPane sp = new JScrollPane(FAQList);
		sp.setBackground(new Color(204, 204, 255));
		sp.setBounds(12, 10, 569, 192);
		sp.setViewportView(FAQList);
		Showpanel.add(sp);
		
		

	}
}
