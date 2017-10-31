package com.example.floura.smsmms;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText message,telp;
    Button send;
    int MY_REQUEST = 1;
    String sent = "SENT_SMS";
    String delivered = "SMS_DELEIEVERED";
    //
    PendingIntent si,di;
    BroadcastReceiver sentMs,deliverMs;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (EditText) findViewById(R.id.message);
        telp = (EditText) findViewById(R.id.telphone);
        send = (Button) findViewById(R.id.send);
        si = PendingIntent.getBroadcast(this,0,new Intent(sent),0);
        si = PendingIntent.getBroadcast(this,0,new Intent(delivered),0);
        send.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sentMs = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (getResultCode())
                {
                    case AppCompatActivity.RESULT_OK:
                        Toast.makeText(MainActivity.this,"Successful message sent",Toast.LENGTH_LONG).show();
                        break;
                    default:
                }
            }
        };

        deliverMs = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };

        registerReceiver(sentMs,new IntentFilter(sent));


    }


    @Override
    public void onClick(View v) {

//        using default messanger
        //intent.setType("vnd.android-dir/mms-sms");
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("smsto:"+Uri.encode(telp.getText().toString())));
//        intent.putExtra("sms_body",message.getText().toString());
//        startActivity(intent);

        /*
        receive - sms
        
        Bundle bundle = intent.getExtras();

        SmsMessage[] msgs = null;

        String str = "";

        if (bundle != null) {
            // Retrieve the SMS Messages received
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];

            // For every SMS message received
            for (int i=0; i < msgs.length; i++) {
                // Convert Object array
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                // Sender's phone number
                str += "SMS from " + msgs[i].getOriginatingAddress() + " : ";
                // Fetch the text message
                str += msgs[i].getMessageBody().toString();
                // Newline <img draggable="false" class="emoji" alt="🙂" src="https://s.w.org/images/core/emoji/72x72/1f642.png">
                str += "\n";
            }

            // Display the entire SMS Message
            Log.d(TAG, str);
         */

        String messageto = message.getText().toString();
        String telephone = telp.getText().toString();

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != (PackageManager.PERMISSION_GRANTED)){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.SEND_SMS},
                    MY_REQUEST);
        }
        else{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(telephone,null,messageto,si,di);
            Toast.makeText(this,messageto,Toast.LENGTH_LONG).show();
        }
    }
}
