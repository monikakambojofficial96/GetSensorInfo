package com.example.ssnsorsifo;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView ;
    SensorManager sensorManager ;
    List<Sensor> listsensor;
    List<String> liststring ;
    ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview1);

        liststring = new ArrayList<String> ();

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        listsensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for(int i=0; i<listsensor.size(); i++){

            liststring.add(listsensor.get(i).getName());
        }

        adapter = new ArrayAdapter<String> (MainActivity.this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1, liststring
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView <?> parent , View view , int position , long id) {

                Intent sensorintent=new Intent ( MainActivity.this, SensorActivity.class );

                sensorintent.putExtra ( "sensorname" ,listsensor.get(position).getName () );
                sensorintent.putExtra ( "sensorType" ,listsensor.get(position).getType () );
                sensorintent.putExtra ( "sensorVesion" ,listsensor.get(position).getVendor () );
                sensorintent.putExtra ( "sensorPosition" ,listsensor.get(position).getVersion () );
                sensorintent.putExtra ( "sensorMaxvalue" ,listsensor.get(position).getMaximumRange () );
                sensorintent.putExtra ( "sensorResolution" ,listsensor.get(position).getResolution () );
                sensorintent.putExtra ( "sensorMindelay" ,listsensor.get(position).getMinDelay () );
                sensorintent.putExtra ( "sensorpower" ,listsensor.get(position).getPower () );

                startActivity ( sensorintent );

            }
        } );


    }
}
