package classActivities.class10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathflick.R;

public class surfaceAVActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cubeSCard;
    CardView cuboidLCard, cuboidBCard, cuboidHCard;
    CardView sphereRCard;
    CardView coneLCard;
    Button Calc, Reset;
    long idOfAdapter;
    ImageView img;
    TextView resultTxt, detailTxt;
    String resultStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_a_v);

        img = findViewById(R.id.detailIcon);

        detailTxt = findViewById(R.id.detailContent);

        cubeSCard=findViewById(R.id.cubeSideCard);

        cuboidLCard=findViewById(R.id.cuboidLCard);
        cuboidBCard=findViewById(R.id.cuboidBCard);
        cuboidHCard=findViewById(R.id.cuboidHCard);

        sphereRCard = findViewById(R.id.sphereRCard);

        coneLCard = findViewById(R.id.coneLCard);

        Calc = findViewById(R.id.Calc);
        Calc.setOnClickListener(this);
        Reset = findViewById(R.id.Reset);
        Reset.setOnClickListener(this);

        resultTxt = findViewById(R.id.result);

        Spinner surfaceSpinner = findViewById(R.id.surfaceSpinner);
        surfaceSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        idOfAdapter = id;
                        resultTxt.setText("");
                        switch ((int) id){
                            case 0 :
                                img.setImageDrawable(getDrawable(R.drawable.cube1));
                                detailTxt.setText(getText(R.string.cube_d));
                                hideAndShowCuboid(0);
                                hideAndShowSphere(0);
                                hideAndShowCone(0);
                                hideAndShowCylin(0);
                                hideAndShowHemi(0);
                                hideAndShowCube(1);
                                break;

                            case 1 :
                                img.setImageDrawable(getDrawable(R.drawable.cuboid));
                                detailTxt.setText(getText(R.string.cuboid_d));
                                hideAndShowCube(0);
                                hideAndShowSphere(0);
                                hideAndShowCone(0);
                                hideAndShowCylin(0);
                                hideAndShowHemi(0);
                                hideAndShowCuboid(1);
                                break;

                            case 2 :
                                img.setImageDrawable(getDrawable(R.drawable.sphere));
                                detailTxt.setText(getText(R.string.sphere_d));
                                hideAndShowCube(0);
                                hideAndShowCuboid(0);
                                hideAndShowCone(0);
                                hideAndShowCylin(0);
                                hideAndShowHemi(0);
                                hideAndShowSphere(1);
                                break;

                            case 3 :
                                img.setImageDrawable(getDrawable(R.drawable.cone));
                                detailTxt.setText(getText(R.string.cone_d));
                                hideAndShowCube(0);
                                hideAndShowCuboid(0);
                                hideAndShowSphere(0);
                                hideAndShowCylin(0);
                                hideAndShowHemi(0);
                                hideAndShowCone(1);
                                break;

                            case 4 :
                                img.setImageDrawable(getDrawable(R.drawable.cylinder));
                                detailTxt.setText(getText(R.string.cylinder_d));
                                hideAndShowCube(0);
                                hideAndShowCuboid(0);
                                hideAndShowSphere(0);
                                hideAndShowCone(0);
                                hideAndShowHemi(0);
                                hideAndShowCylin(1);
                                break;

                            case 5 :
                                img.setImageDrawable(getDrawable(R.drawable.hemisphere));
                                detailTxt.setText(getText(R.string.hemisphere_d));
                                hideAndShowCube(0);
                                hideAndShowCuboid(0);
                                hideAndShowSphere(0);
                                hideAndShowCone(0);
                                hideAndShowCylin(0);
                                hideAndShowHemi(1);
                                break;
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(surfaceAVActivity.this,"Select One", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void hideAndShowCube(int id){
        if(id==1){
            cubeSCard.setVisibility(View.VISIBLE);
        }
        else{
            cubeSCard.setVisibility(View.GONE);
        }
    }
    public void hideAndShowCuboid(int id){
        if(id==1){
            cuboidLCard.setVisibility(View.VISIBLE);
            cuboidBCard.setVisibility(View.VISIBLE);
            cuboidHCard.setVisibility(View.VISIBLE);
        }
        else{
            cuboidLCard.setVisibility(View.GONE);
            cuboidBCard.setVisibility(View.GONE);
            cuboidHCard.setVisibility(View.GONE);
        }
    }
    public void hideAndShowSphere(int id){
        if(id==1){
            sphereRCard.setVisibility(View.VISIBLE);
        }
        else{
            sphereRCard.setVisibility(View.GONE);
        }
    }
    public void hideAndShowCone(int id){
        if(id==1){
            sphereRCard.setVisibility(View.VISIBLE);
            coneLCard.setVisibility(View.VISIBLE);
        }
        else{
            sphereRCard.setVisibility(View.GONE);
            coneLCard.setVisibility(View.GONE);
        }
        EditText RR = findViewById(R.id.sphereR);
        RR.setText("");
    }
    public void hideAndShowCylin(int id){
        if(id==1){
            sphereRCard.setVisibility(View.VISIBLE);
            cuboidHCard.setVisibility(View.VISIBLE);
        }
        else{
            sphereRCard.setVisibility(View.GONE);
            cuboidHCard.setVisibility(View.GONE);
        }
        EditText HH = findViewById(R.id.cuboidH);
        HH.setText("");
    }
    public void hideAndShowHemi(int id){
        if(id==1){
            sphereRCard.setVisibility(View.VISIBLE);
         }
        else{
            sphereRCard.setVisibility(View.GONE);
        }
        EditText RR = findViewById(R.id.sphereR);
        RR.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Calc:
                double TSA, CSA, V;
                double pi = 3.14;
                if (idOfAdapter == 0) {
                    EditText s;
                    s = findViewById(R.id.cubeSide);
                    if (s.getText().toString().trim().length() == 0) {
                        showToast("Enter The value");
                        break;
                    }
                    double S = Double.parseDouble(s.getText().toString());
                    TSA = 6 * S * S;
                    CSA = 4 * S * S;
                    V = S * S * S;
                    resultStr = "For a Cube with side = " + S + " units,\nTotal Surface Area = " + TSA + " Units Sq.\nCurved Surface Area = " +
                            CSA + " Units Sq.\nVolume of Cube = " + V + " Units Cube.";
                } else if (idOfAdapter == 1) {
                    EditText l, b, h;
                    l = findViewById(R.id.cuboidL);
                    b = findViewById(R.id.cuboidB);
                    h = findViewById(R.id.cuboidH);
                    if (l.getText().toString().trim().length() == 0 || b.getText().toString().trim().length() == 0 ||
                            h.getText().toString().trim().length() == 0) {
                        showToast("Enter all the values");
                        break;
                    }
                    double L = Double.parseDouble(l.getText().toString());
                    double B = Double.parseDouble(b.getText().toString());
                    double H = Double.parseDouble(h.getText().toString());
                    TSA = 2 * ((L * B) + (B * H) + (H * L));
                    CSA = 2 * H * (L + B);
                    V = L * B * H;
                    resultStr = "For a Cuboid with sides = " + L + "," + B + "&" + H + " units,\nTotal Surface Area = " + TSA + " Units Sq.\nCurved Surface Area = " +
                            CSA + " Units Sq.\nVolume of Cuboid = " + V + " Units Cube.";
                } else if (idOfAdapter == 2) {
                    EditText r;
                    r = findViewById(R.id.sphereR);
                    if (r.getText().toString().trim().length() == 0) {
                        showToast("Enter The value");
                        break;
                    }
                    double R = Double.parseDouble(r.getText().toString());
                    TSA = 4 * pi * R * R;
                    CSA = TSA;
                    V = (TSA * R) / 3;
                    resultStr = "For a Sphere with radius = " + R + " units,\nTotal Surface Area = " + TSA + " Units Sq.\nCurved Surface Area = " +
                            CSA + " Units Sq.\nVolume of Cube = " + V + " Units Cube.";
                } else if (idOfAdapter == 3) {
                    EditText l, r;
                    l = findViewById(R.id.coneL);
                    r = findViewById(R.id.sphereR);
                    if (l.getText().toString().trim().length() == 0 || r.getText().toString().trim().length() == 0) {
                        showToast("Enter all the values");
                        break;
                    }
                    double L = Double.parseDouble(l.getText().toString());
                    double R = Double.parseDouble(r.getText().toString());
                    double H;
                    TSA = pi * R * (R + L);
                    CSA = pi * R * L;
                    H = Math.sqrt((L * L) - (R * R));
                    V = pi * R * R * H / 3;
                    resultStr = "For a Cone with radius = " + R + " & Length = " + L + " units,\nTotal Surface Area = " + TSA + " Units Sq.\nCurved Surface Area = " +
                            CSA + " Units Sq.\nVolume of Cuboid = " + V + " Units Cube.";
                } else if (idOfAdapter == 4) {
                    EditText h, r;
                    h = findViewById(R.id.cuboidH);
                    r = findViewById(R.id.sphereR);
                    if (h.getText().toString().trim().length() == 0 || r.getText().toString().trim().length() == 0) {
                        showToast("Enter all the values");
                        break;
                    }
                    double H = Double.parseDouble(h.getText().toString());
                    double R = Double.parseDouble(r.getText().toString());
                    TSA = 2 * pi * R * (R + H);
                    CSA = 2 * pi * R * H;
                    V = pi * R * R * H;
                    resultStr = "For a Cylinder with radius = " + R + " & Height = " + H + " units,\nTotal Surface Area = " + TSA + " Units Sq.\nCurved Surface Area = " +
                            CSA + " Units Sq.\nVolume of Cuboid = " + V + " Units Cube.";
                } else {
                    EditText r;
                    r = findViewById(R.id.sphereR);
                    if (r.getText().toString().trim().length() == 0) {
                        showToast("Enter The value");
                        break;
                    }
                    double R = Double.parseDouble(r.getText().toString());
                    TSA = 3 * pi * R * R;
                    CSA = 2 * pi * R * R;
                    V = (CSA * R * 2) / 3;
                    resultStr = "For a HemiSphere with radius = " + R + " units,\nTotal Surface Area = " + TSA + " Units Sq.\nCurved Surface Area = " +
                            CSA + " Units Sq.\nVolume of Cube = " + V + " Units Cube.";
                }
                resultTxt.setText(resultStr);
                break;

            case R.id.Reset:
                EditText l, b, h, r, s, hl;
                s = findViewById(R.id.cubeSide);
                l = findViewById(R.id.cuboidL);
                b = findViewById(R.id.cuboidB);
                h = findViewById(R.id.cuboidH);
                hl = findViewById(R.id.coneL);
                r = findViewById(R.id.sphereR);
                s.setText("");
                l.setText("");
                b.setText("");
                h.setText("");
                r.setText("");
                hl.setText("");
                resultTxt.setText("");
                break;
        }
    }

    public void showToast(String str) {
        Toast.makeText(surfaceAVActivity.this, str, Toast.LENGTH_SHORT).show();
    }
}
