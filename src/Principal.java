/*
Nosso trabalho parte do contexto de um supermercado que está informatizando seus processos. Este supermercado possui
um/a gerente e cinco funcionários/as, sendo que estes/as funcionários/as se revezam em três caixas de pagamento.
Cada caixa está equipado com uma balança, o que permite vendas de produtos tanto por quilo ou por unidade.
 Este sistema possui alguns requisitos:* */

public class Principal {
    public static void main(String[] args) {
        Funcionario func1 = new Funcionario("Gabriel", 20);
        Funcionario func2 = new Funcionario("MARIA", 21);
        Funcionario func3 = new Funcionario("Romualdo", 43);
        Funcionario func4 = new Funcionario("Leandro", 54);
        Funcionario func5 = new Funcionario("Josimara", 34);

        Gerente gerente = new Gerente("Amariudo", 45);

        Produto arroz = new Produto("Arroz",20, 21f);
        Produto feijao = new Produto("Feijão",2, 5.40f);
        Produto farinha = new Produto("Farinha",3, 5.60f);

        gerente.receberProduto(arroz);
        gerente.receberProduto(feijao);
        gerente.receberProduto(farinha);
        gerente.visitar();





    }
}
