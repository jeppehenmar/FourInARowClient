package logic;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;

/**
 * Created by Jeppe Henmar on 21-11-2017.
 */
public class PacketLogic {
    public static String readMsg(DatagramPacket packet){
        try{
            byte[] buf = packet.getData();

            ByteArrayInputStream bais = new ByteArrayInputStream(buf);
            InputStreamReader isr = new InputStreamReader(bais);
            BufferedReader br = new BufferedReader(isr);

            return br.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return "Packet not found";
    }
}
