package com.vdh.pushnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final int MY_ID = 1;
    Button btnSendNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSendNo=findViewById(R.id.btnSendNotifycation);
        btnSendNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushNotification();
            }
        });
    }

    private void pushNotification() {
        Notification notification = new NotificationCompat.Builder(this,MyApplicaion.CHANNEL_ID)
                .setContentText("description 1")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("title 1")
                .setColor(Color.argb(1,100,50,100))
                .build();

        NotificationManager manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(getNotifiID(),notification);
    }
    public int getNotifiID(){
        return (int) new Date().getTime();
    }
}