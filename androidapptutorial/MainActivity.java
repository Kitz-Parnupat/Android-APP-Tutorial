package com.example.stealkel2.androidapptutorial;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    NotificationManager nManager;
    int NOTFICATION_ID = 100;
    NotificationText nf = new NotificationText();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button bt = (Button) findViewById(R.id.btOK);
        bt.setOnClickListener(this);

        Button bn = (Button) findViewById(R.id.btToast);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Toast Notification",Toast.LENGTH_LONG).show();
            }
        });
        final AlertDialog.Builder aDlg = new AlertDialog.Builder(this);
        Button ba = (Button) findViewById(R.id.btAD);
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aDlg.setTitle("Alert Dialog");
                aDlg.setMessage("Save Data");
                aDlg.setNegativeButton("No",null);
                aDlg.setPositiveButton("Yes", new AlertDialog.OnClickListener(){
                    public void onClick(DialogInterface dialog,int arg1){
                        Toast.makeText(MainActivity.this,"Save Data",Toast.LENGTH_LONG).show();
                    }
                });
                aDlg.show();
            }
        });
        Button bnf = (Button) findViewById(R.id.btNFCT);
        bnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,updateActivity.class);
                PendingIntent pI = PendingIntent.getActivity(MainActivity.this,0,i,0);
                NotificationCompat.Builder nb = (NotificationCompat.Builder) new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle(nf.getNotiTilte())
                        .setContentText(nf.getNotiText())
                        .setContentIntent(pI).setAutoCancel(true);
                Notification n = nb.build();
               nManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nManager.notify(NOTFICATION_ID,n);
            }
        });

    }

     MainActivity(){
        nf.setNotiText("Android 4.0");
        nf.setSetNotiTilte("News Update");
    }



    @Override
    public void onClick(View v) {
        TextView tv = (TextView) findViewById(R.id.txtView);
        tv.setText("Chang Your Text");
    }




}
