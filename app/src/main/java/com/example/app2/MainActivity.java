package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = findViewById(R.id.editTextTextPersonName2);
    }

    public void sendMessage(View view) {
        final Intent intent = new Intent();
        intent.setAction("com.pkg.perform.Ruby");
        String Msg = msg.getText().toString();
        intent.putExtra(Msg,1);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.setComponent(new ComponentName("com.pkg.app1", "com.pkg.app1.MainActivity"));
        sendBroadcast(intent);
    }
}
