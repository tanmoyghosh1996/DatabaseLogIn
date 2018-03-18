package com.example.tanmoy.database2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by HP on 09-Mar-18.
 */

public class DataBaseManager extends SQLiteOpenHelper{

    public DataBaseManager(Context context) {
        super(context, "EmployeeDetails.DB",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table EmployeeDetails"+"(Employeeid integer primary key autoincrement, Employeename text, Employeepassword text, Empployeemail text, Employeephone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS EmployeeDetails");
        onCreate(db);
    }

    public boolean InsertData(String ename, String epassword, String eemail, String ephone) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Employeename", ename);
        contentValues.put("Employeepassword", epassword);
        contentValues.put("Empployeemail", eemail);
        contentValues.put("Employeephone", ephone);
        long sucess = -1;
        try {
            sucess = sqLiteDatabase.insert("EmployeeDetails", null, contentValues);

        } catch (Exception e) {
            e.printStackTrace();
            sucess = -1;
        }
        if (sucess > -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public ArrayList<SetGet> ShowData(){
        ArrayList<SetGet> arrayList= new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from EmployeeDetails",null );
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false) {
            SetGet setGet = new SetGet();
            setGet.setEmployeeid(cursor.getString(cursor.getColumnIndex("Employeeid")));
            setGet.setEmployeename(cursor.getString(cursor.getColumnIndex("Employeename")));
            setGet.setEmpployeemail(cursor.getString(cursor.getColumnIndex("Empployeemail")));
            setGet.setEmployeepassword(cursor.getString(cursor.getColumnIndex("Employeepassword")));
            setGet.setEmployeephone(cursor.getString(cursor.getColumnIndex("Employeephone")));

            arrayList.add(setGet);
            cursor.moveToNext();
        }
        cursor.close();
        return arrayList;
    }

    public boolean LoginData(String email, String password)
    {
        ArrayList<SetGet> arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query("EmployeeDetails", new String[]{"Employeeid"},"Empployeemail" + " = ?" + " AND " + "Employeepassword" + " = ?", new String[]{email, password},null,null,null);
        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0)
        {
            return true;
        }

        return false;
    }

    public ArrayList<SetGet> getLoginData(String email)
    {
        ArrayList<SetGet> arrayList=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("EmployeeDetails", new String[]{"Employeeid", "Employeename", "Empployeemail", "Employeepassword","Employeephone"},"Empployeemail" + "=?", new String[]{email},null, null, null);
        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            SetGet setGet=new SetGet();
            setGet.setEmployeeid(cursor.getString(cursor.getColumnIndex("Employeeid")));
            setGet.setEmployeename(cursor.getString(cursor.getColumnIndex("Employeename")));
            setGet.setEmpployeemail(cursor.getString(cursor.getColumnIndex("Empployeemail")));
            setGet.setEmployeepassword(cursor.getString(cursor.getColumnIndex("Employeepassword")));
            setGet.setEmployeephone(cursor.getString(cursor.getColumnIndex("Employeephone")));

            arrayList.add(setGet);
            cursor.moveToNext();
        }

        cursor.close();
        return arrayList;

    }
}
