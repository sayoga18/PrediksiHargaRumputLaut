package com.example.muhammad.prediksihargarumputlaut;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> items;

    public Adapter(Activity activity, List<Data> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);
        TextView id = (TextView) convertView.findViewById(R.id.txt_id);
        TextView moving = (TextView) convertView.findViewById(R.id.moving);
        TextView moving2 = (TextView) convertView.findViewById(R.id.moving2);
        TextView moving3 = (TextView) convertView.findViewById(R.id.moving3);
        TextView smoothing = (TextView) convertView.findViewById(R.id.smoothing);
        TextView smoothing2 = (TextView) convertView.findViewById(R.id.smoothing2);
        TextView smoothing3 = (TextView) convertView.findViewById(R.id.smoothing3);
        TextView naive = (TextView) convertView.findViewById(R.id.naive);
        TextView naive2 = (TextView) convertView.findViewById(R.id.naive2);
        TextView naive3 = (TextView) convertView.findViewById(R.id.naive3);

        Data data = items.get(position);
        id.setText(data.getId());
        moving.setText(data.getMoving());
        moving2.setText(data.getMoving2());
        moving3.setText(data.getMoving3());
        smoothing.setText(data.getSmoothing());
        smoothing2.setText(data.getSmoothing2());
        smoothing3.setText(data.getSmoothing3());
        naive.setText(data.getNaive());
        naive2.setText(data.getNaive2());
        naive3.setText(data.getNaive3());

        return convertView;
    }
}
