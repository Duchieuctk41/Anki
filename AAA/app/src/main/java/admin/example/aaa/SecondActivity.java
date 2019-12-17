package admin.example.aaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    Button btcontinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Anhxa();
        btcontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        final ImageView imgrotate = (ImageView) findViewById(R.id.laugh);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_);
        imgrotate.startAnimation(animation);



    }

    private void Anhxa() {
        btcontinue = (Button) findViewById(R.id.btcontinue);


    }
}
