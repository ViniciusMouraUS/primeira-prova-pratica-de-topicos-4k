package com.example.viniciusmoura.prova4k;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import DAO.CondominioDAO;
import POJO.Condominio;

/**
 * Created by viniciusmoura on 13/06/17.
 */

public class TelaCadastrar extends AppCompatActivity {

    private EditText etCondominio, etAreaTotal;
    private CheckBox cbElevador;
    private Spinner spAps;
    private Button btCadastrar;
    private String[] aps;
    private ArrayAdapter<String> apsAdapter;
    private Condominio condominio;
    private CondominioDAO condominioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cadastrar);

        inicializaComponentes();
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condominio = new Condominio();
                condominio.setNome(etCondominio.getText().toString());
                condominio.setAreaTotal((etAreaTotal.getText().toString()));
                condominio.setQtApartamentos((spAps.getSelectedItem().toString()));
                condominio.setPosicaoItemSpinner(spAps.getSelectedItemPosition());
                if(cbElevador.isChecked()){
                    condominio.setTemElevador("Sim");
                }else{
                    condominio.setTemElevador("Não");
                }

                boolean salvou = condominioDAO.salvar(condominio);
                if(salvou==true){
                    Toast.makeText(getApplicationContext(), "Salvou", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Não deu bom", Toast.LENGTH_LONG).show();
                }
                finish();
            }
        });
    }

    private void inicializaComponentes(){
        etCondominio = (EditText)findViewById(R.id.et_condominio);
        etAreaTotal = (EditText)findViewById(R.id.et_areatotal);
        cbElevador = (CheckBox)findViewById(R.id.cb_elevador);
        spAps = (Spinner)findViewById(R.id.sp_aps);
        btCadastrar = (Button)findViewById(R.id.bt_cadastrar);
        aps = new String[] {"1","2","3","4","5","6","7","8","9","10"};
        apsAdapter = new ArrayAdapter<String>(TelaCadastrar.this, android.R.layout.simple_spinner_dropdown_item, aps);
        spAps.setAdapter(apsAdapter);
        condominioDAO = new CondominioDAO(TelaCadastrar.this);
    }
}