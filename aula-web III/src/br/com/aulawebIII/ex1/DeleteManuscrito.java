package br.com.aulawebIII.ex1;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class DeleteManuscrito {

	public static void main(String[] args) {
		try {
			//abrindo a conexao
			//ConnectionFactory - minha classe de conexao
			//createConnection() -  metodo da classe ConnectionFactory
			Connection conexao = ConnectionFactory.createConnection();
			JOptionPane.showMessageDialog(null, "Conexão aberta com sucesso");//exibe uma mensagem
			
			String autor = JOptionPane.showInputDialog("digite o autor");
			
			//fazer a busca no banco de dados de todos os valores e trazer para escolher qual deletar
			//escolher o id e incluir no sql para deletar
			
			
			//String sql para deletar por id
			String sql = "DELETE FROM tbl_manuscrito where autor=?;";
			
			
			//criando o comando..
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			/**
			 * o que vai determinar a exclusao sera o parametro colocado na query
			 * depois do where. Ex: where id=?. Porque ele será o primeiro indice da
			 * coluna da tabela por onde começará a excluir.
			 * cmd.setString(1, id); -> indice 1
			 * cmd.setString(2, autor); -> indice 2
			 * cmd.setString(3, titulo); -> indice 3
			 */
			cmd.setString(1, autor);
			
			//execute o comando
			cmd.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dados deletado com sucesso");
			//fecha a conexao
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
