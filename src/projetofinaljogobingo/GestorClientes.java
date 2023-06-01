package projetofinaljogobingo;
import java.util.List;
import java.util.ArrayList;

public class GestorClientes {
	  private List<Cliente> clientes;

	    public GestorClientes() {
	        this.clientes = new ArrayList<>();
	    }

	    public void cadastrarCliente(Cliente cliente) {
	        clientes.add(cliente);
	    }

	    public void editarCliente(int indice, Cliente cliente) {
	        clientes.set(indice, cliente);
	    }

	    public void deletarCliente(int indice) {
	        clientes.remove(indice);
	    }

	    public List<Cliente> listarClientes() {
	        return clientes;
	    }
	


}
