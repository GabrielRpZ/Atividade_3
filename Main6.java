import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class Produto {
    int codigo;
    String nome;
    double valorUnitario;
    String unidade;

    public Produto(int codigo, String nome, double valorUnitario, String unidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Valor: R$ " + valorUnitario + ", Unidade: " + unidade;
    }
}

class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> codigosCadastrados = new HashSet<>();
        List<Produto> produtosCadastrados = new ArrayList<>();
        int menu = 0;

        while (menu != 6) {
            System.out.println("Bem-vindo ao sistema da lojinha do Sr. Abu");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Alterar produto");
            System.out.println("3. Excluir produto");
            System.out.println("4. Visualizar produtos cadastrados");
            System.out.println("5. Realizar venda");
            System.out.println("6. Sair do sistema");
            System.out.println("---------------------");

            menu = scanner.nextInt();

            switch (menu) {
                // Cadastrar produto
                case 1:
                    System.out.println("Digite o código do produto:");
                    int codigoProduto = scanner.nextInt();

                    if (codigosCadastrados.contains(codigoProduto)) {
                        System.out.println("Erro: Código já cadastrado!");
                    } else {
                        System.out.println("Digite o nome do produto:");
                        String nomeProduto = scanner.next();
                        System.out.println("Digite o valor unitário do produto:");
                        double valorUnitario = scanner.nextDouble();
                        System.out.println("Digite a unidade do produto (ex: unidade, kg, litro):");
                        String unidadeProduto = scanner.next();

                        Produto produto = new Produto(codigoProduto, nomeProduto, valorUnitario, unidadeProduto);
                        produtosCadastrados.add(produto);
                        codigosCadastrados.add(codigoProduto);

                        System.out.println("Produto cadastrado com sucesso!");
                    }
                    break;

                // Alterar produto
                case 2:
                    System.out.println("Digite o código do produto para alterar:");
                    int codigoAlterar = scanner.nextInt();

                    boolean encontradoAlterar = false;
                    for (Produto produto : produtosCadastrados) {
                        if (produto.codigo == codigoAlterar) {
                            System.out.println("Produto encontrado. Digite o novo nome:");
                            produto.nome = scanner.next();
                            System.out.println("Digite o novo valor unitário:");
                            produto.valorUnitario = scanner.nextDouble();
                            System.out.println("Digite a nova unidade:");
                            produto.unidade = scanner.next();

                            System.out.println("Produto alterado com sucesso!");
                            encontradoAlterar = true;
                            break;
                        }
                    }

                    if (!encontradoAlterar) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                // Excluir produto
                case 3:
                    System.out.println("Digite o código do produto para excluir:");
                    int codigoExcluir = scanner.nextInt();

                    boolean encontradoExcluir = false;
                    for (Produto produto : produtosCadastrados) {
                        if (produto.codigo == codigoExcluir) {
                            produtosCadastrados.remove(produto);
                            codigosCadastrados.remove(codigoExcluir);

                            System.out.println("Produto excluído com sucesso!");
                            encontradoExcluir = true;
                            break;
                        }
                    }

                    if (!encontradoExcluir) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                // Visualizar produtos cadastrados
                case 4:
                    if (produtosCadastrados.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println("Produtos cadastrados:");
                        for (Produto produto : produtosCadastrados) {
                            System.out.println(produto);
                        }
                    }
                    break;

                // Realizar venda
                case 5:
                    double totalCompra = 0;
                    while (true) {
                        System.out.println("Digite o código do produto para a venda (0 para finalizar):");
                        int codigoVenda = scanner.nextInt();

                        if (codigoVenda == 0) {
                            break; // Finalizar compra
                        }

                        Produto produtoVenda = null;
                        for (Produto produto : produtosCadastrados) {
                            if (produto.codigo == codigoVenda) {
                                produtoVenda = produto;
                                break;
                            }
                        }

                        if (produtoVenda == null) {
                            System.out.println("Produto não encontrado.");
                        } else {
                            System.out.println("Digite a quantidade:");
                            int quantidade = scanner.nextInt();
                            totalCompra += produtoVenda.valorUnitario * quantidade;
                            System.out.println("Produto adicionado à compra.");
                        }
                    }

                    // Finalizar pagamento
                    System.out.println("Total da compra: R$ " + totalCompra);
                    System.out.println("Escolha a forma de pagamento:");
                    System.out.println("1. Pix");
                    System.out.println("2. Cartão (Crédito ou Débito)");
                    System.out.println("3. Dinheiro");
                    int pagamento = scanner.nextInt();

                    switch (pagamento) {
                        case 1: // Pix
                            System.out.println("Realize o pagamento via Pix utilizando o código abaixo: ");
                            System.out.println("Código Pix: 123456789");
                            break;

                        case 2: // Cartão
                            System.out.println("Digite a bandeira do cartão (Crédito ou Débito):");
                            String bandeira = scanner.next();
                            System.out.println("Digite o número do cartão:");
                            String numeroCartao = scanner.next();
                            System.out.println("Digite a validade (MM/AA):");
                            String validade = scanner.next();
                            System.out.println("Digite o código de segurança (CVV):");
                            String cvv = scanner.next();
                            System.out.println("Pagamento realizado com sucesso!");
                            break;

                        case 3: // Dinheiro
                            System.out.println("Digite o valor pago:");
                            double valorPago = scanner.nextDouble();
                            if (valorPago < totalCompra) {
                                System.out.println("Valor insuficiente.");
                            } else {
                                double troco = valorPago - totalCompra;
                                System.out.println("Troco: R$ " + troco);
                            }
                            break;
                    }
                    break;


                case 6:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

    }
}
