package classActivities.class10;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mathflick.R;

public class arithProgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arith_prog);

        ActionBar arithBar = getSupportActionBar();
        assert arithBar != null;
        arithBar.setDisplayShowTitleEnabled(true);
        arithBar.setDisplayShowHomeEnabled(true);
        arithBar.show();

    }
}
