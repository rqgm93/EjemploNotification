package com.raquel.garvi.ejemplonotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationReceiver extends BroadcastReceiver {
    private static final String TAG = "Notify";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive ejecutado"); // Asegúrate de que este log se muestra en el Logcat
        // Construye la notificación
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,
                "daily_reminder_channel")
                .setSmallIcon(R.drawable.notification_icon) // Icono de la notificación
                .setContentTitle("Recordatorio Diario") // Título de la notificación
                .setContentText("¡Hora de tu recordatorio diario!") // Texto de la notificación
                .setPriority(NotificationCompat.PRIORITY_DEFAULT) // Prioridad de la notificación
                .setAutoCancel(true); // La notificación se cancela al tocarla

        // Muestra la notificación
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        if (ActivityCompat.checkSelfPermission(context,
            android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManager.notify(1, builder.build());
        Log.d(TAG, "Notificación enviada");
    }
}
