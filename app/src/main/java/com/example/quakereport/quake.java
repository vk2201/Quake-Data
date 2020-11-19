  package com.example.quakereport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewCompat;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class quake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quake);

        ArrayList<quakeData> quakeDataArrayList = new ArrayList<quakeData>();
        quakeDataArrayList.add( new quakeData("7","xyz","3 oct,12.00"));
        quakeDataArrayList.add(new quakeData("4.5","ytr","5 oct,12.00"));

        QuakeDataAdapter adapter = new QuakeDataAdapter(this,quakeDataArrayList);

        ListView listView = (ListView) findViewById(R.id.quakeDataList) ;

        listView.setAdapter(adapter);

    }
}