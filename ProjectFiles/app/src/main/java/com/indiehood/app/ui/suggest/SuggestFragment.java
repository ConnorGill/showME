package com.indiehood.app.ui.suggest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.firebase.firestore.FirebaseFirestore;
import com.indiehood.app.R;

public class SuggestFragment extends Fragment {

    private SuggestViewModel suggestViewModel;

    /*private Button mVenueButton;
    private EditText mVenueName;
    private EditText mVenueAdd;
    private EditText mVenueNum;
    private EditText mVenueText;

    private FirebaseFirestore mFireStore; */


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        suggestViewModel =
                ViewModelProviders.of(this).get(SuggestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_suggest, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        suggestViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        /*mFireStore = FirebaseFirestore.getInstance();

        mVenueName = (EditText) getView().findViewById(R.id.venueName);
        mVenueAdd = (EditText) getView().findViewById(R.id.venueAdd);
        mVenueNum = (EditText) getView().findViewById(R.id.venueNum);
        mVenueText = (EditText) getView().findViewById(R.id.venueText);
        mVenueButton = (Button) getView().findViewById(R.id.venueButton);*/


        return root;
    }
}