package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidades.Produto;
import servicos.CalcularServico;

public class App01 {

	public static void main(String[] args) {
		
		List<Produto>list= new ArrayList<>();
		String path= "c:\\temp\\in.txt";
		
		try(BufferedReader br = new BufferedReader( new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				String[] primeiro = line.split(",");
				list.add(new Produto (primeiro[0],Double.parseDouble(primeiro[1])));
				
				line = br.readLine();
				}
			Produto x= CalcularServico.max(list);
			System.out.println("Mostrar o maior preço:");
			System.out.println(x);
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

}
