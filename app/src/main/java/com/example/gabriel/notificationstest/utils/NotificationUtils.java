package com.example.gabriel.notificationstest.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v4.content.ContextCompat;

import com.example.gabriel.notificationstest.MainActivity;
import com.example.gabriel.notificationstest.R;
import com.example.gabriel.notificationstest.services.NotificationReminderService;

/**
 * Created by Gabriel on 12-09-2017.
 */

public class NotificationUtils
{
    private static final int PENDING_INTENT_ID = 1132;
    private static final int SIMPLE_NOTIFICATION_ID = 1133;
    private static final int AUTOLAUNCH_NOTIFICATION_ID = 1136;

/*    private static final int CONTINOUS_NOTIFICATION_ID = 1134;
    private static final int ACTION_NOTIIFICATION_ID = 1135;*/

/*    private static final int ACTION_CLOSE_PENDINGINTENT_ID = 100;
    private static final int ACTION_OPEN_PENDINGINTENT_ID = 101;*/

    public static final String CLOSE_NOTIFICATION_ACTION = "close notification";
    public static final String OPEN_MESSAGE_ACTION = "open notification";

    public static void clearAllNotifications(Context context)
    {
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }

    public static void showSimpleNotification(Context context)
    {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setColor(ContextCompat.getColor(context,R.color.colorPrimary))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(largeIcon(context, R.mipmap.ic_launcher_round))
                .setContentTitle(context.getString(R.string.app_name))
                .setContentText(context.getString(R.string.simple_notification_content))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(context.getString(R.string.simple_notification_content)))
                .setDefaults(NotificationCompat.DEFAULT_VIBRATE)
                .setContentIntent(contentIntent(context))
                .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            notificationBuilder.setPriority(Notification.PRIORITY_HIGH);
        }

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(SIMPLE_NOTIFICATION_ID,notificationBuilder.build());
    }

    public static void showAutoLaunchNotification(Context context)
    {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setColor(ContextCompat.getColor(context,R.color.colorPrimary))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(largeIcon(context,R.mipmap.ic_launcher_round))
                .setContentTitle(context.getString(R.string.app_name))
                .setContentText(context.getString(R.string.autolaunch_notification_content))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(context.getString(R.string.autolaunch_notification_content)))
                .setDefaults(NotificationCompat.DEFAULT_VIBRATE)
                .setFullScreenIntent(contentIntent(context),true) //Keeps the notification visible unless swiped away
                .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            notificationBuilder.setPriority(Notification.PRIORITY_HIGH);
        }

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(AUTOLAUNCH_NOTIFICATION_ID,notificationBuilder.build());
    }



   /*public static void showContinuousNotification(Context context)
    {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setColor(ContextCompat.getColor(context,R.color.colorPrimary))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(largeIcon(context,R.mipmap.ic_launcher_round))
                .setContentTitle(context.getString(R.string.app_name))
                .setContentText(context.getString(R.string.continuous_notification_content))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(context.getString(R.string.continuous_notification_content)))
                .setDefaults(NotificationCompat.DEFAULT_VIBRATE)
                .setContentIntent(contentIntent(context))
                .setOngoing(true)//Cannot dismiss by swipe
                .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            notificationBuilder.setPriority(Notification.PRIORITY_HIGH);
        }

        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(CONTINOUS_NOTIFICATION_ID,notificationBuilder.build());
    }*/

    /*public static void showActionNotification(Context context)
    {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setColor(ContextCompat.getColor(context,R.color.colorPrimary))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(largeIcon(context, R.mipmap.ic_launcher_round))
                .setContentTitle(context.getString(R.string.app_name))
                .setContentText(context.getString(R.string.action_notification_content))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(context.getString(R.string.action_notification_content)))
                .setDefaults(NotificationCompat.DEFAULT_VIBRATE)
                .addAction(openMessageNotification(context))
                .addAction(closeNotification(context))
                .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            notificationBuilder.setPriority(Notification.PRIORITY_HIGH);
        }


        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(ACTION_NOTIIFICATION_ID,notificationBuilder.build());
    }*/

    /*private static Action closeNotification(Context context)
    {
        Intent closeNotificationIntent = new Intent(context,NotificationReminderService.class);
        closeNotificationIntent.setAction(CLOSE_NOTIFICATION_ACTION);

        PendingIntent closeNotificationPendingIntent = PendingIntent.getService(
                context,
                ACTION_CLOSE_PENDINGINTENT_ID,
                closeNotificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        Action closeNotifcationAction = new Action(R.drawable.ic_close_24dp,"Close",closeNotificationPendingIntent);


        return closeNotifcationAction;
    }

    private static Action openMessageNotification(Context context)
    {
        Intent openNotificationIntent = new Intent(context,NotificationReminderService.class);
        openNotificationIntent.setAction(OPEN_MESSAGE_ACTION);
        PendingIntent openNotificationPendingIntent = PendingIntent.getService(
                context,
                ACTION_OPEN_PENDINGINTENT_ID,
                openNotificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        Action openNotifcationAction = new Action(R.drawable.ic_message_black_24dp,"Open",openNotificationPendingIntent);

        return openNotifcationAction;
    }*/


   //To create a pending intent for setContentIntent()
    private static PendingIntent contentIntent(Context context) {
        Intent startActivityIntent = new Intent(context, MainActivity.class);
        return PendingIntent.getActivity(
                context,
                PENDING_INTENT_ID,
                startActivityIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private static Bitmap largeIcon(Context context, int iconID) {
        Resources res = context.getResources();
        Bitmap largeIcon = BitmapFactory.decodeResource(res, iconID);
        return largeIcon;
    }

}
