package peppa.hamburgueria;

import java.util.Map;

public class PedidoService {

    private Map<String, Double> cardapio;
    private int totalEmCentavos = 0;

    public void setCardapio(Map<String, Double> cardapio) {
        this.cardapio = cardapio;
    }

    public void adicionarItem(String item, int quantidade) {
        if (!cardapio.containsKey(item)) {
            throw new IllegalArgumentException("Item indisponível no cardápio");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida");
        }

        int precoCentavos = (int) Math.round(cardapio.get(item) * 100);
        totalEmCentavos += precoCentavos * quantidade;
    }

    public void adicionarItemComDesconto(String item, int quantidade, int desconto) {
        adicionarItem(item, quantidade);
        totalEmCentavos -= (totalEmCentavos * desconto) / 100;
    }

    public double getTotal() {
        return totalEmCentavos;
    }

    public int calcularTempoEstimado(int quantidadeTotal) {
        return quantidadeTotal * 4;
    }

    public void resetar() {
        totalEmCentavos = 0;
    }
}
