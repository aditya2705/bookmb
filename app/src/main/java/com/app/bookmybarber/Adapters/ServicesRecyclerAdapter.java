package com.app.bookmybarber.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.app.bookmybarber.R;
import com.app.bookmybarber.objects.ServiceItemObject;

import java.util.ArrayList;


public class ServicesRecyclerAdapter extends RecyclerView.Adapter<ServiceItemViewHolder> {

    private Context context;
    private ArrayList<ServiceItemObject> customObjectArrayList;

    public ServicesRecyclerAdapter(Context context, ArrayList<ServiceItemObject> customObjectArrayList) {
        this.context = context;
        this.customObjectArrayList = customObjectArrayList;
    }

    @Override
    public ServiceItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_item_layout, parent, false);
        ServiceItemViewHolder customViewHolder = new ServiceItemViewHolder(v);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(ServiceItemViewHolder holder, int position) {
        ServiceItemObject customObject = customObjectArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return customObjectArrayList.size();
    }
}

class ServiceItemViewHolder extends RecyclerView.ViewHolder {


    public ServiceItemViewHolder(View itemView) {
        super(itemView);
    }
}



