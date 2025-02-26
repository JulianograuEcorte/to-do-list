package toDoList;



import java.util.Date;

public class Tarefa {
	private String nome;
	private Status status;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	Tarefa(String nome, Status status, Date data){
		this.nome = nome;
		this.status = status.PENDENTE;
		
	}
	@Override
	public String toString() {
		return "Tarefa:" + nome + " Status:" + status;
 	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
