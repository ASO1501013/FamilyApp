package com.example.wanko.FamilyApp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by wanko on 16/09/07.
 */
public class AnbayasiAdapter extends RecyclerView.Adapter<AnbayasiViewHolder>{
    private ArrayList<AnbayasiData> rouletteDataSet;
    private Activity activity;

    public AnbayasiAdapter(ArrayList<AnbayasiData> roulette, Activity activity){

        this.rouletteDataSet = roulette;
        this.activity = activity;

    }

    @Override
    public AnbayasiViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);

        return new AnbayasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AnbayasiViewHolder holder, final int listPosition){

        holder.textViewNumber.setText(rouletteDataSet.get(listPosition).getMoneyValue() + "円");
        holder.base.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("mailto:");
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra(Intent.EXTRA_SUBJECT,"おばあちゃんへ");
                intent.putExtra(Intent.EXTRA_TEXT,rouletteDataSet.get(listPosition).getMoneyValue() + "円ちょうだい");
                activity.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount(){
        return rouletteDataSet.size();
    }
}

