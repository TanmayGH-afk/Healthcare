package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername,edEmail, edPassword, edConfirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.AppName);
        edPassword = findViewById(R.id.AppContact);
        edEmail = findViewById(R.id.AppAddress);
        edConfirm = findViewById(R.id.ConstFee);
        btn = findViewById(R.id.BookAppButton);
        tv = findViewById(R.id.AlreadyHaveAnAccount);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(),"healthcare", null,1);
                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || confirm.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirm) == 0) {
                        if (isValid(password)) {
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(),"Thank you for registering", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Password must contain atleast 8 characters", Toast.LENGTH_SHORT).show();                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Password and confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
        public static boolean isValid(String password){
            int f1=0,f2=0,f3=0;
            if(password.length()<8){
                return false;
            }else {
                for(int p=0;p< password.length();p++){
                    if(Character.isLetter(password.charAt(p))){
                        f1=1;
                    }
                }
                for(int r=0;r< password.length(); r++){
                    if(Character.isDigit(password.charAt(r))){
                        f2=1;
                    }
                }
                for(int s=0;s<password.length();s++){
                    char c = password.charAt(s);
                    if(c>=33&&c<=46||c==64){
                        f3=1;
                    }
                }
                if(f1==1 && f2==1 && f3==1)
                    return true;
                return false;
            }
        }
    }