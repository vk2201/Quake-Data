package com.example.quakereport;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuakeDataAdapter extends ArrayAdapter<quakeData> {

    public QuakeDataAdapter(Activity Context , ArrayList<quakeData> quakeDataArrayList ){
        super(Context,0, quakeDataArrayList);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;

        if(listView == null)
        {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        quakeData currData = getItem( position );

        TextView currMag = (TextView) listView.findViewById(R.id.magText);
        currMag.setText(currData.getmMagnitude());

        TextView currLocn = (TextView) listView.findViewById(R.id.locationText);
        currLocn.setText(currData.getmLocation());

        Date dateObject = new Date(currData.getmDateTime());

        SimpleDateFormat formatDate = new SimpleDateFormat("LLL dd,YYY");
        String date = formatDate.format(dateObject);

        SimpleDateFormat formatTime = new SimpleDateFormat("h:mm a");
        String time = formatTime.format(dateObject);

        TextView dateView = (TextView) listView.findViewById(R.id.dateText);
        dateView.setText(date);

        TextView timeView = (TextView) listView.findViewById(R.id.timeText);
        timeView.setText(time);

        return listView;
    }
}
