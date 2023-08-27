import java.math.BigDecimal;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ContaTerminal {

    public static int calcularTamanho(int numero) {
        return String.valueOf(numero).length();
    }

    public static class Conta{
        private Integer usuario;
        private String agencia;
        private String nomeCliente;
        private Double saldo;

        public Conta() {
        }

        public Conta(Integer usuario, String agencia, String nomeCliente, Double saldo) {
            this.usuario = usuario;
            this.agencia = agencia;
            this.nomeCliente = nomeCliente;
            this.saldo = saldo;
        }

        public Integer getUsuario() {
            return usuario;
        }

        public void setUsuario(Integer usuario) {
            this.usuario = usuario;
        }

        public String getAgencia() {
            return agencia;
        }

        public void setAgencia(String agencia) {
            this.agencia = agencia;
        }

        public String getNomeCliente() {
            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
        }

        public Double getSaldo() {
            return saldo;
        }

        public void setSaldo(Double saldo) {
            this.saldo = saldo;
        }

        @Override
        public String toString() {
            return "Conta{" +
                    "usuario=" + usuario +
                    ", agencia='" + agencia + '\'' +
                    ", nomeCliente='" + nomeCliente + '\'' +
                    ", saldo=" + saldo +
                    '}';
        }
    }

    public static void main(String[] args) {
        // TODO: 26/08/2023 Conhecer e importar a classe Scanner

        Scanner inputString = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);
        Conta conta = new Conta();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("--------- Bem vindo ao cadastro de conta do Banco SantanderDio ---------");
        System.out.println("--- A seguir digite os dados solicitados para a criação da sua conta ---");
        System.out.println("------------------------------------------------------------------------");

        System.out.println("Por favor, digite o número da Agência!");
        System.out.println("Agência: ");
        conta.setAgencia(inputString.nextLine());
        System.out.println("------------------------------------------------------------------------");

        System.out.println("Por favor, digite o número da Conta");
        System.out.println("Conta: ");
        conta.setUsuario(inputNumber.nextInt());
        System.out.println("------------------------------------------------------------------------");

        System.out.println("Por favor, digite seu primeiro e último nome!");
        System.out.println("Nome Cliente: ");
        conta.setNomeCliente(inputString.nextLine());
        System.out.println("------------------------------------------------------------------------");

        System.out.println("Por favor, digite seu primeiro e último nome!");
        System.out.println("Saldo: ");
        conta.setSaldo(inputNumber.nextDouble());
        System.out.println("------------------------------------------------------------------------");


        inputString.close();
        inputNumber.close();
        System.out.println("Processando os dados...");

        // Agendando a tarefa para ser executada após 3 segundos
        scheduler.schedule(() -> {
            System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco é seja bem vindo, sua agência é %s, " +
                            "conta %d e seu saldo: R$ %.2f já está disponível para saque."
                    ,conta.getNomeCliente(),conta.getAgencia(),conta.getUsuario(),conta.getSaldo());
            scheduler.shutdown(); // Encerra o scheduler após a execução da tarefa
        }, 3, TimeUnit.SECONDS);

    }

}