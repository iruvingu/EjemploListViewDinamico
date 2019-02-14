package com.example.scott.ejemplolistviewdinamico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

        private ListView listView;
        private Button btnAddNewItem;

        List<String> pulsos = new ArrayList<String>();

        Random rand = new Random();

        private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        btnAddNewItem = (Button) findViewById(R.id.btnNuevoItem);

        AddValorRandom();

        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,pulsos);

        listView.setAdapter(arrayAdapter);

        btnAddNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerificarLista();
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }

    public void AddValorRandom(){
        for (int i = 0; i < 1; i++ ){
            int  n = rand.nextInt(190 - 60) + 60;
            pulsos.add(String.valueOf(n));
        }
    }

    public void VerificarLista(){
        if (pulsos.size() < 14){
            AddValorRandom();
        }else {

            pulsos.clear();
            AddValorRandom();
        }
    }
}
