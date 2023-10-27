//package com.example.healthcare.ui.login;
//
//import android.app.Activity;
//
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProvider;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//
//import androidx.annotation.Nullable;
//import androidx.annotation.StringRes;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.KeyEvent;
//import android.view.View;
//import android.view.inputmethod.EditorInfo;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.healthcare.CheckOutCart;
//import com.example.healthcare.Database;
//import com.example.healthcare.HomeActivity;
//import com.example.healthcare.R;
//import com.example.healthcare.ui.login.LoginViewModel;
//import com.example.healthcare.ui.login.LoginViewModelFactory;
//import com.example.healthcare.databinding.ActivityBuyMedicineBookBinding;
//
//public class LoginActivity extends AppCompatActivity {
//
//    EditText edname, edaddress, edcontact, edpincode;
//    Button btnBooking;
//    Intent intent = getIntent();
//    String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
//    String date = intent.getStringExtra("date");
////    String time = intent.getStringExtra("time");
//
//        btnBooking.setOnClickListener(new View.OnClickListener()
//
//    {
//        @Override
//        public void onClick (View view){
//        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
//        String username = sharedPreferences.getString("username", "").toString();
//
//        Database db = new Database(getApplicationContext(), "healthcare", null, 1);
//        db.addOrder(username, edname.getText().toString(), edaddress.getText().toString(), edcontact.getText().toString(), Integer.parseInt(edpincode.getText().toString()), date.toString(), time.toString(), Float.parseFloat(price[1].toString()), "med");
//        db.removeCart(username, "lab");
//        Toast.makeText(getApplicationContext(), "Your booking is done successfully", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(CheckOutCart.this, HomeActivity.class));
//    }
//    });
//}
