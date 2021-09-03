package com.eceakilli.tabbetjavafragment.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.eceakilli.tabbetjavafragment.R;

public class FirstFragment extends Fragment {


    PageViewModel pageViewModel;

    public static Fragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //---------this yada getcontext ile fragmenta baglayamazsın fragment extends edildiği için aşagıdaki gib işlem yapabilirsin
            Toast.makeText(getActivity().getApplicationContext(),"MESAJ",Toast.LENGTH_LONG).show();

        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editText = view.findViewById(R.id.editText);

        //text değisince bana callback fonksiyon ver
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                pageViewModel.setName(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}