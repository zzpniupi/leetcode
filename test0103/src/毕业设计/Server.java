package 毕业设计;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        startService();

    }

    private static void startService(){
        new Thread(){
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(1234);
                    System.out.println("--开启服务器，监听端口1234--");
                    while(true){
                        System.out.println("--等待客户端连接--");
                        Socket socket = serverSocket.accept();
                        System.out.println("--客户端接入--" + socket);
                        startReader(socket);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private static void startReader(final Socket socket){
        new Thread(){
            @Override
            public void run() {
                DataInputStream reader;
                try {
                    reader = new DataInputStream(socket.getInputStream());
                    while(true){
                        System.out.println("--等待客户端传输信息--");
                        //int msg = reader.readInt();
                        String msg = reader.readUTF();
                        System.out.println("获取到的客户端信息：" + msg);
                        handleMsg(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private static void handleMsg(String msg){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        switch (msg){
            case "1":
                robot.keyPress(KeyEvent.VK_UP);
                robot.keyRelease(KeyEvent.VK_UP);
                System.out.println("robot自动点击↑");
                break;
            case "2":
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                System.out.println("robot自动点击↓");
                break;
            case "3":
                robot.keyPress(KeyEvent.VK_LEFT);
                robot.keyRelease(KeyEvent.VK_LEFT);
                System.out.println("robot自动点击←");
                break;
            case "4":
                robot.keyPress(KeyEvent.VK_RIGHT);
                robot.keyRelease(KeyEvent.VK_RIGHT);
                System.out.println("robot自动点击→");
                break;
            case "5":
                robot.keyPress(KeyEvent.VK_F5);
                robot.keyRelease(KeyEvent.VK_F5);
                System.out.println("robot自动播放PPT");
                break;
            case "6":
                robot.keyPress(KeyEvent.VK_ESCAPE);
                robot.keyRelease(KeyEvent.VK_ESCAPE);
                System.out.println("robot自动退出PPT播放");
                break;
            default:
                break;
        }
    }
}
