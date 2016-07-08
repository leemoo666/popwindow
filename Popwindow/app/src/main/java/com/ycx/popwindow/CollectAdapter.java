package com.ycx.popwindow;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lixiaoming on 16/4/12.
 */
public class CollectAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> list = new ArrayList<>();

    private ViewHolder holder; //提问

    public CollectAdapter(Context context) {
        this.context = context;
    }

    public void setList(ArrayList<String> lists) {
        list = lists;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_collect, parent, false);
            holder = new ViewHolder();
            holder.tvTitleMyCollect = (TextView) convertView.findViewById(R.id.tvItemCollect);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                int location[] = new int[2];
                v.getLocationOnScreen(location);
                SelectPopWindow popWindow = new SelectPopWindow(context,null);
                popWindow.showAtLocation(v,Gravity.NO_GRAVITY,getDeviceWidth(context) / 2 - popWindow.getMeasureWidth() / 2,location[1]);
                return true;
            }
        });

        holder.tvTitleMyCollect.setText(list.get(position));

        return convertView;
    }

    private static class ViewHolder {

        TextView tvTitleMyCollect;

    }

    /*
  * 获取屏幕宽度
  * **/
    public static int getDeviceWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        return wm.getDefaultDisplay().getWidth();
    }
}
