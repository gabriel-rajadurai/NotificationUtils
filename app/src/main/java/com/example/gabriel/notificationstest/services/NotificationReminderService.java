package com.example.gabriel.notificationstest.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.gabriel.notificationstest.utils.NotificationUtils;

/**
 * Created by Gabriel on 12-09-2017.
 */

public class NotificationReminderService extends IntentService
{
    private static final String TAG = "NotificationReminderSer";

    public NotificationReminderService() {
        super("NotificationReminderIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent)
    {
        String action = intent.getAction();

        if(NotificationUtils.CLOSE_NOTIFICATION_ACTION.equals(action)) {
            NotificationUtils.clearAllNotifications(this);
            Log.d(TAG, "closed Notification: ");
        }
        else if(NotificationUtils.OPEN_MESSAGE_ACTION.equals(action))
        {
            Log.d(TAG, "opened Message: ");
            NotificationUtils.clearAllNotifications(this);
        }


    }
}
