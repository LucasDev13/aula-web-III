package br.com.aulawebIII.ex1;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class InsereManuscrito {
	
	public static void main(String[] args) {
		try {
			//abrindo a conexao
			//ConnectionFactory - minha classe de conexao
			//createConnection() -  metodo da classe ConnectionFactory
			Connection conexao = ConnectionFactory.createConnection();
			JOptionPane.showMessageDialog(null, "Conexão aberta com sucesso");//exibe uma mensagem
			
			//Vamos salvar nas variaveis os dados que serao inseridos no banco
			String autor = JOptionPane.showInputDialog("Digite o autor do manuscrito");
			String titulo = JOptionPane.showInputDialog("Digite o titulo do manuscrito: ");
			String descricao = JOptionPane.showInputDialog("Digite a descricao: ");
			
			String sql = "insert into tbl_manuscrito(autor, titulo, descricao) values (?, ?, ?)";
			
			//Criando um comando para passar a sql por parametro com o preparedStatement
			PreparedStatement cmd=conexao.prepareStatement(sql);
			cmd.setString(1, autor);// passando os parametros do sql
			cmd.setString(2, titulo);// obs: caso fosse do tipo inteiro seria cmd.setInt
			cmd.setString(3, descricao);
			
			//execute o comando
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
			//fecha a conexao
			cmd.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
