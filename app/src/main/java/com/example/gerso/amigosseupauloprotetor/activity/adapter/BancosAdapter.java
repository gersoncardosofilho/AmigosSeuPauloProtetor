package com.example.gerso.amigosseupauloprotetor.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by gerso on 6/16/2017.
 */

public class BancosAdapter extends RecyclerView.Adapter<BancosAdapter.MyViewHolder> {


    ArrayList<Banco> mData;
    FragmentActivity mActivity;
    private static LayoutInflater inflater = null;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewBanco, textViewConta, textViewAgencia, textViewTipoConta, textViewCpf;
        ImageView imageViewBanco;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);
            this.textViewBanco = (TextView) itemView.findViewById(R.id.textViewNomeBanco);
            this.textViewAgencia = (TextView) itemView.findViewById(R.id.textViewAgencia);
            this.textViewConta = (TextView) itemView.findViewById(R.id.textViewConta);
            this.textViewTipoConta = (TextView) itemView.findViewById(R.id.textViewTipoConta);
            this.textViewCpf = (TextView) itemView.findViewById(R.id.textViewCpf);
            this.imageViewBanco = (ImageView) itemView.findViewById(R.id.imageViewBanco);
            this.cardView = (CardView) itemView.findViewById(R.id.cardViewContas);
        }
    }

    public BancosAdapter(ArrayList<Banco> mData, FragmentActivity mActivity) {
        this.mData = mData;
        this.mActivity = mActivity;
    }


    @Override
    public BancosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.contas_layout,parent,false);



        BancosAdapter.MyViewHolder myViewHolder = new BancosAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(BancosAdapter.MyViewHolder holder, int position) {
        final TextView textViewBanco = holder.textViewBanco;
        TextView textViewAgencia = holder.textViewAgencia;
        TextView textViewConta = holder.textViewConta;
        TextView textViewTipoConta = holder.textViewTipoConta;
        TextView textViewCpf = holder.textViewCpf;
        ImageView imageViewBanco = holder.imageViewBanco;
        CardView cardView = holder.cardView;

        textViewBanco.setText(mData.get(position).getNomeBanco());
        textViewAgencia.setText(mData.get(position).getNumeroAgencia());
        textViewConta.setText(mData.get(position).getNumeroConta());
        textViewTipoConta.setText(mData.get(position).getTipoConta());
        textViewCpf.setText(mData.get(position).getCpf());
        imageViewBanco.setImageResource(mData.get(position).getImageBanco());

        cardView.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View v) {

                String nomeBanco = textViewBanco.getText().toString();
                final String BB_APP_PACKAGE_NAME = "br.com.bb.android";
                final String ITAU_APP_PACKAGE_NAME = "com.itau";
                final String SANTANDER_APP_PACKAGE_NAME = "com.santander.app";
                final String CAIXA_APP_PACKAGE_NAME = "br.com.gabba.Caixa";
                final String BRADESCO_APP_PACKAGE_NAME = "com.bradesco";


                switch (nomeBanco){
                    case "Banco Itaú":
                        intent = mActivity.getBaseContext().getPackageManager().getLaunchIntentForPackage(ITAU_APP_PACKAGE_NAME);
                        if(intent != null){
                            mActivity.startActivity(intent);
                            mActivity.finish();
                        } else {
                            try {
                                mActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + ITAU_APP_PACKAGE_NAME)));
                            } catch (android.content.ActivityNotFoundException anfe) {
                                mActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + ITAU_APP_PACKAGE_NAME)));
                            }
                        }
                        break;

                    case "Banco do Brasil":
                            intent = mActivity.getBaseContext().getPackageManager().getLaunchIntentForPackage(BB_APP_PACKAGE_NAME);
                        if(intent != null){
                            mActivity.startActivity(intent);
                            mActivity.finish();
                        } else {
                            try {
                                mActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + BB_APP_PACKAGE_NAME)));
                            } catch (android.content.ActivityNotFoundException anfe) {
                                mActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + BB_APP_PACKAGE_NAME)));
                            }
                        }
                        break;

                    case "Caixa Econômica Federal":
                        intent = mActivity.getBaseContext().getPackageManager().getLaunchIntentForPackage(CAIXA_APP_PACKAGE_NAME);
                        if(intent != null){
                            mActivity.startActivity(intent);
                            mActivity.finish();
                        } else {
                            try {
                                mActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + CAIXA_APP_PACKAGE_NAME)));
                            } catch (android.content.ActivityNotFoundException anfe) {
                                mActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + CAIXA_APP_PACKAGE_NAME)));
                            }
                        }
                        break;

                    case "Banco Bradesco":
                        intent = mActivity.getBaseContext().getPackageManager().getLaunchIntentForPackage(BRADESCO_APP_PACKAGE_NAME);
                        if(intent != null){
                            mActivity.startActivity(intent);
                            mActivity.finish();
                        } else {
                            try {
                                mActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + BRADESCO_APP_PACKAGE_NAME)));
                            } catch (android.content.ActivityNotFoundException anfe) {
                                mActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + BRADESCO_APP_PACKAGE_NAME)));
                            }
                        }
                        break;

                    default:
                        break;
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

}
