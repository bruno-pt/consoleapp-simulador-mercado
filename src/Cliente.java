import java.util.*;

public class Cliente {
    static int corredorAtual;
    static String setorAtual;
    static boolean retornar;
    static int caixaEscolhido;
    static ArrayList<Produto> carrinho = new ArrayList<Produto>();

    /*public void consultarCorredor(int corredorAtual){
        switch (corredorAtual){
            case 1: System.out.println("Setor - Alimento");
                break;
            case 2: System.out.println("Setor - Limpeza");
                break;
            case 3: System.out.println("Setor - Acougue");
                    System.out.println("Setor - Bebidas");
                break;
            case 4: System.out.println("Setor - Hortifruti");
                    System.out.println("Setor - Padaria");
                break;
        }
    }*/
    //Estoque es = new Estoque();

    public void corredores(){
        Scanner sc = new Scanner(System.in);

        System.out.println("$ Tipo Login > Cliente");
        System.out.println("===========================");
        System.out.println("Corredor - Setor");
        System.out.println("===========================");
        System.out.println("1 - Alimentos");
        System.out.println("2 - Limpeza");
        System.out.println("3 - Acougue, Bebidas");
        System.out.println("4 - Hortifruti, Padaria");
        System.out.println();
        System.out.println("Any - Para voltar");
        System.out.println("===========================");
        System.out.print("Digite o numero do corredor > ");
        int option = sc.nextInt();

        if(option >=1 && option <=4) {
            this.corredorAtual = option;
            setores();
        }
        else
            this.retornar = true;
    }

    public void setores(){

        Scanner sc = new Scanner(System.in);

        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
        System.out.println("$ Tipo Login > Cliente");
        System.out.println("=============================");
        System.out.println("Setores do corredor atual (" + this.corredorAtual + ")");
        System.out.println("=============================");

        switch (this.corredorAtual){
            case 1:
                System.out.println("{Alimentos}");
                break;

            case 2:
                System.out.println("{Limpeza}");
                break;

            case 3:
                System.out.print("{Acougue, ");
                System.out.println("Bebidas}");
                break;

            case 4:
                System.out.print("{Hortifruti, ");
                System.out.println("Padaria}");
                break;
        }
        System.out.println();
        System.out.println("Any - Para voltar");
        System.out.println("==========================");
        System.out.print("Digite o nome do setor > ");

        String option = sc.nextLine().toLowerCase();

        if(this.corredorAtual == 1 && option.equals("alimentos")){
            this.setorAtual = option;
            consultarProdutos();
        }
        else if(this.corredorAtual == 2 && option.equals("limpeza")){
            this.setorAtual = option;
            consultarProdutos();
        }
        else if(this.corredorAtual == 3 && (option.equals("acougue") || option.equals("bebidas"))){
            this.setorAtual = option;
            consultarProdutos();
        }
        else if(this.corredorAtual == 4 && (option.equals("hortifruti") || option.equals("padaria"))){
            this.setorAtual = option;
            consultarProdutos();
        }
        else
            corredores();
    }

    public void consultarProdutos(){

        Scanner sc = new Scanner(System.in);

        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
        System.out.println("$ Tipo Login > Cliente");
        System.out.println("======================================");
        System.out.println("Consulta de produtos");
        System.out.println("Corredor - " + this.corredorAtual + " | " + "Setor - " + this.setorAtual);
        System.out.println("=======================================");

        switch (this.setorAtual){
            case "alimentos":
                for(Produto produto: Estoque.setorAlimento){System.out.println(produto);}
                break;

            case "limpeza":
                for(Produto produto: Estoque.setorLimpeza){System.out.println(produto);}
                break;

            case "acougue":
                for(Produto produto: Estoque.setorAcougue){System.out.println(produto);}
                break;

            case "bebidas":
                for(Produto produto: Estoque.setorBebidas){System.out.println(produto);}
                break;

            case "hortifruti":
                for(Produto produto: Estoque.setorHortifruti){System.out.println(produto);}
                break;

            case "padaria":
                for(Produto produto: Estoque.setorPadaria){System.out.println(produto);}
                break;
        }
        System.out.println("=======================================");
        System.out.println("1 - Realizar compra de produtos");
        System.out.println();
        System.out.println("Any - Voltar");
        System.out.println("=======================================");
        System.out.print("Digite a escolha > ");

        int option = sc.nextInt();

        if (option == 1){
            comprar();
        }
        else
            setores();
    }

    public void comprar(){
        Scanner sc = new Scanner(System.in);
        int continuar = 1;

        System.out.println("======================================");
        System.out.println("Compra de produtos");

        while(continuar == 1) {
            String produtoNome;
            int qntCompra;
            boolean achou = false;

            System.out.print("Digite o nome do produto > ");
            produtoNome = sc.nextLine().toLowerCase();
            System.out.print("Digite a quantidade (un) > ");
            qntCompra = sc.nextInt();

            switch (this.setorAtual) {
                case "alimentos":
                        for (Produto produto: Estoque.setorAlimento) {
                            achou = checkProduto(produto, produtoNome, qntCompra, achou);
                        }

                case "limpeza":
                        for (Produto produto : Estoque.setorLimpeza) {
                            achou = checkProduto(produto, produtoNome, qntCompra, achou);
                        }

                case "acougue":
                        for (Produto produto : Estoque.setorAcougue) {
                            achou = checkProduto(produto, produtoNome, qntCompra, achou);
                        }

                case "bebidas":
                        for (Produto produto : Estoque.setorBebidas) {
                            achou = checkProduto(produto, produtoNome, qntCompra, achou);
                        }

                case "hortifruti":
                        for (Produto produto : Estoque.setorHortifruti) {
                            achou = checkProduto(produto, produtoNome, qntCompra, achou);
                        }

                case "padaria":
                        for (Produto produto : Estoque.setorPadaria) {
                            achou = checkProduto(produto, produtoNome, qntCompra, achou);
                        }
            }
            if(!achou)
                System.err.println("Produto {" + produtoNome + "} não cadastrado no estoque!");
            else{
                System.out.println("Produto inserido no carrinho com sucesso!");
            }
            //alterar aqui
            System.out.print("Continuar comprando? (1/0) > ");
            continuar = sc.nextInt();
            sc.nextLine();
            if(continuar == 0){
                System.out.println("Escolha o caixa para finalizar a venda:");
                System.out.println("[1, 2, 3]");
                System.out.print("> ");
                caixaEscolhido = sc.nextInt();
            }

        }
        int i = 0;
        for (Caixa caixa : Principal.caixas) {
            if(i+1 == caixaEscolhido){
                caixa.finalizarVenda();
            }else
                i++;
        }
    }

    private boolean checkProduto(Produto produto, String produtoNome, int qntCompra, boolean achou){
        if (produtoNome.equals(produto.getNome().toLowerCase())) {
            if(qntCompra > produto.getQuantidadeEstoque()){
                System.err.println("Produto {" + produtoNome + "} sem estoque suficiente!");
            }
            else {
                carrinho.add(produto);
                produto.setQuantidadeCompra(qntCompra);
                achou = true;
            }
        }
        return achou;
    }

}

