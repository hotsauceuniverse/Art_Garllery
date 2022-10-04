package com.example.art_gallery;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    TextView first_text;
    TextView second_text;
    TextView function_text;
    TextView nonmember;
    ImageView imageView;

    // backKey 탭 시, 종료
    // ctrl + o를 누르면 Override를 할 수 있다.
    private BackKeyHandler backKeyHandler = new BackKeyHandler(this);

    @Override
    public void onBackPressed() {
        backKeyHandler.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_splash);
        // 로딩화면 시작
        Loadingstart();

        // 텍스트 부분 컬러
        TextView function_text = (TextView)findViewById(R.id.function_text); //텍스트 변수 선언

        String content = function_text.getText().toString(); // 텍스트 가져옴
        SpannableString spannableString = new SpannableString(content); // 객체 생성

        String word = "GET";
        int start = content.indexOf(word);
        int end =  start + word.length();

        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#8BC34A")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        function_text.setText(spannableString);

        first_text = findViewById(R.id.first_text);
        second_text = findViewById(R.id.second_text);
        function_text = findViewById(R.id.function_text);
        imageView = findViewById(R.id.imageView);

        // 뷰에 애니메이션 적용하기
        // res폴더의 anim폴더에 애니매이션 설계
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.appear_image);
        imageView.startAnimation(animation);

        first_text.startAnimation(AnimationUtils.loadAnimation(this, R.anim.appear_title));
        second_text.startAnimation(AnimationUtils.loadAnimation(this, R.anim.appear_title));
        function_text.startAnimation(AnimationUtils.loadAnimation(this, R.anim.appear_subtitle));


        // join_button event
        Button join_button = (Button)findViewById(R.id.join_button);
        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });

        // login_button event
        Button login_button = (Button)findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        // nonMember event
        TextView nonmember = (TextView)findViewById(R.id.nonmember);
        nonmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ArtMain.class);
                startActivity(intent);
            }
        });

    }

    private void Loadingstart() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        },5000);
    }
    



}