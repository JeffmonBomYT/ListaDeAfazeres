import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private final String ARQUIVO_NUVEM = "tarefas.txt";
    private ArrayList<String> tarefas;

    public ToDoList() {
    this.tarefas = carregarTarefas();
    }

    public void adicionarTarefa(String novaTarefa) {
        tarefas.add(novaTarefa);
        salvarTarefas();
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void removerTarefa(int indice) {
        if (indice >= 0 && indice< tarefas.size()) {
            String tarefaRemovida = tarefas.remove(indice);
            salvarTarefas();
            System.out.println("Tarefa \"" +tarefaRemovida+ "\" removida.");
        }
        else {
            System.out.println("Índice inválido.");
        }
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa listada.");
        }
        else {
            System.out.println(" <---- Suas Tarefas ---->");
            for (int i = 0; i < tarefas.size(); i++){
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    public boolean estaVazia() {
        return tarefas.isEmpty();
    }

    public void salvarTarefas() {
        try (PrintWriter writer = new PrintWriter(ARQUIVO_NUVEM)) {
            for (String tarefa : tarefas) {
                writer.println(tarefa);
            }
        }
        catch (IOException e) {
            System.out.println("Erro ao salvar as tarefas: " + e.getMessage());
        }
    }

    private ArrayList<String> carregarTarefas() {
        ArrayList<String> listaCarregada = new ArrayList<>();
        File arquivo = new File(ARQUIVO_NUVEM);
        if (arquivo.exists()) {
            try (Scanner scannerArquivo = new Scanner(arquivo)) {
                while (scannerArquivo.hasNextLine()) {
                    listaCarregada.add(scannerArquivo.nextLine());
                }
            } catch (IOException e) {
                System.out.println("Erro ao carregar as tarefas: " + e.getMessage());
            }
        }
        return listaCarregada;
    }

}
