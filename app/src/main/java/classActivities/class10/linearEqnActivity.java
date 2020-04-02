package classActivities.class10;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathflick.R;

public class linearEqnActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtResult;
    private EditText edtA, edtB, edtC, edtD, edtE, edtF;

    public linearEqnActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_eqn);

        ActionBar arithBar = getSupportActionBar();
        assert arithBar != null;
        arithBar.setDisplayShowTitleEnabled(true);
        arithBar.setDisplayShowHomeEnabled(true);
        arithBar.show();

        Button btnFind = findViewById(R.id.linearFind);
        btnFind.setOnClickListener(this);

        Button btnReset = findViewById(R.id.linearReset);
        btnReset.setOnClickListener(this);

        txtResult = findViewById(R.id.linearResult);

        edtA =findViewById(R.id.linear_a);
        edtB =findViewById(R.id.linear_b);
        edtC =findViewById(R.id.linear_c);
        edtD =findViewById(R.id.linear_d);
        edtE =findViewById(R.id.linear_e);
        edtF =findViewById(R.id.linear_f);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.linearFind:
                if (edtA.getText().toString().trim().length() <= 0 ||
                        edtB.getText().toString().trim().length() <= 0 || edtC.getText().toString().trim().length() <= 0 ||
                        edtD.getText().toString().trim().length() <= 0 || edtE.getText().toString().trim().length() <= 0 ||
                        edtF.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this,"Enter all values First", Toast.LENGTH_SHORT).show();
                }
                else{
                    double a,b,c,d,e,f,x,y,det;
                    String result;
                    a = Double.parseDouble(String.valueOf(edtA.getText()));
                    b = Double.parseDouble(String.valueOf(edtB.getText()));
                    c = Double.parseDouble(String.valueOf(edtC.getText()));
                    d = Double.parseDouble(String.valueOf(edtD.getText()));
                    e = Double.parseDouble(String.valueOf(edtE.getText()));
                    f = Double.parseDouble(String.valueOf(edtF.getText()));
                    det = ((a * d) - (b * c));
                    x = ((d * e) - (b * f)) / det;
                    y = ((a * f) - (c * e)) / det;

                    result = "For the given linear Equations,\n" + "The Value of x is : " + x + "\nThe Value of y is :" + y;
                    txtResult.setText(result);
                }
                break;

            case R.id.linearReset:
                edtA.setText("");
                edtB.setText("");
                edtC.setText("");
                edtD.setText("");
                edtE.setText("");
                edtF.setText("");
                txtResult.setText("");
                break;
        }

    }
}
