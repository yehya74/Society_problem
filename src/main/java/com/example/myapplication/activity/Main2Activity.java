package com.example.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.classes.Main;
import com.example.myapplication.R;
import com.example.myapplication.classes.adapter;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView firstlist=findViewById(R.id.flist);

        ArrayList<Main>mainlist=new ArrayList<>();

        Main main1=new Main();
        main1.setName("FC Barcelona");
        main1.setYear(1899);
        main1.setImage(R.drawable.barca);

        Main main5=new Main();
        main5.setName("Al Ahly");
        main5.setYear(1907);
        main5.setImage(R.drawable.ahly);

        Main main3=new Main();
        main3.setName("Manchester City");
        main3.setYear(1894);
        main3.setImage(R.drawable.mancity);

        Main main4=new Main();
        main4.setName("Manchester United");
        main4.setYear(1878);
        main4.setImage(R.drawable.manu);

        mainlist.add(main1);
        mainlist.add(main5);
        mainlist.add(main3);
        mainlist.add(main4);

        adapter adapt=new adapter(this,R.layout.main2,mainlist);
        firstlist.setAdapter(adapt);

    }
}
