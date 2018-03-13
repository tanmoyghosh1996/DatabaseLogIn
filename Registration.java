package com.example.sudipta.d_lo;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText password;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name=(EditText)findViewById(R.id.et_name);
        //Log.i("Nme------------"+name)
        email=(EditText)findViewById(R.id.et_email);
        password=(EditText)findViewById(R.id.et_password);
        save=(Button)findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1 =name.getText().toString();
                String email1 = email.getText().toString();
                String password1 =  password.getText().toString();
                DbManager dbManager = new DbManager(Registration.this);
                boolean res =dbManager.Insertdata(name1,email1,password1);
                if (res==true){

                    Toast.makeText(getApplicationContext(),"sucess",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                }
                else {

                    Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_LONG).show();

                }

            }
        });
    }

}
