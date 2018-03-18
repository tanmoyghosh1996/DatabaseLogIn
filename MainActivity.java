package com.example.tanmoy.database2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_email,et_password;
    Button btn_login, btn_register,btn_show;
    DataBaseManager dataBaseManager = new DataBaseManager(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email=(EditText)findViewById(R.id.et_email);
        et_password=(EditText)findViewById(R.id.et_password);
        btn_register=(Button)findViewById(R.id.btn_register);
        btn_show=(Button)findViewById(R.id.btn_show);
        btn_login=(Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Usermail = et_email.getText().toString();
                String Password=  et_password.getText().toString();
                DataBaseManager manager=new DataBaseManager(MainActivity.this);
                boolean data=manager.LoginData(Usermail,Password);

                if (data==true)
                {
                    Toast.makeText(getApplicationContext(),"Login sucessful",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(getApplicationContext(),LoginResult.class);
                    intent.putExtra("Data",Usermail);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Log in failed",Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ShowActivity.class);
                startActivity(intent);
            }
        });

    }
}
