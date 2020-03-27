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

public class tanActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtAngle, edtValue;
    private TextView txtTanResult, txtInvResult;

    Double inputValue,resultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tan);

        Button btnCalc, btnInvCalc, btnTanReset, btnInvReset;

        ActionBar trignoBar = getSupportActionBar();
        assert trignoBar != null;
        trignoBar.setDisplayShowTitleEnabled(true);
        trignoBar.setDisplayShowHomeEnabled(true);
        trignoBar.show();

        edtAngle = findViewById(R.id.tanAngle);
        edtValue = findViewById(R.id.tanValue);

        btnCalc = findViewById(R.id.tanCalc);
        btnTanReset = findViewById(R.id.tanReset);
        btnInvCalc = findViewById(R.id.tanInvCalc);
        btnInvReset = findViewById(R.id.tanInvReset);

        txtTanResult = findViewById(R.id.tanResult);
        txtInvResult = findViewById(R.id.tanInvResult);

        btnCalc.setOnClickListener(this);
        btnTanReset.setOnClickListener(this);
        btnInvCalc.setOnClickListener(this);
        btnInvReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        DecimalFormat df = new DecimalFormat("0.###");
        switch (v.getId()){
            case R.id.tanCalc:
                if (edtAngle.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter a Value", Toast.LENGTH_SHORT).show();
                }
                else{
                    inputValue = Math.toRadians(Double.parseDouble(edtAngle.getText().toString()));
                    resultValue = Math.tan(inputValue);
                    txtTanResult.setText(df.format(resultValue));
                }
                break;

            case R.id.tanReset:
                edtAngle.setText("");
                txtTanResult.setText("");
                break;

            case R.id.tanInvCalc:
                if (edtValue.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter a Value", Toast.LENGTH_SHORT).show();
                }
                else{
                    inputValue = Double.parseDouble(edtValue.getText().toString());
                    resultValue = Math.toDegrees(Math.atan(inputValue));
                    txtInvResult.setText(df.format(resultValue));

                }
                break;

            case R.id.tanInvReset:
                edtValue.setText("");
                txtInvResult.setText("");
                break;
        }
    }
}