package entities;

public class Funcionario {
	private Integer id;
	private String nome;
	private Double sal;
	
	public Funcionario(Integer id, String nome, Double sal) {
		this.id = id;
		this.nome = nome;
		this.sal = sal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSal() {
		return sal;
	}
	
	public void calculoSalario(double por){
		sal += sal * por / 100;
	}

	@Override
	public String toString() {
		return "Funcionario [id= " + id + ", nome= " + nome + ", sal= " 
				+ String.format("%.2f", sal) + "]";
	}
	
}
