package com.example.opet.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddItem extends AppCompatActivity {

    private EditText editNome, editQtde;
    private AppDatabase db;
    private Spinner spinnerCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        editNome= findViewById(R.id.editNome);
        editQtde= findViewById(R.id.editQtde);
        spinnerCategoria = findViewById(R.id.spinnerCategoria);

        findViewById(R.id.btnSalvar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarDados();
            }
        });
    }

    private void salvarDados() {
        String nome = editNome.getText().toString().trim();
        String qtde_s = editQtde.getText().toString().trim();
        String categoria = spinnerCategoria.getSelectedItem().toString();

        if (nome.isEmpty()){
            editNome.setError("Campo nome obrigatorio");
            editNome.requestFocus();
            return;
        }

        if (qtde_s.isEmpty()){
            editQtde.setError("Quantidade obrigatoria");
            editQtde.requestFocus();
            return;
        }

        /*if (categoria.isEmpty()){
            spinnerCategoria.setE("Categoria obrigatoria");
            spinnerCategoria.requestFocus();
            return;
        }*/

        Item item = new Item(nome, Integer.parseInt(qtde_s), categoria);
        db = AppDatabase.getInstance(getApplicationContext());
        long id_resultado = db.itemDAO().insert(item);

        if(id_resultado>0){
            Toast.makeText(this,"Item inserido!",Toast.LENGTH_SHORT);
            trocaTela();
        }else{
            Toast.makeText(this,"Erro ao inserir!",Toast.LENGTH_SHORT);
        }
    }

    private void trocaTela() {
        Intent intent = new Intent(AddItem.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
