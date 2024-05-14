import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Client {
    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(ServerData.SERVER_IP);

            String message1 = "Це перше наше повідомлення, на відправку до сервера";
            String message2 = "А це коротке друге.";

            System.out.println("Перше:");
            // Відправляємо перше повідомлення
            sendMessage(clientSocket, serverAddress, message1);
            // Отримуємо та виводимо результат
            printResponseWithServer(clientSocket);

            System.out.println("Друге:");
            // Відправляємо друге повідомлення
            sendMessage(clientSocket, serverAddress, message2);
            printResponseWithServer(clientSocket);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(DatagramSocket clientSocket, InetAddress serverAddress,
                                    String message) throws IOException {
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, ServerData.SERVER_PORT);
        clientSocket.send(sendPacket);
    }
    private static String printResponseWithServer(DatagramSocket clientSocket) throws IOException {
        byte[] receiveData = new byte[ServerData.BYTE_ARRAY_LENGTH];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Кількість заданих символів у рядку: " + response + ".");

        return response;
    }
}