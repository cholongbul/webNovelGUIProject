package WebNovelGUI;

import java.awt.List;
import java.io.BufferedReader;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Login {

	private Vector<Beans> vlist;
	private Mgrs mgr;
	private Beans bean;
	private List idlist, pwdlist;
	boolean flag = false;
	Mgrs umgr = new Mgrs();

	boolean logining(String ID, String PW) {
		
		
		mgr = new Mgrs();
		vlist = new Vector<Beans>();
		vlist = mgr.getListUsers();
		idlist = new List(vlist.size(), false);
		pwdlist = new List(vlist.size(), false);
		for (int i = 0; i < vlist.size(); i++) {
			Beans bean = vlist.get(i);
			String s = bean.getu_id().trim();
			idlist.add(s);
		}
		for (int i = 0; i < vlist.size(); i++) {
			Beans bean = vlist.get(i);
			String s = bean.getpwd().trim();
			pwdlist.add(s);
		}
		for (int i = 0; i < vlist.size(); i++) {
			if (ID.equals(idlist.getItem(i)) && PW.equals(pwdlist.getItem(i))) {
				flag = true;
 				return flag;
			}
		}
		return flag;
	}

	boolean registing(String ID, String PW, String NAME, String EMAIL, String BIRTH, String GENDER,int Icon) {
		if (ID.equals(null) || PW.equals(null) || NAME.equals(null) || EMAIL.equals(null)) {
			JOptionPane.showMessageDialog(null, "여백을 채워주세요", "여백", JOptionPane.WARNING_MESSAGE);
			return flag;
		}
		bean = new Beans();
		mgr = new Mgrs();
		Formchange f = new Formchange();
		String JOIN = f.presenttime();
		if(u_idoverlap(ID)&&emailoverlap(EMAIL)) {
		bean.setu_id(ID);
		bean.setpwd(PW);
		bean.setu_name(NAME);
		bean.setjoin(JOIN);
		bean.setemail(EMAIL);
		bean.setbirth(BIRTH);
		bean.setgender(f.gender(GENDER));
		bean.setIcon(Icon);
		if (mgr.insertUsers(bean)) {
			flag = true;
			return flag;
		}}
		return flag;
	}

	String getpwd(String ID) {
		String pwd = null;
		bean.getpwd();

		return pwd;
	}

	boolean u_idoverlap(String ID) {
		Beans cbean = new Beans();
		Vector<Beans> userlist = new Vector<Beans>();// 유저 테이블 담을 벡터
		userlist = umgr.getListUsers();// 오라클에서 백터로
		List u_idlist = new List(userlist.size(), false);// 유저 아이디 담을 리스트
		for (int i = 0; i < userlist.size(); i++) {
			cbean = userlist.get(i);// 확인빈에 유저벡터에 담긴 데이터 저장
			String u_id = cbean.getu_id().trim();// 확인빈에서 아이디만 빼냄
			u_idlist.add(u_id);// 빼낸 아이디 저장, 반복
		}
		for (int i = 0; i < userlist.size(); i++) {
			if (ID.equals(u_idlist.getItem(i))) {
				JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.", "존재하는 아이디", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		return true;
	}


	boolean emailoverlap(String EMAIL) {
		Beans cbean = new Beans();
		Vector<Beans> userlist = new Vector<Beans>();// 유저 테이블 담을 벡터
		userlist = umgr.getListUsers();// 오라클에서 백터로
		List emaillist = new List(userlist.size(), false);// 유저 아이디 담을 리스트
		for (int i = 0; i < userlist.size(); i++) {
			cbean = userlist.get(i);// 유저빈에 유저벡터에 담긴 데이터 저장
			String email = cbean.getemail().trim();// 유저빈에서 아이디만 빼냄
			emaillist.add(email);// 빼낸 아이디 저장, 반복
		}
		for (int i = 0; i < userlist.size(); i++) {
			if (EMAIL.equals(emaillist.getItem(i))) {
				JOptionPane.showMessageDialog(null, "이미 존재하는 이메일입니다.", "존재하는 이메일", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		
		return true;
	}
	
	boolean pwdcheck(String pw1, String pw2) {
	// 2개의 비번입력필드 서로 비교하여 다를 경우 팝업메시지
	if (pw1.equals(pw2) == false) {
		JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "비밀번호 재입력", JOptionPane.ERROR_MESSAGE);
		return false;
	} else {return true;}
	}
}