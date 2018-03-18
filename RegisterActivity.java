package com.example.tanmoy.database2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText et_name,et_password, et_email,et_phone;
    Button btn_bcktohome, btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name=(EditText)findViewById(R.id.et_name);
        et_password=(EditText)findViewById(R.id.et_password);
        et_email=(EditText)findViewById(R.id.et_email);
        et_phone=(EditText)findViewById(R.id.et_Phone);
        btn_save=(Button)findViewById(R.id.btn_save);
        btn_bcktohome=(Button)findViewById(R.id.btn_bcktohome);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et_name.getText().toString();
                String password = et_password.getText().toString();
                String email=et_email.getText().toString();
                String phone=et_phone.getText().toString();
                DataBaseManager dataBaseManager = new DataBaseManager(RegisterActivity.this);
                boolean result = dataBaseManager.InsertData(name,password, email, phone);
                if(result==true) {
                    Toast.makeText(getApplicationContext(),"Sucess",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_bcktohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
