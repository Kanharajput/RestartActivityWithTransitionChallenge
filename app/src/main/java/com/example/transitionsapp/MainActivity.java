package com.example.transitionsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // don't need to add anything in theme it's already working fine
        // set the enter transition
        getWindow().setEnterTransition(new Explode());    // as we are relaunching this activity by itself

        // set the exit transition
        getWindow().setExitTransition(new Explode());

    }

    // relauching the activity with transitions
    public void relaunchMainActivity(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}