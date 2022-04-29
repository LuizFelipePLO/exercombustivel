import java.beans.Transient;

import com.lfoliveira.CentroDistribuicao;
import com.lfoliveira.CentroDistribuicao.SITUACAO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CentroDistribuicaoTest {

    private CentroDistribuicao cd = null;

    void setUpTanqueNormal() {
        cd = new CentroDistribuicao(tAditivo, tGasolina, tAlcool1, tAlcool2);
        tAditivo = 500;
        tGasolina = 100000;
        tAlcool1 = 1250;
        tAlcool2 = 1250;

        SITUACAO situacaoTanqueCheio = SITUACAO.NORMAL;
    }

    void setUpTanqueSobraviso() {
        cd = new CentroDistribuicao(tAditivo, tGasolina, tAlcool1, tAlcool2);
        tAditivo = 300;
        tGasolina = 4000;
        tAlcool1 = 1000;
        tAlcool2 = 1250;

        SITUACAO situacaoTanqueSobraviso = SITUACAO.SOBRAVISO;
    }

    void setUpTanqueEmergencia() {
        cd = new CentroDistribuicao(tAditivo, tGasolina, tAlcool1, tAlcool2);
        tAditivo = 100;
        tGasolina = 3500;
        tAlcool1 = 400;
        tAlcool2 = 500;

        SITUACAO situacaoTanqueEmergencia = SITUACAO.EMERGENCIA;
    }

    @Test
    public void defineSituacaoTest() {

    }

    @Test
    public void getSituacaoTest() {

    }

    @Test
    public void gettGasolinaTest() {

    }

    @Test
    public void gettAditivoTest() {

    }

    @Test
    public void gettAlcool1Test() {

    }

    @Test
    public void gettAlcool2Test() {

    }

    @Test
    public void recebeAditivoTest() {

    }

    @Test
    public void recebeGasolinaTest() {

    }

    @Test
    public void recebeAlcoolTest() {

    }

    @Test
    public void encomendaCombustivelTest() {

    }

}
