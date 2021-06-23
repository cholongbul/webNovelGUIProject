package WebNovelGUI;

import java.io.File;

public class Test {
	public static void main(String[] args) {
	
		
	       File f = new File("./src/img/cursor.png");
	        
	        //파일의 존재 여부
	       System.out.println("파일의 존재 여부 " + f.exists());
		System.out.print(DefaultPanel.imgpath + "cursor.png");
		
	}

}
