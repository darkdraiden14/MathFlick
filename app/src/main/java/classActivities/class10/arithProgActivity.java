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

public class arithProgActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtA, edtD, edtN, edtAn, edtSn;
    private TextView txtResult;
    private int flag;

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
                txtResult.setText("");
                flag=0;
                double a, d, n , an, sn;
                a = checkValue(edtA);
                d = checkValue(edtD);
                n = checkValue(edtN);
                an = checkValue(edtAn);
                sn = checkValue(edtSn);

                if (n==0){
                    Toast.makeText(this, "n cannot be 0",Toast.LENGTH_SHORT).show();
                    break;
                }

                if(flag==2) {
                    String result;
                    if(a==-99999999 && d==-99999999){
                        a = ((sn*2/n)-an);
                        d = ((an - a)/(n-1));
                    }
                    else if(a==-99999999 && n==-99999999){
                        Toast.makeText(this, "Enter any one A or N", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else if(a==-99999999 && an==-99999999){
                        a = ((sn*2/n)-((n-1)*d));
                        an = (a + ((n-1)*d));
                    }
                    else if(a==-99999999 && sn==-99999999){
                        a = (an-((n-1)*d));
                        sn = ((n/2)*(a+an));
                    }
                    else if(d==-99999999 && n==-99999999){
                        n = ((sn*2)/(a+an));
                        d = ((an - a)/(n-1));
                    }
                    else if(d==-99999999 && an==-99999999){
                        d = ((sn*2/n)-a)/(n-1);
                        an = (a + ((n-1)*d));
                    }
                    else if(d==-99999999 && sn==-99999999){
                        d = ((an-a)/(n-1));
                        sn = ((n/2)*(a+an));
                    }
                    else if(n==-99999999 && an==-99999999){
                        Toast.makeText(this, "Enter any one N or An", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else if(n==-99999999 && sn==-99999999){
                        n = (((an-a)/d)+1);
                        sn = ((n/2)*(a+an));
                    }
                    else{ //an==-99999999 and sn==-99999999
                        an = (a + ((n-1)*d));
                        sn = ((n/2)*(a+an));
                    }

                    result = "A.P. :\n" + "\t\ta (first Term) = " + a + "\n\t\td (difference) = " + d +
                            "\n\t\tn (number of terms) = " + n + "\n\t\tAn (nth Term) = " + an +
                            "\n\t\tSn (Sum of first n terms) = " + sn;

                    txtResult.setText(result);
                }
                else {
                    Toast.makeText(this, "Enter any 3 Values", Toast.LENGTH_SHORT).show();
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

    public double checkValue(EditText edt){
        if(edt.getText().toString().trim().length() <= 0){
            flag++;
            return -99999999;
        }
        else{
            return Double.parseDouble(String.valueOf(edt.getText()));
        }
    }
}