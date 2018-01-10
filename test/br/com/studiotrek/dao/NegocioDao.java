package br.com.studiotrek.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.studiotrek.model.Negocio;
import br.com.studiotrek.reflaction.BaseReflaction;

public class NegocioDao {

	public void inserir(Negocio negocio) throws Exception {
		
		BaseReflaction<Negocio> reflaction = new BaseReflaction<>(Negocio.class);
		reflaction.checkAnnotation(negocio);
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			StringBuilder qry = new StringBuilder();
			
			qry.append("INSERT INTO Negocio");
			qry.append(" (neg_nome, neg_idade)");
			qry.append(" VALUES");
			qry.append(" (?, ?)");
			
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(qry.toString());
			
			preparedStatement.setString(1, negocio.nome);
			preparedStatement.setInt(2, negocio.idade);
			
			//preparedStatement.executeUpdate();
		} catch (SQLException  e) {
			throw new SQLException();
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
	
	private static Connection getDBConnection() throws SQLException {
		Connection dbConnection = null;
		
		try {	
			Class.forName("");
			dbConnection = DriverManager.getConnection("DB_CONNECTION", "DB_USER","DB_PASSWORD");
			return dbConnection;
		} catch (ClassNotFoundException | SQLException e) {
			throw new SQLException(e);
		}
	}
	
}
