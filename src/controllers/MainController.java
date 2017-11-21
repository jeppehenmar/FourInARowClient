package controllers;

import models.User;
import senders.Sender;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by jeppe on 21-11-2017.
 */
public class MainController {

    public static void sendJoin(InetAddress serverIP, DatagramSocket socket, String username){
        Sender.sendJoin(serverIP, socket, username);
    }
}
