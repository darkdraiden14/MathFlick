package classActivities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mathflick.R;

import classActivities.class10.arithProgActivity;
import classActivities.class10.linearEqnActivity;
import classActivities.class10.polynomialsActivity;
import classActivities.class10.realNumbersActivity;
import classActivities.class10.trignoActivity;

public class class10Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class10);

        Button btnReal, btnPoly, btnLinearEqn, btnTrigno, btnArithProg;

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

        btnTrigno = findViewById(R.id.trignometry);
        btnTrigno.setOnClickListener(this);

        btnArithProg = findViewById(R.id.arithProg);
        btnArithProg.setOnClickListener(this);
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

            case R.id.trignometry:
                Intent trignoIntent = new Intent(class10Activity.this, trignoActivity.class);
                startActivity(trignoIntent);
                break;

            case R.id.arithProg:
                Intent arithProgIntent = new Intent(class10Activity.this, arithProgActivity.class);
                startActivity(arithProgIntent);
                break;
        }
    }
}
