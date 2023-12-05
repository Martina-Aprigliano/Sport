package Progetto.sport.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import Progetto.sport.Util.LettoreFile;

public class Database {

	private static Database instance;
	private Connection conn;


	private Database() {
		apriConnection();
	}

	protected static Database getInstance() {
		if(instance == null)
			instance = new Database();
		return instance;
	}


	private void apriConnection() {
		HashMap<String, String> dbConf = LettoreFile.getDBCONF();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbConf.get("percorso"), dbConf.get("user"), dbConf.get("pass"));
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Classe Driver NON TROVATA, controlla il jar");
		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("Errore nella connessione al Database");
		}

	}

	protected void chiudiConnection() {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Errore nella chiusura della Connection");
			}
	}

	private void chiudiItems(PreparedStatement ps, ResultSet rs) {
		try {
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> eseguiQuery(String query, String... params) {

		ArrayList<HashMap<String, Object>> listaMappe = new ArrayList<HashMap<String, Object>>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);

			for(int i = 0; i < params.length; i++)
				ps.setString(i+1, params[i]);

			rs = ps.executeQuery();

			HashMap<String, Object> mappa = new HashMap<String, Object>();
			HashMap<String, Object> record;
			while(rs.next()) {
				//				System.out.println(" -- inizio lettura record");
				record = (HashMap<String, Object>) mappa.clone();

				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					//					System.out.println(" -- " + rs.getMetaData().getColumnName(i) + " : " + rs.getObject(i));
					record.put(rs.getMetaData().getColumnLabel(i).toLowerCase(), rs.getObject(i));
				}

				listaMappe.add(record);
				//				System.out.println(" -- fine lettura record\n");
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			chiudiItems(ps, rs);
		}

		return listaMappe;
	}

	public boolean eseguiUpdate(String query, String... params) {

		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(query);

			for(int i = 0; i < params.length; i++)
				ps.setString(i+1, params[i]);

			ps.executeUpdate();
			return true;

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			chiudiItems(ps, null);
		}

		return false;
	}

}

