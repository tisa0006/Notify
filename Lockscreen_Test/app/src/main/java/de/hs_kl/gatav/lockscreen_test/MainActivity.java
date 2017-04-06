package de.hs_kl.gatav.lockscreen_test;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent();
                        PendingIntent pIntent1 = PendingIntent.getActivity(MainActivity.this, 0, intent1, 0);
                        /**
                        Notification notif1 = new Notification.Builder(MainActivity.this)
                                .setTicker("Ticker_Text")
                                .setContentTitle("Content_Titel")
                                .setContentText("Content_Text")
                                .setSmallIcon(R.drawable.zoidberg)
                                .addAction(R.drawable.fry, "Action_1", pIntent1)
                                .addAction(R.drawable.bender, "Action_2", pIntent1)
                                .setOngoing(true)
                                .setContentIntent(pIntent1).getNotification();
                        notif1.flags = Notification.FLAG_ONGOING_EVENT;
                        notif1.flags = Notification.FLAG_AUTO_CANCEL;
                        notif1.flags = Notification.VISIBILITY_PRIVATE;
                        NotificationManager nm1 = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                        nm1.notify(0, notif1);
                        **/

                        Notification.Builder builder = new Notification.Builder(getApplicationContext());
                        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.bender, "Alarm!", pIntent1).build();
                        builder.setTicker("Ticker_Text");
                        builder.setContentTitle("Content_Titel");
                        builder.setContentText("Content_Text");
                        builder.setSmallIcon(R.drawable.zoidberg);
                        builder.addAction(action);
                        //builder.addAction(R.drawable.bender, "Action_2", pIntent1);
                        builder.setOngoing(true);
                        builder.setContentIntent(pIntent1).getNotification();

                        Notification noti = builder.build();
                        NotificationManager nm1 = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                        nm1.notify(0, noti);


                    }
                }
        );
    }
}