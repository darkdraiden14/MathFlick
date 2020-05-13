package classActivities.class10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mathflick.R;

public class surfaceAVActivity extends AppCompatActivity {

    CardView cubeCard, cuboidCard, sphereCard, cylinCard, coneCard, hemiCard, temp;
    CardView cubeSCard;
    CardView cuboidLCard, cuboidBCard, cuboidHCard;
    CardView sphereRCard;
    CardView coneLCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_a_v);

        cubeCard = findViewById(R.id.cubeD);
        cuboidCard = findViewById(R.id.cuboidD);
        coneCard = findViewById(R.id.coneD);
        sphereCard = findViewById(R.id.sphereD);
        cylinCard = findViewById(R.id.cylinderD);
        hemiCard = findViewById(R.id.hemisphereD);

        cubeSCard=findViewById(R.id.cubeSideCard);

        temp = cubeCard;

        cuboidLCard=findViewById(R.id.cuboidLCard);
        cuboidBCard=findViewById(R.id.cuboidBCard);
        cuboidHCard=findViewById(R.id.cuboidHCard);

        sphereRCard = findViewById(R.id.sphereRCard);

        coneLCard = findViewById(R.id.coneLCard);

        Spinner surfaceSpinner = findViewById(R.id.surfaceSpinner);
        surfaceSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        switch ((int) id){
                            case 0 :
                                hideAndShow(cubeCard);
                                hideAndShowCuboid(0);
                                hideAndShowSphere(0);
                                hideAndShowCone(0);
                                hideAndShowCylin(0);
                                hideAndShowHemi(0);
                                hideAndShowCube(1);
                                break;

                            case 1 :
                                hideAndShow(cuboidCard);
                                hideAndShowCube(0);
                                hideAndShowSphere(0);
                                hideAndShowCone(0);
                                hideAndShowCylin(0);
                                hideAndShowHemi(0);
                                hideAndShowCuboid(1);
                                break;

                            case 2 :
                                hideAndShow(sphereCard);
                                hideAndShowCube(0);
                                hideAndShowCuboid(0);
                                hideAndShowCone(0);
                                hideAndShowCylin(0);
                                hideAndShowHemi(0);
                                hideAndShowSphere(1);
                                break;

                            case 3 :
                                hideAndShow(coneCard);
                                hideAndShowCube(0);
                                hideAndShowCuboid(0);
                                hideAndShowSphere(0);
                                hideAndShowCylin(0);
                                hideAndShowHemi(0);
                                hideAndShowCone(1);
                                break;

                            case 4 :
                                hideAndShow(cylinCard);
                                hideAndShowCube(0);
                                hideAndShowCuboid(0);
                                hideAndShowSphere(0);
                                hideAndShowCone(0);
                                hideAndShowHemi(0);
                                hideAndShowCylin(1);
                                break;

                            case 5 :
                                hideAndShow(hemiCard);
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

    public void hideAndShow(CardView card){
        if(temp!=null){
            temp.setVisibility(View.GONE);
        }
        card.setVisibility(View.VISIBLE);
        temp = card;
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
    }
    public void hideAndShowHemi(int id){
        if(id==1){
            sphereRCard.setVisibility(View.VISIBLE);
         }
        else{
            sphereRCard.setVisibility(View.GONE);
        }
    }

}
