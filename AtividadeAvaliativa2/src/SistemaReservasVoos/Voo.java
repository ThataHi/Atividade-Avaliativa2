package SistemaReservasVoos;

public class Voo {
    private final String numeroVoo;
    private final int capacidadeTotal;
    private int assentosReservados;

    public Voo(String numeroVoo, int capacidadeTotal) {
        this.numeroVoo = numeroVoo;
        this.capacidadeTotal = capacidadeTotal;
        this.assentosReservados = 0;
    }

    // Método sincronizado para garantir acesso exclusivo
    public synchronized boolean reservarAssento() {
        if (assentosReservados < capacidadeTotal) {
            assentosReservados++;
            return true;
        }
        return false;
    }

    public synchronized int getAssentosDisponiveis() {
        return capacidadeTotal - assentosReservados;
    }

    @Override
    public String toString() {
        return "\nNúmero do Voo: " + numeroVoo + "\n" +
               "Capacidade Total: " + capacidadeTotal + "\n" +
               "Assentos Reservados: " + assentosReservados + "\n";
    }
}