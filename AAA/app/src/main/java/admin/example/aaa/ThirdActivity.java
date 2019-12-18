package admin.example.aaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class ThirdActivity extends AppCompatActivity {
    Button btcontinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Anhxa();
        btcontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        final ImageView imgrotate = (ImageView) findViewById(R.id.laugh);
        final ImageView star = (ImageView) findViewById(R.id.star);
        final ImageView star2 = (ImageView) findViewById(R.id.star2);

        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_);
        final Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.anim_star);
        imgrotate.startAnimation(animation);
        star.startAnimation(animation2);
        star2.startAnimation(animation2);



    }

    private void Anhxa() {
        btcontinue = (Button) findViewById(R.id.btcontinue);


    }
}
