package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import static com.example.attendance.HomeActivity.imei;
import static com.example.attendance.HomeActivity.ip;
import static com.example.attendance.HomeActivity.randomno;

public class scanview extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView ScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScannerView =new ZXingScannerView(this);
        setContentView(ScannerView);
    }

    @Override
    public void handleResult(Result result) {

        String resulttxt;
        resulttxt = result.getText();
        String[] arrOfStr = resulttxt.split("#", 2);
        randomno = Integer.parseInt(arrOfStr[0]);
        ip = arrOfStr[1];
        System.out.println(ip);
        onBackPressed();
    }
    protected void onPause() {
        super.onPause();
        ScannerView.stopCamera();
    }
    protected void onPostResume() {
        super.onPostResume();
        ScannerView.setResultHandler(this);
        ScannerView.startCamera();
    }


}
