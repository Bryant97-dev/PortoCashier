package com.uc.portocashier;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Output;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputLayout;
import com.uc.portocashier.model.SimpanData;
import com.uc.portocashier.model.User;

public class AddUserActivity<dialog> extends AppCompatActivity {
    TextInputLayout fname, age, address,total;
    Button button;
    private String Name, Age, Address,totals;
    TextView outputtotal;
    Dialog dialog;
    String test;
    //Spinner sp;
   private static int diskon;


    //public final static String total_beli = ("com.uc.uts_protech.total_beli");

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        dialog= SimpanData.loadingDialog(AddUserActivity. this);
        fname = findViewById(R.id.input_fname);
        age = findViewById(R.id.input_age);
        address= findViewById(R.id.input_address);
        button = findViewById(R.id.check_button);
        total = (TextInputLayout) findViewById(R.id.input_pay);

       // outputtotal =findViewById(R.id.input_total_harga);


        Toolbar toolbar2 = findViewById(R.id.toolbar_add_user);

        //setSupportActionBar(toolbar2);
      // getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        fname.getEditText().addTextChangedListener(textwacther);
        age.getEditText().addTextChangedListener(textwacther);
        address.getEditText().addTextChangedListener(textwacther);
        total.getEditText().addTextChangedListener(textwacther);



        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {
                dialog.show();
                    new Handler().postDelayed(new Runnable() {
                     @Override
                      public void run() {
                         Intent intent = new Intent(AddUserActivity.this, HomeActivity.class);
                         dialog.cancel();

                         int a1 = Integer.parseInt(Age);
                         if(totals.equalsIgnoreCase("grabfood")){
                             diskon = a1*30/100;
                         }else if(totals.equalsIgnoreCase("gofood")){
                             diskon = a1*20/100;
                         }
                        // int a2 =Integer.parseInt(totals);
                         int harga = a1-diskon ;
                         test =String.valueOf(harga);
                         Output output = new Output(test);
                         User user = new User(Name, test, Address);
                         SimpanData.list.add(user);
                         intent.putExtra("user", user);
                         intent.putExtra("total beli", test);
                         intent.putExtra("pembeli", Address);
                         ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation( AddUserActivity. this);
                         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                         startActivity(intent,options.toBundle());
                         finish();
                       }
                    }, 2000);
            }
        });

        toolbar2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                onBackPressed();
            }
        });

    }

    TextWatcher textwacther = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Name = fname.getEditText().getText().toString().trim();
            Age = age.getEditText().getText().toString().trim();
            Address = address.getEditText().getText().toString().trim();
            totals = total.getEditText().getText().toString().trim();

            /*outputtotal.setText((Integer.parseInt(age.toString())*100).toString());
            int a2 = Integer.parseInt(total.toString());
            //int harga = a1+a2;
            if(a1 != 0){
                outputtotal.setVisibility(View.INVISIBLE);
            }else{
                outputtotal.setVisibility(View.VISIBLE);
                outputtotal.setText(String.valueOf(a1+a2));
            }*/




            button.setEnabled(!Name.isEmpty() && !Age.isEmpty() && !Address.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {


        }
    };
}
