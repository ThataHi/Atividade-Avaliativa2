package SistemaReservasVoos;

public class Reserva implements Runnable {
    private final Voo voo;

    public Reserva(Voo voo) {
        this.voo = voo;
    }

    @Override
    public void run() {
        boolean sucesso = voo.reservarAssento();
        if (sucesso) {
            // Mova a leitura de assentos disponíveis para dentro do bloco sincronizado
            synchronized (voo) {
                System.out.println(Thread.currentThread().getName() + ": Reserva bem-sucedida. Assentos disponíveis: " + voo.getAssentosDisponiveis());
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ": Falha na reserva. Nenhum assento disponível.");
        }
    }
}
