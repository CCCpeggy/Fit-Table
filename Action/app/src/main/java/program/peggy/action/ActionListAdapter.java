package program.peggy.action;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ActionListAdapter extends SimpleCursorAdapter {
    private Context mContext;
    private Context appContext;
    private int layout;
    private Cursor cr;
    //private final LayoutInflater inflater;
    int[] to;


    static class ViewHolder{
        LinearLayout rlBorder;
        TextView Name;
    }

    public ActionListAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
        this.layout = layout;
        this.mContext=context;
        //this.inflater=LayoutInflater.from(context);
        this.cr=c;
        Log.v("1243","");
        this.to=to;
    }

    @Override
    public void bindView(View view,Context context,Cursor cursor){
        super.bindView(view, context, cursor);
        TextView Name=view.findViewById(to[0]);
        TextView Part=view.findViewById(to[1]);

        int Name_col =cursor.getColumnIndexOrThrow(ActionClass.ActionName_ColName);
        int Part_col =cursor.getColumnIndexOrThrow(ActionClass.ActionPart_ColName);

        Log.v("123","");
        Name.setText(cr.getString(Name_col));
        Part.setText(MyApplication.getActionPart( cr.getInt(Part_col)));
    }
/*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //當ListView被拖拉時會不斷觸發getView，為了避免重複加載必須加上這個判斷
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.style_listview, null);
            holder.Name = (TextView) convertView.findViewById(R.id.tvName);

            holder.rlBorder = (LinearLayout) convertView.findViewById(R.id.llBorder);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        convertView.setBackgroundResource(R.drawable.default_selector);
        return convertView;
    }*/

}
