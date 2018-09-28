package com.klinger.shmuli.awsgooglesignindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amazonaws.mobile.auth.core.IdentityManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button signOutButton = (Button)findViewById(R.id.signout_button);

        signOutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                IdentityManager.getDefaultIdentityManager().signOut();
                Intent intent = new Intent(getApplicationContext(), AuthenticationActivity.class);
                startActivity(intent);
            }
        });
    }
}
