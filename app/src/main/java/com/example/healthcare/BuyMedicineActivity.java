package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Uprise-D3 1000IU Capsule","","","", "50"},
            {"HealthVit Chromium Picolinate 200mcg Capsule", "Vitamin B Complex Capsules", "", "","", "448"},
            {"Inlife Vitamin E Wheat Germ Oil Capsule", "Dolo 650 Tablet", "","","", "30"},
            {"Crocin 650 Advance Tablet", "","","", "50"},
            {"Strepsils Medicated Lozenges for Sore Throat","","","","343"},
            {"Tata 1mg Calcium + Vitamin D3","","","","343"},
            {"Feronia -XT Tablet","","","", "130"}
    };

    private String[] package_details = {
            "Uprise-D3 1000IU Capsule:\n- Helps in building and keeping the bones & teeth strong\n- Reduces fatigue/stress and muscular pains\n- Boosts immunity and increases resistance against infection",

            "HealthVit Chromium Picolinate 200mcg Capsule:\n- Chromium is an essential trace mineral that helps regulate insulin\n- Provides relief from vitamin B deficiencies\n- Helps in the formation of red blood cells\n- Maintains a healthy nervous system",

            "Inlife Vitamin E Wheat Germ Oil Capsule:\n- Promotes skin health and reduces skin blemishes and pigmentation\n- Protects the skin from UVA and UVB sun rays",

            "Dolo 650 Tablet:\n- Helps relieve pain and fever by blocking the release of certain chemicals\n- Suitable for people with heart conditions or high blood pressure",

            "Crocin 650 Advance Tablet:\n- Helps relieve fever and reduce a high temperature\n- Suitable for people with heart conditions or high blood pressure",

            "Strepsils Medicated Lozenges for Sore Throat:\n- Provides relief from the symptoms of a bacterial throat infection\n- Soothes the throat during the recovery process",

            "Tata 1mg Calcium + Vitamin D3:\n- Reduces the risk of calcium deficiency, Rickets, and Osteoporosis\n- Promotes mobility and flexibility of joints",

            "Feronia -XT Tablet:\n- Helps reduce iron deficiency due to chronic blood loss or low iron intake"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.BMClistViewCart);
        btnBack = findViewById(R.id.BMCDbuttonDDBack2Cart);
        btnGoToCart = findViewById(R.id.BMCDbuttonCheckoutCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicneActivity.class));
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] { "line1", "line2", "line3", "line4", "line5" },
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}