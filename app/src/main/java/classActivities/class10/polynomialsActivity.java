package classActivities.class10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

                break;
        }

    }
}
