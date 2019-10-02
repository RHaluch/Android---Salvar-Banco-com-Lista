package com.example.opet.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView listItem;
    private AppDatabase db;
    private List<Item> itens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItem = findViewById(R.id.listItem);
        findViewById(R.id.btnCadastrar).setOnClickListener(this);

        carregarDados();
    }

    private void carregarDados() {
        db = AppDatabase.getInstance(getApplicationContext());
        itens=db.itemDAO().getAll();
        carregarListView();
    }

    private void carregarListView() {
        ItemAdapter adapter = new ItemAdapter(getApplicationContext(),R.layout.list_item, itens);

        listItem.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        Intent intent =  new Intent(MainActivity.this, AddItem.class);
        startActivity(intent);
    }


}
