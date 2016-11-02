package com.example.wanko.FamilyApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RandomMoneyActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("RandomMoneyActivitySTART");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_random);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardList);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llManager = new LinearLayoutManager(this);

        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llManager);

        ArrayList<AnbayasiData> anbayasi = new ArrayList<AnbayasiData>();
        for(int i = 0; i <MyData.moneyArray.length; i++){
            anbayasi.add(new AnbayasiData(
                    MyData.moneyArray[i]
            ));
        }

        AnbayasiAdapter anbayasiAdapter = new AnbayasiAdapter(anbayasi, this);
        RecyclerView.Adapter adapter = anbayasiAdapter;
        recyclerView.setAdapter(adapter);
        int anbayasiSize = anbayasi.size();
        int scrollSize = (int)(Math.random()*anbayasiSize);
        recyclerView.smoothScrollToPosition (anbayasiSize - scrollSize);

    }
}
