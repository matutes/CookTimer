package com.eno.nael.cooktimer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactUsActivity extends AppCompatActivity {

    private Button sendBn;


    private EditText nameText;
    private EditText subjText2;
    private EditText messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        sendBn = findViewById(R.id.sendBn);

        nameText = findViewById(R.id.nameText);
        subjText2 = findViewById(R.id.subjText2);

        messageText = findViewById(R.id.messageText);

        nameText.setFocusable(true);
        nameText.requestFocusFromTouch();
        sendBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });




    }
    public void sendMail(){

        String[] mmail = {"naeleno@gmail.com"};

        String subject = subjText2.getText().toString();
        String name = nameText.getText().toString();
        String message = messageText.getText().toString();

        if(subject.equals("")||name.equals("")||message.equals("")){

            Toast.makeText(this, "Pleas fill first", Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL,mmail);
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,  message + "\n" + "\n" + name  );
            intent.setType("message/rfc822");

            startActivity(Intent.createChooser(intent,"Choose an App to send your message"));
        }


    }
}
