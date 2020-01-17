package com.example.recdemo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<DataPojo> lst;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView)findViewById(R.id.rv);
        lst = new ArrayList<>();

        lst.add(new DataPojo(1,"", "", "",true,false));
        lst.add(new DataPojo(1,"aaa", "ce", "10000",false,false));
        lst.add(new DataPojo(2,"bbb", "me", "20000",false,false));
        lst.add(new DataPojo(3,"ccc", "ee", "30000",false,false));
        lst.add(new DataPojo(4,"ddd", "ce", "40000",false, false));
        lst.add(new DataPojo(5,"", "", "",false,true));

        adapter = new CustomAdapter(this, lst);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);


    }
}
