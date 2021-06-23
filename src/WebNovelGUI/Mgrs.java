package WebNovelGUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Mgrs {

	// DB���� ��ü 10�� ����� ����.
		private DBConnectionMgr pool;

		public Mgrs() {
			pool = DBConnectionMgr.getInstance();
		}

		// ����Ʈ
		// ���׸�: vector�� ����Ǵ� Ÿ���� MemberBen����
		public Vector<Beans> getListAuthor() {
			// DB���� ����
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Vector<Beans> vlist = new Vector<Beans>();
			try {
				// pool��ü���� ������
				con = pool.getConnection();
				sql = "select * from Author order by a_id";
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();// DB ���� �� ����� ����
				while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
					Beans bean = new Beans();
					int a_id = rs.getInt("a_id");// Į����
					String a_name = rs.getString("a_name");
					String as_name = rs.getString("as_name");
					String r_name = rs.getString("r_name");
					String a_history = rs.getString("a_history");
					int gender = rs.getInt("gender");
					String birth = rs.getString("birth");
					bean.seta_id(a_id);
					bean.seta_name(a_name);
					bean.setas_name(as_name);
					bean.setr_name(r_name);
					bean.setgender(gender);
					bean.setbirth(birth);
					bean.seta_history(a_history);
					// ���ڵ带 �����Ų ��� Vector�� ����
					vlist.addElement(bean);
				} // --while
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// con�� �ݳ�, pstmt�� rs�� close
				pool.freeConnection(con, pstmt, rs);
			}
			return vlist;

		}
		
		// ���ڵ� �� �� ��������
		public Beans getAuthor(int a_id) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Beans bean = new Beans();
			try {
				con = pool.getConnection();
				sql = "select * from Author where =?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, a_id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bean.seta_id(rs.getInt(1));//���̺� ��Ű�� �ε���
					bean.seta_name(rs.getString(2));
					bean.setas_name(rs.getString(3));
					bean.setr_name(rs.getString(4));
					bean.setgender(rs.getInt(5));
					bean.setbirth(rs.getString(6));
					bean.seta_history(rs.getString(7));

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;

		}

		// �Է�
		public boolean insertAuthor(Beans bean) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "insert into Author(a_id,a_name,as_name,r_name,gender,birth,a_history)" + " values(SEQ_AUTHOR_a_id.nextval,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.geta_name());
				pstmt.setString(2, bean.getas_name());
				pstmt.setString(3, bean.getr_name());
				pstmt.setInt(4, bean.getgender());
				pstmt.setString(5, bean.getbirth());
				pstmt.setString(6, bean.geta_history());
				int cnt = pstmt.executeUpdate();// insert, update, delete\
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		// ����
		public boolean updateAuthor(Beans bean) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "update Author set a_name=?, as_name=?, r_name=? birth=?" + "where a_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.geta_name());
				pstmt.setString(2, bean.getas_name());
				pstmt.setString(3, bean.getr_name());
				pstmt.setString(4, bean.getbirth());
				pstmt.setInt(5, bean.geta_id());
				int cnt = pstmt.executeUpdate();// insert, update, delete\
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		// ����
		public boolean deleteAuthor(int a_id) {
			Connection con = null;//DB���� ��ü
			PreparedStatement pstmt = null;//sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "delete from Author where a_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, a_id);
				int cnt = pstmt.executeUpdate();//insert, update, delete
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return false;
		}
		// ����Ʈ
		// ���׸�: vector�� ����Ǵ� Ÿ���� MemberBen����
		public Vector<Beans> getListFAQ() {
			// DB���� ����
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Vector<Beans> vlist = new Vector<Beans>();
			try {
				// pool��ü���� ������
				con = pool.getConnection();
				sql = "select * from FAQ order by faq_id";
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();// DB ���� �� ����� ����
				while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
					Beans bean = new Beans();
					int faq_id = rs.getInt("faq_id");// Į����
					String subject = rs.getString("subject");
					String answer = rs.getString("answer");
					bean.setfaq_id(faq_id);
					bean.setsubject(subject);
					bean.setanswer(answer);
					// ���ڵ带 �����Ų ��� Vector�� ����
					vlist.addElement(bean);
				} // --while
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// con�� �ݳ�, pstmt�� rs�� close
				pool.freeConnection(con, pstmt, rs);
			}
			return vlist;

		}

		// ���ڵ� �� �� ��������
		public Beans getFAQ(int faq_id) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Beans bean = new Beans();
			try {
				con = pool.getConnection();
				sql = "select * from FAQ where faq_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, faq_id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bean.setfaq_id(rs.getInt(1));//���̺� ��Ű�� �ε���
					bean.setsubject(rs.getString(2));
					bean.setanswer(rs.getString(3));

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;

		}
		
		// ���ڵ� ���� �� ��������
		public Vector<Beans> getFAQSubJect() {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Vector<Beans> vlist = new Vector<Beans>();
			try {
				con = pool.getConnection();
				sql = "select SUBJECT from FAQ order by FAQ_id";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Beans bean = new Beans();
					
					String subject = rs.getString("subject");
				
					bean.setsubject(subject);
					
					vlist.addElement(bean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return vlist;
			
		}
		

		// ���ڵ� �� �� ��������
		public Beans getFAQAnswer(int faq_id) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Beans bean = new Beans();
			try {
				con = pool.getConnection();
				sql = "select answer from FAQ where FAQ_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, faq_id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					String Answer = rs.getString(1);
					
					bean.setanswer(Answer);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;

		}

		// �Է�
		public boolean insertFAQ(Beans bean) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "insert into FAQ(faq_id,subject,answer,)" + " values(SEQ_FAQ_faq_id.nextval,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getsubject());
				pstmt.setString(2, bean.getanswer());
				int cnt = pstmt.executeUpdate();// insert, update, delete\
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		// ����
		public boolean updateFAQ(Beans bean) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "update FAQ set subject=?, answer=?" + "where faq_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getsubject());
				pstmt.setString(2, bean.getanswer());
				pstmt.setInt(3, bean.getfaq_id());
				int cnt = pstmt.executeUpdate();// insert, update, delete\
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		// ����
		public boolean deleteFAQ(int faq_id) {
			Connection con = null;//DB���� ��ü
			PreparedStatement pstmt = null;//sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "delete from FAQ where faq_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, faq_id);
				int cnt = pstmt.executeUpdate();//insert, update, delete
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return false;
		}
		
		// ����Ʈ
		// ���׸�: vector�� ����Ǵ� Ÿ���� MemberBen����
		public Vector<Beans> getListMembers() {
			// DB���� ����
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Vector<Beans> vlist = new Vector<Beans>();
			try {
				// pool��ü���� ������
				con = pool.getConnection();
				sql = "select * from Members order by m_id";
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();// DB ���� �� ����� ����
				while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
					Beans bean = new Beans();
					int m_id = rs.getInt("m_id");// Į����
					String m_name = rs.getString("m_name");
					int age = rs.getInt("age");
					String profil = rs.getString("profil");
					int gender = rs.getInt("gender");
					int n_id = rs.getInt("n_id");
					bean.setm_id(m_id);
					bean.setm_name(m_name);
					bean.setage(age);
					bean.setprofil(profil);
					bean.setgender(gender);
					bean.setn_id(n_id);
					// ���ڵ带 �����Ų ��� Vector�� ����
					vlist.addElement(bean);
				} // --while
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// con�� �ݳ�, pstmt�� rs�� close
				pool.freeConnection(con, pstmt, rs);
			}
			return vlist;

		}

		// �Է�
		public boolean insertMembers(Beans bean) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "insert into Members(m_id,m_name,gender,age,profil,n_id)" + " values(SEQ_MEMBERS_m_id.nextval,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getm_name());
				pstmt.setInt(2, bean.getgender());
				pstmt.setInt(3, bean.getage());
				pstmt.setString(4, bean.getprofil());
				pstmt.setInt(5, bean.getn_id());
				
				int cnt = pstmt.executeUpdate();
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		// ����
		public boolean updateMembers(Beans bean) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "update Members set m_name=?, age=?, profil=?, n_id=?" + "where m_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getm_name());
				pstmt.setInt(2, bean.getage());
				pstmt.setString(3, bean.getprofil());
				pstmt.setInt(4, bean.getn_id());
				pstmt.setInt(5, bean.getm_id());
				int cnt = pstmt.executeUpdate();// insert, update, delete\
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		// ����
		public boolean deleteMembers(int m_id) {
			Connection con = null;//DB���� ��ü
			PreparedStatement pstmt = null;//sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "delete from Members where m_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, m_id);
				int cnt = pstmt.executeUpdate();//insert, update, delete
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return false;
		}
		// ����
		public boolean deleteMembers(String m_name) {
			Connection con = null;//DB���� ��ü
			PreparedStatement pstmt = null;//sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "delete from Members where m_name = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m_name);
				int cnt = pstmt.executeUpdate();//insert, update, delete
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return false;
		}
		
		// ����Ʈ
		// ���׸�: vector�� ����Ǵ� Ÿ���� MemberBen����
		public Vector<Beans> getListMembertag() {
			// DB���� ����
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Vector<Beans> vlist = new Vector<Beans>();
			try {
				// pool��ü���� ������
				con = pool.getConnection();
				sql = "select * from Membertag order by mtag_id";
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();// DB ���� �� ����� ����
				while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
					Beans bean = new Beans();
					int mtag_id = rs.getInt("mtag_id");// Į����
					String mtag_name = rs.getString("mtag_name");
					String description = rs.getString("description");
					
					bean.setmtag_id(mtag_id);
					bean.setmtag_name(mtag_name);
					bean.setdescription(description);
				
					// ���ڵ带 �����Ų ��� Vector�� ����
					vlist.addElement(bean);
				} // --while
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// con�� �ݳ�, pstmt�� rs�� close
				pool.freeConnection(con, pstmt, rs);
			}
			return vlist;

		}
		

		//��� ���̵�� ��� ���ڵ� �� �� ��������
		public Beans getMembers(int m_id) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Beans bean = new Beans();
			try {
				con = pool.getConnection();
				sql = "select * from Members where =?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, m_id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bean.setm_id(rs.getInt(1));//���̺� ��Ű�� �ε���
					bean.setm_name(rs.getString(2));
					bean.setage(rs.getInt(3));
					bean.setprofil(rs.getString(4));
					bean.setgender(rs.getInt(5));
					bean.setn_id(rs.getInt(6));

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;

		}
		


		// ���ڵ� �� �� ��������
		public Beans getMembertag(int mtag_id) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Beans bean = new Beans();
			try {
				con = pool.getConnection();
				sql = "select * from Membertag where =?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, mtag_id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bean.setmtag_id(rs.getInt(1));//���̺� ��Ű�� �ε���
					bean.setmtag_name(rs.getString(2));
					bean.setdescription(rs.getString(3));

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;

		}

		// �Է�
		public boolean insertMembertag(Beans bean) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "insert into Membertag(mtag_id,mtag_name,description)" + " values(SEQ_MEMBER_TAG_mtag_id.nextval,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(2, bean.getmtag_name());
				pstmt.setString(3, bean.getdescription());

				int cnt = pstmt.executeUpdate();// insert, update, delete\
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		// ����
		public boolean updateMembertag(Beans bean) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "update Membertag set mtag_name=?, description=?" + "where mtag_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getmtag_name());
				pstmt.setString(2, bean.getdescription());
				pstmt.setInt(3, bean.getmtag_id());
				int cnt = pstmt.executeUpdate();// insert, update, delete\
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		// ����
		public boolean deleteMembertag(int mtag_id) {
			Connection con = null;//DB���� ��ü
			PreparedStatement pstmt = null;//sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "delete from Membertag where mtag_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, mtag_id);
				int cnt = pstmt.executeUpdate();//insert, update, delete
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return false;
		}
		
		// ����Ʈ
		// ���׸�: vector�� ����Ǵ� Ÿ���� MemberBen����
		public Vector<Beans> getListNovel() {
			// DB���� ����
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Vector<Beans> vlist = new Vector<Beans>();
			try {
				// pool��ü���� ������
				con = pool.getConnection();
				sql = "select * from NOVEL order by n_id";
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();// DB ���� �� ����� ����
				while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
					Beans bean = new Beans();
					int n_id = rs.getInt("n_id");// Į����
					String title = rs.getString("title");
					int agelimit = rs.getInt("agelimit");
					int mediamix = rs.getInt("mediamix");
					String storyline = rs.getString("storyline");
					String n_history = rs.getString("n_history");
					String n_image = rs.getString("n_image");
					bean.setn_id(n_id);
					bean.settitle(title);
					bean.setagelimit(agelimit);
					bean.setmediamix(mediamix);
					bean.setstoryline(storyline);
					bean.setn_history(n_history);
					bean.setn_image(n_image);
					// ���ڵ带 �����Ų ��� Vector�� ����
					vlist.addElement(bean);
				} // --while
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// con�� �ݳ�, pstmt�� rs�� close
				pool.freeConnection(con, pstmt, rs);
			}
			return vlist;

		}
		
		// ���ڵ� �� �� ��������
		public Beans getNovel(int n_id) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Beans bean = new Beans();
			try {
				con = pool.getConnection();
				sql = "select * from NOVEL  where n_id =?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, n_id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bean.setn_id(rs.getInt(1));//���̺� ��Ű�� �ε���
					bean.settitle(rs.getString(2));
					bean.setagelimit(rs.getInt(3));
					bean.setstoryline(rs.getString(4));
					bean.setn_history(rs.getString(5));
					bean.setn_image(rs.getString(6));
					bean.setending(rs.getInt(7));

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;

		}
		// ���ڵ� �� �� ��������
		public Beans getMembers(String m_name) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Beans bean = new Beans();
			try {
				con = pool.getConnection();
				sql = "select * from Members where m_name =?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, m_name);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bean.setm_id(rs.getInt(1));//���̺� ��Ű�� �ε���
					bean.setm_name(rs.getString(2));
					bean.setgender(rs.getInt(3));
					bean.setage(rs.getInt(4));
					bean.setprofil(rs.getString(5));
					bean.setn_id(rs.getInt(6));
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;
			
		}
		// Ÿ��Ʋ�� �뺧
		public Beans getNovel(String title) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Beans bean = new Beans();
			try {
				con = pool.getConnection();
				sql = "select * from NOVEL where title= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, title);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bean.setn_id(rs.getInt(1));
					bean.settitle(rs.getString(2));
					bean.setagelimit(rs.getInt(3));
					bean.setstoryline(rs.getString(4));
					bean.setn_history(rs.getString(5));
					bean.setn_image(rs.getString(6));
					bean.setending(rs.getInt(7));
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;
			
		}
// ���� novel title
public Vector<Beans> getNoveltitle() {
	Connection con = null;// DB���� ��ü
	PreparedStatement pstmt = null;// sql�� ����� ��ü
	ResultSet rs = null; // select�� ���� ����� ���� ��ü
	String sql = null;
	Vector<Beans> vlist = new Vector<Beans>();
	try {
		con = pool.getConnection();
		sql = "select title from NOVEL order by n_id";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Beans bean = new Beans();
			String Title = rs.getString("title");
		
			bean.setm_name(Title);
			vlist.addElement(bean);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt, rs);
	}
	return vlist;
	
}
// ���� member m name
public Vector<Beans> getMemberMname() {
	Connection con = null;// DB���� ��ü
	PreparedStatement pstmt = null;// sql�� ����� ��ü
	ResultSet rs = null; // select�� ���� ����� ���� ��ü
	String sql = null;
	Vector<Beans> vlist = new Vector<Beans>();
	try {
		con = pool.getConnection();
		sql = "select M_name from MEMBERS order by M_id";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Beans bean = new Beans();
			String M_name = rs.getString("m_name");
		
			bean.setm_name(M_name);
			vlist.addElement(bean);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pool.freeConnection(con, pstmt, rs);
	}
	return vlist;
	
}

		// �Է�
		public boolean insertNovel(Beans bean) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "insert into NOVEL(n_id,title,agelimit,storyline,n_history,n_image,ending)" + " values(SEQ_NOVEL_n_id.nextval,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.gettitle());
				pstmt.setInt(2, bean.getagelimit());
				pstmt.setString(3, bean.getstoryline());
				pstmt.setString(4, bean.getn_history());
				pstmt.setString(5, bean.getn_image());
				pstmt.setInt(6, bean.getending());
				int cnt = pstmt.executeUpdate();// insert, update, delete\
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		// ����
		public boolean updateNovel(Beans bean) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "update NOVEL set title=?, agelimit=?, storyline=?, n_history=?, n_image=?, ending=?" + "where n_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.gettitle());
				pstmt.setInt(2, bean.getagelimit());
				pstmt.setString(3, bean.getstoryline());
				pstmt.setString(4, bean.getn_history());
				pstmt.setString(5, bean.getn_image());
				pstmt.setInt(6, bean.getending());
				pstmt.setInt(7, bean.getn_id());
				int cnt = pstmt.executeUpdate();// insert, update, delete\
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		// ����
		public boolean deleteNovel(int n_id) {
			Connection con = null;//DB���� ��ü
			PreparedStatement pstmt = null;//sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "delete from NOVEL where n_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, n_id);
				int cnt = pstmt.executeUpdate();//insert, update, delete
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return false;
		}

		// ����Ʈ
		// ���׸�: vector�� ����Ǵ� Ÿ���� MemberBen����
		public Vector<Beans> getListNoveltag() {
			// DB���� ����
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Vector<Beans> vlist = new Vector<Beans>();
			try {
				// pool��ü���� ������
				con = pool.getConnection();
				sql = "select * from Noveltag order by ntag_id";
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();// DB ���� �� ����� ����
				while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
					Beans bean = new Beans();
					int ntag_id = rs.getInt("ntag_id");// Į����
					String ntag_name = rs.getString("ntag_name");
					String remark = rs.getString("remark");
					
					bean.setntag_id(ntag_id);
					bean.setntag_name(ntag_name);
					bean.setremark(remark);
				
					// ���ڵ带 �����Ų ��� Vector�� ����
					vlist.addElement(bean);
				} // --while
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// con�� �ݳ�, pstmt�� rs�� close
				pool.freeConnection(con, pstmt, rs);
			}
			return vlist;

		}

		// ���ڵ� �� �� ��������
		public Beans getNoveltag(int ntag_id) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			ResultSet rs = null; // select�� ���� ����� ���� ��ü
			String sql = null;
			Beans bean = new Beans();
			try {
				con = pool.getConnection();
				sql = "select * from Noveltag where ntag_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ntag_id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					bean.setntag_id(rs.getInt(1));//���̺� ��Ű�� �ε���
					bean.setntag_name(rs.getString(2));
					bean.setremark(rs.getString(3));

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;

		}

		// �Է�
		public boolean insertNoveltag(Beans bean) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "insert into Noveltag(ntag_id,ntag_name,remark)" + " values(SEQ_NOVELTAG_ntag_id.nextval,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getntag_name());
				pstmt.setString(2, bean.getremark());

				int cnt = pstmt.executeUpdate();// insert, update, delete\
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		// ����
		public boolean updateNoveltag(Beans bean) {
			Connection con = null;// DB���� ��ü
			PreparedStatement pstmt = null;// sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "update Noveltag set ntag_name=?, remark=?" + "where ntag_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getntag_name());
				pstmt.setString(2, bean.getremark());
				pstmt.setInt(3, bean.getntag_id());
				int cnt = pstmt.executeUpdate();// insert, update, delete\
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return flag;
		}
		// ����
		public boolean deleteNoveltag(int ntag_id) {
			Connection con = null;//DB���� ��ü
			PreparedStatement pstmt = null;//sql�� ����� ��ü
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				sql = "delete from Noveltag where ntag_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ntag_id);
				int cnt = pstmt.executeUpdate();//insert, update, delete
				if(cnt==1) flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
			return false;
		}
		
			// ����Ʈ
			// ���׸�: vector�� ����Ǵ� Ÿ���� MemberBen����
			public Vector<Beans> getListPubcomp() {
				// DB���� ����
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Vector<Beans> vlist = new Vector<Beans>();
				try {
					// pool��ü���� ������
					con = pool.getConnection();
					sql = "select * from Pubcomp order by p_id";
					pstmt = con.prepareStatement(sql);

					rs = pstmt.executeQuery();// DB ���� �� ����� ����
					while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
						Beans bean = new Beans();
						int p_id = rs.getInt("p_id");// Į����
						String p_name = rs.getString("p_name");
						String url = rs.getString("url");
					
						bean.setp_id(p_id);
						bean.setp_name(p_name);
						bean.seturl(url);
						// ���ڵ带 �����Ų ��� Vector�� ����
						vlist.addElement(bean);
					} // --while
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// con�� �ݳ�, pstmt�� rs�� close
					pool.freeConnection(con, pstmt, rs);
				}
				return vlist;

			}

			// ���ڵ� �� �� ��������
			public Beans getPubcomp(int p_id) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Beans bean = new Beans();
				try {
					con = pool.getConnection();
					sql = "select * from Pubcomp where =?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, p_id);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						bean.setp_id(rs.getInt(1));//���̺� ��Ű�� �ε���
						bean.setp_name(rs.getString(2));
						bean.seturl(rs.getString(3));
					
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return bean;

			}

			// �Է�
			public boolean insertPubcomp(Beans bean) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				String sql = null;
				boolean flag = false;
				try {
					con = pool.getConnection();
					sql = "insert into Pubcomp(p_id,p_name,url)" + " values(SEQ_PUB_COMP_p_id.nextval,?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bean.getp_name());
					pstmt.setString(2, bean.geturl());
					int cnt = pstmt.executeUpdate();// insert, update, delete\
					if(cnt==1) flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return flag;
			}
			// ����
			public boolean updatePubcomp(Beans bean) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				String sql = null;
				boolean flag = false;
				try {
					con = pool.getConnection();
					sql = "update Pubcomp set p_name=?, url=?" + "where p_id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bean.getp_name());
					pstmt.setString(2, bean.geturl());
					pstmt.setInt(3, bean.getp_id());
					int cnt = pstmt.executeUpdate();// insert, update, delete\
					if(cnt==1) flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return flag;
			}
			// ����
			public boolean deletePubcomp(int p_id) {
				Connection con = null;//DB���� ��ü
				PreparedStatement pstmt = null;//sql�� ����� ��ü
				String sql = null;
				boolean flag = false;
				try {
					con = pool.getConnection();
					sql = "delete from Pubcomp where p_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, p_id);
					int cnt = pstmt.executeUpdate();//insert, update, delete
					if(cnt==1) flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return false;
			}
			
			// ����Ʈ
			// ���׸�: vector�� ����Ǵ� Ÿ���� MemberBen����
			public Vector<Beans> getListUsers() {
				// DB���� ����
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Vector<Beans> vlist = new Vector<Beans>();
				try {
					// pool��ü���� ������
					con = pool.getConnection();
					sql = "select * from Users order by u_id";
					pstmt = con.prepareStatement(sql);

					rs = pstmt.executeQuery();// DB ���� �� ����� ����
					while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
						Beans bean = new Beans();
						String u_id = rs.getString("u_id");// Į����
						String pwd = rs.getString("pwd");
						String u_name = rs.getString("u_name");
						String join = rs.getString("join");
						String email = rs.getString("email");
						int gender = rs.getInt("gender");
						String birth = rs.getString("birth");
						bean.setu_id(u_id);
						bean.setpwd(pwd);
						bean.setu_name(u_name);
						bean.setjoin(join);
						bean.setemail(email);
						bean.setbirth(birth);
						bean.setgender(gender);
						// ���ڵ带 �����Ų ��� Vector�� ����
						vlist.addElement(bean);
					} // --while
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// con�� �ݳ�, pstmt�� rs�� close
					pool.freeConnection(con, pstmt, rs);
				}
				return vlist;

			}

			// ���ڵ� �� �� ��������
			public Beans getUsers(String u_id) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Beans bean = new Beans();
				try {
					con = pool.getConnection();
					sql = "select * from USERS where u_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, u_id);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						bean.setu_id(rs.getString(1));//���̺� ��Ű�� �ε���
						bean.setpwd(rs.getString(2));
						bean.setu_name(rs.getString(3));
						bean.setemail(rs.getString(4));
						bean.setgender(rs.getInt(5));
						bean.setbirth(rs.getString(6));
						bean.setjoin(rs.getString(7));
						bean.setIcon(rs.getInt(8));

					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return bean;

			}

			// �Է�
			public boolean insertUsers(Beans bean) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				String sql = null;
				boolean flag = false;
				try {
					con = pool.getConnection();
					sql = "insert into USERS(u_id,pwd,u_name,email,gender,birth,join,icon)" + " values(?,?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bean.getu_id());
					pstmt.setString(2, bean.getpwd());
					pstmt.setString(3, bean.getu_name());
					pstmt.setString(4, bean.getemail());
					pstmt.setInt(5, bean.getgender());
					pstmt.setString(6, bean.getbirth());
					pstmt.setString(7, bean.getjoin());
					pstmt.setInt(8, bean.getIcon());

					int cnt = pstmt.executeUpdate();// insert, update, delete\
					if(cnt==1) flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return flag;
			}
			// ����
			public boolean updateUsers(Beans bean) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				String sql = null;
				boolean flag = false;
				try {
					con = pool.getConnection();
					sql = "update USERS set pwd=?, email=?,Icon=?" + "where u_id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bean.getpwd());
					pstmt.setString(2, bean.getemail());
					pstmt.setInt(3, bean.getIcon());
					pstmt.setString(4, bean.getu_id());
					int cnt = pstmt.executeUpdate();// insert, update, delete\
					if(cnt==1) flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return flag;
			}
			// ����
			public boolean deleteUsers(String u_id) {
				Connection con = null;//DB���� ��ü
				PreparedStatement pstmt = null;//sql�� ����� ��ü
				String sql = null;
				boolean flag = false;
				try {
					con = pool.getConnection();
					sql = "delete from USERS where u_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, u_id);
					int cnt = pstmt.executeUpdate();//insert, update, delete
					if(cnt==1) flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return false;
			}
			
			// ����Ʈ
			// ���׸�: vector�� ����Ǵ� Ÿ���� MemberBen����
			public Vector<Beans> getListWebcompMgr() {
				// DB���� ����
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Vector<Beans> vlist = new Vector<Beans>();
				try {
					// pool��ü���� ������
					con = pool.getConnection();
					sql = "select * from Webcomp order by w_name";
					pstmt = con.prepareStatement(sql);

					rs = pstmt.executeQuery();// DB ���� �� ����� ����
					while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
						Beans bean = new Beans();
						int w_id = rs.getInt("w_id");// Į����
						String w_name = rs.getString("w_name");
						String url = rs.getString("url");
					
						bean.setw_id(w_id);
						bean.setw_name(w_name);
						bean.seturl(url);
						// ���ڵ带 �����Ų ��� Vector�� ����
						vlist.addElement(bean);
					} // --while
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// con�� �ݳ�, pstmt�� rs�� close
					pool.freeConnection(con, pstmt, rs);
				}
				return vlist;

			}

			// ���ڵ� �� �� ��������
			public Beans getWebcompMgr(int w_id) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Beans bean = new Beans();
				try {
					con = pool.getConnection();
					sql = "select * from Webcomp where =?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, w_id);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						bean.setw_id(rs.getInt(1));//���̺� ��Ű�� �ε���
						bean.setw_name(rs.getString(2));
						bean.seturl(rs.getString(3));
					
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return bean;

			}

			// �Է�
			public boolean insertWebcompMgr(Beans bean) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				String sql = null;
				boolean flag = false;
				try {
					con = pool.getConnection();
					sql = "insert into Webcomp(w_id,w_name,url)" + " values(SEQ_WEB_COMP_w_id.nextval,?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bean.getw_name());
					pstmt.setString(2, bean.geturl());
					int cnt = pstmt.executeUpdate();// insert, update, delete\
					if(cnt==1) flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return flag;
			}
			// ����
			public boolean updateWebcompMgr(Beans bean) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				String sql = null;
				boolean flag = false;
				try {
					con = pool.getConnection();
					sql = "update Webcomp set w_name=?, url=?" + "where w_id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, bean.getw_name());
					pstmt.setString(2, bean.geturl());
					pstmt.setInt(3, bean.getw_id());
					int cnt = pstmt.executeUpdate();// insert, update, delete\
					if(cnt==1) flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return flag;
			}
			// ����
			public boolean deleteWebcompMgr(int w_id) {
				Connection con = null;//DB���� ��ü
				PreparedStatement pstmt = null;//sql�� ����� ��ü
				String sql = null;
				boolean flag = false;
				try {
					con = pool.getConnection();
					sql = "delete from Webcomp where w_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, w_id);
					int cnt = pstmt.executeUpdate();//insert, update, delete
					if(cnt==1) flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return false;
			}
			
			//��ǰ���� �Է��ϸ� n_id ã�� �޼ҵ�
			public int getn_id(String title) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				int n_id = 0;
				try {
					con = pool.getConnection();
					sql = "select n_id from NOVEL where title = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, title);
					rs = pstmt.executeQuery();
					if(rs.next()) {
					n_id = rs.getInt("n_id");}
				
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return n_id;

			}
			//�۰� �̸��� �Է��ϸ� �۰� ID�� ã�� �޼ҵ�
			public int geta_id(String a_name) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				int a_id = 0;
				try {
					con = pool.getConnection();
					sql = "select a_id from Author where a_name = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, a_name);
					rs = pstmt.executeQuery();
					if(rs.next()) {
					a_id = rs.getInt("a_id");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return a_id;

			}
			//����ó �̸��� �Է��ϸ� ����ó ID�� ã�� �޼ҵ�
			public int getw_id(String w_name) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				int w_id = 0;
				try {
					con = pool.getConnection();
					sql = "select w_id from Webcomp where w_name = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, w_name);
					rs = pstmt.executeQuery();
					if(rs.next()) {
					w_id = rs.getInt("w_id");}
				
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return w_id;

			}
			//���ǻ� �̸��� �Է��ϸ� ���ǻ� ID�� ã�� �޼ҵ�
			public int getp_id(String p_name) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				int p_id = 0;
				try {
					con = pool.getConnection();
					sql = "select p_id from Pubcomp where p_name = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, p_name);
					rs = pstmt.executeQuery();
					if(rs.next()) {
					p_id = rs.getInt("p_id");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return p_id;

			}
			
			//���� ���̺� �߰�
			public boolean insertWebPosting(Beans bean) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				String sql = null;
				boolean flag = false;
				try {
					con = pool.getConnection();
					sql = "insert into WebPosting(n_id,w_id,started,ended,serial)" + 
					" values(?,?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, bean.getn_id());
					pstmt.setInt(2, bean.getw_id());
					pstmt.setString(3, bean.getstarted());
					pstmt.setString(4, bean.getended());
					pstmt.setInt(5, bean.getserial());
					
					int cnt = pstmt.executeUpdate();// insert, update, delete\
					if(cnt==1) flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return flag;
			}
			//�������̺� �߰�
			public boolean insertPUBLISHING(Beans bean) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				String sql = null;
				boolean flag = false;
				try {
					con = pool.getConnection();
					sql = "insert into PUBLISHING(p_id,n_id)" + 
					" values(?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, bean.getp_id());
					pstmt.setInt(2, bean.getn_id());
				
			
					
					int cnt = pstmt.executeUpdate();// insert, update, delete\
					if(cnt==1) flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return flag;
			}
			//�뺧 �±� �̸� �Է��ϸ� �뺧�±� ���̵� ����
			public int getntag_id(String ntag_name) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				int ntag_id = 0;
				try {
					con = pool.getConnection();
					sql = "select ntag_id from noveltag where ntag_name = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, ntag_name);
					rs = pstmt.executeQuery();
					if(rs.next()) {
					ntag_id = rs.getInt("ntag_id");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return ntag_id;

			}
			// �Է�
			public boolean insertn_tag_order(Beans bean) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				String sql = null;
				boolean flag = false;
				try {
					con = pool.getConnection();
					sql = "insert into n_tag_order(n_subtag_id,n_supertag_id)" + " values(?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, bean.getn_subtag());
					pstmt.setInt(2, bean.getn_supertag());
					int cnt = pstmt.executeUpdate();// insert, update, delete\
					if(cnt==1) flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt);
				}
				return flag;
			}
			
			public Vector<Beans> getbigNoveltag() {
				// DB���� ����
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Vector<Beans> vlist = new Vector<Beans>();
				try {
					// pool��ü���� ������
					con = pool.getConnection();
					sql = "select * from noveltag nt join n_tag_order nto on nt.ntag_id = nto.n_subtag_id where nto.n_supertag_id in (Select ntag_ID from noveltag nt where not exists ( select 1 from n_tag_order nto where nto.n_subtag_id = nt.ntag_id))";
					pstmt = con.prepareStatement(sql);

					rs = pstmt.executeQuery();// DB ���� �� ����� ����
					while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
						Beans bean = new Beans();
						int ntag_id = rs.getInt("ntag_id");// Į����
						String ntag_name = rs.getString("ntag_name");
						String remark = rs.getString("remark");
						
						bean.setntag_id(ntag_id);
						bean.setntag_name(ntag_name);
						bean.setremark(remark);
					
						// ���ڵ带 �����Ų ��� Vector�� ����
						vlist.addElement(bean);
					} // --while
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// con�� �ݳ�, pstmt�� rs�� close
					pool.freeConnection(con, pstmt, rs);
				}
				return vlist;

			}
			
			public Vector<Beans> getsmallNoveltag(int parents) {
				// DB���� ����
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Vector<Beans> vlist = new Vector<Beans>();
				try {
					// pool��ü���� ������
					con = pool.getConnection();
					sql = "select * from noveltag nt join n_tag_order nto on nt.ntag_id = nto.n_subtag_id where nto.n_supertag_id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, parents);
					
					rs = pstmt.executeQuery();// DB ���� �� ����� ����
					while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
						Beans bean = new Beans();
						int ntag_id = rs.getInt("ntag_id");// Į����
						String ntag_name = rs.getString("ntag_name");
						String remark = rs.getString("remark");
						
						bean.setntag_id(ntag_id);
						bean.setntag_name(ntag_name);
						bean.setremark(remark);
					
						// ���ڵ带 �����Ų ��� Vector�� ����
						vlist.addElement(bean);
					} // --while
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// con�� �ݳ�, pstmt�� rs�� close
					pool.freeConnection(con, pstmt, rs);
				}
				return vlist;

			}
			//�Ҽ� �Խù� ����1
			public Beans getnovelifo1(String title) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Beans bean = new Beans();
				try {
					con = pool.getConnection();
					sql = "select n.n_id, n.title, a.a_name, n.agelimit, n.n_history, n.n_image, n.storyline from novel n join authoring aing on n.n_id = aing.n_id join author a on aing.a_id = a.a_id where title = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, title);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						bean.setn_id(rs.getInt(1));//���̺� ��Ű�� �ε���
						bean.settitle(rs.getString(2));
						bean.seta_name(rs.getString(3));
						bean.setagelimit(rs.getInt(4));
						bean.setn_history(rs.getString(5));
						bean.setn_image(rs.getString(6));
						bean.setstoryline(rs.getString(7));
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return bean;
			}
			//�Ҽ� �Խù� ����ó ����
			public Vector<Beans> getnovelifo_webcomp(String title) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Vector<Beans> vlist = new Vector<Beans>();
				try {
					con = pool.getConnection();
					sql = "select w.w_name from webcomp w join webposting wing on w.w_id = wing.w_id join novel n on n.n_id = wing.n_id where n.title = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, title);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						Beans bean = new Beans();
						String w_name = rs.getString("w_name");// Į����
						bean.setw_name(w_name);
						vlist.addElement(bean);
					} // --while
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// con�� �ݳ�, pstmt�� rs�� close
					pool.freeConnection(con, pstmt, rs);
				}
				return vlist;

			}
			//��ǰ�Խù� ���ǻ�
			public Beans getnovelifo_pubcomp(String title) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Beans bean = new Beans();
				try {
					con = pool.getConnection();
					sql = "select p.p_name from pubcomp p join publishing ping on ping.p_id = p.p_id join novel n on ping.n_id=n.n_id where n.title = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, title);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						bean.setp_name(rs.getString(1));//���̺� ��Ű�� �ε���
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return bean;
			}
			//��ǰ�Խù� ���������
			public Beans getnovelifo_started(String title) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Beans bean = new Beans();
				try {
					con = pool.getConnection();
					sql = "select MIN(wing.started), Min(wing.ended) from webposting wing join novel n on wing.n_id = n.n_id where n.title = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, title);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						bean.setstarted(rs.getString(1));//���̺� ��Ű�� �ε���
						bean.setended(rs.getString(2));
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					pool.freeConnection(con, pstmt, rs);
				}
				return bean;
			}
			//�Ҽ� �Խù� ����ó ����
			public Vector<Beans> getnovelifo_tag(String title) {
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Vector<Beans> vlist = new Vector<Beans>();
				try {
					con = pool.getConnection();
					sql = "SELECT nt.ntag_name from noveltag nt join n_tagging nting on nt.ntag_id = nting.ntag_id join novel n on nting.n_id = n.n_id where title = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, title);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						Beans bean = new Beans();
						String ntag_name = rs.getString("ntag_name");// Į����
						bean.setntag_name(ntag_name);
						vlist.addElement(bean);
					} // --while
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// con�� �ݳ�, pstmt�� rs�� close
					pool.freeConnection(con, pstmt, rs);
				}
				return vlist;

			}
			//�۰��� �˻�
			public Vector<Beans> getSearchListAuthor(String a_name) {
				// DB���� ����
				Connection con = null;// DB���� ��ü
				PreparedStatement pstmt = null;// sql�� ����� ��ü
				ResultSet rs = null; // select�� ���� ����� ���� ��ü
				String sql = null;
				Vector<Beans> vlist = new Vector<Beans>();
				
				try {
					// pool��ü���� ������
					con = pool.getConnection();
					sql = "select * FROM Author where a_name like ? ";
					pstmt = con.prepareStatement(sql);
					pstmt. setString(1, "%"+a_name+"%");

					rs = pstmt.executeQuery();// DB ���� �� ����� ����
					while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
						Beans bean = new Beans();

						bean.seta_id(rs.getInt("A_ID"));
						bean.seta_name(rs.getString("A_NAME"));
						bean.setas_name(rs.getString("AS_NAME"));
						bean.setr_name(rs.getString("R_NAME"));
						bean.setgender(rs.getInt("GENDER"));
						bean.setbirth(rs.getString("BIRTH"));
						bean.seta_history(rs.getString("A_HISTORY"));

						// ���ڵ带 �����Ų ��� Vector�� ����
						vlist.addElement(bean);
					} // --while
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// con�� �ݳ�, pstmt�� rs�� close
					pool.freeConnection(con, pstmt, rs);
				}
				return vlist;
			}
			// �Է�
						public boolean insertmediamix(Beans bean) {
							Connection con = null;// DB���� ��ü
							PreparedStatement pstmt = null;// sql�� ����� ��ü
							String sql = null;
							boolean flag = false;
							try {
								con = pool.getConnection();
								sql = "insert into mediamix(n_id, mediamix)" + " values(?,?)";
								pstmt = con.prepareStatement(sql);
								pstmt.setInt(1, bean.getn_id());
								pstmt.setInt(2, bean.getmediamix());
								int cnt = pstmt.executeUpdate();// insert, update, delete\
								if(cnt==1) flag = true;
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								pool.freeConnection(con, pstmt);
							}
							return flag;
						}
						// �Է�
						public boolean insertn_tagging(Beans bean) {
							Connection con = null;// DB���� ��ü
							PreparedStatement pstmt = null;// sql�� ����� ��ü
							String sql = null;
							boolean flag = false;
							try {
								con = pool.getConnection();
								sql = "insert into n_tagging(n_id, ntag_id)" + " values(?,?)";
								pstmt = con.prepareStatement(sql);
								pstmt.setInt(1, bean.getn_id());
								pstmt.setInt(2, bean.getntag_id());
								int cnt = pstmt.executeUpdate();// insert, update, delete\
								if(cnt==1) flag = true;
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								pool.freeConnection(con, pstmt);
							}
							return flag;
						}

						// �Է�
						public boolean insertAuthoring(Beans bean) {
							Connection con = null;// DB���� ��ü
							PreparedStatement pstmt = null;// sql�� ����� ��ü
							String sql = null;
							boolean flag = false;
							try {
								con = pool.getConnection();
								sql = "insert into Authoring(a_id,n_id)" + " values(?,?)";
								pstmt = con.prepareStatement(sql);
								pstmt.setInt(1, bean.geta_id());
								pstmt.setInt(2, bean.getn_id());
								int cnt = pstmt.executeUpdate();// insert, update, delete\
								if(cnt==1) flag = true;
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								pool.freeConnection(con, pstmt);
							}
							return flag;
						}
						//�뺧�� �Խ��� ����, ��ǰ, �۰�, �̿뿬��, �ϰῩ�� ���
						public Vector<Beans> getNoveltablist() {
							// DB���� ����
							Connection con = null;// DB���� ��ü
							PreparedStatement pstmt = null;// sql�� ����� ��ü
							ResultSet rs = null; // select�� ���� ����� ���� ��ü
							String sql = null;
							Vector<Beans> vlist = new Vector<Beans>();
							try {
								// pool��ü���� ������
								con = pool.getConnection();
								sql = "select n.title, a.a_name, n.agelimit, n.ending from NOVEL n Join authoring aing on n.n_id = aing.n_id Join author a on a.a_id = aing.a_id";
								pstmt = con.prepareStatement(sql);

								rs = pstmt.executeQuery();// DB ���� �� ����� ����
								while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
									Beans bean = new Beans();
									String title = rs.getString("title");
									String a_name = rs.getString("a_name");
									int agelimit = rs.getInt("agelimit");
									int ending = rs.getInt("ending");
									bean.settitle(title);
									bean.setagelimit(agelimit);
									bean.seta_name(a_name);
									bean.setending(ending);
									// ���ڵ带 �����Ų ��� Vector�� ����
									vlist.addElement(bean);
								} // --while
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								// con�� �ݳ�, pstmt�� rs�� close
								pool.freeConnection(con, pstmt, rs);
							}
							return vlist;

						}
						
						//��ǰ�� �˻�
						public Vector<Beans> getSearchListnovel(String title) {
							// DB���� ����
							Connection con = null;// DB���� ��ü
							PreparedStatement pstmt = null;// sql�� ����� ��ü
							ResultSet rs = null; // select�� ���� ����� ���� ��ü
							String sql = null;
							Vector<Beans> vlist = new Vector<Beans>();
							
							try {
								// pool��ü���� ������
								con = pool.getConnection();
								sql = "select * FROM novel where title like ? ";
								pstmt = con.prepareStatement(sql);
								pstmt. setString(1, "%"+title+"%");

								rs = pstmt.executeQuery();// DB ���� �� ����� ����
								while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
									Beans bean = new Beans();

									bean.setn_id(rs.getInt("N_ID"));
									bean.settitle(rs.getString("TITLE"));
									bean.setagelimit(rs.getInt("AGELIMIT"));
									bean.setstoryline(rs.getString("STORYLINE"));
									bean.setn_history(rs.getString("N_HISTORY"));
									bean.setn_image(rs.getString("N_IMAGE"));
									bean.setending(rs.getInt("ENDING"));

									// ���ڵ带 �����Ų ��� Vector�� ����
									vlist.addElement(bean);
								} // --while
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								// con�� �ݳ�, pstmt�� rs�� close
								pool.freeConnection(con, pstmt, rs);
							}
							return vlist;
						}
						
						//�뺧�� ��ǰ �˻� ���̺� ����
						public Vector<Beans> getNovelsearchtablist(String title) {
							// DB���� ����
							Connection con = null;// DB���� ��ü
							PreparedStatement pstmt = null;// sql�� ����� ��ü
							ResultSet rs = null; // select�� ���� ����� ���� ��ü
							String sql = null;
							Vector<Beans> vlist = new Vector<Beans>();
							try {
								// pool��ü���� ������
								con = pool.getConnection();
								sql = "select n.title, a.a_name, n.agelimit, n.ending from NOVEL n Join authoring aing on n.n_id = aing.n_id Join author a on a.a_id = aing.a_id where n.title like ?";
								pstmt = con.prepareStatement(sql);
								pstmt. setString(1, "%"+title+"%");

								rs = pstmt.executeQuery();// DB ���� �� ����� ����
								while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
									Beans bean = new Beans();
									String title2 = rs.getString("title");
									String a_name = rs.getString("a_name");
									int agelimit = rs.getInt("agelimit");
									int ending = rs.getInt("ending");
									bean.settitle(title2);
									bean.setagelimit(agelimit);
									bean.seta_name(a_name);
									bean.setending(ending);
									// ���ڵ带 �����Ų ��� Vector�� ����
									vlist.addElement(bean);
								} // --while
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								// con�� �ݳ�, pstmt�� rs�� close
								pool.freeConnection(con, pstmt, rs);
							}
							return vlist;

						}
						
						public Vector<Beans> getAuthorsearchtablist(String a_name) {
							// DB���� ����
							Connection con = null;// DB���� ��ü
							PreparedStatement pstmt = null;// sql�� ����� ��ü
							ResultSet rs = null; // select�� ���� ����� ���� ��ü
							String sql = null;
							Vector<Beans> vlist = new Vector<Beans>();
							try {
								// pool��ü���� ������
								con = pool.getConnection();
								sql = "select n.title, a.a_name, n.agelimit, n.ending from NOVEL n Join authoring aing on n.n_id = aing.n_id Join author a on a.a_id = aing.a_id where n.title like ?";
								pstmt = con.prepareStatement(sql);
								pstmt. setString(1, "%"+a_name+"%");

								rs = pstmt.executeQuery();// DB ���� �� ����� ����
								while (rs.next()/* ���� Ŀ������ ���� Ŀ���� �̵� */) {
									Beans bean = new Beans();
									String title = rs.getString("title");
									String a_name2 = rs.getString("a_name");
									int agelimit = rs.getInt("agelimit");
									int ending = rs.getInt("ending");
									bean.settitle(title);
									bean.setagelimit(agelimit);
									bean.seta_name(a_name2);
									bean.setending(ending);
									// ���ڵ带 �����Ų ��� Vector�� ����
									vlist.addElement(bean);
								} // --while
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								// con�� �ݳ�, pstmt�� rs�� close
								pool.freeConnection(con, pstmt, rs);
							}
							return vlist;

						}
}
