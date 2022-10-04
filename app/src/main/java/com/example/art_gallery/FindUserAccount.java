package com.example.art_gallery;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class FindUserAccount extends AppCompatActivity {

    // Toolbar나 ActionBar등 import 할 때는 androidx.appcompat.widget패키지 안에 들어있는 클래스를 import
    Toolbar toolbar;

    IdFragment fragment1;
    PwFragment fragment2;

    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_find_account);

        // 텍스트 부분 컬러
        TextView find_title = (TextView)findViewById(R.id.titleText);

        String content = find_title.getText().toString();
        SpannableString spannableString = new SpannableString(content);

        String word = "아이디 / 비밀번호";
        int start = content.indexOf(word);
        int end = start + word.length();

        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#8BC34A")), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        find_title.setText(spannableString);

        // toolbar
        toolbar = findViewById(R.id.toolbar); // 1toolbar 설정
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        // fragment 보여주기
        fragment1 = new IdFragment();
        fragment2 = new PwFragment();
        
        // fragment를 매니져로 보여줌
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        // 2탭기능 구현
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("아이디 찾기"));
        tabs.addTab(tabs.newTab().setText("비밀번호 찾기"));

        // 탭버튼을 클릭했을 때 fragment 동작
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 선택된 탭 번호 반환
                int position = tab.getPosition();
                Log.d("FindUserAccount", "선택된 탭 : " + position);

                Fragment selected = null;
                if (position == 0) {
                    selected = fragment1;
                } else if (position == 1) {
                    selected = fragment2;
                }

                // 선택된 fragment로 바꿔줌
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}