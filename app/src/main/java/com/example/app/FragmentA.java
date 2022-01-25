package com.example.app;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentA extends Fragment {
    private FragmentAListener listener;
    private EditText editText;
    private Button buttonok;

    public interface FragmentAListener{
        void onInputASent(CharSequence input);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a,container,false);
        editText = v.findViewById(R.id.edit_text);
        buttonok = v.findViewById(R.id.button_ok);
        buttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputASent(input);
            }
        });

        return v;
    }
    public void updateEditText(CharSequence newText){
        editText.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAListener){
            listener=(FragmentAListener) context;
        }
        else{
            throw new RuntimeException(context.toString()+"implemente A");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}