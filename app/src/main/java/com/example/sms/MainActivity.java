package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
EditText number, msg;
Button send, call;
TextView dev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number=findViewById(R.id.number);
        msg=findViewById(R.id.message);
        send=findViewById(R.id.sms);
        call=findViewById(R.id.call);
        dev=findViewById(R.id.developer);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=number.getText().toString();
                String m=msg.getText().toString();

                if (n.equals("")){
                    number.setError("Please Enter the number");
                } else if (m.equals("")) {
                    msg.setError("Please Enter the Message");
                }
                else {
                    SmsManager sms=SmsManager.getDefault();
                    sms.sendTextMessage(n,null, m, null, null);
                    Toast.makeText(MainActivity.this, "Message Successfully send to : " + n, Toast.LENGTH_SHORT).show();
                }
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=number.getText().toString();

                if (n.equals("")){
                    number.setError("Please Enter the Contact Number");
                }
                else {
                    Intent i=new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel: "+n));
                    startActivity(i);
                }
            }
        });

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:9108553983"));
                startActivity(i);
            }
        });
    }
}