import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        // Valor apenas didático; substitua pelo salário mínimo desejado.
        double salarioMinimo = 1500.00;
        Vendedor vendedor = new Vendedor("Ana", "111.111.111-11", salarioMinimo, 50.00, 20);
        Consultor consultor = new Consultor("Bruno", "222.222.222-22", 80.00, 160);
        Gerente gerente = new Gerente("Carla", "333.333.333-33", salarioMinimo, 2000.00);

        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(vendedor);
        funcionarios.add(consultor);
        funcionarios.add(gerente);

        System.out.println("FOLHA DE PAGAMENTO");
        for (Funcionario funcionario : funcionarios) {
            // O Java escolhe a implementação da subclasse: polimorfismo.
            System.out.printf(Locale.forLanguageTag("pt-BR"),
                    "Nome: %s | Tipo: %s | Salário: R$ %,.2f%n",
                    funcionario.getNome(), funcionario.getClass().getSimpleName(),
                    funcionario.calcularSalario());
        }

        ArrayList<RegistroPonto> registros = new ArrayList<>();
        LocalDateTime entrada = LocalDateTime.of(2026, 10, 26, 8, 0);
        for (Funcionario funcionario : funcionarios) {
            RegistroPonto ponto = new RegistroPonto(funcionario, entrada);
            ponto.registrarSaida(entrada.plusHours(9));
            registros.add(ponto);
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("\nCONTROLE DE PONTO");
        for (RegistroPonto ponto : registros) {
            System.out.printf("Nome: %s | Entrada: %s | Saída: %s%n",
                    ponto.getFuncionario().getNome(), ponto.getEntrada().format(formato),
                    ponto.getSaida().format(formato));
        }
        // Não é necessário instanceof: nenhum comportamento aqui exige um tipo específico.
    }
}
