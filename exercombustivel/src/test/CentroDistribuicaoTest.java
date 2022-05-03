import com.lfoliveira.CentroDistribuicao;
import com.lfoliveira.CentroDistribuicao.SITUACAO;
import com.lfoliveira.CentroDistribuicao.TIPOPOSTO;

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

    void setUpTanqueNormalSemSituacao() {
        cd = new CentroDistribuicao(tAditivo, tGasolina, tAlcool1, tAlcool2);
        tAditivo = 500;
        tGasolina = 100000;
        tAlcool1 = 1250;
        tAlcool2 = 1250;
    }

    void setUpTanqueSobraviso() {
        cd = new CentroDistribuicao(tAditivo, tGasolina, tAlcool1, tAlcool2);
        tAditivo = 300;
        tGasolina = 4000;
        tAlcool1 = 1000;
        tAlcool2 = 1250;

        SITUACAO situacaoTanqueSobraviso = SITUACAO.SOBRAVISO;
    }

    void setUpTanqueSobravisoSemSituacao() {
        cd = new CentroDistribuicao(tAditivo, tGasolina, tAlcool1, tAlcool2);
        tAditivo = 300;
        tGasolina = 4000;
        tAlcool1 = 1000;
        tAlcool2 = 1250;
    }

    void setUpTanqueEmergencia() {
        cd = new CentroDistribuicao(tAditivo, tGasolina, tAlcool1, tAlcool2);
        tAditivo = 100;
        tGasolina = 3500;
        tAlcool1 = 0;
        tAlcool2 = 900;

        SITUACAO situacaoTanqueEmergencia = SITUACAO.EMERGENCIA;
    }

    void setUpTanqueEmergenciaSemSituacao() {
        cd = new CentroDistribuicao(tAditivo, tGasolina, tAlcool1, tAlcool2);
        tAditivo = 100;
        tGasolina = 3500;
        tAlcool1 = 0;
        tAlcool2 = 900;
    }

    @Test
    public void defineSituacaoNormalTest() {

        setUpTanqueNormalSemSituacao();
        SITUACAO resultNormal = cd.defineSituacao();
        Assertion.assertEquals(SITUACAO.NORMAL, resultNormal);
    }

    @Test
    public void defineSituacaoSobravisoTest() {

        setUpTanqueSobravisoSemSituacao();
        SITUACAO resultSobraviso = cd.defineSituacao();
        Assertion.assertEquals(SITUACAO.SOBRAVISO, resultNormal);
    }

    @Test
    public void defineSituacaoEmergenciaTest() {

        setUpTanqueEmergenciaSemSituacao();
        SITUACAO resultEmergencia = cd.defineSituacao();
        Assertion.assertEquals(SITUACAO.EMERGENCIA, resultNormal);
    }

    @Test
    public void getSituacaoNormalTest() {

        setUpTanqueNormal();
        SITUACAO resultNormal = cd.getSituacao();
        Assertions.assertEquals(SITUACAO.NORMAL, resultNormal);
    }

    @Test
    public void getSituacaoSobravisoTest() {

        setUpTanqueSobraviso();
        SITUACAO resultSobraviso = cd.getSituacao();
        Assertions.assertEquals(SITUACAO.SOBRAVISO, resultSobraviso);
    }

    @Test
    public void getSituacaoEmergenciaTest() {
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
    public void encomendaCombustivelComTanqueNormalEmPostoComumTest() {
        setUpTanqueNormal();
        int[] expectedResult = { 485, 9790, 1175, 1250 };
        int[] result = cd.encomendaCombustivel(300, TIPOPOSTO.COMUM);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void encomendaCombustivelComTanqueNormalEmPostoComumEstrategico() {
        setUpTanqueNormal();
        int[] expectedResult = { 485, 9790, 1175, 1250 };
        int[] result = cd.encomendaCombustivel(300, TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void encomendaCombustivelComTanqueSobravisoEmPostoComumTest() {
        setUpTanqueSobraviso();
        int[] expectedResult = { 292, 3895, 963, 1250 };
        int[] result = cd.encomendaCombustivel(300, TIPOPOSTO.COMUM);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void encomendaCombustivelComTanqueSobravisoEmPostoEstrategicoTest() {
        setUpTanqueSobraviso();
        int[] expectedResult = { 285, 3790, 925, 1250 };
        int[] result = cd.encomendaCombustivel(300, TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void encomendaCombustivelComTanqueEmergenciaEmPostoComumTest() {
        setUpTanqueEmergencia();
        int[] expectedResult = { -14, 3395, 0, 863 };
        int[] result = cd.encomendaCombustivel(300, TIPOPOSTO.COMUM);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void encomendaCombustivelComTanqueEmergenciaEmPostoEstrategicoTest() {
        setUpTanqueEmergencia();
        int[] expectedResult = { 93, 3395, 0, 863 };
        int[] result = cd.encomendaCombustivel(300, TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void encomendaCombustivelValorInvalidoTest() {
        setUpTanqueNormal();
        int[] expectedResult = { -7, 9790, 1175, 1250 };
        int[] result = cd.encomendaCombustivel(-300, TIPOPOSTO.COMUM);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void encomendaCombustivelReservaInsuficientelTest() {
        setUpTanqueNormal();
        int[] expectedResult = { -21, 9790, 1175, 1250 };
        int[] result = cd.encomendaCombustivel(20000, TIPOPOSTO.COMUM);
        Assertions.assertEquals(expectedResult, result);
    }

}
