package com.lfoliveira;

public class CentroDistribuicao {

    public enum SITUACAO {
        NORMAL, SOBRAVISO, EMERGENCIA
    }

    public enum TIPOPOSTO {
        COMUM, ESTRATEGICO
    }

    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    public CentroDistribuicao(int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) {
    }

    // ajusta situação de acordo com as regras. Deve ser chamado pelo método
    // encomendaCombustível.
    public void defineSituacao() {
    }

    public SITUACAO getSituacao() {
        return null;
    }

    public int gettGasolina() {
        return 0;
    }

    public int gettAditivo() {
        return 0;
    }

    public int gettAlcool1() {
        return 0;
    }

    public int gettAlcool2() {
        return 0;
    }

    // metodos recebe[...] devem retornar o quanto armazenaram de acordo com o
    // tamanho do tanque. Devem retornar -1 caso o parametro seja invalido.
    public int recebeAditivo(int qtdade) {
        return qtdade;
    }

    public int recebeGasolina(int qtdade) {
        return qtdade;
    }

    public int recebeAlcool(int qtdade) {
        return qtdade;
    }

    //
    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
        return null;
    }

}
