package com.example.ssnsorsifo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SensorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_sensor );

        TextView txname=findViewById ( R.id.sensorName );

        TextView txVersion=findViewById ( R.id.sensorVersion );

        TextView txVendor=findViewById ( R.id.sensorVendor );

        TextView txResolution=findViewById ( R.id.sensorResolution );

        TextView txMaxrange=findViewById ( R.id.sensorMaxRange );

        TextView txType=findViewById ( R.id.sensorType );

        TextView txMinDelay=findViewById ( R.id.sensorMindelay);

        TextView txPower=findViewById ( R.id.sensorPower );

        Bundle sensordetails=getIntent ().getExtras ();

        txname.setText ( "Name= " +sensordetails.get("sensorname") );
        txVersion.setText ( "Version= " +sensordetails.get("sensorVersion") );

        txVendor.setText ( "Vendor= " +sensordetails.get("sensorVendor") );

        txResolution.setText ( "Resolution= " +sensordetails.get("sensorResolution") );
        txMaxrange.setText ( "Maxtrange= " +sensordetails.get("sensorMaxvalue") );
        txType.setText ( "Type= " +sensordetails.get("sensorType") );
        txMinDelay.setText ( "MinDelay= " +sensordetails.get("sensorMindelay") );
        txPower.setText ( "Power= " +sensordetails.get("sensorpower") );





    }
}
