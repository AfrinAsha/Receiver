package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView batteryTxt;
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context ctxt, Intent intent) {

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            batteryTxt.setText(String.valueOf(level) + "%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        batteryTxt = (TextView) this.findViewById(R.id.batteryTxt);
        this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        //



//        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
//        Intent batteryStatus = registerReceiver(null, ifilter);
//
//        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
//        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
//
//        float batteryPct = level / (float)scale;
//        int num = (int)(batteryPct*100);
//
//        Toast.makeText(this,"Battery is "+num+"percent",Toast.LENGTH_LONG).show();
    }
}


//public class Main extends Activity {
//  private TextView batteryTxt;
//  private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
//    @Override
//    public void onReceive(Context ctxt, Intent intent) {
//      int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
//      batteryTxt.setText(String.valueOf(level) + "%");
//    }
//  };
//
//  @Override
//  public void onCreate(Bundle b) {
//    super.onCreate(b);
//    setContentView(R.layout.main);
//    batteryTxt = (TextView) this.findViewById(R.id.batteryTxt);
//    this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
//  }
//}