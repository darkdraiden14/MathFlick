package classActivities.class10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathflick.R;

public class realNumbersActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtFirstNum, edtSecondNum;
    private TextView txtResult;
    private Button btnCalc, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_numbers);

        edtFirstNum = findViewById(R.id.firstNum);
        edtSecondNum  = findViewById(R.id.secondNum);

        txtResult = findViewById(R.id.realResult);

        btnCalc = findViewById(R.id.realCalc);
        btnCalc.setOnClickListener(this);

        btnReset = findViewById(R.id.realReset);
        btnReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.realCalc:
                if (edtFirstNum.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter the First Number", Toast.LENGTH_SHORT).show();
                }
                else if (edtSecondNum.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter the Second Number", Toast.LENGTH_SHORT).show();
                }
                else if (edtFirstNum.getText().toString().trim().length() <= 0 &&
                        edtSecondNum.getText().toString().trim().length()<=0) {
                    Toast.makeText(this,"Enter the Numbers", Toast.LENGTH_SHORT).show();
                }
                else{
                    int a, b, x, y, t;
                    int lcm, hcf;
                    String answer;
                    x = Integer.parseInt(edtFirstNum.getText().toString());
                    y = Integer.parseInt(edtSecondNum.getText().toString());
                    a = x;
                    b = y;

                    while(b != 0)
                    {
                        t = b;
                        b = a%b;
                        a = t;
                    }

                    hcf = a;
                    lcm = (x*y)/hcf;
                    answer = "H.C.F. of the given Numbers is : " + hcf + "\n" + "L.C.M. of the given Numbers is : " + lcm;
                    txtResult.setText(answer);
                }
                break;

            case R.id.realReset:
                edtFirstNum.setText("");
                edtSecondNum.setText("");
                txtResult.setText("");
                break;
        }
    }
}
