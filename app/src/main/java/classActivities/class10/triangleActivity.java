package classActivities.class10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mathflick.R;

import classActivities.class10.triangle.AreaActivity;
import classActivities.class10.triangle.PythagorusActivity;

public class triangleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);


        Button btnPythagorus, btnArea;
        btnPythagorus = findViewById(R.id.pythagorus);
        btnPythagorus.setOnClickListener(this);


        btnArea = findViewById(R.id.Area);
        btnArea.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pythagorus:
                Intent pythaIntent = new Intent(triangleActivity.this, PythagorusActivity.class);
                startActivity(pythaIntent);
                break;
            case R.id.Area:
                Intent areaIntent = new Intent(triangleActivity.this, AreaActivity.class);
                startActivity(areaIntent);
                break;
        }

    }
}
