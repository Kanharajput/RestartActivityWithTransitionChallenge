package com.example.transitionsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.transition.Fade;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // relauching the activity with transitions
    public void relaunchMainActivity(View view) {

        Explode explode = new Explode();
        getWindow().setEnterTransition(explode);
        getWindow().setExitTransition(explode);

        Intent intent = getIntent();
        finish();
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

    }

    public void relauchMainActivityFade(View view) {

        Fade fadeIn = new Fade(Fade.IN);
        Fade fadeOut = new Fade(Fade.OUT);
        getWindow().setExitTransition(fadeOut);
        getWindow().setEnterTransition(fadeIn);

        Intent intent = getIntent();        // get the intent which starts this activity
        finish();                        // finish the activity
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());        // again start activity with transition

    }

    public void rotateMe(View view) {
        // rotate the square
        ObjectAnimator rotation90 = ObjectAnimator.ofFloat(view,"rotation",90f,180f);
        rotation90.setDuration(2000);
        rotation90.start();

    }
}