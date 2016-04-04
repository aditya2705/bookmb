package com.app.bookmybarber.adapters;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.bookmybarber.objects.ServiceItemObject;
import com.app.bookmybarber.R;

/**
 *
 * @author Sumeet
 *
 */
public class ServiceItemAdapter extends ArrayAdapter<ServiceItemObject> {
    Context context;
    int layoutResourceId;
    ArrayList<ServiceItemObject> data = new ArrayList<ServiceItemObject>();

    public ServiceItemAdapter(Context context, int layoutResourceId,
                              ArrayList<ServiceItemObject> data) {
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


        ServiceItemObject item = data.get(position);
        holder.serviceName.setText(item.getServiceName());

        return row;

    }

    static class ItemHolder {

        private TextView serviceName;

    }
}
