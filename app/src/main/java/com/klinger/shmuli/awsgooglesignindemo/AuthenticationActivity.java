package com.klinger.shmuli.awsgooglesignindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.amazonaws.mobile.auth.ui.SignInUI;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.AWSStartupHandler;
import com.amazonaws.mobile.client.AWSStartupResult;

import static com.amazonaws.mobile.client.AWSMobileClient.*;

public class AuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);


        getInstance().initialize(this, new AWSStartupHandler() {
            @Override
            public void onComplete(AWSStartupResult awsStartupResult) {
                Log.d("YourMainActivity", "AWSMobileClient is instantiated and you are connected to AWS!");
                SignInUI signin = (SignInUI) AWSMobileClient.getInstance().getClient(AuthenticationActivity.this, SignInUI.class);
                signin.login(AuthenticationActivity.this, MainActivity.class).execute();
            }
        }).execute();
    }
}
