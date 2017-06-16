package com.example.gerso.amigosseupauloprotetor.activity.fragments;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerso.amigosseupauloprotetor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContas extends Fragment {


    public FragmentContas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contas, container, false);
    }

}
