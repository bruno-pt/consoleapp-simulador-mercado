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

            this.valorAcumulado += produto.getPrecoUni()* produto.getQuantidadeCompra();
            this.funcionario.vendas.add(produto.getPrecoUni()* produto.getQuantidadeCompra());

            Produto produtoRelatorio = new Produto(
                    produto.getNome(),
                    produto.getQuantidadeEstoque(),
                    produto.getPrecoUni());

            produtoRelatorio.setQuantidadeCompra(produto.getQuantidadeCompra());

            boolean achou = false;
            if(Gerente.relatorio != null){
                for(Produto prd: Gerente.relatorio){
                    if(prd.getNome().equals(produto.getNome())){
                        prd.setQuantidadeCompra(prd.getQuantidadeCompra() + produto.getQuantidadeCompra());
                        achou = true;
                        break;
                    }
                }
                if(!achou){
                    Gerente.relatorio.add(produtoRelatorio);
                }
            }
            else
                Gerente.relatorio.add(produtoRelatorio);

            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - produto.getQuantidadeCompra());
            produto.setQuantidadeCompra(0);

            itCarrinho.remove();
        }
        Principal.opSistema();
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public float getValorAcumulado() {
        return valorAcumulado;
    }
}
