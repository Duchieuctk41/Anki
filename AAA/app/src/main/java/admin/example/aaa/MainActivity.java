package admin.example.aaa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
        Adapter gridviewadapter = new Adapter(this,hinh);
        gridView.setAdapter(gridviewadapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = new ArrayList<String>();
                list.add("Grape");list.add("Orange");list.add("Avocado");
                list.add("Apple");list.add("Banana");list.add("Coconut");
                list.add("Strawberry");list.add("Papaya");list.add("Watermelon");

                Random random = new Random();
                String question = list.get(random.nextInt(list.size()));
                textView.setText(question);


                CountDownTimer countDownTimer = new CountDownTimer(110,100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = progressBar.getProgress();

                        progressBar.setProgress(current - 200);
                        if(current<=0)
                        {
                            Dialog();

                        }

                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this,"TIME OVER",Toast.LENGTH_SHORT).show();

                    }
                };
                countDownTimer.start();

            }
        });
    }
    /*them dong nay cho vui*/

    private void Anhxa() {
        gridView = (GridView) findViewById(R.id.gridview);
        button = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        textView = (TextView) findViewById(R.id.textView);
    }
    private void Dialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        final ImageView animation = (ImageView) dialog.findViewById(R.id.animation);
        final Animation animRotate = AnimationUtils.loadAnimation(this,R.anim.anim_);
        /*animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animRotate);
            }
        });*/
        animation.startAnimation(animRotate);
        dialog.show();
    }
}
