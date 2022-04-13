package com.del.higherlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText edtNumber;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.btn_submit);
        edtNumber = findViewById(R.id.edt_number);

        int tebak = randNumber();

        btnSubmit.setOnClickListener(view -> {
            try {
                int res = Integer.parseInt(edtNumber.getText().toString());
                cekRes(res, tebak);
            }catch (NumberFormatException e){
                msg = "Input can't be null or must be a integer";
            }finally{
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cekRes(int res, int tebak){
        if(res<tebak){
            msg = "Higher !!";
        }else if(res>tebak){
            msg = "Lower !!";
        }else{
            msg = "You got me !!";
        }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public int randNumber(){
        Random rn = new Random();
        return rn.nextInt(20)+1;
    }
}