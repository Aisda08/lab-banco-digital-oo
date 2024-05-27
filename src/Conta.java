public abstract class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void sacar(double valor) {
        if (valor <= saldo && valor > 0) {
            saldo -= valor;
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public void transferir(double valor, Conta conta) {
            sacar(valor);
            conta.depositar(valor);
    }

    public void imprimirInfosComuns() {
        System.out.println("Titular: " + cliente);
        System.out.println("Agência: " + agencia);
        System.out.println("Número: " + numero);
        System.out.println("Saldo: " + saldo);
    }

    public String toString() {
        return "[" + cliente + ", " +
                agencia + ", " +
                numero + "]";
    }

    public abstract void imprimirExtrato();
}
