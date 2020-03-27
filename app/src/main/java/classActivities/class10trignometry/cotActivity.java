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

public class cotActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtAngle, edtValue;
    private TextView txtCotResult, txtInvResult;

    Double inputValue,resultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cot);

        Button btnCalc, btnInvCalc, btnCotReset, btnInvReset;

        ActionBar trignoBar = getSupportActionBar();
        assert trignoBar != null;
        trignoBar.setDisplayShowTitleEnabled(true);
        trignoBar.setDisplayShowHomeEnabled(true);
        trignoBar.show();

        edtAngle = findViewById(R.id.cotAngle);
        edtValue = findViewById(R.id.cotValue);

        btnCalc = findViewById(R.id.cotCalc);
        btnCotReset = findViewById(R.id.cotReset);
        btnInvCalc = findViewById(R.id.cotInvCalc);
        btnInvReset = findViewById(R.id.cotInvReset);

        txtCotResult = findViewById(R.id.cotResult);
        txtInvResult = findViewById(R.id.cotInvResult);

        btnCalc.setOnClickListener(this);
        btnCotReset.setOnClickListener(this);
        btnInvCalc.setOnClickListener(this);
        btnInvReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        DecimalFormat df = new DecimalFormat("0.###");
        switch (v.getId()){
            case R.id.cotCalc:
                if (edtAngle.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter a Value", Toast.LENGTH_SHORT).show();
                }
                else{
                    inputValue = Math.toRadians(Double.parseDouble(edtAngle.getText().toString()));
                    resultValue = (1/Math.tan(inputValue));
                    txtCotResult.setText(df.format(resultValue));
                }
                break;

            case R.id.cotReset:
                edtAngle.setText("");
                txtCotResult.setText("");
                break;

            case R.id.cotInvCalc:
                if (edtValue.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter a Value", Toast.LENGTH_SHORT).show();
                }
                else{
                    inputValue = Double.parseDouble(edtValue.getText().toString());
                    resultValue = Math.toDegrees(Math.atan(1/inputValue));
                    txtInvResult.setText(df.format(resultValue));

                }
                break;

            case R.id.cotInvReset:
                edtValue.setText("");
                txtInvResult.setText("");
                break;
        }
    }
}
