package toDoList;

public class TarefaTeste {
	public static void main(String[] args) {
		View v1 = new View();
		CadastrarTarefa c1 = new CadastrarTarefa();
		Model m1 = new Model(v1, c1);
		Controller c = new Controller(v1, m1, c1);
		
		c.Mostrar();
		
		
		
	}
}
