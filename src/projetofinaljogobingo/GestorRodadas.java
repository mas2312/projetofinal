package projetofinaljogobingo;
import java.util.List;
import java.util.ArrayList;
public class GestorRodadas {
	private List<Rodada> rodadas;

    public GestorRodadas() {
        this.rodadas = new ArrayList<>();
    }

    public void criarRodada() {
        int numero = rodadas.size() + 1;
        rodadas.add(new Rodada(numero));
    }

    public void sortearNumero(int numeroRodada) {
        Rodada rodada = rodadas.get(numeroRodada - 1);
        rodada.sortearNumero();
    }

    public List<Rodada> listarRodadas() {
        return rodadas;
    }

}
