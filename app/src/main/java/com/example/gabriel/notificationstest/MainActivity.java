package com.example.gabriel.notificationstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gabriel.notificationstest.utils.NotificationUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button btsimpleNotification;
    private Button btAutoLaunchNotification;

    /*private Button btcontinousNotification;
    private Button btActionNotification;*/

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btsimpleNotification = (Button)findViewById(R.id.bt_simpleNotification);
        btAutoLaunchNotification = (Button)findViewById(R.id.bt_autoLaunchNotification);

        /*btcontinousNotification = (Button)findViewById(R.id.bt_continuousNotification);
        btActionNotification = (Button)findViewById(R.id.bt_actionNotification);*/


        btsimpleNotification.setOnClickListener(this);
        btAutoLaunchNotification.setOnClickListener(this);

        /*btcontinousNotification.setOnClickListener(this);
        btActionNotification.setOnClickListener(this);*/

    }

    @Override
    public void onClick(View view)
    {
        if(view.equals(btsimpleNotification))
        {
            NotificationUtils.showSimpleNotification(this);
        }
        else if (view.equals(btAutoLaunchNotification))
        {
            NotificationUtils.showAutoLaunchNotification(this);
        }

        /*else if(view.equals(btcontinousNotification))
        {
            NotificationUtils.showContinuousNotification(this);
        }
        else if(view.equals(btActionNotification))
        {
            NotificationUtils.showActionNotification(this);
        }*/
    }
}
