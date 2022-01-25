package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FragmentForActivity extends Fragment {
    private FragmentListener listener;
    private TextView textView;
    private Button buttonok;

    public interface FragmentListener {
        void onInputSent(CharSequence input);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_for_activity, container, false);
        textView = v.findViewById(R.id.textView);
        buttonok = v.findViewById(R.id.button_ok);
        buttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),FragmentToActivity.class);
                intent.putExtra("key","Shrabani");
                startActivity(intent);
//                CharSequence input = editText.getText();
//                listener.onInputSent(input);
            }
        });

        return v;
    }
}