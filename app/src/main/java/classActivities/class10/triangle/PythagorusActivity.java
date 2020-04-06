package classActivities.class10.triangle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathflick.R;

public class PythagorusActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtB, edtP, edtH;
    private TextView txtResult;
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pythagorus);

        Button btnCalc, btnReset;

        edtB = findViewById(R.id.base);
        edtP = findViewById(R.id.perpendicular);
        edtH = findViewById(R.id.hypotenuse);

        txtResult = findViewById(R.id.pythagorusResult);

        btnCalc = findViewById(R.id.pythagorusCalc);
        btnCalc.setOnClickListener(this);
        btnReset = findViewById(R.id.pythagorusReset);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pythagorusCalc:
                flag=0;
                double b = checkValue(edtB);
                double p = checkValue(edtP);
                double h = checkValue(edtH);

                if(flag==1) {
                    String result;
                    if(p ==0){
                        p = Math.sqrt((h * h)-(b * b));
                    }
                    else if(b ==0){
                        b = Math.sqrt((h * h)-(p * p));
                    }
                    else {
                        h = Math.sqrt((p * p)+(b * b));
                    }
                    result = "P (Perpendicular) = " + p + "\nB (Base) = " + b + "\nH (Hypotenuse) = " + h;
                    txtResult.setText(result);
                }
                else {
                    Toast.makeText(this, "Enter any 2 Values", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.pythagorusReset:
                edtB.setText("");
                edtH.setText("");
                edtP.setText("");
                txtResult.setText("");
                break;
        }
    }

    public double checkValue(EditText edt){
        if(edt.getText().toString().trim().length() <= 0){
            flag++;
            return 0.0;
        }
        else{
            return Double.parseDouble(String.valueOf(edt.getText()));
        }
    }
}
