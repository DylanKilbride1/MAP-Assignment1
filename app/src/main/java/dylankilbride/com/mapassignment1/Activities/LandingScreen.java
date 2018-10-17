package dylankilbride.com.mapassignment1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dylankilbride.com.mapassignment1.R;

public class LandingScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

  Spinner spinner;
  int subscriptionType;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_landing_screen);
    spinner = (Spinner) findViewById(R.id.subscriptionSpinner);
    addItemsToSpinner();
    spinner.setOnItemSelectedListener(this);
  }

  public void addItemsToSpinner() {
    spinner = (Spinner) findViewById(R.id.subscriptionSpinner);
    List<String> list = new ArrayList<String>();
    list.add("Standard");
    list.add("Premium");
    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, list);
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(dataAdapter);
  }

  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    String item = parent.getItemAtPosition(position).toString();
    if (item.equals("Standard")) {
      subscriptionType = 1;
    } else {
      subscriptionType = 2;
    }
  }

  @Override
  public void onNothingSelected(AdapterView<?> adapterView) {
    Toast.makeText(this, "You must select a subscription type!",
        Toast.LENGTH_LONG).show();
  }

  public void validateCredentials(View view) {
    EditText emailEditText = (EditText) findViewById(R.id.emailTextFieldLoginScreen);
    EditText passwordEditText = (EditText) findViewById(R.id.passwordTextFieldLoginScreen);
    String emailToString = emailEditText.getText().toString();
    String passwordToString = passwordEditText.getText().toString();
    if ((checkEmail(emailToString) == true && checkPassword(passwordToString) == true) && subscriptionType == 1) {
      Intent intent = new Intent(LandingScreen.this, StandardSubscriptionActivity.class);
      intent.putExtra("email", emailToString);
      startActivity(intent);
    } else if ((checkEmail(emailToString) == true && checkPassword(passwordToString) == true) && subscriptionType == 2) {
      Intent intent = new Intent(LandingScreen.this, PremiumSubscriptionActivity.class);
      intent.putExtra("email", emailToString);
      startActivity(intent);
    }
    else {
      Toast.makeText(this, "Invalid Details!",
          Toast.LENGTH_LONG).show();
    }
  }

  public boolean checkEmail(String email) {
    String emailLowerCase = email.toLowerCase();
    if ((emailLowerCase.contains("@")
        && ((emailLowerCase.indexOf("@") != 0)
        && (!emailLowerCase.endsWith("@")))
        && (!email.contains(" ")))) {
      return true;
    } else return false;
  }

  public boolean checkPassword(String password) {
    if (!password.contains(" ")
        && password.length() >= 6) {
      return true;
    } else return false;
  }
}