package WebNovelGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileUpload2 extends JFrame {
	JPanel p;
	JTextField tf;
	JButton selectFileBt;
	JLabel label;
	JButton uploadBt;
	File selectedFile;
	String basePath = "." + File.pathSeparator + "src" + File.pathSeparator + "img" + File.pathSeparator;
	private Novelinsert novelinsert;
	
	public FileUpload2() {
		
	} 

	
	public FileUpload2(Novelinsert novelinsert) { //--- class ������
		setTitle("Web Novel ǥ�� �̹������� ���ε�");
		setResizable(false);
		p = new JPanel();
		getContentPane().add(p, BorderLayout.CENTER);
		
		p.add(tf = new JTextField(30)); //���ε� ��� �̹��� ������ ��θ� ǥ���� �ؽ�Ʈ�ʵ� ����
		
		p.add(selectFileBt = new JButton("���� ����")); //"���� ����"��ư ����
		
		JLabel label = new JLabel("* �̹����� 5MB ������ jpg ���ϸ� ���ε� �����մϴ�.      ");
		label.setForeground(new Color(0, 0, 255));
		p.add(label); //�󺧻���

		p.add(uploadBt = new JButton("���ε�")); //"���ε�"��ư ����
		uploadBt.setBackground(Color.LIGHT_GRAY);
		uploadBt.setVisible(false); //"���ε�"��ư ���߱�
		
		selectFileBt.addActionListener(new ActionListener() { //--- "���� ����"��ư Ŭ���� ����(�͸�Ŭ����)
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(); //����Ž���� ������ ȣ��
				FileNameExtensionFilter filter =
						new FileNameExtensionFilter("JPG only", "jpg"); //�������� ����
				fileChooser.setFileFilter(filter); //���Ͽ��� ���̾�α׿� �������� ��ɺο�
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					tf.setText(selectedFile.getAbsolutePath());
					uploadBt.setVisible(true); //"���ε�"��ư ��Ÿ����
				}
			}
		}); //--- "���� ����"��ư Ŭ���� ����(�͸�Ŭ����)

		uploadBt.addActionListener(new ActionListener() { //--- "���ε�"��ư Ŭ���� ����(�͸�Ŭ����)
			public void actionPerformed(ActionEvent e) {
				
				showMessage("���������� ���ε� �Ǿ����ϴ�.");
				novelinsert.imgField.setText(selectedFile.getAbsolutePath());
				novelinsert.imgfile = selectedFile;
				dispose(); //�ڽ��� �ݰ� �ڽ��� ȣ���� ���������� Ŀ�� ����
				
			}
		}); //--- "���ε�"��ư Ŭ���� ����(�͸�Ŭ����)

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
		setVisible(true);
		setBounds(500, 200, 500, 100);

	} //--- class ������

	
	// �޼ҵ� : showMessage //////////////////////////////////////////////////
	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	// �޼ҵ� : confirmMessage ///////////////////////////////////////////////
	public int confirmMessage(String msg) {
		return JOptionPane.showConfirmDialog(this, msg);
	}

	//�޼ҵ� : makeDirNduplChk ///////////////////////////////////////////////
	public int makeDirNduplChk(String basePath, String fileName){
		int cmd = 0;
		File dir = new File(basePath);
		
		if(!dir.exists()) //���丮�� ������ ���丮 ����
			dir.mkdirs();
		
		File[] file = dir.listFiles();
		for(int i=0; i<file.length; i++){ //���丮 �ȿ� ���� �̸��� ������ �ִ��� Ȯ��
			if(file[i].getName().trim().equals(fileName)){
				cmd = -1;
			}
		}
		return cmd;
	}
	
	//�޼ҵ� : saveFile //////////////////////////////////////////////////////
	public String saveFile(File file, String basePath, String fileName)
			throws Exception{
		if(file == null || file.getName().equals("") || file.length() < 1)
			return null;

		String serverFullPath = basePath
							  +	System.getProperty("file.separator")
							  +	fileName;
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(serverFullPath);
		int readSize = 0;

		byte[] buf = new byte[1024*10];
		while((readSize = fis.read(buf)) != -1)
			fos.write(buf, 0, readSize);

		fos.close();
		fis.close();
		return serverFullPath;
	}

	
}