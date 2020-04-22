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

public class coordinateGeoActivity extends AppCompatActivity implements View.OnClickListener {


    CardView mCard, nCard;
    TextView resultTxt;
    long idOfAdapter=0;
    EditText x1, x2, y1, y2, m, n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate_geo);

        Button calcBtn, resetBtn;
        Spinner coGeoSpinner = findViewById(R.id.coGeoSpinner);

        mCard = findViewById(R.id.mCard);
        nCard = findViewById(R.id.nCard);

        calcBtn = findViewById(R.id.Calc);
        calcBtn.setOnClickListener(this);
        resetBtn = findViewById(R.id.Reset);
        resetBtn.setOnClickListener(this);

        resultTxt = findViewById(R.id.coGeoResult);

        x1 = findViewById(R.id.x1);
        y1 = findViewById(R.id.y1);
        x2 = findViewById(R.id.x2);
        y2 = findViewById(R.id.y2);
        m = findViewById(R.id.m);
        n = findViewById(R.id.n);

        coGeoSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        idOfAdapter = id;
                        switch ((int) id){
                            case 0 :
                                hideM();
                                break;

                            case 1 :
                                showM();
                                break;
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(coordinateGeoActivity.this,"Select One", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    void hideM(){
        mCard.setVisibility(View.GONE);
        nCard.setVisibility(View.GONE);
    }
    void showM(){
        nCard.setVisibility(View.VISIBLE);
        mCard.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        double X1, X2, Y1, Y2, M1, M2;
        switch(v.getId()){
            case R.id.Calc:
                if(idOfAdapter==0){
                    if(x1.getText().toString().trim().length() <= 0 ||
                            x2.getText().toString().trim().length() <= 0 || y1.getText().toString().trim().length() <= 0 ||
                            y2.getText().toString().trim().length() <= 0  ){
                      Toast.makeText(coordinateGeoActivity.this, " Enter all the values", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        X1 = Double.parseDouble(String.valueOf(x1.getText()));
                        X2 = Double.parseDouble(String.valueOf(x2.getText()));
                        Y1 = Double.parseDouble(String.valueOf(y1.getText()));
                        Y2 = Double.parseDouble(String.valueOf(y2.getText()));
                        String result;
                        double d1, d2, d;
                        d1 = (X1 - X2)*(X1-X2);
                        d2 = (Y1 - Y2)*(Y1-Y2);
                        d = Math.sqrt(d1-d2);

                        result = "The Distance between the entered points is : " +  d;
                        resultTxt.setText(result);
                    }
                }
                else{
                    if(x1.getText().toString().trim().length() <= 0 ||
                            x2.getText().toString().trim().length() <= 0 || y1.getText().toString().trim().length() <= 0 ||
                            y2.getText().toString().trim().length() <= 0 || m.getText().toString().trim().length() <= 0 ||
                            n.getText().toString().trim().length() <= 0  ){
                        Toast.makeText(coordinateGeoActivity.this, " Enter all the values", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        X1 = Double.parseDouble(String.valueOf(x1.getText()));
                        X2 = Double.parseDouble(String.valueOf(x2.getText()));
                        Y1 = Double.parseDouble(String.valueOf(y1.getText()));
                        Y2 = Double.parseDouble(String.valueOf(y2.getText()));
                        M1 = Double.parseDouble(String.valueOf(m.getText()));
                        M2 = Double.parseDouble(String.valueOf(n.getText()));

                        String result;
                        double d1, d2;
                        d1 = ((M1*X2)+(M2*X1))/(M1+M2);
                        d2 = ((M1*Y2)+(M2*Y1))/(M1+M2);
                        result = "The coordinates of the point which will divide the line segment in " +  M1 + " : " + M2 + " is : "
                                  + " (" + d1 + "," + d2 + ")";
                        resultTxt.setText(result);
                    }
                }
                break;

            case R.id.Reset:
                if(idOfAdapter==1){
                    m.setText("");
                    n.setText("");
                }
                x1.setText("");
                x2.setText("");
                y1.setText("");
                y2.setText("");
                resultTxt.setText("");
        }
    }
}
