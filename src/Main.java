public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco do Gabriel");
        Cliente gabriel = new Cliente("Gabriel Dantas");

        Conta corrente = new ContaCorrente(gabriel);
        banco.addConta(corrente);
        Conta poupanca = new ContaPoupanca(gabriel);
        banco.addConta(poupanca);

        corrente.depositar(100);
        corrente.transferir(100, poupanca);
        corrente.imprimirExtrato();

        System.out.println();
        poupanca.depositar(100);
        poupanca.transferir(100, corrente);
        poupanca.imprimirExtrato();

        System.out.println();
        for (Conta c : banco.getContas()) {
            System.out.println(c);
        }
    }
}
