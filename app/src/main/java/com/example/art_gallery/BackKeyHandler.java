package com.example.art_gallery;

import android.app.Activity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BackKeyHandler extends AppCompatActivity {
    // backKeyPressedTime이라는 long형 변수를 선언하고 0으로 초기화 (변수 = 뒤로가기 버튼을 누를 시간을 저장)
    private long backKeyPressedTime = 0;
    // private Activity activity로 변수 선언 -> Activity를 this.activity에 저장
    private Activity activity;
    private Toast toast;

    public BackKeyHandler(Activity activity) {
        this.activity = activity;
    }

    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            activity.finish();
            toast.cancel();
        }
    }


    // 전역 변수로 Toast toast를 선언하고, showGuide() 메소드 내부에서 toast에 Toast를 생성
    // 오버라이딩 : 메소드 이름이 동일하지만 매개 변수의 개수가 다르거나 매개 변수의 타입이 다른경우
    private void showGuide() {
        toast = Toast.makeText(activity, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void showGuide(String msg) {
        toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}
