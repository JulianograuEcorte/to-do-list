package toDoList;

import java.util.List;

public class Model {
	private View view;
	private CadastrarTarefa cadastrarTarefa;
	
	Model(View view, CadastrarTarefa cadastrarTarefa){
		this.view = view;
		this.cadastrarTarefa = cadastrarTarefa;
	}
	
	void exibirMenu() {
		int opcao;
		
		do {
			opcao = view.exibirMenu();
		switch (opcao) {
		case 1: {
			Tarefa tarefa = view.cadastrarTarefa();
			cadastrarTarefa.addTarefa(tarefa);
			break;
		}
		case 2:{
			String nome = view.chamarPeloNome();
			cadastrarTarefa.removerTarefa(nome);
		}
		case 3: {
			String nome = view.chamarPeloNome();
			cadastrarTarefa.chamarTarefa(nome);
			break;
		}
		case 4:{
			List<Tarefa> tarefas = cadastrarTarefa.tarefas;
			view.listarTarefas(tarefas);
			break;
		}
		case 5:{
			String nome = view.chamarParaEditar();
			cadastrarTarefa.editarTarefa(nome, nome);
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
		}
		while (opcao != 0);
	}
}
