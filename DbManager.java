package com.example.sudipta.d_lo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by root on 1/2/18.
 */

public class DbManager extends SQLiteOpenHelper {                          //A helper class to manage database creation and version management.
    public DbManager(Context context) {

        super(context,"Employee.DB",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Employee"+"(Empid integer primary key autoincrement,Empname text,Empmail text,passw0rd text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS Employee");
        onCreate(db);
    }
    public boolean Insertdata(String name,String email,String passw0rd)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues cv=new ContentValues();      //This class is used to store a set of values
        cv.put("Empname",name);
        cv.put("Empmail",email);
        cv.put("passw0rd",passw0rd);
        long sucess=-1;                      //return the row ID of the newly inserted row, or -1 if an error occurred
        try {
            sucess= database.insert("Employee", null, cv);    //public long insert(String table, String nullColumnHack, ContentValues values)

        }catch (Exception e)
        {
            e.printStackTrace();
            sucess=-1;
        }
        if(sucess>-1)
        {
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<SetGet> getAllData()
    {
        ArrayList<SetGet> arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from Employee",null);     //This interface provides random read-write access to the result set returned
        res.moveToFirst();                        //Move the cursor to the first row.

        while (res.isAfterLast()==false)
        {
            SetGet setGet=new SetGet();
            setGet.setEmpid(res.getString(res.getColumnIndex("Empid")));
            setGet.setEmpname(res.getString(res.getColumnIndex("Empname")));
            setGet.setEmpmail(res.getString(res.getColumnIndex("Empmail")));
            setGet.setPassword(res.getString(res.getColumnIndex("passw0rd")));

            arrayList.add(setGet);
            res.moveToNext();   //Move the cursor to the next row.
        }
        res.close();
        return arrayList;
    }

    public boolean Login(String email,String password)
    {
        ArrayList<SetGet> arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query("Employee", new String[]{"Empid"},"Empmail" + " = ?" + " AND " + "passw0rd" + " = ?", new String[]{email, password},null,null,null);


        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0)
        {
            return true;
        }

        return false;
    }

    public ArrayList<SetGet> getData(String email)
    {
        ArrayList<SetGet> arrayList=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.query("Employee",
                new String[]{"Empid", "Empname", "Empmail", "passw0rd"},
                "Empmail" + "=?",
                new String[]{email},//Where clause
                null, null, null);

        if (res != null && res.moveToFirst()&& res.getCount()>0) {
            SetGet setGet=new SetGet();
            setGet.setEmpid(res.getString(res.getColumnIndex("Empid")));
            setGet.setPassword(res.getString(res.getColumnIndex("passw0rd")));
            setGet.setEmpname(res.getString(res.getColumnIndex("Empname")));
            setGet.setEmpmail(res.getString(res.getColumnIndex("Empmail")));

            arrayList.add(setGet);
            res.moveToNext();
        }

        res.close();
        return arrayList;

    }
}

