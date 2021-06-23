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
			JOptionPane.showMessageDialog(null, "������ ä���ּ���", "����", JOptionPane.WARNING_MESSAGE);
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
		Vector<Beans> userlist = new Vector<Beans>();// ���� ���̺� ���� ����
		userlist = umgr.getListUsers();// ����Ŭ���� ���ͷ�
		List u_idlist = new List(userlist.size(), false);// ���� ���̵� ���� ����Ʈ
		for (int i = 0; i < userlist.size(); i++) {
			cbean = userlist.get(i);// Ȯ�κ� �������Ϳ� ��� ������ ����
			String u_id = cbean.getu_id().trim();// Ȯ�κ󿡼� ���̵� ����
			u_idlist.add(u_id);// ���� ���̵� ����, �ݺ�
		}
		for (int i = 0; i < userlist.size(); i++) {
			if (ID.equals(u_idlist.getItem(i))) {
				JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ���̵��Դϴ�.", "�����ϴ� ���̵�", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		return true;
	}


	boolean emailoverlap(String EMAIL) {
		Beans cbean = new Beans();
		Vector<Beans> userlist = new Vector<Beans>();// ���� ���̺� ���� ����
		userlist = umgr.getListUsers();// ����Ŭ���� ���ͷ�
		List emaillist = new List(userlist.size(), false);// ���� ���̵� ���� ����Ʈ
		for (int i = 0; i < userlist.size(); i++) {
			cbean = userlist.get(i);// ������ �������Ϳ� ��� ������ ����
			String email = cbean.getemail().trim();// �����󿡼� ���̵� ����
			emaillist.add(email);// ���� ���̵� ����, �ݺ�
		}
		for (int i = 0; i < userlist.size(); i++) {
			if (EMAIL.equals(emaillist.getItem(i))) {
				JOptionPane.showMessageDialog(null, "�̹� �����ϴ� �̸����Դϴ�.", "�����ϴ� �̸���", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		
		return true;
	}
	
	boolean pwdcheck(String pw1, String pw2) {
	// 2���� ����Է��ʵ� ���� ���Ͽ� �ٸ� ��� �˾��޽���
	if (pw1.equals(pw2) == false) {
		JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "��й�ȣ ���Է�", JOptionPane.ERROR_MESSAGE);
		return false;
	} else {return true;}
	}
}