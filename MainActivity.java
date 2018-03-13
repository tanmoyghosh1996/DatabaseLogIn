package com.example.sudipta.d_lo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText email,password;
    Button log_in,sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=(EditText)findViewById(R.id.et_email);
        password=(EditText)findViewById(R.id.et_password);
        log_in=(Button)findViewById(R.id.log_in);
        sign_up=(Button)findViewById(R.id.sign_up);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             String email1=email.getText().toString();
             String password1=password.getText().toString();
             DbManager dbManager = new DbManager(MainActivity.this);
                boolean data=dbManager.Login(email1,password1);

                if (data==true)
                {
                    Toast.makeText(getApplicationContext(),"Login sucessful",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                    intent.putExtra("Data",email1);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Log in failed",Toast.LENGTH_LONG).show();
                }

                //ArrayList<SetGet> arrayList;
                //SetGet setGet =new SetGet();
               // arrayList =dbManager.Login(email1,password1);
               // String email23= setGet.getEmpmail();
                //Log.i("email .. " ,email23);


                //Boolean check =  dbManager.Login(email1,password1);
                /*if (arrayList.size()>0){


                    Toast.makeText(getApplicationContext(),"Sucess",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(getApplicationContext(),Show.class);
                    intent.putExtra("Email",email23);
                    startActivity(intent);


                   // Intent intent=new Intent(getApplicationContext(),UpdateActivity.class);
                   // intent.putExtra("Id",arrayList.get(position).getEmpid());

                }
          else {
                    Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_LONG).show();

                }*/


            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Registration.class);
                startActivity(intent);

            }
        });
    }





}
