package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Funcionario> list = new ArrayList<>();
		Funcionario F = null;
		Integer id = 0;
		String nome;
		Double sal;
		System.out.println("Informe a quantidade de registro");
		int n = sc.nextInt();
		
		for(int i = 0; i<n; i++){
			sc.nextLine();
			System.out.println("Funcionario " + (i + 1));
			System.out.println("ID");
			id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.println("Informe outro ID");
				id = sc.nextInt();
			}
			
			System.out.println("Nome");
			nome = sc.next();
			sc.nextLine();
			System.out.println("Salario");
			sal = sc.nextDouble();
			F = new Funcionario(id, nome, sal);
			list.add(F);
		}
		
		System.out.println("Informe Id para aumento no sal");
		int idP = sc.nextInt();
		Integer pos = position(list, idP);
		
		if(pos == null){
			System.out.println("ID não encontrado");
		} 
		else{
			System.out.println("Informe a porcentagem");
			double por = sc.nextDouble();
			list.get(pos).calculoSalario(por);
		}
		
		for(Funcionario Fun : list){
			System.out.println(Fun);
		}
		sc.close();
	}
	
	public static Integer position(List<Funcionario> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}