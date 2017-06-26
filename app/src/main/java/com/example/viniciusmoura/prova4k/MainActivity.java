package com.example.viniciusmoura.prova4k;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private String [] opcoes;
    private ArrayAdapter<String> opcoesAdapter;

    @Override
    //OnCreate = coisas principais
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicializaComponentes();

        // Sem isso porque ListAcitvity tem um layout próprio.
        // setContentView(R.layout.layout_main);

        super.setListAdapter(opcoesAdapter);

    }

    private void inicializaComponentes() {
        opcoes = new String[] {"Cadastrar", "Editar"};
        opcoesAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, opcoes);
    }

    //digitar onListItemClick
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
//        switch (position){
//            case 0:
//                Intent telaCadastro = new Intent(MainActivity.this, TelaCadastrar.class);
//                startActivity(telaCadastro);
//        break;
//            case 1:
//                Intent telaEditar = new Intent(MainActivity.this, ListaActivity.class);
//                startActivity(telaEditar);
//        break;
//        }
        if(position == 0){
            Intent telaCadastro = new Intent(MainActivity.this, TelaCadastrar.class);
            startActivity(telaCadastro);
        }else if (position == 1){
            Intent telaEditar = new Intent(MainActivity.this, ListaActivity.class);
            startActivity(telaEditar);
        }
    }
}


public class ExemploListActivity extends ListActivity {
    private ArrayList<Usuario> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_exemplo_list);
        Bundle parametrosPrimeiraTEla = getIntent().getExtras();
        users =(ArrayList<Usuario>)paramentrosPrimeiraTela.getSerializable("listaUsuarios");
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(this, android.R.layout.simples_list_item_1, users);
        setListAdapter(adapter);
    }
}


