package controllers;

import logic.PacketLogic;
import models.User;
import senders.Sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by jeppe on 21-11-2017.
 */
public class MainController {

    private static PacketLogic packetLogic = new PacketLogic();
    private static Sender sender = new Sender();

    public static void sendJoin(InetAddress serverIP, DatagramSocket socket, String username){
        sender.sendJoin(serverIP, socket, username);
    }

    public static String readMsg(DatagramPacket packet){
        return packetLogic.readMsg(packet);
    }

    public void sendMove(InetAddress serverIP, DatagramSocket socket, String move) {
        sender.sendMove(serverIP, socket, move);
    }
}
