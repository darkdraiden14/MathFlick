package classActivities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mathflick.R;

import classActivities.class10.arithProgActivity;
import classActivities.class10.circleActivity;
import classActivities.class10.coordinateGeoActivity;
import classActivities.class10.linearEqnActivity;
import classActivities.class10.polynomialsActivity;
import classActivities.class10.probabilityActivity;
import classActivities.class10.quadEqnActivity;
import classActivities.class10.realNumbersActivity;
import classActivities.class10.statisticsActivity;
import classActivities.class10.surfaceAVActivity;
import classActivities.class10.triangleActivity;
import classActivities.class10.trignoActivity;

public class class10Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class10);

        Button btnReal, btnPoly, btnLinearEqn, btnQuad, btnArithProg, btnTriangle, btnCoGeo,
                btnTrigno, btnCircle, btnSurfaceAV, btnStats, btnProb;

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        ActionBar class10Bar = getSupportActionBar();
        assert class10Bar != null;
        class10Bar.setDisplayShowTitleEnabled(true);
        class10Bar.setDisplayShowHomeEnabled(true);
        class10Bar.show();

        btnReal = findViewById(R.id.realNumber);
        btnReal.setOnClickListener(this);

        btnPoly = findViewById(R.id.polynomial);
        btnPoly.setOnClickListener(this);

        btnLinearEqn = findViewById(R.id.linearEqn);
        btnLinearEqn.setOnClickListener(this);

        btnQuad = findViewById(R.id.quadEqn);
        btnQuad.setOnClickListener(this);

        btnArithProg = findViewById(R.id.arithProg);
        btnArithProg.setOnClickListener(this);

        btnTriangle = findViewById(R.id.triangle);
        btnTriangle.setOnClickListener(this);

        btnCoGeo = findViewById(R.id.coordinateGeometry);
        btnCoGeo.setOnClickListener(this);

        btnTrigno = findViewById(R.id.trignometry);
        btnTrigno.setOnClickListener(this);

        btnCircle = findViewById(R.id.circle);
        btnCircle.setOnClickListener(this);

        btnSurfaceAV = findViewById(R.id.surfaceArea);
        btnSurfaceAV.setOnClickListener(this);

        btnStats = findViewById(R.id.statistics);
        btnStats.setOnClickListener(this);

        btnProb = findViewById(R.id.probability);
        btnProb.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.realNumber:
                Intent realIntent = new Intent(class10Activity.this, realNumbersActivity.class);
                startActivity(realIntent);
                break;

            case R.id.polynomial:
                Intent polyIntent = new Intent(class10Activity.this, polynomialsActivity.class);
                startActivity(polyIntent);
                break;

            case R.id.linearEqn:
                Intent linearIntent = new Intent(class10Activity.this, linearEqnActivity.class);
                startActivity(linearIntent);
                break;

            case R.id.quadEqn:
                Intent quadIntent = new Intent(class10Activity.this, quadEqnActivity.class);
                startActivity(quadIntent);
                break;

            case R.id.arithProg:
                Intent arithProgIntent = new Intent(class10Activity.this, arithProgActivity.class);
                startActivity(arithProgIntent);
                break;

            case R.id.triangle:
                Intent triangleIntent = new Intent(class10Activity.this, triangleActivity.class);
                startActivity(triangleIntent);
                break;

            case R.id.coordinateGeometry:
                Intent coGeoIntent = new Intent(class10Activity.this, coordinateGeoActivity.class);
                startActivity(coGeoIntent);
                break;

            case R.id.trignometry:
                Intent trignoIntent = new Intent(class10Activity.this, trignoActivity.class);
                startActivity(trignoIntent);
                break;

            case R.id.circle:
                Intent circleIntent = new Intent(class10Activity.this, circleActivity.class);
                startActivity(circleIntent);
                break;

            case R.id.surfaceArea:
                Intent surfaceAVIntent = new Intent(class10Activity.this, surfaceAVActivity.class);
                startActivity(surfaceAVIntent);
                break;

            case R.id.statistics:
                Intent statsIntent = new Intent(class10Activity.this, statisticsActivity.class);
                startActivity(statsIntent);
                break;

            case R.id.probability:
                Intent probIntent = new Intent(class10Activity.this, probabilityActivity.class);
                startActivity(probIntent);
                break;
        }
    }
}
