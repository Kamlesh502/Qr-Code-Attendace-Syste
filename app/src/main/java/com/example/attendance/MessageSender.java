package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static com.example.attendance.HomeActivity.enroll;
import static com.example.attendance.HomeActivity.imei;
import static com.example.attendance.HomeActivity.ip;
import static com.example.attendance.HomeActivity.randomno;

public class MessageSender extends AsyncTask<String,Void,Void> {


    Socket s;
    DataOutputStream dos;
    PrintWriter pw;

    @Override
    protected Void doInBackground(String... voids) {

        String message = voids[0];
        try {
            System.out.println(ip);
            s = new Socket(ip, 6868);
            System.out.println("Connection success");

            BufferedReader bfs = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String st = bfs.readLine();
            System.out.println(st);

            String[] arrOfStr = st.split("#", 2);
            String pc_data = arrOfStr[0];
            int random= Integer.parseInt(pc_data);

            if(random == randomno)
            {
                pw = new PrintWriter(s.getOutputStream());
                pw.write(enroll);
                pw.flush();
                pw.close();
                s.close();
            }
            else {
                System.out.println("error");
            }






        }
        catch (IOException e){
            e.printStackTrace();
        }


        return null;
    }
}
