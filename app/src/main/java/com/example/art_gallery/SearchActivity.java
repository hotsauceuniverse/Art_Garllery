package com.example.art_gallery;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.search_page);
        
        // 텍스트 부분 컬러
        TextView search = (TextView)findViewById(R.id.search_title);

        String content = search.getText().toString();
        SpannableString spannableString = new SpannableString(content);

        String word = "찾아";
        int start = content.indexOf(word);
        int end = start + word.length();

        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#8BC34A")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        search.setText(spannableString);


        // EditText Enter 처리
        EditText editText = (EditText)findViewById(R.id.search_text);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // 일단 Toast 처리 -> 검색된 페이지 이동 처리
                    Toast.makeText(SearchActivity.this,
                            "검색 버튼 누름",
                            Toast.LENGTH_SHORT
                    ).show();
                    handled = true;
                }
                return handled;
            }
        });
    }
}