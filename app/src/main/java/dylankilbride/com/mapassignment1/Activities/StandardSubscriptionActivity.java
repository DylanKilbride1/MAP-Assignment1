package dylankilbride.com.mapassignment1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import dylankilbride.com.mapassignment1.R;

public class StandardSubscriptionActivity extends AppCompatActivity {

  TextView welcomeMsg;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_standard_subscription);
    Intent intent = getIntent();
    String email = intent.getStringExtra("email");
    welcomeMsg = (TextView) findViewById(R.id.standardActivityWelcomeMsg);
    welcomeMsg.setText("Your standard subscription account " + email +
        " has been successfully created");
  }
}
