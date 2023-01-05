import java.util.List;

public class index {
    
    public index() {

        interfaceDao conexao = new ConecaoBanco();

        conexao.abreBanco();
        
        List<Pessoas> lista = conexao.getAllPessoas();

        for (Pessoas pessoa : lista) {
            
            System.out.println("Nome: " + pessoa.getName() + ", Email: " + pessoa.getEmail());
        }

        conexao.fechaBanco();
    }

    public static void main(String[] args) {
        
        new index();
    }
}
