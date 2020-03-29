package classActivities.class10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mathflick.R;

import classActivities.class10.circle.areaCircleActivity;

public class circleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        Button btnAreaCircle;
        btnAreaCircle = findViewById(R.id.areaCircle);
        btnAreaCircle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.areaCircle){
            Intent areaIntent = new Intent(circleActivity.this, areaCircleActivity.class);
            startActivity(areaIntent);
        }
    }
}
