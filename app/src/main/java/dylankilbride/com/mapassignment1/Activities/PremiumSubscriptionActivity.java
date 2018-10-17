package dylankilbride.com.mapassignment1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dylankilbride.com.mapassignment1.R;

public class PremiumSubscriptionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

  Spinner monthSpinner, dateSpinner;
  EditText cardHolderEmail;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_premium_subscription);

    Intent intent = getIntent();
    String email = intent.getStringExtra("email");
    cardHolderEmail = (EditText) findViewById(R.id.cardHolderEmail);
    cardHolderEmail.setText(email);

    monthSpinner = (Spinner) findViewById(R.id.cardMonthSpinner);
    dateSpinner = (Spinner) findViewById(R.id.cardDateSpinner);

    addItemsToMonthSpinner();
    addItemsToDateSpinner();

    monthSpinner.setOnItemSelectedListener(this);
    dateSpinner.setOnItemSelectedListener(this);
  }

  public void addItemsToMonthSpinner() {
    monthSpinner = (Spinner) findViewById(R.id.cardMonthSpinner);
    List<String> list = new ArrayList<String>();
    list.add("January");
    list.add("February");
    list.add("March");
    list.add("April");
    list.add("May");
    list.add("June");
    list.add("July");
    list.add("August");
    list.add("September");
    list.add("October");
    list.add("November");
    list.add("December");
    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, list);
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    monthSpinner.setAdapter(dataAdapter);
  }

  public void addItemsToDateSpinner() {
    dateSpinner = (Spinner) findViewById(R.id.cardDateSpinner );
    List<String> list = new ArrayList<String>();
    list.add("01");
    list.add("02");
    list.add("03");
    list.add("05");
    list.add("06");
    list.add("07");
    list.add("08");
    list.add("09");
    list.add("10");
    list.add("11");
    list.add("11");
    list.add("12");
    list.add("13");
    list.add("14");
    list.add("15");
    list.add("16");
    list.add("17");
    list.add("18");
    list.add("19");
    list.add("20");
    list.add("21");
    list.add("22");
    list.add("23");
    list.add("24");
    list.add("25");
    list.add("26");
    list.add("27");
    list.add("28");
    list.add("29");
    list.add("30");
    list.add("31");

    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, list);
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    dateSpinner.setAdapter(dataAdapter);
  }

  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    String item = parent.getItemAtPosition(position).toString();
  }

  @Override
  public void onNothingSelected(AdapterView<?> adapterView) {
  }
}
