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

        setUpTanqueNormal();
        SITUACAO resultNormal = cd.getSituacao();
        Assertions.assertEquals(SITUACAO.NORMAL, resultNormal);

        setUpTanqueSobraviso();
        SITUACAO resultSobraviso = cd.getSituacao();
        Assertions.assertEquals(SITUACAO.SOBRAVISO, resultSobraviso);

        setUpTanqueEmergencia();
        SITUACAO resultEmergencia = cd.getSituacao();
        Assertions.assertEquals(SITUACAO.EMERGENCIA, resultEmergencia);

    }

    @Test
    public void gettGasolinaTest() {

        setUpTanqueNormal();
        int result = cd.gettGasolina();
        Assertions.assertEquals(10000, result);

    }

    @Test
    public void gettAditivoTest() {

        setUpTanqueNormal();
        int result = cd.gettAditivo();
        Assertions.assertEquals(500, result);

    }

    @Test
    public void gettAlcool1Test() {

        setUpTanqueNormal();
        int result = cd.gettAlcool1();
        Assertions.assertEquals(1250, result);

    }

    @Test
    public void gettAlcool2Test() {

        setUpTanqueNormal();
        int result = cd.gettAlcool2();
        Assertions.assertEquals(1250, result);

    }

    @Test
    public void recebeAditivoTest() {

        setUpTanqueSobraviso();
        int result = cd.recebeAditivo(100);
        Assertion.assertEquals(400, result);

    }

    @Test
    public void recebeAditivoValorInvalidoTest() {

        setUpTanqueNormal();
        int result = cd.recebeAditivo(150);
        Assertions.assertEquals(-1, result);

    }

    @Test
    public void recebeGasolinaTest() {

        setUpTanqueSobraviso();
        int result = cd.recebeGasolina(1000);
        Assertions.assertEquals(5000, result);

    }

    @Test
    public void recebeGasolinaValorInvalidoTest() {

        setUpTanqueNormal();
        int result = cd.recebeGasolina(1500);
        Assertions.assertEquals(-1, result);

    }

    @Test
    public void recebeAlcoolTest() {

        setUpTanqueSobraviso();
        int result = cd.recebeGasolina(200);
        Assertions.assertEquals(1450, result);

    }

    @Test
    public void recebeAlcoolValorInvalidoTest() {

        setUpTanqueNormal();
        int result = cd.recebeAlcool(150);
        Assertions.assertEquals(-1, result);

    }

    @Test
    public void encomendaCombustivelTest() {

    }

}
