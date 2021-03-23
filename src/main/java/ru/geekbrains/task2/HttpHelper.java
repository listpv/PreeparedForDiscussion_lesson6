package ru.geekbrains.task2;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

@Component
public class HttpHelper {

    public String doAction(){
        String result = null;
        try {
            Socket socket = new Socket("localhost", 8080);
            String header = "GET HTTP/1.1\n" +
                    "User-Agent: HTTPClient\n\n";
            socket.getOutputStream().write(header.getBytes());
            InputStreamReader isr = new InputStreamReader(socket
                    .getInputStream());
            BufferedReader bfr = new BufferedReader(isr);
            StringBuffer sbf = new StringBuffer();
            int ch = bfr.read();
            while (ch != -1) {
                sbf.append((char) ch);
                ch = bfr.read();
            }
            result = sbf.toString();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }
}
