import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDoList menager = new ToDoList();
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n <---- Lista de Tarefas ---->");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Remover tarefa");
            System.out.println("3 - Listar tarefas");
            System.out.println("4 - Sair");
            System.out.print("\n>  ");
            String opcao = scan.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite a tarefa a adicionar > ");
                    String novaTarefa = scan.nextLine();
                    menager.adicionarTarefa(novaTarefa);
                    break;
                case "2":
                    if (menager.estaVazia()) {
                        System.out.println("Nenhuma tarefa listada.");
                    }
                    else {
                        menager.listarTarefas();
                        System.out.print("Digite o número da tarefa que desejas remover > ");
                        try {
                            int indice = Integer.parseInt(scan.nextLine()) - 1;
                            menager.removerTarefa(indice);
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Por favor, digite um número.");
                        }
                    }
                    break;
                case "3":
                    menager.listarTarefas();
                    break;
                case "4":
                    continuar = false;
                    System.out.println("Até outro momento");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scan.close();
    }
}
