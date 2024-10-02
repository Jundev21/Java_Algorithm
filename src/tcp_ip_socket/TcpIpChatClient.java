package tcp_ip_socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

// tcp 소켓 클라이언트 단계
// 클라이언트 소켓 생성한다.
// 서버 포트번호로 연결한다.


public class TcpIpChatClient {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력해주세요");
        String servetIP = "127.0.0.1";
        Socket socket = new Socket(servetIP, 8080);

        Thread sender = new ClientSender(socket, sc.nextLine());
        Thread receiver = new ClientReceiver(socket);

        sender.start();
        receiver.start();

    }

    public static class ClientSender extends Thread {
        Socket socket;
        DataOutputStream out;
        String name;

        ClientSender(Socket socket, String name) {
            this.socket = socket;
            try {
                out = new DataOutputStream(socket.getOutputStream());
                this.name = name;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        public void run() {
            Scanner sc = new Scanner(System.in);

            try {
                out.writeUTF(name);
                while (out != null) {
                    out.writeUTF("[" + name + "]" + sc.nextLine());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class ClientReceiver extends Thread {
        Socket socket;
        DataInputStream in;

        ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void run() {

            while (in != null) {
                try {
                    System.out.println(in.readUTF());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }


    }

}
