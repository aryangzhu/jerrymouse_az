package com.aryangzhu.net;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);
        handle(socket);
        socket.close();
        System.out.println(">>>完事儿了");
    }

    static void handle(Socket socket){
        InputStream inputStream=null;
        OutputStream outputStream=null;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            Scanner scanner = new Scanner(System.in);
            System.out.println("start input by yourself....");
            for(;;){
                System.out.print(">>> "); // 打印提示
                String s = scanner.nextLine(); // 读取一行输入
                bufferedWriter.write(s);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                String resp = bufferedReader.readLine();
                System.out.println("<<< " + resp);
                if (resp.equals("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
