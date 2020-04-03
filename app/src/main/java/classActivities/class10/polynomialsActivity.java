package classActivities.class10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathflick.R;

public class polynomialsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtResult;
    private EditText edtA, edtB, edtC, edtD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polynomials);

        Button btnFind, btnReset;

        txtResult = findViewById(R.id.polynomialResult);

        edtA =findViewById(R.id.polynomial_a);
        edtB =findViewById(R.id.polynomial_b);
        edtC =findViewById(R.id.polynomial_c);
        edtD =findViewById(R.id.polynomial_d);

        btnFind = findViewById(R.id.polynomialFind);
        btnFind.setOnClickListener(this);
        btnReset = findViewById(R.id.polynomialReset);
        btnReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.polynomialReset:
                edtA.setText("");
                edtB.setText("");
                edtC.setText("");
                edtD.setText("");
                txtResult.setText("");
                break;

            case R.id.polynomialFind:
                if (edtB.getText().toString().trim().length() <= 0 || edtC.getText().toString().trim().length() <= 0 ||
                        edtD.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter all values First", Toast.LENGTH_SHORT).show();
                }
                else if(edtA.getText().toString().trim().length() <= 0 ||
                        Double.parseDouble(String.valueOf(edtA.getText())) == 0){
                    double a, b, c;
                    double Dis, x1, x2;
                    String result;
                    a = Double.parseDouble(String.valueOf(edtB.getText()));
                    b = Double.parseDouble(String.valueOf(edtC.getText()));
                    c = Double.parseDouble(String.valueOf(edtD.getText()));

                    Dis = Math.sqrt(Math.abs(Math.pow(b,2.0) - (4*a*c)));

                    x1 = (-b+Dis)/(2*a);
                    x2 = (-b-Dis)/(2*a);
                    result = "For the given Polynomial, the zeroes are : \n" + " α = " + x1 + "\n β = " + x2 +
                            "\n Sum of zeroes,α+β = -(" + b + "/" +a + ")" + "\n Product of zeroes, αβ = (" + c + "/" + a + ")";
                    txtResult.setText(result);
                }
                else{
                    double a, b, c, d;
                    String  x1, x2, x3;
                    String result;
                    a = Double.parseDouble(String.valueOf(edtA.getText()));
                    b = Double.parseDouble(String.valueOf(edtB.getText()));
                    c = Double.parseDouble(String.valueOf(edtC.getText()));
                    d = Double.parseDouble(String.valueOf(edtD.getText()));

                    x1 = "-("+b+"/"+a+")";
                    x2 = "("+c+"/"+a+")";
                    x3 = "-("+d+"/"+a+")";

                    result = "For the given Polynomial, the zeroes are : \n" + " α+β+γ = " + x1 + "\n αβ + βγ + γα= " + x2
                            + "\n αβγ = " + x3;
                    txtResult.setText(result);
                }

                break;
        }

    }
}
