package toDoList;

import java.util.ArrayList;
import java.util.List;

public class CadastrarTarefa {
	public List<Tarefa> tarefas;
	
	public CadastrarTarefa() {
		tarefas = new ArrayList<>();
	}
	
	public void addTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
	}
	public Tarefa chamarTarefa(String nome) {
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getNome().equalsIgnoreCase(nome)) {
				return tarefa;
			}
			else {
				System.out.println("Cadastro não encontrado!");
			}
		}
		return null;
	}
	public List<Tarefa> listarTarefa() {
		return tarefas;
	}
	public boolean removerTarefa(String nome) {
	    for (Tarefa tarefa : tarefas) {
	        if (tarefa.getNome().equalsIgnoreCase(nome)) {
	            tarefas.remove(tarefa);
	            return true; 
	        }
	    }
	    return false; 
	}
		
	public boolean editarTarefa(String nome, String novoNome) {
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getNome().equalsIgnoreCase(nome)) {
				tarefa.setNome(novoNome);
				System.out.println("\nNovo nome da tarefa:" + novoNome);
				return true;
				 
			}
		}
		return false;
	}
	public boolean mudarStatus(String nome, Status novoStatus) {
		Tarefa tarefa = chamarTarefa(nome);
		if (nome != null) {
			tarefa.setStatus(novoStatus);
			return true;
		}
		return false;
	}
}
