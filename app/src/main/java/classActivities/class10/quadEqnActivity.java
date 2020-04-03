package classActivities.class10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathflick.R;

public class quadEqnActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtA, edtB, edtC;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quad_eqn);

        Button btnFind, btnReset;


        edtA = findViewById(R.id.quad_a);
        edtB = findViewById(R.id.quad_b);
        edtC = findViewById(R.id.quad_c);
        txtResult = findViewById(R.id.quadResult);

        btnFind = findViewById(R.id.quadCalc);
        btnFind.setOnClickListener(this);

        btnReset = findViewById(R.id.quadReset);
        btnReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.quadReset:
                edtA.setText("");
                edtB.setText("");
                edtC.setText("");
                txtResult.setText("");
                break;

            case R.id.quadCalc:

                if (edtA.getText().toString().trim().length() <= 0 || edtB.getText().toString().trim().length() <= 0 ||
                        edtC.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this, "Enter all values First", Toast.LENGTH_SHORT).show();
                } else {
                    double a, b, c;
                    double Dis, x1, x2;
                    String result;
                    a = Double.parseDouble(String.valueOf(edtA.getText()));
                    b = Double.parseDouble(String.valueOf(edtB.getText()));
                    c = Double.parseDouble(String.valueOf(edtC.getText()));

                    final double abs = Math.abs(Math.pow(b, 2.0) - (4 * a * c));
                    Dis = Math.sqrt(abs);

                    x1 = (-b + Dis) / (2 * a);
                    x2 = (-b - Dis) / (2 * a);
                    result = "For the given Quadratic Equation :\n" + " D = " + abs + "\n x  = " + x1 + ",\n" + x2;
                    txtResult.setText(result);
                }
                break;
        }
    }
}
