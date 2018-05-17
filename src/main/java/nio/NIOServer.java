package nio;

public class NIOServer {

    public static void main(String[] args) {
        int port = 8888;
        TimeClientHandle server = new TimeClientHandle("192.168.2.12", port);
        new Thread(server, "server").start();
    }
}
