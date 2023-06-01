package projetofinaljogobingo;
import java.util.List;
import java.util.ArrayList;
import  java.util.Random;
public class Rodada {
	private int numero;
    private List<Integer> numerosSorteados;

    public Rodada(int numero) {
        this.numero = numero;
        this.numerosSorteados = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public List<Integer> getNumerosSorteados() {
        return numerosSorteados;
    }

    public void sortearNumero() {
        Random random = new Random();
        int numeroSorteado;
        do {
            numeroSorteado = random.nextInt(75) + 1;
        } while (numerosSorteados.contains(numeroSorteado));
        numerosSorteados.add(numeroSorteado);
        System.out.println("Número sorteado: " + numeroSorteado);
    }

}
