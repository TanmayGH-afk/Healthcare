package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicineBookActivityFF extends AppCompatActivity {
    EditText edname, edaddress, edcontact, edpincode;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book_ff);

        edname = findViewById(R.id.editTextFNBookCheckout);
        edaddress = findViewById(R.id.editTextAddressBookCheckout);
        edcontact = findViewById(R.id.editTextContactBookCheckout);
        edpincode = findViewById(R.id.editTextPincodeBookCheckout);
        btnBooking = findViewById(R.id.buttonBuyBookCheckout);

        Intent intent = getIntent();
        String price = intent.getStringExtra("price");
        String date = intent.getStringExtra("date");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username", "");

                // Assuming the "Database" class is properly defined
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                db.addOrder(username, edname.getText().toString(), edaddress.getText().toString(), edcontact.getText().toString(), edpincode.getText().toString(), date.toString(), "", Float.parseFloat(price[1].toString()), "medicine");
                db.removeCart(username, "medicine");

                Toast.makeText(getApplicationContext(), "Your booking is done successfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(BuyMedicineBookActivityFF.this, HomeActivity.class));
            }
        });
    }
}
