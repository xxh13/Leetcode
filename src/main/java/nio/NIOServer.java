package nio;

public class NIOServer {

    public static void main(String[] args) {
        int port = 8888;
        TimeClientHandle server = new TimeClientHandle("127.0.0.1", port);
        new Thread(server, "server").start();
    }
}
