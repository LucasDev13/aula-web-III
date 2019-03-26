package br.com.aulawebIII.ex1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SelectManuscrito {

	public static void main(String[] args) {
		
		try {
			//abrindo a conexao
			//ConnectionFactory - minha classe de conexao
			//createConnection() -  metodo da classe ConnectionFactory
			Connection conexao = ConnectionFactory.createConnection();
			JOptionPane.showMessageDialog(null, "Conexão aberta com sucesso");//exibe uma mensagem
			
			//criar o SQL para extrair dados do banco
			String sql = "Select * from tbl_manuscrito";
			
			//criando o comando..
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			//Executa o comando
			ResultSet resultado = cmd.executeQuery();//resultado recebe os dados 
			
			String manuscrito;//variavel para receber dados
			manuscrito = "<< Manuscritos encontrados >>\n";
			while(resultado.next()) {//percorre todos os dados do retorno
				manuscrito += " - Id -> " + resultado.getInt("id") 
				+ " - Titulo -> " + resultado.getString("titulo") 
				+ " - Autor -> " + resultado.getString("autor")
				+ "\n";
			}
			
			
			JOptionPane.showMessageDialog(null, manuscrito);
			conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
