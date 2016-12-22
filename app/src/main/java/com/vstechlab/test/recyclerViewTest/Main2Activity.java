package com.vstechlab.test.recyclerViewTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vstechlab.test.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView rvContact = (RecyclerView) findViewById(R.id.rv_contact);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvContact.setLayoutManager(layoutManager);

        MyRecyclerAdapter adapter = new MyRecyclerAdapter(new ArrayList<Contact>(), this);
        rvContact.setAdapter(adapter);
    }


}
