import java.util.ArrayList;

public class Gerente extends Estoque {
    private String nome;
    private int idade;
    static ArrayList<Produto> relatorio = new ArrayList<>();

    Gerente(String nome, int idade){
        this.idade = idade;
        this.setNome(nome);
    }

    //valor total por caixa
    void relatorioVendas(){
        for(Caixa caixa: Principal.caixas){
            System.out.println("Caixa: "+(Principal.caixas.indexOf(caixa)+1)
                    +" | Valor Acumulado: "+caixa.getValorAcumulado()
                    +" | Funcionario: "+caixa.funcionario.getNome());
            //oi lindo te amo
        }
    }

    //estoque inicial e final de cada produto
    void relatorioEstoque(){
        for(Produto produto: relatorio){
            System.out.println("Produto{nome="+produto.getNome()
                    +", estoqueInicial="+produto.getQuantidadeEstoque()
                    +", estoqueFinal="+(produto.getQuantidadeEstoque()-produto.getQuantidadeCompra()));
        }
    }

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

            default:
                System.out.println("Setor inexistente!");
                Principal.opGerente();
        }
    }

    public String getNome() {
        return nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }
}

