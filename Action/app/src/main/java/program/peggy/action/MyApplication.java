package program.peggy.action;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

public class MyApplication extends Application {
    private static MyApplication mInstance;
    public static SQLiteDatabase db=null;
    public final static String SQLiteDB_Path="fitness_project.db";

    public static synchronized MyApplication getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        mInstance= this;
    }

    public static String getActionPart(int index){
        switch (index){
            case 1:
                return getInstance().getString(R.string.hand);
            case 2:
                return getInstance().getString(R.string.leg);
            case 3:
                return getInstance().getString(R.string.shoulder);
            case 4:
                return getInstance().getString(R.string.back);
            case 5:
                return getInstance().getString(R.string.chest);
            default:
                return null;
        }
    }

}
