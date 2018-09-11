package com.opustechinc.navigationdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Developer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        TextView emailFeedback = (TextView) findViewById(R.id.developer_email);
        emailFeedback.setText(Html.fromHtml("<a href=\"mailto:kathurimakimathi415@gmail.com \">Email: kathurimakimathi415@gmail.com</a"));
        emailFeedback.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
