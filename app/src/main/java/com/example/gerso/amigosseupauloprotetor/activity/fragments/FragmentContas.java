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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerso.amigosseupauloprotetor.R;
import com.example.gerso.amigosseupauloprotetor.activity.Util.MySeedData;
import com.example.gerso.amigosseupauloprotetor.activity.adapter.BancosAdapter;
import com.example.gerso.amigosseupauloprotetor.activity.adapter.CardsAdapter;
import com.example.gerso.amigosseupauloprotetor.activity.models.Banco;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContas extends Fragment {

    private RecyclerView mRecyclerView;
    private TextView textViewBanco, textViewAgencia, textViewConta, textViewTipoConta, textViewCpf;
    private ImageView imageViewBanco;
    private RecyclerView.Adapter mAdapter;
    private FragmentActivity mFragmentActivity;
    private ArrayList<Banco> bancosList;
    private View mRootView;
    private LinearLayoutManager mLinearLayoutManager;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mFragmentActivity = getActivity();
    }

    public FragmentContas() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_contas, container, false);

        mLinearLayoutManager = new LinearLayoutManager(mFragmentActivity,1,false);
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.rv_contas);
        bancosList = createListBancos();

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(new BancosAdapter(bancosList,mFragmentActivity));

        return mRootView;
    }

    public ArrayList<Banco> createListBancos(){

        bancosList = new ArrayList<Banco>();

        for(int i=0; i< MySeedData.bancos.length; i++){
            Banco banco = new Banco(MySeedData.bancos[i],MySeedData.agencias[i], MySeedData.contas[i], MySeedData.tipoContas[i],MySeedData.cpf,MySeedData.bancoImages[i]);
            bancosList.add(banco);
        }

        return bancosList;

    };

}
