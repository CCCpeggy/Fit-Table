package program.peggy.action;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;



public class ActionListAdapter extends SimpleCursorAdapter {
    private Context mContext;
    private Context appContext;
    private int layout;
    private Cursor cr;
    private final LayoutInflater inflater;
    String[] from;
    int[] to;

    static class ViewHolder{
        TextView Text1;
        TextView Text2;
    }

    public ActionListAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
        this.layout = layout;
        this.mContext=context;
        this.inflater=LayoutInflater.from(context);
        this.cr=c;
        this.from=from;
        this.to=to;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(layout, null);
            holder.Text1 = (TextView) convertView.findViewById(to[0]);
            holder.Text2 = (TextView) convertView.findViewById(to[1]);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        cr.moveToPosition(position);
        int Text1_colIndex =cr.getColumnIndexOrThrow(from[0]);
        int Text2_colIndex =cr.getColumnIndexOrThrow(from[1]);
        holder.Text1.setText(cr.getString(Text1_colIndex));
        holder.Text2.setText(MyApplication.getActionPart( cr.getInt(Text2_colIndex)));
        return convertView;
    }

}
