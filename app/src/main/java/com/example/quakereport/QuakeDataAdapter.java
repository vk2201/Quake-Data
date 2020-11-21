package com.example.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuakeDataAdapter extends ArrayAdapter<quakeData> {

    private static final String LOCATION_SEPARATOR = " of ";

    private  String OriginalLocation , directionOffset , primaryLocation ;


    public QuakeDataAdapter(Activity Context , ArrayList<quakeData> quakeDataArrayList ){
        super(Context,0, quakeDataArrayList);

    }

    public int getMagnitudeColor( double magnitude )
    {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        Log.v("color value",String.valueOf(ContextCompat.getColor(getContext(), magnitudeColorResourceId)));
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
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
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        String magnitudeFormatted = magnitudeFormat.format(currData.getmMagnitude());
        currMag.setText(magnitudeFormatted);


         OriginalLocation = currData.getmLocation();

        if (OriginalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = OriginalLocation.split(LOCATION_SEPARATOR);
            directionOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }
        else {
            directionOffset = getContext().getString(R.string.near_the);
            primaryLocation = OriginalLocation;
        }

        TextView currDirectionOffset = (TextView) listView.findViewById( R.id.directionText );
        currDirectionOffset.setText( directionOffset );

        TextView currPrimaryLocation = (TextView) listView.findViewById(R.id.locationText);
        currPrimaryLocation.setText( primaryLocation );

        Date dateObject = new Date(currData.getmDateTime());

        SimpleDateFormat formatDate = new SimpleDateFormat("LLL dd,YYY");
        String date = formatDate.format(dateObject);

        SimpleDateFormat formatTime = new SimpleDateFormat("h:mm a");
        String time = formatTime.format(dateObject);

        TextView dateView = (TextView) listView.findViewById(R.id.dateText);
        dateView.setText(date);

        TextView timeView = (TextView) listView.findViewById(R.id.timeText);
        timeView.setText(time);


        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) currMag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currData.getmMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return listView;
    }
}
