
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMaisSimples {

	public ConexaoMaisSimples() {

		// Conexão com o driver JDBC
		String nomeJDBC = "jdbc:mysql://localhost/bd_pessoal";
		String nomeUser = "root";
		String password = "";
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(nomeJDBC, nomeUser, password);

			// Acessa um banco de dados específico.
			Statement st = con.createStatement();
			st.executeUpdate("USE " + "bd_pessoal");

			// Faz a consulta SQL
			String pedido = "Select * From pessoal;";

			ResultSet rs = st.executeQuery(pedido);

			// Mostra os resultados da consulta
			int numeroLinhas = 1;
			System.out.print("REGISTRO;");
			System.out.print("Nome;");
			System.out.println("Email;");
			while (rs.next()) {
				System.out.print(numeroLinhas + ";");
				System.out.print(rs.getString("nome") + ";");
				System.out.println(rs.getString("email"));
				numeroLinhas++;
			}
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		} finally {

		}

	}

	public static void main(String[] args) {
		new ConexaoMaisSimples();
	}

}
