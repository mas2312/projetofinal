package projetofinaljogobingo;
import java.util.List;
import java.util.ArrayList;
public class GestorVendas {
    private List<Cartela> cartelasDisponiveis;
    private List<Cartela> cartelasVendidas;

    public GestorVendas() {
        this.cartelasDisponiveis = new ArrayList<>();
        this.cartelasVendidas = new ArrayList<>();
    }

    public void cadastrarCartela(Cartela cartela) {
        cartelasDisponiveis.add(cartela);
    }

    public void venderCartela(int numeroCartela) {
        Cartela cartela = cartelasDisponiveis.remove(numeroCartela);
        cartelasVendidas.add(cartela);
    }

    public List<Cartela> listarCartelasDisponiveis() {
        return cartelasDisponiveis;
    }

    public List<Cartela> listarCartelasVendidas() {
        return cartelasVendidas;
    }

}
