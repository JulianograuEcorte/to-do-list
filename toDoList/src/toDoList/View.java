package toDoList;

import java.util.List;
import java.util.Scanner;

public class View {
	public Scanner scanner;
	
	public View() {
		scanner = new Scanner(System.in);
	}
	
	public int exibirMenu() {
		System.out.println("\n-Seja bem-vindo ao to-doList-\n");
		System.out.println("1. Cadastrar nova tarefa!");
		System.out.println("2. Remover tarefa!");
		System.out.println("3. Procurar tarefa pelo nome!");
		System.out.println("4. Listar todas tarefas cadastradas!");
		System.out.println("5. Alterar tarefa");
		System.out.println("6. Alterar status da tarefa");
		System.out.println("0. Sair do aplicativo.");
		return scanner.nextInt();
		
	}
	public Tarefa cadastrarTarefa() {
		scanner.nextLine();
		System.out.println("Nome da tarefa:");
		String nome = scanner.nextLine();
		System.out.println("Tarefa cadastrada!");
		
		return new Tarefa(nome, null, null);
	}
	public Status status() {
		System.out.println("Escolha o status:");
		System.out.println("1. PENDENTE");
		System.out.println("2. EM ANDAMENTO");
		System.out.println("3. CONCLUIDA");
		int opcao = scanner.nextInt();
		
		switch (opcao) {
		case 1: {
			return Status.PENDENTE;
		}
		case 2: {
			return Status.EM_ANDAMENTO;
		}
		case 3: {
			return Status.CONCLUIDA;
		}
		default:
			System.out.println("Opção inválida...");
			return null;
		}
	}
	
	public String exibirTarefa (String tarefa) {
		if (tarefa != null) {
			System.out.println(tarefa);
		}
		else {
			System.out.println("❌ Tarefa não encontrada!");
		}
		return null;
	}
	
	public void listarTarefas(List<Tarefa> tarefas) {
		if (tarefas.isEmpty()) {
			System.out.println("❌ Lista de tarefas está vazia!");
		}
		else{
			for (Tarefa tarefa : tarefas) {
				System.out.println(tarefa);
			}
		}
		
	}
	
	public String chamarPeloNome() {
		scanner.nextLine();
		System.out.println("Digite o nome da tarefa:");
		return scanner.nextLine();
	}
	public String chamarParaEditar() {
		scanner.nextLine();
		System.out.println("Qual será o novo nome da tarefa?:");
		return scanner.nextLine();
	}
	
	
}
