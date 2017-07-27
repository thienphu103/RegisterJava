package com.ftravel.fpt.registerjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtUsename, edtPass, edtCPass, edtname, edtmail, edttelephone;
    Button btnOK, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kiemTrong(edtPass);
                kiemTrong(edtCPass);
                kiemTrong(edtname);
                kiemTrong(edtmail);
                kiemTrong(edttelephone);
                kiemPassSize(edtPass,edtCPass);
                kiemUserSize(edtUsename);


            }
        });

        clear();


    btnReset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Reset(edtUsename);
            Reset(edtPass);
            Reset(edtCPass);
            Reset(edtname);
            Reset(edtmail);
            Reset(edttelephone);
        }
    });

    clear();

}

    private void clear() {
        edtUsename.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(edtUsename.getText().toString().equals(R.string.trong)){
                    edtUsename.setText("");
                }
            }
        });
    }

    private void Anhxa() {
        edtUsename = (EditText) findViewById(R.id.editTextUsername);
        edtPass = (EditText) findViewById(R.id.editTextPassword);
        edtCPass = (EditText) findViewById(R.id.editTextConfirmPassword);
        edtname = (EditText) findViewById(R.id.editTextFullname);
        edttelephone = (EditText) findViewById(R.id.editTextTelephone);
        edtmail = (EditText) findViewById(R.id.editTextEmail);
        btnOK = (Button) findViewById(R.id.ButtonOK);
        btnReset = (Button) findViewById(R.id.ButtonReset);
    }
    private boolean kiemTrong(EditText ten){
        if (ten.getText().toString().trim().equals("")){
            ten.setError("Khong duoc de trong");
            return true;
        } else {
            return  false ;
        }
    }
    private boolean Reset(EditText ten){
        if (!(ten.getText().toString().trim().equals(""))){
            ten.setText("");
            return true;
        } else {
            return  false ;
        }
    }
    private boolean kiemPass(EditText ten,EditText ten1){
        if (!(ten.getText().toString().equals(ten1.getText().toString()))){
            ten1.setError("Password not match");
            return true;
        } else {
            return  false ;
        }
    }
    private boolean kiemPassSize(EditText ten,EditText ten1){
        if (ten.getText().toString().length()<16&&ten.getText().toString().length()<7) {
            ten.setError("Password have 8-15 characters");
            return true;
        } else if (ten1.getText().toString().length()<16&&ten1.getText().toString().length()<7) {
            ten1.setError("Password have 8-15 characters");
            return true;
        }

        else {
            return  false ;
        }
    }
    private boolean kiemUserSize(EditText ten){
        if (ten.getText().toString().isEmpty()) {
            ten.setError("Khong duoc de trong");
            return true;
        }
        if (ten.getText().toString().length()<13&&ten.getText().toString().length()<5) {
            ten.setError("UserName have 6-12 characters");
            return true;
        }
        else {
            return  false ;
        }
    }

}
