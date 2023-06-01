package projetofinaljogobingo;
import java.util.List;
import java.util.ArrayList;
public class GestorFinanceiro {
    private List<Double> receitas;
    private List<Double> despesas;

    public GestorFinanceiro() {
        this.receitas = new ArrayList<>();
        this.despesas = new ArrayList<>();
    }

    public void registrarReceita(double valor) {
        receitas.add(valor);
    }

    public void registrarDespesa(double valor) {
        despesas.add(valor);
    }

    public double calcularTotalReceitas() {
        double total = 0.0;
        for (Double receita : receitas) {
            total += receita;
        }
        return total;
    }

    public double calcularTotalDespesas() {
        double total = 0.0;
        for (Double despesa : despesas) {
            total += despesa;
        }
        return total;
    }

    public double calcularLucro() {
        return calcularTotalReceitas() - calcularTotalDespesas();
    }

}
