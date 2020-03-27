package classActivities.class10trignometry;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathflick.R;

import java.text.DecimalFormat;


public class SineActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtAngle, edtValue;
    private TextView txtSinResult, txtInvResult;

    Double inputValue,resultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sine);

        Button btnCalc, btnInvCalc, btnSinReset, btnInvReset;

        ActionBar trignoBar = getSupportActionBar();
        assert trignoBar != null;
        trignoBar.setDisplayShowTitleEnabled(true);
        trignoBar.setDisplayShowHomeEnabled(true);
        trignoBar.show();

        edtAngle = findViewById(R.id.sineAngle);
        edtValue = findViewById(R.id.sineValue);

        btnCalc = findViewById(R.id.sineCalc);
        btnSinReset = findViewById(R.id.sineReset);
        btnInvCalc = findViewById(R.id.sineInvCalc);
        btnInvReset = findViewById(R.id.sineInvReset);

        txtSinResult = findViewById(R.id.sineResult);
        txtInvResult = findViewById(R.id.sineInvResult);

        btnCalc.setOnClickListener(this);
        btnSinReset.setOnClickListener(this);
        btnInvCalc.setOnClickListener(this);
        btnInvReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        DecimalFormat df = new DecimalFormat("0.###");
        switch (v.getId()){
            case R.id.sineCalc:
                if (edtAngle.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter a Value", Toast.LENGTH_SHORT).show();
                }
                else{
                    inputValue = Math.toRadians(Double.parseDouble(edtAngle.getText().toString()));
                    resultValue = Math.sin(inputValue);
                    txtSinResult.setText(df.format(resultValue));
                }
                break;

            case R.id.sineReset:
                edtAngle.setText("");
                txtSinResult.setText("");
                break;

            case R.id.sineInvCalc:
                if (edtValue.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter a Value", Toast.LENGTH_SHORT).show();
                }
                else{
                    inputValue = Double.parseDouble(edtValue.getText().toString());
                    if(inputValue<0 || inputValue>1){
                        Toast.makeText(this,"This value must be in range 0 and 1",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        resultValue = Math.toDegrees(Math.asin(inputValue));
                        txtInvResult.setText(df.format(resultValue));
                    }
                }
                break;

            case R.id.sineInvReset:
                edtValue.setText("");
                txtInvResult.setText("");
                break;
        }
    }
}
