package com.example.gerso.amigosseupauloprotetor.activity.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerso.amigosseupauloprotetor.R;
import com.example.gerso.amigosseupauloprotetor.activity.models.Banco;
import com.example.gerso.amigosseupauloprotetor.activity.models.Novidade;

import java.util.ArrayList;

/**
 * Created by gerso on 6/15/2017.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.MyViewHolder> {


    ArrayList<Novidade> mData;
    FragmentActivity  mActivity;
    private static LayoutInflater inflater = null;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTituloNovidade;
        ImageView imageViewNovidade;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);
            this.textViewTituloNovidade = (TextView) itemView.findViewById(R.id.textViewTitulo);
            this.imageViewNovidade = (ImageView) itemView.findViewById(R.id.imageViewConteudo);
            this.cardView = (CardView) itemView.findViewById(R.id.cardViewNovidades);
        }
    }

    public CardsAdapter(ArrayList<Novidade> mData, FragmentActivity mActivity) {
        this.mData = mData;
        this.mActivity = mActivity;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       this.inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.novidades_layout,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView textViewTituloNovidade = holder.textViewTituloNovidade;
        ImageView imageViewNovidade = holder.imageViewNovidade;

        textViewTituloNovidade.setText(mData.get(position).getTituloNovidade());
        imageViewNovidade.setImageResource(mData.get(position).getImageNovidade());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
