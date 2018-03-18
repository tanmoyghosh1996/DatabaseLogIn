package com.example.tanmoy.database2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<SetGet> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        DataBaseManager manage=new DataBaseManager(ShowActivity.this);
        listView=(ListView)findViewById(R.id.listview);

        arrayList=manage.ShowData();
        listView.setAdapter(new CustomAdapter());
    }

    public class CustomAdapter extends BaseAdapter{

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

            TextView tv_id, tv_name,tv_password, tv_email,tv_phnno;
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.show_result,parent, false);
            tv_id = (TextView)view.findViewById(R.id.tv_id);
            tv_name = (TextView)view.findViewById(R.id.tv_name);
            tv_password = (TextView)view.findViewById(R.id.tv_password);
            tv_email = (TextView)view.findViewById(R.id.tv_email);
            tv_phnno = (TextView)view.findViewById(R.id.tv_phnno);

            tv_id.setText(arrayList.get(position).getEmployeeid());
            tv_name.setText(arrayList.get(position).getEmployeename());
            tv_password.setText(arrayList.get(position).getEmployeepassword());
            tv_email.setText(arrayList.get(position).getEmpployeemail());
            tv_phnno.setText(arrayList.get(position).getEmployeephone());
            return view;
        }
    }
}
