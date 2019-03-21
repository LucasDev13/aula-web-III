package br.com.aulawebIII.ex1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection createConnection() {
		String stringDeconexao = "jdbc:postgresql://localhost:5432/aula-de-web";//url do driver jdbc
		String usuario = "postgres";
		String senha = "@901256";
		Connection conexao = null;
		
		try {
			conexao = DriverManager.getConnection(stringDeconexao, usuario, senha); // cria a conexão
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conexao;
	}
}