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

	
	public FileUpload2(Novelinsert novelinsert) { //--- class 생성자
		setTitle("Web Novel 표지 이미지파일 업로드");
		setResizable(false);
		p = new JPanel();
		getContentPane().add(p, BorderLayout.CENTER);
		
		p.add(tf = new JTextField(30)); //업로드 대상 이미지 파일의 경로를 표시할 텍스트필드 생성
		
		p.add(selectFileBt = new JButton("파일 선택")); //"파일 선택"버튼 생성
		
		JLabel label = new JLabel("* 이미지는 5MB 이하의 jpg 파일만 업로드 가능합니다.      ");
		label.setForeground(new Color(0, 0, 255));
		p.add(label); //라벨생성

		p.add(uploadBt = new JButton("업로드")); //"업로드"버튼 생성
		uploadBt.setBackground(Color.LIGHT_GRAY);
		uploadBt.setVisible(false); //"업로드"버튼 감추기
		
		selectFileBt.addActionListener(new ActionListener() { //--- "파일 선택"버튼 클릭시 동작(익명클래스)
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(); //파일탐색기 생성자 호출
				FileNameExtensionFilter filter =
						new FileNameExtensionFilter("JPG only", "jpg"); //파일필터 선언
				fileChooser.setFileFilter(filter); //파일열기 다이얼로그에 파일필터 기능부여
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					tf.setText(selectedFile.getAbsolutePath());
					uploadBt.setVisible(true); //"업로드"버튼 나타내기
				}
			}
		}); //--- "파일 선택"버튼 클릭시 동작(익명클래스)

		uploadBt.addActionListener(new ActionListener() { //--- "업로드"버튼 클릭시 동작(익명클래스)
			public void actionPerformed(ActionEvent e) {
				
				showMessage("정상적으로 업로드 되었습니다.");
				novelinsert.imgField.setText(selectedFile.getAbsolutePath());
				novelinsert.imgfile = selectedFile;
				dispose(); //자신을 닫고 자신을 호출한 프레임으로 커서 리턴
				
			}
		}); //--- "업로드"버튼 클릭시 동작(익명클래스)

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
		setVisible(true);
		setBounds(500, 200, 500, 100);

	} //--- class 생성자

	
	// 메소드 : showMessage //////////////////////////////////////////////////
	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	// 메소드 : confirmMessage ///////////////////////////////////////////////
	public int confirmMessage(String msg) {
		return JOptionPane.showConfirmDialog(this, msg);
	}

	//메소드 : makeDirNduplChk ///////////////////////////////////////////////
	public int makeDirNduplChk(String basePath, String fileName){
		int cmd = 0;
		File dir = new File(basePath);
		
		if(!dir.exists()) //디렉토리가 없으면 디렉토리 생성
			dir.mkdirs();
		
		File[] file = dir.listFiles();
		for(int i=0; i<file.length; i++){ //디렉토리 안에 같은 이름의 파일이 있는지 확인
			if(file[i].getName().trim().equals(fileName)){
				cmd = -1;
			}
		}
		return cmd;
	}
	
	//메소드 : saveFile //////////////////////////////////////////////////////
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