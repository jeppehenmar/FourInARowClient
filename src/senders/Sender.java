package senders;

import models.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by jeppe on 21-11-2017.
 */
public class Sender {
    public static void sendJoin(InetAddress serverIP, DatagramSocket socket, String username){
        try {
            String joinMSG = "JOIN " + username;
            byte[] data = joinMSG.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, serverIP, 4711);
            socket.send(packet);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void sendMove(InetAddress serverIP, DatagramSocket socket, String move) {
        try{
            String moveMSG = "MOVE " + move;
            byte[] data = moveMSG.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, serverIP, 4711);
            socket.send(packet);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMSG(InetAddress serverIP, DatagramSocket socket, String msg){
        try{
            byte[] data = msg.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, serverIP, 4711);
            socket.send(packet);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
