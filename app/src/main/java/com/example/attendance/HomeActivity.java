package com.example.attendance;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {
    ImageButton scnbtn1;
    public static String ip;
    public static String enroll = "170303105021";
    public static int randomno;
    TelephonyManager tm;
    public static String imei;
    Button sbtbtn;
    private FingerprintManager fingerprintManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        scnbtn1 = (ImageButton) findViewById(R.id.scnbtn);
        scnbtn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("HardwareIds")
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), scanview.class));
                tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    Activity#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    return;
                }
                imei = tm.getDeviceId();


            }
        });

    }
    public void sen_data(View v)
    {


        System.out.println("hiiiiii working");
        System.out.println(imei);
        MessageSender messageSender = new MessageSender();
        messageSender.execute(enroll);

    }
}
