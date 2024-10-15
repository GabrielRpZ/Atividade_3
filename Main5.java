import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //estruturas para médicos
        HashSet<String> medicoCadastrados = new HashSet<>();
        List<String[]> crmCadastrados = new ArrayList<>();

        //estruturas para pacientes
        HashSet<String> pacienteCadastrados = new HashSet<>();
        List<String[]> pacientesLista = new ArrayList<>();

        String cadastro;
        int menu = 0;

        while (menu != 5) {
            System.out.println("Bem Vindo ao sistema de cadastro");
            System.out.println("1. Cadastrar novo Médico");
            System.out.println("2. Visualizar Médicos cadastrados");
            System.out.println("3. Cadastrar novo Paciente");
            System.out.println("4. Visualizar Pacientes cadastrados");
            System.out.println("5. Sair do sistema");
            System.out.println("---------------------");

            menu = scanner.nextInt();

            //cadastro de médicos
            if (menu == 1) {
                System.out.println("Qual o código do Médico?");
                cadastro = scanner.next();

                if (medicoCadastrados.contains(cadastro)) {
                    System.out.println("Erro: Código já cadastrado!");
                    System.out.println("---------------------");
                } else {
                    System.out.println("Qual o nome do médico?");
                    String nomeMedico = scanner.next();
                    System.out.println("Qual setor o médico pertence?");
                    String setor = scanner.next();

                    medicoCadastrados.add(cadastro);
                    crmCadastrados.add(new String[]{cadastro, nomeMedico, setor});
                    System.out.println("Médico cadastrado com sucesso!");
                    System.out.println("---------------------");
                }
            }

            //visualização de médicos cadastrados
            if (menu == 2) {
                System.out.println("Médicos cadastrados:");
                for (String[] medico : crmCadastrados) {
                    System.out.println("CRM: " + medico[0] + ", Nome: " + medico[1] + ", Setor: " + medico[2]);
                }
                System.out.println("---------------------");
            }

            // Cadastro de pacientes
            if (menu == 3) {
                System.out.println("Qual o código do Paciente?");
                cadastro = scanner.next();

                if (pacienteCadastrados.contains(cadastro)) {
                    System.out.println("Erro: Código já cadastrado!");
                    System.out.println("---------------------");
                } else {
                    System.out.println("Qual o nome do paciente?");
                    String nomePaciente = scanner.next();
                    System.out.println("Qual o diagnóstico do paciente?");
                    String diagnostico = scanner.next();

                    pacienteCadastrados.add(cadastro);
                    pacientesLista.add(new String[]{cadastro, nomePaciente, diagnostico});
                    System.out.println("Paciente cadastrado com sucesso!");
                    System.out.println("---------------------");
                }
            }

            //visualização de pacientes cadastrados
            if (menu == 4) {
                System.out.println("Pacientes cadastrados:");
                for (String[] paciente : pacientesLista) {
                    System.out.println("Código: " + paciente[0] + ", Nome: " + paciente[1] + ", Diagnóstico: " + paciente[2]);
                }
                System.out.println("---------------------");
            }
        }
    }
}
