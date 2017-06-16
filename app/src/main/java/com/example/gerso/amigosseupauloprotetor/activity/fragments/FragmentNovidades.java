package com.example.gerso.amigosseupauloprotetor.activity.fragments;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gerso.amigosseupauloprotetor.R;
import com.example.gerso.amigosseupauloprotetor.activity.Util.MySeedData;
import com.example.gerso.amigosseupauloprotetor.activity.adapter.NovidadesAdapter;
import com.example.gerso.amigosseupauloprotetor.activity.models.Novidade;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNovidades extends Fragment {


    ListView listViewNovidades;
    View rootView;
    NovidadesAdapter novidadesAdapter;
    LinearLayoutManager mLinearLayoutManager;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    FragmentActivity mActivity;
    ArrayList<Novidade> mNovidadesList;

    public FragmentNovidades() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_novidades, container, false);

        mLinearLayoutManager =  new LinearLayoutManager(mActivity,1,false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewNovidades);

        mNovidadesList = createDataCards();

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(new NovidadesAdapter(mNovidadesList, mActivity));

        return rootView;
    }

    private ArrayList<Novidade> createDataCards(){

            mNovidadesList = new ArrayList<Novidade>();

            Novidade novidade = new Novidade(MySeedData.novidadesTitulos[0], MySeedData.novidadesImages[0]);
            Novidade novidade2 = new Novidade(MySeedData.novidadesTitulos[1], MySeedData.novidadesImages[1]);
            Novidade novidade3 = new Novidade(MySeedData.novidadesTitulos[2], MySeedData.novidadesImages[2]);


            mNovidadesList.add(novidade);
            mNovidadesList.add(novidade2);
            mNovidadesList.add(novidade3);

        return mNovidadesList;
    }

}
