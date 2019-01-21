package in.co.learncodeonline;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ConstraintSet constraintSet1 = new ConstraintSet();
    ConstraintSet constraintSet2 = new ConstraintSet();
    ConstraintLayout constraintLayout;
    MaterialButton login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = this;
        constraintSet2.clone(context,R.layout.activity_main_end);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.layout);
        constraintSet1.clone(constraintLayout);

        login = findViewById(R.id.login_button);
        signup = findViewById(R.id.signup_button);
        setColor("Login");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                constraintSet1.applyTo(constraintLayout);
                setColor("Login");
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                constraintSet2.applyTo(constraintLayout);
                setColor("Signup");
            }
        });
    }

    private void setColor(String text){
        switch (text) {
            case "Login":
                login.setElevation(6);
                login.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                login.setTextColor(getResources().getColor(R.color.colorBlueEnd));
                signup.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlueEnd)));
                signup.setTextColor(getResources().getColor(R.color.colorAccent));
                signup.setElevation(0);
                break;
            case "Signup":
                signup.setElevation(6);
                signup.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                signup.setTextColor(getResources().getColor(R.color.colorBlueEnd));
                login.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBlueEnd)));
                login.setTextColor(getResources().getColor(R.color.colorAccent));
                login.setElevation(0);
                break;

        }

    }
}
