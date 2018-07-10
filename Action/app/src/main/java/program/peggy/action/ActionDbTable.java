package program.peggy.action;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by info on 2017/11/10.
 */

public class ActionDbTable extends DbTable{
    public final static  String SQLiteTable_Name= "動作"; //資料表的名字
    public final static String CREATE_TABLE="CREATE TABLE if not exists '"+SQLiteTable_Name+"'(" +
            "_id INTEGER  PRIMARY KEY NOT NULL," +
            "'ActionName' TEXT NOT NULL," +
            "'ActionPart' INTEGER NOT NULL)";

    public ActionDbTable() {
        super(SQLiteTable_Name,CREATE_TABLE);
    }

    public void InsertData(String name,int part){ //不用第一的ID
        ContentValues row = new ContentValues();
        row.put(ActionClass.ActionName_ColName, name);
        row.put(ActionClass.ActionPart_ColName, part);
        String inform=String.format("%s=%s,%s=%s",ActionClass.ActionName_ColName, name,ActionClass.ActionPart_ColName, part);
        super.InsertData(row,inform);
    }

    public void AddTestData(){
        String[] Name={"臥推","A","B","C","D"};
        int[] Part={5,4,3,2,1};
        for(int i=0;i<Name.length;i++){
            InsertData(Name[i],Part[i]);
        }
    }


    public ActionClass getData(int id){
        Cursor cursor= super.getCursorById(id);
        ActionClass data=new ActionClass(cursor.getInt(0),cursor.getString(1),cursor.getInt(2));
        return data;
    }




}
