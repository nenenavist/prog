package managers;

import network.Request;
import network.Response;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.nio.channels.DatagramChannel;

public class Handler {
    public Request readPacket(byte[] bytes) throws Exception {
        Request request = null;
        try (ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
             ObjectInputStream objStream = new ObjectInputStream(byteStream)) {
             request = (Request) objStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Обработка возможных исключений
            }
        return request;
    }

    public Response handleRequest(Request request, Console console) throws Exception {
        return console.start(request);
    }

    public void send(byte[] bytes, DatagramChannel datagramChannel, SocketAddress clientAddress){
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        try{
            datagramChannel.send(buffer, clientAddress);
        }catch (Exception e){
            System.err.println("Lost the connection with user");
        }
        buffer.clear();
    }
}
