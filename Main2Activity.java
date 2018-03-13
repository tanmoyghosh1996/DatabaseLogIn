package com.example.sudipta.d_lo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity
{
    ListView listView;
    ArrayList<SetGet> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DbManager manage=new DbManager(Main2Activity.this);
        listView=(ListView)findViewById(R.id.listview);

        String email=getIntent().getExtras().getString("Data");

        arrayList=manage.getData(email);
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

            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.list_row,parent,false);
            TextView name=(TextView)view.findViewById(R.id.tv1);
            TextView email=(TextView)view.findViewById(R.id.tv2);
            TextView pass=(TextView)view.findViewById(R.id.tv5);
            TextView phone=(TextView)view.findViewById(R.id.tv3);
            TextView empid=(TextView)view.findViewById(R.id.tv4) ;

            name.setText(arrayList.get(position).getEmpname());
            pass.setText(arrayList.get(position).getPassword());
            email.setText(arrayList.get(position).getEmpmail());
            empid.setText(arrayList.get(position).getEmpid());

            return view;
        }
    }
}
