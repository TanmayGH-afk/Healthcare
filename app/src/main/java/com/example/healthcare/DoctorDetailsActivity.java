package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {
            {"Doctor Name: John Morgan", "Hospital Address: Pimpri", "Exp: 10yrs", "Mobile No: 9330149124", "4040"},
            {"Doctor Name: Alice Johnson", "Hospital Address: Central Hospital", "Exp: 8yrs", "Mobile No: 9876543210", "2020"},
            {"Doctor Name: Emily Smith", "Hospital Address: Mercy Clinic", "Exp: 15yrs", "Mobile No: 8765432109", "5050"},
            {"Doctor Name: David Williams", "Hospital Address: City Health Center", "Exp: 12yrs", "Mobile No: 7890123456", "6060"},
            {"Doctor Name: Sarah Davis", "Hospital Address: Riverside Medical", "Exp: 7yrs", "Mobile No: 6543210987", "7070"}
    };

    private String[][] doctor_details2 = {
            {"Doctor Name: Rajesh Gupta", "Hospital Address: Apollo Hospital, Mumbai", "Exp: 10yrs", "Mobile No: 9330149124", "4040"},
            {"Doctor Name: Priya Sharma", "Hospital Address: AIIMS, Delhi", "Exp: 8yrs", "Mobile No: 9876543210", "2020"},
            {"Doctor Name: Sanjay Patel", "Hospital Address: Fortis Hospital, Bangalore", "Exp: 15yrs", "Mobile No: 8765432109", "5050"},
            {"Doctor Name: Deepa Verma", "Hospital Address: Medanta Hospital, Hyderabad", "Exp: 12yrs", "Mobile No: 7890123456", "6060"}
    };

    private String[][] doctor_details3 = {
            {"Doctor Name: Ananya Singh", "Hospital Address: Max Hospital, Delhi", "Exp: 7yrs", "Mobile No: 6543210987", "7070"},
            {"Doctor Name: Rohit Kumar", "Hospital Address: Columbia Asia, Pune", "Exp: 9yrs", "Mobile No: 9876543210", "8080"},
            {"Doctor Name: Aishwarya Reddy", "Hospital Address: Global Hospital, Chennai", "Exp: 11yrs", "Mobile No: 8765432109", "9090"},
            {"Doctor Name: Harish Joshi", "Hospital Address: Jaslok Hospital, Mumbai", "Exp: 14yrs", "Mobile No: 7890123456", "1010"}
    };

    private String[][] doctor_details4 = {
            {"Doctor Name: Neha Patel", "Hospital Address: Ruby Hall Clinic, Pune", "Exp: 10yrs", "Mobile No: 9330149124", "4040"},
            {"Doctor Name: Arjun Sharma", "Hospital Address: Wockhardt Hospital, Mumbai", "Exp: 8yrs", "Mobile No: 9876543210", "2020"}
    };

    private String[][] doctor_details5 = {
            {"Doctor Name: Pooja Verma", "Hospital Address: Apollo Hospitals, Hyderabad", "Exp: 15yrs", "Mobile No: 8765432109", "5050"},
            {"Doctor Name: Ravi Kumar", "Hospital Address: Narayana Health, Bangalore", "Exp: 12yrs", "Mobile No: 7890123456", "6060"}
    };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    ArrayList<HashMap<String,String>> list;
    SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.BMtitleCart);
        btn = findViewById(R.id.BMCDbuttonCheckoutCart);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
        if(title.compareTo("Cardilogist") == 0)
            doctor_details = doctor_details5;



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList<>();
        for(int i = 0;i<doctor_details.length;i++){
            HashMap<String, String> item = new HashMap<>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        simpleAdapter = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(simpleAdapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text1", doctor_details[i][0]);
                it.putExtra("text1", doctor_details[i][1]);
                it.putExtra("text1", doctor_details[i][2]);
                it.putExtra("text1", doctor_details[i][3]);
                startActivity(it);


            }
        });
    }
}