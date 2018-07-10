package program.peggy.action;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DbTable {
    private String SQLiteTable_Name; //資料表的名字
    private String CREATE_TABLE;

    public DbTable(String table_name,String create_table_string) {
        SQLiteTable_Name=table_name;
        CREATE_TABLE=create_table_string;
        OpenOrCreateDateTable();
    }

    public static void OpenOrCreateDataBase(){
        try{
            MyApplication.db= MyApplication.getInstance().openOrCreateDatabase(MyApplication.SQLiteDB_Path,MyApplication.getInstance().MODE_PRIVATE,null);
            Log.v(MyApplication.SQLiteDB_Path,"載入成功");
        }catch (Exception ex){
            Log.e(MyApplication.SQLiteDB_Path,"載入錯誤");
        }
    }

    //打開或新增資料表
    public void OpenOrCreateDateTable(){
        try{
            MyApplication.db.execSQL(CREATE_TABLE);
            Log.v(SQLiteTable_Name,"建立或開啟成功");
        }catch (Exception ex){
            Log.e(SQLiteTable_Name,"建立或開啟錯誤");
        }
    }

    public void InsertData(ContentValues row){ //不用第一的ID
        try {
            MyApplication.db.insert(SQLiteTable_Name, null, row);
            Log.v(SQLiteTable_Name, "新增一筆資料");
        } catch (Exception e){
            Log.e(SQLiteTable_Name, "新增資料失敗");
        }
    }

    public void InsertData(ContentValues row,String informationString){ //不用第一的ID
        try {
            MyApplication.db.insert(SQLiteTable_Name, null, row);
            Log.v(SQLiteTable_Name, "新增一筆資料（"+informationString+"）");
        } catch (Exception e){
            Log.e(SQLiteTable_Name, "新增資料失敗（"+informationString+"）");
        }
    }

    public void UpdateData(ContentValues row,int id){
        try {
            MyApplication.db.update(SQLiteTable_Name, row, "_id=" + id, null);
            Log.v(SQLiteTable_Name, "更新一筆資料");
        } catch (Exception e) {
            Log.e(SQLiteTable_Name, "更新資料失敗");
        }
    }

    public void UpdateData(ContentValues row,int id,String informationString){
        try {
            MyApplication.db.update(SQLiteTable_Name, row, "_id=" + id, null);
            Log.v(SQLiteTable_Name, "更新一筆資料（"+informationString+"）");
        } catch (Exception e) {
            Log.e(SQLiteTable_Name, "更新資料失敗（"+informationString+"）");
        }
    }

    public void DeleteData(int id) {
        try {
            MyApplication.db.delete(SQLiteTable_Name, "_id=" + id, null);
            Log.v(SQLiteTable_Name, "刪除一筆資料");
        } catch (Exception ex) {
            Log.e(SQLiteTable_Name, "刪除資料失敗");
        }
    }

    public void DeleteData(int id,String informationString) {
        try {
            MyApplication.db.delete(SQLiteTable_Name, "_id=" + id, null);
            Log.v(SQLiteTable_Name, "刪除一筆資料（"+informationString+"）");
        } catch (Exception ex) {
            Log.e(SQLiteTable_Name, "刪除資料失敗（"+informationString+"）");
        }
    }

    public Cursor getCursor(){
        return getCursor(String.format("SELECT *  FROM '%s'",SQLiteTable_Name));
    }

    public Cursor getCursorById(int id){
        return getCursor(String.format("SELECT *  FROM '%s' WHERE _id = "+id,SQLiteTable_Name));
    }

    public Cursor getCursorByWHERE(String Where_string){
        return getCursor(String.format("SELECT *  FROM '%s' WHERE %s",SQLiteTable_Name,Where_string));
    }

    public Cursor getCursorBySTRING(String Cmd_string){
        return getCursor(String.format("SELECT *  FROM '%s' %s",SQLiteTable_Name,Cmd_string));
    }

    private Cursor getCursor(String cmd){
        Log.v(SQLiteTable_Name+"查詢",cmd);
        Cursor cursor=MyApplication.db.rawQuery(cmd,null);
        cursor.moveToFirst();
        return cursor;
    }

    public void deleteAllRow(){
        MyApplication.db.execSQL("DELETE FROM "+SQLiteTable_Name);
        Log.v(SQLiteTable_Name, "刪除全部資料");
    }
}
