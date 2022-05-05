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

    private int tAditivo;
    private int tGasolina;
    private int tAlcool1;
    private int tAlcool2;
    private SITUACAO situacaoAtual;
    private TIPOPOSTO tipoPosto;

    public CentroDistribuicao(int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) {
        this.tAditivo = tAditivo;
        this.tGasolina = tGasolina;
        this.tAlcool1 = tAlcool1;
        this.tAlcool2 = tAlcool2;
        defineSituacao();
    }

    // ajusta situação de acordo com as regras. Deve ser chamado pelo método
    // encomendaCombustível.
    public void defineSituacao() {
        if (getAditivo() < (MAX_ADITIVO / 2) || getGasolina() < (MAX_GASOLINA / 2)
                || (getAlcool1() + getAlcool2()) > (MAX_ALCOOL / 2)) {
            situacaoAtual = SITUACAO.SOBRAVISO;
        } else if (getAditivo() < (MAX_ADITIVO / 4) || getGasolina() < (MAX_GASOLINA / 4)
                || (getAlcool1() + getAlcool2()) > (MAX_ALCOOL / 4)) {
            situacaoAtual = SITUACAO.EMERGENCIA;
        } else {
            situacaoAtual = SITUACAO.NORMAL;
        }
    }

    public SITUACAO getSituacao() {
        return this.situacaoAtual;
    }

    public int getGasolina() {
        return this.tGasolina;
    }

    public int getAditivo() {
        return this.tAditivo;
    }

    public int getAlcool1() {
        return this.tAlcool1;
    }

    public int getAlcool2() {
        return this.tAlcool2;
    }

    // metodos recebe[...] devem retornar o quanto armazenaram de acordo com o
    // tamanho do tanque. Devem retornar -1 caso o parametro seja invalido.
    private boolean validaGasolina(int novaGasolina) {
        if (novaGasolina > MAX_GASOLINA)
            return false;
        return true;
    }

    private boolean validaÁlcool(int novoAlcool) {
        if (novoAlcool > MAX_ALCOOL / 2)
            return false;
        return true;
    }

    private boolean validaAditivo(int novoAditivo) {
        if (novoAditivo > MAX_ADITIVO)
            return false;
        return true;
    }

    public int recebeAditivo(int qtdade) {
        if (validaAditivo(this.tAditivo + qtdade)) {
            this.tAditivo += qtdade / 2;
            defineSituacao();
            return getAditivo();
        }
        return -1;
    }

    public int recebeGasolina(int qtdade) {
        if (validaGasolina(this.tAditivo + qtdade)) {
            this.tGasolina += qtdade;
            defineSituacao();
            return getAditivo();
        }
        return -1;
    }

    public int recebeAlcool(int qtdade) {
        if (validaÁlcool(this.tAditivo + qtdade)) {
            this.tAlcool1 += qtdade / 2;
            this.tAlcool2 += qtdade / 2;
            defineSituacao();
            return getAditivo();
        }
        return -1;
    }

    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
        int[] tanqueAtual = new int[4];
        getSituacao();
        switch (getSituacao()) {
            case NORMAL:
                tAditivo = getAditivo() - (qtdade / 20);
                tGasolina = getGasolina() - (qtdade * (7 / 10));
                tAlcool1 = getAlcool1() - (qtdade / 8);
                tAlcool2 = getAlcool2() - (qtdade / 8);
                tanqueAtual[0] = getAditivo();
                tanqueAtual[1] = getGasolina();
                tanqueAtual[2] = getAlcool1();
                tanqueAtual[3] = getAlcool2();
                break;
            case SOBRAVISO:
                if (tipoPosto == TIPOPOSTO.COMUM) {
                    tAditivo = getAditivo() - (qtdade / 40);
                    tGasolina = getGasolina() - (qtdade * (7 / 20));
                    tAlcool1 = getAlcool1() - (qtdade / 16);
                    tAlcool2 = getAlcool2() - (qtdade / 16);
                    tanqueAtual[0] = getAditivo();
                    tanqueAtual[1] = getGasolina();
                    tanqueAtual[2] = getAlcool1();
                    tanqueAtual[3] = getAlcool2();
                } else {
                    tAditivo = getAditivo() - (qtdade / 20);
                    tGasolina = getGasolina() - (qtdade * (7 / 10));
                    tAlcool1 = getAlcool1() - (qtdade / 8);
                    tAlcool2 = getAlcool2() - (qtdade / 8);
                    tanqueAtual[0] = getAditivo();
                    tanqueAtual[1] = getGasolina();
                    tanqueAtual[2] = getAlcool1();
                    tanqueAtual[3] = getAlcool2();
                }
                break;
            case EMERGENCIA:
                if (tipoPosto == TIPOPOSTO.COMUM) {
                    tanqueAtual[0] = -14;
                } else {
                    tAditivo = getAditivo() - (qtdade / 40);
                    tGasolina = getGasolina() - (qtdade * (7 / 20));
                    tAlcool1 = getAlcool1() - (qtdade / 16);
                    tAlcool2 = getAlcool2() - (qtdade / 16);
                    tanqueAtual[0] = getAditivo();
                    tanqueAtual[1] = getGasolina();
                    tanqueAtual[2] = getAlcool1();
                    tanqueAtual[3] = getAlcool2();
                }
                break;
        }

        return tanqueAtual;
    }

    public static void main(String[] args) {
        CentroDistribuicao tanqueDistribuicao = new CentroDistribuicao(500, 10000, 1250, 1250);
        tanqueDistribuicao.encomendaCombustivel(300, TIPOPOSTO.ESTRATEGICO);

    }

}