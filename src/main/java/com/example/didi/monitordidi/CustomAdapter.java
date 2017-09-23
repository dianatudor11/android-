package com.example.didi.monitordidi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Didi on 14.06.2017.
 */
public class CustomAdapter extends ArrayAdapter<Monitor> {
    public CustomAdapter(@NonNull Context context, ArrayList<Monitor> resource) {
        super(context, R.layout.monitor_layout,resource);}

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.monitor_layout, parent, false);

        Monitor monitor = getItem(position);

        TextView serviceNumberCustom = (TextView) customView.findViewById(R.id.serviceNumberCusto);
        TextView producerCustom = (TextView) customView.findViewById(R.id.producerCustom);
        TextView diagonalCustom = (TextView) customView.findViewById(R.id.diagonalCustom);
        TextView ownerCustom = (TextView) customView.findViewById(R.id.ownerCustom);
        TextView serviceDate = (TextView) customView.findViewById(R.id.serviceDateCustom);

        serviceNumberCustom.setText(String.valueOf(monitor.getServiceNumber()));
        producerCustom.setText(monitor.getProducer());
        diagonalCustom.setText(String.valueOf(monitor.getDiagonal()));
        ownerCustom.setText(monitor.getOwner());
        serviceDate.setText(monitor.getServiceDate().toString());

        return customView;

    }
}
