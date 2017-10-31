package com.example.floura.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
//long task - extend IntentService
public class MyService extends Service {
    public MyService() {
    }

    //bounded type service
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.i("mylog","onCreate in Service");
        super.onCreate();
    }

    //if overridding this then must stop also
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("mylog","onStartCommand in Service");
        //check the thread id
        Log.i("mylog","Thread in MyService: "+Thread.currentThread().getId());
        //after download close
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("mylog","onDestroy in Service");
        super.onDestroy();
    }
}
