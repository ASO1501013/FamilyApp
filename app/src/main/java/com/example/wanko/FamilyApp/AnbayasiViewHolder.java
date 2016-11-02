package com.example.wanko.FamilyApp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by wanko on 16/09/07.
 */
public class AnbayasiViewHolder extends RecyclerView.ViewHolder{

    View base;
    TextView textViewNumber;

    public AnbayasiViewHolder(View v){
        super(v);
        this.base = v;
        this.textViewNumber = (TextView) v.findViewById(R.id.number);
    }

}
