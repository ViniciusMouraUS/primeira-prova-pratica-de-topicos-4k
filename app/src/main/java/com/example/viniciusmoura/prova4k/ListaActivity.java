package com.example.viniciusmoura.prova4k;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import DAO.CondominioDAO;
import POJO.Condominio;

/**
 * Created by viniciusmoura on 16/06/17.
 */

public class ListaActivity extends ListActivity {

    private ArrayList<Condominio> listaCondominio;
    private ArrayAdapter<Condominio> adapterListaCondominio;
    private CondominioDAO condominioDAO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicializaComponentes();
    }
        private void inicializaComponentes(){
            condominioDAO = new CondominioDAO(getApplicationContext());
            listaCondominio = condominioDAO.listar();
            adapterListaCondominio = new ArrayAdapter<Condominio>(getApplicationContext(), android.R.layout.simple_list_item_1, listaCondominio);
            setListAdapter(adapterListaCondominio);
        }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent itTelaEditar = new Intent(getApplicationContext(), TelaEditar.class);
        itTelaEditar.putExtra("condominio", listaCondominio.get(position));
        startActivity(itTelaEditar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.onCreate(null);
    }
}