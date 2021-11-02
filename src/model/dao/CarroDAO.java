package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ConexaoBD;
import model.vo.Carro;

public class CarroDAO {
	
	private PreparedStatement stmt = null;

	public Carro readCarro(int id) {
		Connection connection =  ConexaoBD.getConnection();
		String select = "select*from carro where id = ?;";
		Carro c = null;
		
		try {
			stmt = connection.prepareStatement(select);
			stmt.setInt(1, id);
	
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				c = new Carro();
				
				c.setId(rs.getInt("id"));
				c.setPlaca(rs.getString("placa"));
				c.setRenavam(rs.getString("renavam"));
				c.setModelo(rs.getString("modelo"));
				c.setFabricante(rs.getString("fabricante"));
				c.setAno_fabricacao(rs.getString("ano_fabricacao"));
				c.setAno_modelo(rs.getString("ano_modelo"));
			}
			
		}catch(SQLException ex) {
			System.err.println("Erro ao visualizar carro!");
			ex.printStackTrace();
		}finally {
			ConexaoBD.closeConnection();
		}
		
		return c;
	}
	
	public ArrayList<Carro> readCarros() {
		Connection connection =  ConexaoBD.getConnection();
		String select = "select*from carro;";
		ArrayList<Carro> carros = new ArrayList<Carro>();
		Carro c = null;
		
		try {
			stmt = connection.prepareStatement(select);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				c = new Carro();
				
				c.setId(rs.getInt("id"));
				c.setPlaca(rs.getString("placa"));
				c.setRenavam(rs.getString("renavam"));
				c.setModelo(rs.getString("modelo"));
				c.setFabricante(rs.getString("fabricante"));
				c.setAno_fabricacao(rs.getString("ano_fabricacao"));
				c.setAno_modelo(rs.getString("ano_modelo"));
				
				carros.add(c);
			}
		}catch(SQLException ex) {
			System.err.println("Erro ao visualizar Carros!");
			ex.printStackTrace();
		}finally {
			ConexaoBD.closeConnection();
		}
		
		return carros;
	}

	public int createCarro(Carro c) {
		Connection connection =  ConexaoBD.getConnection();
		String insert = "insert into carro (placa,renavam,modelo,fabricante,ano_fabricacao,ano_modelo) values(?,?,?,?,?,?);";
		int r = 0;
		
		try {
			stmt = connection.prepareStatement(insert);
			
			stmt.setString(1, c.getPlaca());
			stmt.setString(2, c.getRenavam());
			stmt.setString(3, c.getModelo());
			stmt.setString(4, c.getFabricante());
			stmt.setString(5, c.getAno_fabricacao());
			stmt.setString(6, c.getAno_modelo());
			
			r = stmt.executeUpdate();	
		}catch(SQLException ex) {
			System.err.println("Erro ao cadastrar Carro!");
			ex.printStackTrace();
		}finally {
			ConexaoBD.closeConnection();
		}
		
		return r;
	}
	
	public int updateCarro(Carro c) {
		
		Connection connection =  ConexaoBD.getConnection();
		String insert = "update carro set placa = ?, modelo = ?,fabricante = ? where id = ?;";
		int x = 0;
		
		try {
			stmt = connection.prepareStatement(insert);
			
			stmt.setString(1, c.getPlaca());
			stmt.setString(2, c.getModelo());
			stmt.setString(3, c.getFabricante());
			//stmt.setString(4, c.getAno_fabricacao());
			stmt.setInt(4, c.getId());
			
			x = stmt.executeUpdate();	
			
		}catch(SQLException ex) {
			System.err.println("Erro ao atualizar Carro!");
			ex.printStackTrace();
		}finally {
			ConexaoBD.closeConnection();
		}
		
		return x;
	}
	
	public void deleteCarro(Carro c) {
		Connection connection =  ConexaoBD.getConnection();
		String delete = "delete from carro where id = ?;";
		
		try {
			stmt = connection.prepareStatement(delete);
			stmt.setInt(1, c.getId());
			
			stmt.executeUpdate();	
		}catch(SQLException ex) {
			System.err.println("Erro ao remover Carro!");
			ex.printStackTrace();
		}finally {
			ConexaoBD.closeConnection();
		}
	}
}