/*
Nosso trabalho parte do contexto de um supermercado que está informatizando seus processos. Este supermercado possui
um/a gerente e cinco funcionários/as, sendo que estes/as funcionários/as se revezam em três caixas de pagamento.
Cada caixa está equipado com uma balança, o que permite vendas de produtos tanto por quilo ou por unidade.
 Este sistema possui alguns requisitos:* */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Principal {

    public static void opSistema(){
        int escolha;
        Scanner sc = new Scanner(System.in);

        System.out.println(new String(new char[50]).replace("\0", "\r\n"));

        System.out.println("======================");
        System.out.println("1 - Login como Gerente");
        System.out.println("2 - Login como Cliente");
        System.out.println();
        System.out.println("Any - Sair do Sistema");
        System.out.println("======================");
        System.out.print("> ");
        escolha = sc.nextInt();

        System.out.println(new String(new char[50]).replace("\0", "\r\n"));

        switch (escolha){
            case 1:
                String senha;
                System.out.println("===============");
                System.out.println("Login - Gerente");
                System.out.println("===============");
                System.out.println();
                System.out.print("Senha > ");
                senha = sc.nextLine();
                if(senha.equals("lucianohulk"))
                    opGerente();
                else{
                    //limpa tela
                    System.err.println("Senha Inválida!");
                    opSistema();
                }
                break;

            case 2:
                opCliente();
                break;

            default:
                break;
        }
    }

    public static void opGerente(){
        System.out.println("1 - Gerar Relatório de Vendas");
    }

    public static void opCliente(){
        Cliente cliente = new Cliente();
        cliente.corredores();
        if(Cliente.retornar == true) {
            Cliente.retornar = false;
            opSistema();
            return;
        }
    }

    static ArrayList<Caixa> caixas = new ArrayList<Caixa>();
    static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public ArrayList<Caixa> getCaixas() {
        return caixas;
    }

    public static void main(String[] args) {

        funcionarios.add(new Funcionario("Gabriel", 20));
        funcionarios.add(new Funcionario("Maria", 21));
        funcionarios.add(new Funcionario("Romualdo", 43));
        funcionarios.add(new Funcionario("Leandro", 54));
        funcionarios.add(new Funcionario("Josimara", 34));

        Collections.shuffle(funcionarios);

        for(int i = 0; i < 3; i++){
            caixas.add(new Caixa(funcionarios.get(i)));
        }

        Gerente gerente = new Gerente("Amariudo", 45);
        gerente.cadastrarProduto(new Produto("Arroz",5, 7.5f), "alimento");
        gerente.cadastrarProduto(new Produto("Feijao",29, 6), "alimento");
        gerente.cadastrarProduto(new Produto("Miojo",999, 0.50f), "alimento");
        gerente.cadastrarProduto(new Produto("Omo",7, 7), "limpeza");
        gerente.cadastrarProduto(new Produto("Detergente",8, 15), "limpeza");
        gerente.cadastrarProduto(new Produto("Veja",7, 15), "limpeza");
        gerente.cadastrarProduto(new Produto("Hortela",30, 15), "hortifruti");
        gerente.cadastrarProduto(new Produto("Couve",12, 15), "hortifruti");
        gerente.cadastrarProduto(new Produto("Alface",11, 15), "hortifruti");
        gerente.cadastrarProduto(new Produto("Skol",15, 2), "bebidas");
        gerente.cadastrarProduto(new Produto("Glacial",2350, 0.1f), "bebidas");
        gerente.cadastrarProduto(new Produto("Velho barreiro",20, 9.90f), "bebidas");
        gerente.cadastrarProduto(new Produto("Pao",60, 4.99f), "padaria");
        gerente.cadastrarProduto(new Produto("Pao de queijo",30, 2.50f), "padaria");
        gerente.cadastrarProduto(new Produto("Rosquinha",55,5.50f ), "padaria");
        gerente.cadastrarProduto(new Produto("Lula",20, 30.50f), "acougue");
        gerente.cadastrarProduto(new Produto("Linguiça",36,10.50f), "acougue");
        gerente.cadastrarProduto(new Produto("Picanha",2, 1500), "acougue");

        opSistema();
    }
}
