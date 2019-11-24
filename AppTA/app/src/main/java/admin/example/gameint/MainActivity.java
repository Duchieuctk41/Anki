package admin.example.gameint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;

import admin.example.appta.;
import admin.example.appta.R;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    int[] hinh ={
            R.drawable.apple,R.drawable.avocado,R.drawable.banana,
            R.drawable.coconut, R.drawable.grape,R.drawable.papaya,
            R.drawable.strawberry,R.drawable.watermelon,R.drawable.pineapple
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        android.widget.Adapter gridviewadapter = new admin.example.gameint.Adapter(this,hinh);
        gridView.setAdapter((ListAdapter) gridviewadapter);


    }

    private void Anhxa() {
        gridView = (GridView) findViewById(R.id.gridview);
    }
}
