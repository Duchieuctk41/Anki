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
import android.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    Button button, back;
    ProgressBar progressBar;
    TextView textView,point;
    int diem = 0;

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
        Intent intent = getIntent();
        int noidung = intent.getIntExtra("diemso",0);
        diem = diem + noidung;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"leuleu",Toast.LENGTH_SHORT).show();
            }
        });
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
                CountDownTimer countDownTimer = new CountDownTimer(10480,50) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = progressBar.getProgress();
                        if(current<=0)
                        {

                            Intent intent = new Intent(MainActivity.this,FourActivity.class);
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
                        if(question.equals(list.get(position)))
                        {
                            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
                            point.setText(""+ diem);



                        }
                        else {
                            Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);


                        }


                    }

                });
                countDownTimer.start();



            }
        });
        point.setText(""+ diem);
    }



    private void Anhxa() {
        gridView = (GridView) findViewById(R.id.gridview);
        button = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        textView = (TextView) findViewById(R.id.textView);
        back = (Button) findViewById(R.id.back);
        point = (TextView) findViewById(R.id.point);

    }

}
