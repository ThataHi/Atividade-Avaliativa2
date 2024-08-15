package SistemaReservasVoos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Criação de um voo e capacidade
        Voo voo = new Voo("VOO123", 10);

        // Criação do ExecutorService com um pool de 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submissão de 15 reservas
        for (int i = 0; i < 15; i++) {
            executor.submit(new Reserva(voo));
        }

        // Encerramento do ExecutorService
        executor.shutdown();
        try {
            // Aguarda a conclusão de todas as tarefas ou encerra após 60 segundos
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("\nEstado final do voo: " + voo);
    }
}
