package WebNovelGUI;

import java.io.File;

public class Test {
	public static void main(String[] args) {
	
		
	       File f = new File("./src/img/cursor.png");
	        
	        //������ ���� ����
	       System.out.println("������ ���� ���� " + f.exists());
		System.out.print(DefaultPanel.imgpath + "cursor.png");
		
	}

}
