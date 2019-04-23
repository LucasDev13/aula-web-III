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
			
			//String sql para deletar por id
			String sql = "DELETE FROM tbl_manuscrito where autor=?;";
			
			
			//criando o comando..
			PreparedStatement cmd = conexao.prepareStatement(sql);
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
