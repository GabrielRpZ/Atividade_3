import java.util.Scanner;
class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu = 0;




        while(menu != 3){
            System.out.println("1. Média aritmética");
            System.out.println("2. Média ponderada");
            System.out.println("3. Sair");
            menu = scanner.nextInt();

            if(menu == 1){
                double notaA;
                double notaB;
                double resultado;
                System.out.println("Digite a nota A");
                notaA = scanner.nextInt();

                System.out.println("Digite a nota B");
                notaB = scanner.nextInt();

                resultado = (notaA + notaB) / 2;

                System.out.println("A nota media é " + resultado);
            }

            if(menu == 2){
                System.out.print("Digite a primeira nota: ");
                double nota1 = scanner.nextDouble();
                System.out.print("Digite o peso da primeira nota: ");
                double peso1 = scanner.nextDouble();

                System.out.print("Digite a segunda nota: ");
                double nota2 = scanner.nextDouble();
                System.out.print("Digite o peso da segunda nota: ");
                double peso2 = scanner.nextDouble();

                System.out.print("Digite a terceira nota: ");
                double nota3 = scanner.nextDouble();
                System.out.print("Digite o peso da terceira nota: ");
                double peso3 = scanner.nextDouble();

                // calculo da media ponderada
                double mediaPonderada = (nota1 * peso1 + nota2 * peso2 + nota3 * peso3) / (peso1 + peso2 + peso3);
                System.out.println("A média ponderada é: " + mediaPonderada);

            }






        }
    }
}
