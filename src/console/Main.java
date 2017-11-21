package console;

import controllers.MainController;

import java.net.*;
import java.util.Scanner;

/**
 * Created by jeppe on 20-11-2017.
 */
public class Main {
    public static void main(String[] args) throws UnknownHostException, SocketException{
        final DatagramSocket socket = new DatagramSocket(4710);
        final InetAddress serverIP = InetAddress.getLocalHost();
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome.\nWhat will your username be?");
        String username = input.next();

        MainController.sendJoin(serverIP, socket, username);


    }
}
