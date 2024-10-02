package tcp_ip_socket;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// tcp 서버 생성 단계
// 1. 소켓을 생성한다.
// 2. 클라이언트로부터 요청을 전달받는다.
// 3. 요청을 전달받으면 새로운 소켓을 생성한다.
// 4. 병렬적으로 처리, 여러 사용자를 전달받기위해 스레드를 생성한다.

public class TcpIpChatServer {


    Map<String, DataOutputStream> client = null;

    TcpIpChatServer() {
        client = new HashMap<>();
        Collections.synchronizedMap(client);
    }

    public void startServer() {
        // 서버에서 클라이언트의 요청이 올때까지 기다린다.
        ServerSocket serverSocket = null;
        // 클라이언트 요청이 오게되면 새로운 소켓을 생성하여 클라이언트 소켓과 연결한다.
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("서버가 실행되었습니다. ");
           socket = serverSocket.accept();
            System.out.println(socket.getInetAddress() + " : " + socket.getPort() + "에서 접속하였습니다. ");

            ServerReceiver sr  = new ServerReceiver(socket);
            sr.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendToAllClients(String message) {

        client.keySet().forEach((e) -> {
            try {
                DataOutputStream out = client.get(e);
                out.writeUTF(message);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    class ServerReceiver extends Thread {

        Socket socket = new Socket();
        DataInputStream in;
        DataOutputStream out;

        ServerReceiver(Socket s) {
            try {
                //클라이언트로 전달받은 데이터 내용
                in = new DataInputStream(s.getInputStream());
                //어느 클라이언트인지 해당 클라이언트 포트로 전달
                out = new DataOutputStream(s.getOutputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void run() {
            String name = "";

            try {
                name = in.readUTF();
                sendToAllClients(name + " 님이 접속하였습니다.");
                client.put(name, out);
                System.out.println("현재 접속자 수 : " + client.size());

                //메세지 데이터 전송
                while (in != null) {
                    sendToAllClients(in.readUTF());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static void main(String[] args) {
        new TcpIpChatServer().startServer();
    }

}
