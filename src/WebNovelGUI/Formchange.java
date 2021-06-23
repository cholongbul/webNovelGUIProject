package WebNovelGUI;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

public class Formchange {

	public String presenttime() {

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

		Calendar time = Calendar.getInstance();

		String format_time1 = format1.format(time.getTime());

		return format_time1;
	}


	public int gender(String gENDER) {
		
		if(gENDER.equals("남")) {
			int a = 0;
			return a;
		} else if(gENDER.equals("여")) {int a=1;
		return a;
		} else { int a= 2;
		return a;
		}
	
	}
	
	public String gender(int gENDER) {
		
		if(gENDER == 0) {
			String a = "남";
			return a;
		} else if(gENDER == 1) {String a = "여";
		return a;
		} else {String a = "^무^";
		return a;
		}
		
	}

	public int agetonum(String g) {
		
		if(g.equals("19세이용불가")) {
			int a = 3;
			return a;
		} else 	if(g.equals("15세이용불가")) {
			int a = 2;
			return a;
	} else if (g.equals("12세이용불가")) {
		int a = 1;
		return a;
	}else {
			int a = 0;
			return a;
	}
		
}
	public String itemtodate(Object YY, Object MM, Object DD) {
	String date = YY + "-" + MM + "-" + DD;
	return date;
	}
	
	public String dateToYMD(String date, String YMD) {
		String[] YYMMDD = date.split("-", 9);
		String s = null;
		if(YMD.equals("Y")) {s = YYMMDD[0];}
		else if (YMD.equals("M")) {s = YYMMDD[1];}
		else if (YMD.equals("D")) {s=YYMMDD[2].substring(0,2);
		}
		return s;

	}
	public String inttoagelimit(int agelimit) {
		if(agelimit == 0) {String s = "전체이용가"; 
		return s;}
		else if(agelimit == 1) {String s = "12세이용가"; 
			return s;}
		else	if(agelimit == 2) {String s = "15세이용가"; 
				return s;}
		else{String s = "19세미만 구독불가"; 
					return s;}
	}
	public boolean authorcheck(String a_name) {
		Mgrs mgr = new Mgrs();
		Vector<Beans> vlist = new Vector<Beans>();
		vlist = mgr.getSearchListAuthor(a_name);
		if(vlist.size()!=0) {return false;} else {
	
		return true;
		}
	}

	public String inttoendding(int ending) {
		if(ending==0) {String s = "연재중";
		return s;}
		else {String s = "완결";
		return s;}
	}
}
