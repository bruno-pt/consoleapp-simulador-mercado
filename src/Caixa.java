import java.util.Iterator;

public class Caixa {
    float valorAcumulado = 0;
    Funcionario funcionario;

    public Caixa(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void finalizarVenda(){
        Iterator<Produto> itCarrinho = Cliente.carrinho.iterator();
        while(itCarrinho.hasNext()) {
            Produto produto = itCarrinho.next();
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - produto.getQuantidadeCompra());
            this.valorAcumulado += produto.getPrecoUni()* produto.getQuantidadeCompra();
            this.funcionario.vendas.add(produto.getPrecoUni()* produto.getQuantidadeCompra());
            itCarrinho.remove();
        }

        Principal.opSistema();
    }
}
