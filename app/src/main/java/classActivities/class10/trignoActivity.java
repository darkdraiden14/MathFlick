package classActivities.class10;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mathflick.R;

import classActivities.class10trignometry.SineActivity;
import classActivities.class10trignometry.cosecActivity;
import classActivities.class10trignometry.cosineActivity;
import classActivities.class10trignometry.cotActivity;
import classActivities.class10trignometry.secActivity;
import classActivities.class10trignometry.tanActivity;

public class trignoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigno);

        Button btnSine, btnCosine, btnTan, btnCot, btnCosec, btnSec;

        ActionBar trignoBar = getSupportActionBar();
        assert trignoBar != null;
        trignoBar.setDisplayShowTitleEnabled(true);
        trignoBar.setDisplayShowHomeEnabled(true);
        trignoBar.show();

        btnSine = findViewById(R.id.sine);
        btnCosine = findViewById(R.id.cosine);
        btnTan = findViewById(R.id.tan);
        btnCot = findViewById(R.id.cot);
        btnCosec = findViewById(R.id.cosec);
        btnSec = findViewById(R.id.sec);


        btnSine.setOnClickListener(this);
        btnCosine.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnCot.setOnClickListener(this);
        btnCosec.setOnClickListener(this);
        btnSec.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.sine:
                Intent sineIntent = new Intent(trignoActivity.this, SineActivity.class);
                startActivity(sineIntent);
                break;

            case R.id.cosine:
                Intent cosineIntent = new Intent(trignoActivity.this, cosineActivity.class);
                startActivity(cosineIntent);
                break;

            case R.id.tan:
                Intent tanIntent = new Intent(trignoActivity.this, tanActivity.class);
                startActivity(tanIntent);
                break;

            case R.id.cot:
                Intent cotIntent = new Intent(trignoActivity.this, cotActivity.class);
                startActivity(cotIntent);
                break;

            case R.id.cosec:
                Intent cosecIntent = new Intent(trignoActivity.this, cosecActivity.class);
                startActivity(cosecIntent);
                break;

            case R.id.sec:
                Intent secIntent = new Intent(trignoActivity.this, secActivity.class);
                startActivity(secIntent);
                break;
        }
    }

}
