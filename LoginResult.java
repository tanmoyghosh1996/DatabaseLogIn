package com.example.tanmoy.database2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LoginResult extends AppCompatActivity {
    ListView listView;
    ArrayList<SetGet> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        DataBaseManager manage=new DataBaseManager(LoginResult.this);
        listView=(ListView)findViewById(R.id.listview);

        String email=getIntent().getExtras().getString("Data");
        arrayList=manage.getLoginData(email);
        listView.setAdapter(new CustomAdapter());
    }

    public class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv_id, tv_name, tv_email, tv_phone;

            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.show_login_result_layout,parent,false);
            tv_id=(TextView) view.findViewById(R.id.tv_id);
            tv_name=(TextView) view.findViewById(R.id.tv_name);
            tv_email=(TextView) view.findViewById(R.id.tv_email);
            tv_phone=(TextView) view.findViewById(R.id.tv_phone);

            tv_id.setText(arrayList.get(position).getEmployeeid());
            tv_name.setText(arrayList.get(position).getEmployeename());
            tv_email.setText(arrayList.get(position).getEmpployeemail());
            tv_phone.setText(arrayList.get(position).getEmployeephone());
            return view;
        }

    }
}
