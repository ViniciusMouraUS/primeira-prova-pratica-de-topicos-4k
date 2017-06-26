package POJO;

import java.io.Serializable;

/**
 * Created by viniciusmoura on 13/06/17.
 */

public class Condominio implements Serializable{

    private String nome;
    private String temElevador;
    private String qtApartamentos;
    private String areaTotal;
    private String id;
    private int posicaoItemSpinner;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTemElevador() {
        return temElevador;
    }

    public void setTemElevador(String temElevador) {
        this.temElevador = temElevador;
    }

    public String getQtApartamentos() {
        return qtApartamentos;
    }

    public void setQtApartamentos(String qtApartamentos) {
        this.qtApartamentos = qtApartamentos;
    }

    public String getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(String areaTotal) {
        this.areaTotal = areaTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPosicaoItemSpinner() {
        return posicaoItemSpinner;
    }

    public void setPosicaoItemSpinner(int posicaoItemSpinner) {
        this.posicaoItemSpinner = posicaoItemSpinner;
    }

    public Condominio(){

    }
    @Override
    public String toString(){
        return this.nome + ", " + this.temElevador + ", " + this.qtApartamentos + ", " + this.areaTotal;
    }
}
