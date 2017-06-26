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

public class TelaEditar extends AppCompatActivity {

    private Condominio condominio;
    private CondominioDAO condominioDAO;
    private EditText etCondominio, etAreaTotal;
    private CheckBox cbElevador;
    private Spinner spAps;
    private Button btEditar;
    private String[] aps;
    private ArrayAdapter<String> apsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_editar);

        inicializaComponentes();

        etCondominio.setText(condominio.getNome());
        etAreaTotal.setText(condominio.getAreaTotal());

        if(condominio.getTemElevador().equals("Sim")){
            cbElevador.toggle();
        }
        spAps.setSelection(condominio.getPosicaoItemSpinner());

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condominio.setNome(etCondominio.getText().toString());
                condominio.setAreaTotal((etAreaTotal.getText().toString()));
                condominio.setQtApartamentos((spAps.getSelectedItem().toString()));
                condominio.setPosicaoItemSpinner(spAps.getSelectedItemPosition());
                if(cbElevador.isChecked()){
                    condominio.setTemElevador("Sim");
                }else{
                    condominio.setTemElevador("Não");
                }

                boolean salvou = condominioDAO.editar(condominio);
                if(salvou==true){
                    Toast.makeText(getApplicationContext(), "Editou", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Não editou", Toast.LENGTH_LONG).show();
                }
                finish();
            }
        });
    }

    private void inicializaComponentes(){
        condominio = (Condominio)getIntent().getSerializableExtra("condominio");
        condominioDAO = new CondominioDAO(getApplicationContext());
        etCondominio = (EditText)findViewById(R.id.et_condominio);
        etAreaTotal = (EditText)findViewById(R.id.et_areatotal);
        cbElevador = (CheckBox)findViewById(R.id.cb_elevador);
        spAps = (Spinner)findViewById(R.id.sp_aps);
        btEditar = (Button)findViewById(R.id.bt_editar);
        aps = new String[] {"1","2","3","4","5","6","7","8","9","10"};
        apsAdapter = new ArrayAdapter<String>(TelaEditar.this, android.R.layout.simple_spinner_dropdown_item, aps);
        spAps.setAdapter(apsAdapter);
    }
}