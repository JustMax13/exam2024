import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP_Server {
    public static void main(String[] args) {
        byte[] receiveData = new byte[ServerData.BYTE_ARRAY_LENGTH];

        try (DatagramSocket serverSocket = new DatagramSocket(ServerData.SERVER_PORT)) {
            System.out.println("Сервер успішно запущено");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Отримано повідомлення від клієнта: " + message);

                // Відправляємо кількість символів у повідомленні назад клієнту
                String response = String.valueOf(message.length());
                DatagramPacket sendPacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                        receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
