package admin.example.aaa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    Button button;
    ProgressBar progressBar;
    TextView textView;

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
        final Adapter gridviewadapter = new Adapter(this,hinh);
        gridView.setAdapter(gridviewadapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final List<String> list = new ArrayList<String>();
                list.add("Apple");list.add("Avocado");list.add("Banana");
                list.add("Coconut");list.add("Grape");list.add("Papaya");
                list.add("Strawberry");list.add("Watermelon");list.add("Pineapple");

                Random random = new Random();
                final String question = list.get(random.nextInt(list.size()));
                textView.setText(question);
                gridView.setAdapter(gridviewadapter);
                CountDownTimer countDownTimer = new CountDownTimer(10400,50) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = progressBar.getProgress();
                        if(current<=0)
                        {

                            Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                            startActivity(intent);

                        }

                        progressBar.setProgress(current - 1);


                    }

                    @Override
                    public void onFinish() {



                    }
                };



                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //position: tra ve vi tri click
                        if(question == list.get(position))
                        {
                            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent(MainActivity.this,FourActivity.class);
                            startActivity(intent);

                        }

                    }

                });
                countDownTimer.start();





            }
        });
    }


    private void Anhxa() {
        gridView = (GridView) findViewById(R.id.gridview);
        button = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        textView = (TextView) findViewById(R.id.textView);
    }

}
