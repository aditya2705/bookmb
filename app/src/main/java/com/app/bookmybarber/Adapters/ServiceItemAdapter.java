package com.app.bookmybarber.Adapters;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.bookmybarber.Objects.ServiceItem;
import com.app.bookmybarber.R;

/**
 *
 * @author Sumeet
 *
 */
public class ServiceItemAdapter extends ArrayAdapter<ServiceItem> {
    Context context;
    int layoutResourceId;
    ArrayList<ServiceItem> data = new ArrayList<ServiceItem>();

    public ServiceItemAdapter(Context context, int layoutResourceId,
                              ArrayList<ServiceItem> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ItemHolder();
            holder.serviceName = (TextView) row.findViewById(R.id.service_name);
            row.setTag(holder);
        } else {
            holder = (ItemHolder) row.getTag();
        }


        ServiceItem item = data.get(position);
        holder.serviceName.setText(item.getServiceName());

        return row;

    }

    static class ItemHolder {

        private TextView serviceName;

    }
}
