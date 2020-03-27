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

public class cosecActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtAngle, edtValue;
    private TextView txtCosecResult, txtInvResult;

    Double inputValue,resultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosec);

        Button btnCalc, btnInvCalc, btnCosecReset, btnInvReset;

        ActionBar trignoBar = getSupportActionBar();
        assert trignoBar != null;
        trignoBar.setDisplayShowTitleEnabled(true);
        trignoBar.setDisplayShowHomeEnabled(true);
        trignoBar.show();

        edtAngle = findViewById(R.id.cosecAngle);
        edtValue = findViewById(R.id.cosecValue);

        btnCalc = findViewById(R.id.cosecCalc);
        btnCosecReset = findViewById(R.id.cosecReset);
        btnInvCalc = findViewById(R.id.cosecInvCalc);
        btnInvReset = findViewById(R.id.cosecInvReset);

        txtCosecResult = findViewById(R.id.cosecResult);
        txtInvResult = findViewById(R.id.cosecInvResult);

        btnCalc.setOnClickListener(this);
        btnCosecReset.setOnClickListener(this);
        btnInvCalc.setOnClickListener(this);
        btnInvReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        DecimalFormat df = new DecimalFormat("0.###");
        switch (v.getId()){
            case R.id.cosecCalc:
                if (edtAngle.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter a Value", Toast.LENGTH_SHORT).show();
                }
                else{
                    inputValue = Math.toRadians(Double.parseDouble(edtAngle.getText().toString()));
                    resultValue = 1/Math.sin(inputValue);
                    txtCosecResult.setText(df.format(resultValue));
                }
                break;

            case R.id.cosecReset:
                edtAngle.setText("");
                txtCosecResult.setText("");
                break;

            case R.id.cosecInvCalc:
                if (edtValue.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter a Value", Toast.LENGTH_SHORT).show();
                }
                else{
                    inputValue = Double.parseDouble(edtValue.getText().toString());
                    resultValue = Math.toDegrees(Math.asin(1 / inputValue));
                    txtInvResult.setText(df.format(resultValue));
                }
                break;

            case R.id.cosecInvReset:
                edtValue.setText("");
                txtInvResult.setText("");
                break;
        }
    }
}
