package WebNovelGUI;

import java.awt.List;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Inputtobean {
	
	Beans nbean, abean, pbean, pingbean, wbean, wingbean = new Beans();
	Mgrs nmgr, amgr, pmgr, pingmgr, wmgr, wingmgr = new Mgrs();
	Formchange age = new Formchange();
	boolean flag = false;

	boolean novelnamebean(String s) {
		if (s.equals(null)) {
			JOptionPane.showMessageDialog(null, "작품 이름을 입력해주세요", "작품공백", JOptionPane.WARNING_MESSAGE);
			return flag;
		}
		Vector<Beans> nvlist = new Vector<Beans>();
		nvlist = nmgr.getListNovel();
		List nnlist = new List(nvlist.size(), false);
		for (int i = 0; i < nvlist.size(); i++) {
			nbean = nvlist.get(i);
			String an = nbean.gettitle().trim();
			nnlist.add(an);
		}
		for (int i = 0; i < nvlist.size(); i++) {
			if (s.equals(nnlist.getItem(i))) {
				JOptionPane.showMessageDialog(null, "이미 존재하는 작품입니다.", "존재하는 작품", JOptionPane.WARNING_MESSAGE);
				return flag;
			}

		}
		flag = true;
		if (flag == true) {
			nbean.settitle(s);
			return flag;
		} else {return flag;}
	}

	boolean Authornamebean(String s) {
		if (s.equals(null)) {
			JOptionPane.showMessageDialog(null, "작가 이름을 입력해주세요", "작가공백", JOptionPane.WARNING_MESSAGE);
			return flag;
		}
		Vector<Beans> avlist = new Vector<Beans>();
		avlist = amgr.getListAuthor();
		List anlist = new List(avlist.size(), false);
		for (int i = 0; i < avlist.size(); i++) {
			abean = avlist.get(i);
			String an = abean.geta_name().trim();
			anlist.add(an);
		}
		for (int i = 0; i < avlist.size(); i++) {
			if (s.equals(anlist.getItem(i))) {
				int result = JOptionPane.showConfirmDialog(null, "같은 이름의 작가가 있습니다. 새로 추가하시겠습니까?", "작가 중복",
						JOptionPane.OK_CANCEL_OPTION);
				if (result == 0) {
					break;
				} else {
					return flag;
				}
			} 

		}
		flag = true;

		if (flag == true) {
			abean.seta_name(s);
			return flag;
		} else {
			return flag;
		}

	}

	boolean webcompnamebean(String s) {
		if (s.equals(null)) {
			return flag;
		}
		Vector<Beans> wvlist = new Vector<Beans>();
		wvlist = wmgr.getListWebcompMgr();
		List wnlist = new List(wvlist.size(), false);
		for (int i = 0; i < wvlist.size(); i++) {
			wbean = wvlist.get(i);
			String wn = wbean.getw_name().trim();
			wnlist.add(wn);
		}
		for (int i = 0; i < wvlist.size(); i++) {
			if (s.equals(wnlist.getItem(i))) {
				flag = false;
				break;
			}
		}

		if (flag == true) {
			wbean.setw_name(s);
			return flag;
		} else {
			return flag;
		}

	}

	boolean pubcompnamebean(String s) {
		if (s.equals(null)) {
			return flag;
		}
		Vector<Beans> pvlist = new Vector<Beans>();
		pvlist = pmgr.getListPubcomp();
		List pnlist = new List(pvlist.size(), false);
		for (int i = 0; i < pvlist.size(); i++) {
			pbean = pvlist.get(i);
			String pn = pbean.getp_name().trim();
			pnlist.add(pn);
		}

		for (int i = 0; i < pvlist.size(); i++) {
			if (s.equals(pnlist.getItem(i))) {
				return flag;
			}
		}
		flag = true;
		if (flag == true) {
			pbean.setp_name(s);
			return flag;
		} else {
			return flag;
		}

	}

}
