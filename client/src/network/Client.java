package network;

import java.io.*;
import java.net.*;
import java.nio.channels.DatagramChannel;


public class Client {


    private DatagramSocket socket = new DatagramSocket();

    DatagramChannel datagramChannel;
    private InetAddress address = InetAddress.getByName("localhost");
    private byte[] buff = new byte[4096];

    final int recoonectionTime = 5000;
    final int maxReconnectionAttempts = 5;
    private static final int port = 2448;
    private DatagramPacket datagramPacket;

    public Client() throws SocketException, UnknownHostException {
    }

    public void connect(){
        datagramPacket = new DatagramPacket(buff, buff.length );
        socket.connect(address, port);
    }

    public void disconnect(){
        socket.close();
    }


    public String callServer(Request request) {
        this.connect();
        for(int reconnectionAttempts = 0; reconnectionAttempts <= maxReconnectionAttempts; reconnectionAttempts++){
            try{
                if (request.getArgs()==null) System.err.println("Empty request");
                String answer = sendRequest(request);
                return answer;
            } catch (Exception e) {
                System.out.println("Reconnection attempt: " + reconnectionAttempts);
                try {
                    Thread.sleep(recoonectionTime);
                } catch (InterruptedException e1) {
                }
                this.connect();
            }
        }
        return null;
    }



    public String sendRequest(Request request) throws IOException, ClassNotFoundException, InterruptedException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(byteArrayOutputStream);
        stream.writeObject(request);
        byte[] buff = byteArrayOutputStream.toByteArray();
        DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length, address, port);
        socket.send(datagramPacket);//посылка запроса
        return getAnswer();

    }

    private String getAnswer() throws IOException, ClassNotFoundException, InterruptedException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024 * 1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        bos.write(packet.getData(), 0, packet.getLength());
        String response = bos.toString();
        bos.close();
        return response;
    }
}