package com.example.art_gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PwFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {
        // xml로 만들어준 fragment를 자바단에서 만들어줌
        ViewGroup rootGroup = (ViewGroup) inflater.inflate(R.layout.find_pw_fragment, container, false);
        return rootGroup;
    }
}
