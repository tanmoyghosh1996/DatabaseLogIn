package com.example.sudipta.d_lo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Show extends AppCompatActivity {

    ListView listView;
    ArrayList<SetGet> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        String email=getIntent().getExtras().getString("Email");

        DbManager manage=new DbManager(Show.this);
        listView=(ListView)findViewById(R.id.lv);


        /*arrayList=manage.findbyone(email);*/

        listView.setAdapter(new Customadapter());



    }

    public class Customadapter extends BaseAdapter{


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


            LayoutInflater  inflater =getLayoutInflater();
            View view=inflater.inflate(R.layout.activity_show,parent,false);


            return view;

        }
    }

}
