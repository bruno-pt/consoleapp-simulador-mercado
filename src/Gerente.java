import java.util.ArrayList;

//acredito que não precisa extender de estoque
//instanciar a classe estoque, pois as variaveis de setor são estaticas
public class Gerente extends Estoque {
    private String nome;
    private int idade;
    static ArrayList<Produto> relatorio = new ArrayList<>();

    Gerente(String nome, int idade){
        this.idade = idade;
        this.setNome(nome);
    }

    //gerarRelatorio();

    void cadastrarProduto(Produto produto, String setor){
        setor.toLowerCase();

        switch (setor){
            case "alimento":
                setorAlimento.add(produto);
                break;

            case "limpeza":
                setorLimpeza.add(produto);
                break;

            case "acougue":
                setorAcougue.add(produto);
                break;

            case "bebidas":
                setorBebidas.add(produto);
                break;

            case "hortifruti":
                setorHortifruti.add(produto);
                break;

            case "padaria":
                setorPadaria.add(produto);
                break;
        }
    }

    public String getNome() {
        return nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }
}

