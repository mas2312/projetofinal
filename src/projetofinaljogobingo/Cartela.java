package projetofinaljogobingo;
import java.util.List;
import java.util.ArrayList;
import  java.util.Random;
public class Cartela {
	private int numero;
    private double valor;
    private List<Integer> numeros;

    public Cartela(int numero, double valor) {
        this.numero = numero;
        this.valor = valor;
        this.numeros = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public double getValor() {
        return valor;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public void gerarNumerosAleatorios() {
        Random random = new Random();
        while (numeros.size() < 24) {
            int numero = random.nextInt(75) + 1;
            if (!numeros.contains(numero)) {
                numeros.add(numero);
            }
        }
    }

    public boolean verificarBingo(List<Integer> numerosSorteados) {
        return numerosSorteados.containsAll(numeros);
    }

}
