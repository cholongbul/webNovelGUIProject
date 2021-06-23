package WebNovelGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class WebnovelServer {

	int port = 8001;
	ServerSocket server;
	Vector<ClientThread> vc;
	Mgrs mgr;
	BufferedReader in;
	PrintWriter out;
	Login login;

	public WebnovelServer() {

		try {
			server = new ServerSocket(port);
			vc = new Vector<ClientThread>();
			mgr = new Mgrs();
			login = new Login();
		} catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1);// 비정상적인 종료
		}
		System.out.println("****************************");
		System.out.println("Welcome webnovelServer3...");
		System.out.println("클라이언트의 접속을 기다리고 있습니다.");
		System.out.println("****************************");
		try {
			while (true) {
				Socket sock = server.accept();
				ClientThread ct = new ClientThread(sock);
				ct.start();
				vc.add(ct);
			}
		} catch (Exception e) {
			System.err.println("Error in Socket");
			e.printStackTrace();
		}

	}// 생성자

	// Vector에 Client를 제거
	public void removeClient(ClientThread ct) {
		vc.remove(ct);
	}

	class ClientThread extends Thread {
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id = "익명";

		public ClientThread(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(), true);
				System.out.println(sock + "접속됨....");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}// 생성자

		public void run() {
			try {
				while (true) {
					String line = in.readLine();
					if (line == null)
						break;
					else
						routine(line);
				}
			} catch (Exception e) {
				removeClient(this);
				System.err.println(sock + "[" + id + "] 끊어짐.");
			}
		}

		public void routine(String line) {
			System.out.println("line : " + line);
			int idx = line.indexOf(':');
			String cmd = line.substring(idx);
			String data = line.substring(idx + 1);
			if (cmd.equals(WebNovelprotocol.LOGIN)) {
				// Login:aaa;1234
				idx = data.indexOf(';');
				cmd/* aaa */ = data.substring(0, idx);
				data/* 1234 */ = data.substring(idx + 1);
				if (login.logining(cmd, data)) {
					sendMessage(WebNovelprotocol.LOGIN + ":" + "T");
				} else {
					sendMessage(WebNovelprotocol.LOGIN + ":" + "F");
				}

			}
		}

	}

	public void sendMessage(String msg) {
		out.println(msg);
	}// 내부 클래스
	
	public static void main(String[] args) {
		new WebnovelServer();
	}
}// 클래스