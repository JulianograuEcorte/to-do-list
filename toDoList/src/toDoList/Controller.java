package toDoList;

import java.util.List;
import java.util.Scanner;

public class Controller {
	private View view;
	@SuppressWarnings("unused")
	private Model model;
	private CadastrarTarefa cadastrarTarefa;
	
	public Controller(View view, Model model, CadastrarTarefa cadastrarTarefa) {
		this.view = view;
		this.model = model;
		this.cadastrarTarefa = cadastrarTarefa;
	}
	
	 void Mostrar() {
		
		int opcao;
		Scanner scanner = new Scanner(System.in);
		
		do {
			
			opcao = view.exibirMenu();
			switch (opcao) {
			case 1: {
				addTarefa();
				break;
			}
			case 2: {
				removerTarefa();
				break;
			}
			case 3: {
				chamarTarefa();
				break;
			}
			case 4: {
				listarTarefa();
				break;
			}
			case 5:{
				editarTarefa();
				break;
			}
			case 6:{
				alterarStatus();
				break;
			}
			case 0:{
				System.out.println("Saindo...");
				break;
			}
			default:
				System.out.println("Opção inválida...");
				break;
			}
			
		} while (opcao != 0);
		scanner.close();
	}
	
	public void addTarefa() {
		Tarefa tarefa = view.cadastrarTarefa();
		cadastrarTarefa.addTarefa(tarefa);
	}
	public void chamarTarefa() {
		String nome = view.chamarPeloNome();
		Tarefa tarefa = cadastrarTarefa.chamarTarefa(nome);
		
		if (tarefa != null) {
			System.out.println(tarefa);
		}
		else {
			System.out.println("❌ Tarefa não encontrada!");
		}
	}
	public void listarTarefa() {
		List<Tarefa> tarefas = cadastrarTarefa.listarTarefa();
		view.listarTarefas(tarefas);
	}
	public void removerTarefa() {
	    String nome = view.chamarPeloNome();
	    boolean removida = cadastrarTarefa.removerTarefa(nome);
	    if (removida) {
	        System.out.println("✅ Tarefa removida com sucesso!");
	    } else {
	        System.out.println("❌ Tarefa não encontrada.");
	    }
	}
	public void editarTarefa() {
		String nomeParaBuscar = view.chamarPeloNome();
		String nome = view.chamarParaEditar();
		boolean alterada = cadastrarTarefa.editarTarefa(nomeParaBuscar, nome);
		if (alterada) {
			 System.out.println("✅ Tarefa alterada com sucesso!");
	    } else {
	        System.out.println("❌ Tarefa não encontrada.");
	    }
	}
	public void alterarStatus() {
		String nome = view.chamarPeloNome();
		Status novoStatus = view.status();
		
		if (novoStatus != null) {
			boolean alterada = cadastrarTarefa.mudarStatus(nome, novoStatus);
			if (alterada) {
				System.out.println("✅ Tarefa alterada com sucesso!");
			}
		 } else {
		        System.out.println("❌ Tarefa não encontrada.");    
		}
		
		
	}
}
