public class Main4 { //atividade4
    public static void main(String[] args) {
        double soma = 0;  // Variável para armazenar a soma dos termos
        int numerador = 1000;  // Inicia o numerador em 1000


        for (int i = 1; i <= 50; i++) {
            //a cada iteração, alternamos entre adição e subtração
            soma += (i % 2 == 1 ? 1 : -1) * ((double) numerador / i);

            // Subtrai 3 do numerador a cada iteração
            numerador -= 3;
        }

        // Exibe o resultado
        System.out.printf("A soma dos 50 primeiros termos da série é:" + soma);
    }
}
