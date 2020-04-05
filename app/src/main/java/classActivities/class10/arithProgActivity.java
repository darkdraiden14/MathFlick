package classActivities.class10;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathflick.R;

public class arithProgActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtA, edtD, edtN, edtAn, edtSn;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arith_prog);

        ActionBar arithBar = getSupportActionBar();
        assert arithBar != null;
        arithBar.setDisplayShowTitleEnabled(true);
        arithBar.setDisplayShowHomeEnabled(true);
        arithBar.show();

        Button btnCalc, btnReset;

        btnCalc = findViewById(R.id.APCalc);
        btnCalc.setOnClickListener(this);

        btnReset = findViewById(R.id.APReset);
        btnReset.setOnClickListener(this);

        edtA = findViewById(R.id.first_term);

        edtD = findViewById(R.id.second_term);

        edtN = findViewById(R.id.numberOfterm);

        edtAn = findViewById(R.id.nthTerm);

        edtSn = findViewById(R.id.sumOfTerms);

        txtResult = findViewById(R.id.APResult);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.APCalc:
                int flag=0;
                if(edtA.getText().toString().trim().length() <= 0){
                    flag++;
                }
                if (edtD.getText().toString().trim().length() <= 0 ){
                    flag++;
                }
                if(edtN.getText().toString().trim().length() <= 0){
                    flag++;
                }
                if (edtAn.getText().toString().trim().length() <= 0 ){
                    flag++;
                }
                if (edtSn.getText().toString().trim().length() <= 0 ){
                    flag++;
                }
                if (flag>2) {
                    Toast.makeText(this, "Enter any 3 Values Only", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, flag, Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.APReset:
                edtA.setText("");
                edtD.setText("");
                edtAn.setText("");
                edtSn.setText("");
                edtN.setText("");
                txtResult.setText("");
                break;
        }
    }


}
