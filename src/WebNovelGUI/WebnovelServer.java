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
			System.exit(1);// ���������� ����
		}
		System.out.println("****************************");
		System.out.println("Welcome webnovelServer3...");
		System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��� �ֽ��ϴ�.");
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

	}// ������

	// Vector�� Client�� ����
	public void removeClient(ClientThread ct) {
		vc.remove(ct);
	}

	class ClientThread extends Thread {
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id = "�͸�";

		public ClientThread(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(), true);
				System.out.println(sock + "���ӵ�....");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}// ������

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
				System.err.println(sock + "[" + id + "] ������.");
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
	}// ���� Ŭ����
	
	public static void main(String[] args) {
		new WebnovelServer();
	}
}// Ŭ����