package classActivities.class10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathflick.R;

public class circleActivity extends AppCompatActivity implements View.OnClickListener {

    CardView thetaCard;
    long idOfAdapter;
    EditText radii,theta;
    TextView resultTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        radii = findViewById(R.id.radius);
        theta = findViewById(R.id.theta);

        thetaCard = findViewById(R.id.thetaCard);
        resultTxt = findViewById(R.id.circleResult);

        Button calcBtn, resetBtn;
        Spinner circleSpinner = findViewById(R.id.circleSpinner);

        calcBtn = findViewById(R.id.Calc);
        calcBtn.setOnClickListener(this);
        resetBtn = findViewById(R.id.Reset);
        resetBtn.setOnClickListener(this);

        circleSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        idOfAdapter = id;
                        resultTxt.setText("");
                        radii.setText("");
                        theta.setText("");
                        switch ((int) id){
                            case 0 :
                                thetaCard.setVisibility(View.GONE);
                                break;

                            case 1 :
                                thetaCard.setVisibility(View.VISIBLE);
                                break;
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(circleActivity.this,"Select One", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        double r,t;
        switch(v.getId()){
            case R.id.Calc:
                if(idOfAdapter==0){
                    if(radii.getText().toString().trim().length() <= 0){
                        Toast.makeText(circleActivity.this, " Enter the Radius", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        r = Double.parseDouble(String.valueOf(radii.getText()));
                        String result;
                        double d;
                        d = 3.14 * r*r;

                        result = "The Area of Circle is : " +  d;
                        resultTxt.setText(result);
                    }
                }
                else{
                    if(radii.getText().toString().trim().length() <= 0 ||
                            theta.getText().toString().trim().length() <= 0){
                        Toast.makeText(circleActivity.this, " Enter both values", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        r = Double.parseDouble(String.valueOf(radii.getText()));
                        t = Double.parseDouble(String.valueOf(theta.getText()));
                        String result;
                        double d;
                        d = t*3.14*r*r;
                        d=d/360;
                        result = "The Area of the Sector is : " + d;
                        resultTxt.setText(result);
                    }
                }
                break;

            case R.id.Reset:
                if(idOfAdapter==1){
                    theta.setText("");
                }
                radii.setText("");
                resultTxt.setText("");
        }
    }
}
