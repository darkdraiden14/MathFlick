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

public class secActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtAngle, edtValue;
    private TextView txtSecResult, txtInvResult;

    Double inputValue,resultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        Button btnCalc, btnInvCalc, btnSecReset, btnInvReset;

        ActionBar trignoBar = getSupportActionBar();
        assert trignoBar != null;
        trignoBar.setDisplayShowTitleEnabled(true);
        trignoBar.setDisplayShowHomeEnabled(true);
        trignoBar.show();

        edtAngle = findViewById(R.id.secAngle);
        edtValue = findViewById(R.id.secValue);

        btnCalc = findViewById(R.id.secCalc);
        btnSecReset = findViewById(R.id.secReset);
        btnInvCalc = findViewById(R.id.secInvCalc);
        btnInvReset = findViewById(R.id.secInvReset);

        txtSecResult = findViewById(R.id.secResult);
        txtInvResult = findViewById(R.id.secInvResult);

        btnCalc.setOnClickListener(this);
        btnSecReset.setOnClickListener(this);
        btnInvCalc.setOnClickListener(this);
        btnInvReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        DecimalFormat df = new DecimalFormat("0.###");
        switch (v.getId()){
            case R.id.secCalc:
                if (edtAngle.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter a Value", Toast.LENGTH_SHORT).show();
                }
                else{
                    inputValue = Math.toRadians(Double.parseDouble(edtAngle.getText().toString()));
                    resultValue = 1/Math.cos(inputValue);
                    txtSecResult.setText(df.format(resultValue));
                }
                break;

            case R.id.secReset:
                edtAngle.setText("");
                txtSecResult.setText("");
                break;

            case R.id.secInvCalc:
                if (edtValue.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter a Value", Toast.LENGTH_SHORT).show();
                }
                else{
                    inputValue = Double.parseDouble(edtValue.getText().toString());
                    resultValue = Math.toDegrees(Math.acos(1 / inputValue));
                    txtInvResult.setText(df.format(resultValue));
                }
                break;

            case R.id.secInvReset:
                edtValue.setText("");
                txtInvResult.setText("");
                break;
        }
    }
}
