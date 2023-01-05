import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConecaoBanco implements interfaceDao {

    String nomeJDBC = "jdbc:mysql://localhost/bd_pessoal";
    String nomeUser = "root";
    String password = "";

    Connection con;
    Statement st;

    @Override
    public void abreBanco() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(nomeJDBC, nomeUser, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pessoas> getAllPessoas() {

        String pedido = "SELECT * FROM pessoal";
        List<Pessoas> lista = new ArrayList<Pessoas>();

        try {

            st = con.createStatement();
            st = con.prepareStatement(pedido);
            st.execute(pedido);

            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                
                Pessoas pessoa = new Pessoas();

                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));

                lista.add(pessoa);
            }

            st.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void fechaBanco() {
        
        try {
            
			con.close();

        } catch (Exception e) {}

    }

}
