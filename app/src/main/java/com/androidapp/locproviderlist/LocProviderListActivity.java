package com.androidapp.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity implements View.OnClickListener{
    TextView mTextView;
    LocationManager locMgr;
    List<String> locProviders;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(this);
        locMgr =(LocationManager) getSystemService(LOCATION_SERVICE);   //만드는게 아니라 가져오는거기 때문에 new LocationManager 사용 XX

        locProviders = locMgr.getAllProviders();
    }

    @Override
    public void onClick(View v){
        String s = "";
        for(int i =0; i < locProviders.size(); i++){
            s += "Loc.Provider: " + locProviders.get(i) +"\n"
                    + "Status: " + locMgr.isProviderEnabled(locProviders.get(i)) + "\n\n";
        }
        mTextView.setText(s);
    }
}