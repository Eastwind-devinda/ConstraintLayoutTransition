package com.eastwind.devinda.constraint_ui_animate;

import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.animation.AnticipateOvershootInterpolator;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                init();
            }
        }, 1000);

    }

    private void init() {
        ConstraintLayout mConstraintLayout = (ConstraintLayout) findViewById(R.id.first);

        Transition transition = new ChangeBounds();
        transition.setInterpolator(new AnticipateOvershootInterpolator(2.0f));
        transition.setDuration(500);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.detail);

        TransitionManager.beginDelayedTransition(mConstraintLayout, transition);

        constraintSet.applyTo(mConstraintLayout);
    }
}
