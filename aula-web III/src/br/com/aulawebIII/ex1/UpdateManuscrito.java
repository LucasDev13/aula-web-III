package br.com.aulawebIII.ex1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class UpdateManuscrito {

	public static void main(String[] args) {
		System.out.println("Olá");
		
		Statement stmt=null;
		try {
			
			Connection conexao = ConnectionFactory.createConnection();
			//conexao.setAutoCommit(false);
			JOptionPane.showMessageDialog(null, "Conexão aberta com sucesso");
			
			String autor = JOptionPane.showInputDialog("Digite o autor do manuscrito");
			String titulo = JOptionPane.showInputDialog("Digite o titulo do manuscrito: ");
			String descricao = JOptionPane.showInputDialog("Digite a descricao: ");
			
			//stmt = conexao.createStatement();
			String sql = "UPDATE tbl_manuscrito SET autor=?, titulo=? descricao? WHERE id=?";
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, autor);
			cmd.setString(2, titulo);
			cmd.setString(3, descricao);
			
			cmd.executeUpdate();
			conexao.commit();
			JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
			
//			ResultSet rs = stmt.executeQuery("select * from tbl_manuscrito;");
//			while(rs.next()) {
//				int id = rs.getInt("id");
//				String aut = rs.getString("autor");
//				String desc = rs.getString("descricao");
//				
//				System.out.println("id = " + id);
//				System.out.println("autor = " + aut);
//				System.out.println("descricao = " + desc);
//			}
//			
//			rs.close();
//			stmt.close();
			cmd.close();
			conexao.close();
			
			
			//String autor = JOptionPane.showInputDialog("Digite o autor");
			
			
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
		}
		
		JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso");


	}

}
