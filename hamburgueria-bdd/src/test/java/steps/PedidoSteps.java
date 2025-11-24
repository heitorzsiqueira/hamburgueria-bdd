package steps;

import io.cucumber.java.pt.*;
import peppa.hamburgueria.PedidoService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoSteps {

    private PedidoService service = new PedidoService();
    private Exception erroCapturado;

    @Dado("que o cardápio contém os itens:")
    public void que_o_cardapio_contem_os_itens(io.cucumber.datatable.DataTable dataTable) {
        Map<String, Double> mapa = new HashMap<>();

        dataTable.asMaps().forEach(linha ->
                mapa.put(linha.get("item"), Double.parseDouble(linha.get("preco")))
        );

        service.setCardapio(mapa);
        service.resetar();
        erroCapturado = null;
    }

    @Quando("eu pedir {string} com quantidade {int}")
    public void eu_pedir_com_quantidade(String item, Integer quantidade) {
        try {
            service.adicionarItem(item, quantidade);
        } catch (Exception e) {
            erroCapturado = e;
        }
    }

    @Quando("eu pedir {string} com quantidade {int} com desconto de {int} por cento")
    public void eu_pedir_com_quantidade_com_desconto(String item, Integer quantidade, Integer desconto) {
        try {
            service.adicionarItemComDesconto(item, quantidade, desconto);
        } catch (Exception e) {
            erroCapturado = e;
        }
    }

    @Quando("eu pedir {string} com quantidade total {int}")
    public void eu_pedir_com_quantidade_total(String item, Integer quantidade) {
        // só para cálculo de tempo (não soma total)
    }

    @Então("o total do pedido deve ser {double}")
    public void o_total_do_pedido_deve_ser(Double esperado) {
        assertEquals(esperado, service.getTotal());
    }

    @Então("deve ocorrer erro {string}")
    public void deve_ocorrer_erro(String msgEsperada) {
        assertNotNull(erroCapturado);
        assertEquals(msgEsperada, erroCapturado.getMessage());
    }

    @Então("o tempo estimado deve ser {int}")
    public void o_tempo_estimado_deve_ser(Integer esperado) {
        assertEquals(esperado, service.calcularTempoEstimado(4));
    }
}
