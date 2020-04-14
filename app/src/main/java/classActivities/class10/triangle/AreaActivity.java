package classActivities.class10.triangle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathflick.R;

public class AreaActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView cardBase, cardHeight, cardA, cardB, cardC, cardS;
    long idOfAdapter;
    EditText edtA, edtB, edtC;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        final Button btnCalc, btnReset;

        btnCalc = findViewById(R.id.areaCalc);
        btnCalc.setOnClickListener(this);

        btnReset = findViewById(R.id.areaReset);
        btnReset.setOnClickListener(this);

        Spinner areaOfTriangle = findViewById(R.id.areaSpinner);

        cardBase = findViewById(R.id.baseCard);
        cardHeight = findViewById(R.id.perpendicularCard);
        cardA = findViewById(R.id.aCard);
        cardB = findViewById(R.id.bCard);
        cardC = findViewById(R.id.cCard);
        cardS = findViewById(R.id.sCard);

        txtResult = findViewById(R.id.areaResult);

        areaOfTriangle.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        idOfAdapter = id;
                        switch ((int) id){
                            case 0 :
                                hideEquilateral();
                                hideHeron();
                                showArea();
                                edtA = findViewById(R.id.base);
                                edtB = findViewById(R.id.height);
                                break;

                            case 1 :
                                hideEquilateral();
                                hideArea();
                                showHeron();
                                edtA = findViewById(R.id.sideA);
                                edtB = findViewById(R.id.sideB);
                                edtC = findViewById(R.id.sideC);
                                break;

                            case 2:
                                hideArea();
                                hideHeron();
                                showEquilateral();
                                edtA = findViewById(R.id.sideS);
                                break;
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        showToast("Select any one");
                    }
                });
    }

    public void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void hideArea() {
        cardBase.setVisibility(View.GONE);
        cardHeight.setVisibility(View.GONE);
    }

    public void hideHeron(){
        cardB.setVisibility(View.GONE);
        cardA.setVisibility(View.GONE);
        cardC.setVisibility(View.GONE);
    }

    public void hideEquilateral(){
        cardS.setVisibility(View.GONE);
    }

    public void showArea() {
        cardBase.setVisibility(View.VISIBLE);
        cardHeight.setVisibility(View.VISIBLE);
    }

    public void showHeron(){
        cardB.setVisibility(View.VISIBLE);
        cardA.setVisibility(View.VISIBLE);
        cardC.setVisibility(View.VISIBLE);
    }

    public void showEquilateral(){
        cardS.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.areaCalc:
                txtResult.setText("");
                if(idOfAdapter==0){
                    if (edtA.getText().toString().trim().length() <= 0 ||
                            edtB.getText().toString().trim().length() <= 0 ) {
                        Toast.makeText(this,"Enter all values First", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    double b, h;
                    String result;
                    b = Double.parseDouble(String.valueOf(edtA.getText()));
                    h = Double.parseDouble(String.valueOf(edtB.getText()));
                    result =  "Area of Triangle : " + (b*h)/2;
                    txtResult.setText(result);
                }
                else if(idOfAdapter==1){
                    if (edtA.getText().toString().trim().length() <= 0 ||
                            edtB.getText().toString().trim().length() <= 0 ||
                            edtC.getText().toString().trim().length() <= 0) {
                        Toast.makeText(this,"Enter all values First", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    double a, b, c, s, area;
                    String result;
                    a = Double.parseDouble(String.valueOf(edtA.getText()));
                    b = Double.parseDouble(String.valueOf(edtB.getText()));
                    c = Double.parseDouble(String.valueOf(edtC.getText()));
                    s = (a+b+c);
                    area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
                    result =  "Area of Triangle : " + area;
                    txtResult.setText(result);
                }
                else{
                    if (edtA.getText().toString().trim().length() <= 0) {
                        Toast.makeText(this, "Enter the Value", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    double s, area;
                    String result;
                    s = Double.parseDouble(String.valueOf(edtA.getText()));
                    area = Math.sqrt(3)*s/4;
                    result =  "Area of Triangle : " + area;
                    txtResult.setText(result);
                }
                break;

            case R.id.areaReset:
                txtResult.setText("");
                if(idOfAdapter==0){
                    edtA.setText("");
                    edtB.setText("");
                }
                else if(idOfAdapter==1){
                    edtA.setText("");
                    edtB.setText("");
                    edtC.setText("");
                }
                else{
                    edtA.setText("");
                }
                break;
        }
    }
}
