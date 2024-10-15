import java.util.Scanner;
// atividade3
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] idades = new int[10];
        double[] pesos = new double[10];
        double[] alturas = new double[10];

        int totalPessoasAcima90kgAbaixo150m = 0;
        int pessoasEntre10e30AnosAcima190m = 0;
        int totalPessoasAcima190m = 0;
        int somaIdades = 0;

        // loop de dados
        for (int i = 0; i < 10; i++) {
            System.out.printf("Digite a idade da pessoa %d: ", i + 1);
            idades[i] = scanner.nextInt();

            System.out.printf("Digite o peso da pessoa %d (em kg): ", i + 1);
            pesos[i] = scanner.nextDouble();

            System.out.printf("Digite a altura da pessoa %d (em metros): ", i + 1);
            alturas[i] = scanner.nextDouble();

            //somando as idades para calcular a media depois
            somaIdades += idades[i];

            // Verificando condições para pessoas acima de 90kg e abaixo de 1,50m
            if (pesos[i] > 90 && alturas[i] < 1.50) {
                totalPessoasAcima90kgAbaixo150m++;
            }

            //verificando pessoas com mais de 1,90
            if (alturas[i] > 1.90) {
                totalPessoasAcima190m++;
                if (idades[i] >= 10 && idades[i] <= 30) {
                    pessoasEntre10e30AnosAcima190m++;
                }
            }
        }

        //calculando a média das idades
        double mediaIdades = somaIdades / 10.0;

        //calculando a porcentagem de pessoas entre 10 e 30 anos e mais de 1,90m
        double porcentagemPessoas10a30Anos = 0.0;
        if (totalPessoasAcima190m > 0) {
            porcentagemPessoas10a30Anos = (pessoasEntre10e30AnosAcima190m * 100.0) / totalPessoasAcima190m;
        }

        //resultados
        System.out.printf("\nA média das idades das 10 pessoas é: %.2f anos\n", mediaIdades);
        System.out.printf("O total de pessoas com mais de 90kg e altura abaixo de 1,50m é: %d\n", totalPessoasAcima90kgAbaixo150m);
        System.out.printf("A porcentagem de pessoas com idade entre 10 e 30 anos e altura acima de 1,90m é: %.2f%%\n", porcentagemPessoas10a30Anos);

        //exibindo a opção para mostrar todos os dados
        System.out.println("\nDeseja ver todos os dados coletados? (Digite S para sim ou N para não)");
        char resposta = scanner.next().toUpperCase().charAt(0);

        if (resposta == 'S') {
            System.out.println("\nDados coletados:");
            for (int i = 0; i < 10; i++) {
                System.out.printf("Pessoa %d: Idade = %d anos, Peso = %.2f kg, Altura = %.2f m\n", i + 1, idades[i], pesos[i], alturas[i]);
            }
        }

        scanner.close();
    }
}
