package console;

import controllers.MainController;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created by jeppe on 20-11-2017.
 */
public class Main {
    public static void main(String[] args) throws UnknownHostException, SocketException{
        final DatagramSocket socket = new DatagramSocket(4710);
        final InetAddress serverIP = InetAddress.getByName("192.168.0.6");
        MainController controller = new MainController();
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome.\nWhat will your username be?");
        String username = input.next();

        controller.sendJoin(serverIP, socket, username);

        while(true){
            try{
                DatagramPacket received = new DatagramPacket(new byte[1024], 1024);
                socket.receive(received);
                String msg = controller.readMsg(received);
                if(msg.substring(0, 1).equals("1")||msg.substring(0, 1).equals("2")){
                    String move = input.next();
                    controller.sendMove(serverIP, socket, move);
                }
                System.out.println(msg);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
