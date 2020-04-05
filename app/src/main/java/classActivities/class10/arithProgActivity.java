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

public class arithProgActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private EditText edtA, edtD, edtN, edtAn, edtSn;
    private TextView txtResult;
    private int flag = 0;

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
        edtA.performClick();
        edtA.setOnTouchListener(this);

        edtD = findViewById(R.id.second_term);
        edtD.performClick();
        edtD.setOnTouchListener(this);

        edtN = findViewById(R.id.numberOfterm);
        edtN.performClick();
        edtN.setOnTouchListener(this);

        edtAn = findViewById(R.id.nthTerm);
        edtAn.performClick();
        edtAn.setOnTouchListener(this);

        edtSn = findViewById(R.id.sumOfTerms);
        edtSn.performClick();
        edtSn.setOnTouchListener(this);

        txtResult = findViewById(R.id.APResult);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.APCalc:
                if (edtA.getText().toString().trim().length() <= 0 || edtD.getText().toString().trim().length() <= 0 ||
                        edtN.getText().toString().trim().length() <= 0 || edtSn.getText().toString().trim().length() <= 0 ||
                        edtAn.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter the Values", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,flag, Toast.LENGTH_SHORT).show();
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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.first_term:
                if(flag==3){
                    edtA.setEnabled(false);
                }
                else{
                    flag++;
                }
                break;

            case R.id.second_term:
                if(flag==3){
                    edtD.setEnabled(false);
                }
                else{
                    flag++;
                }
                break;

            case R.id.numberOfterm:
                if(flag==3){
                    edtN.setEnabled(false);
                }
                else{
                    flag++;
                }
                break;

            case R.id.nthTerm:
                if(flag==3){
                    edtAn.setEnabled(false);
                }
                else{
                    flag++;
                }
                break;

            case R.id.sumOfTerms:
                if(flag==3){
                    edtSn.setEnabled(false);
                }
                else{
                    flag++;
                }
                break;
        }
        return false;
    }
}
