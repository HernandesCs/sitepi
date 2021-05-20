package br.pi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.pi.pojo.Contato;

public class DaoContato {
	
private Connection connection;
	
	private Connection getConnection() throws SQLException {
		return connection = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/",
		        "SA", "");
	}
	
	public List<Contato> getLista() {
		List<Contato> result = new ArrayList<>();
		String sql = "SELECT nome, fone, email from contato";
		PreparedStatement pstmt;
		try {
			pstmt = getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery ();
		while ( rs.next() ) {
			String nome = rs.getString(2);
			int fone = rs.getInt("fone");
			String email = rs.getString(3);
		
			Contato Contato = new Contato(nome, fone, email);
			result.add(Contato);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

	public boolean excluirContato( Contato Contato ) {
		PreparedStatement pstmt;
		try {
			pstmt = getConnection().prepareStatement("DELETE FROM Contato WHERE nome = ?");
			pstmt.setString( 1, Contato.getNome() );
			return pstmt.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean inserirContato(Contato contato) {
		String sql = "INSERT INTO Contato values(?,?,?)";
		boolean result = false;
		PreparedStatement pstmt;
		try {
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, contato.getNome());
			pstmt.setInt( 2, contato.getFone());
			pstmt.setString(3, contato.getEmail());
			result = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean alterarContato( Contato antigo, Contato novo ) {
		PreparedStatement pstmt;
		try {
			pstmt = getConnection().prepareStatement("UPDATE contato set NOME = ?, fone = ?, email = ?  where "
					+ "nome=? and fone=? and email=?");
			pstmt.setString(1, antigo.getNome());
			pstmt.setInt( 2, antigo.getFone() );
			pstmt.setString(3, antigo.getEmail());
			pstmt.setString( 4, novo.getNome() );
			pstmt.setInt(5, novo.getFone());
			pstmt.setString(6, novo.getEmail());
			
			return pstmt.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	
	
	
	
	
	
	
	
	
	
}
