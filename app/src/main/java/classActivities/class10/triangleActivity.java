package classActivities.class10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mathflick.R;

import classActivities.class10.triangle.PythagorusActivity;

public class triangleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);


        Button btnPythagorus;
        btnPythagorus = findViewById(R.id.pythagorus);
        btnPythagorus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.pythagorus){
            Intent areaIntent = new Intent(triangleActivity.this, PythagorusActivity.class);
            startActivity(areaIntent);
        }
    }
}
