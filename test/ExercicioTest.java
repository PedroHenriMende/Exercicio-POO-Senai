import java.time.LocalDateTime;
import java.util.ArrayList;

public class ExercicioTest {
    private static void verificar(boolean condicao, String mensagem) {
        if (!condicao) throw new AssertionError(mensagem);
    }

    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Vendedor vendedor = new Vendedor("Ana", "111", 1500, 50, 20);
        Consultor consultor = new Consultor("Bruno", "222", 80, 160);
        Gerente gerente = new Gerente("Carla", "333", 1500, 2000);
        funcionarios.add(vendedor);
        funcionarios.add(consultor);
        funcionarios.add(gerente);
        double[] esperados = {2500, 12800, 11000};
        for (int i = 0; i < funcionarios.size(); i++) {
            verificar(funcionarios.get(i).calcularSalario() == esperados[i], "Salário incorreto");
        }
        vendedor.setNumeroVendas(0);
        verificar(vendedor.calcularSalario() == 1500, "Vendedor sem vendas");
        consultor.setHorasTrabalhadas(0);
        verificar(consultor.calcularSalario() == 0, "Consultor sem horas");
        gerente.setBonificacao(0);
        verificar(gerente.calcularSalario() == 9000, "Gerente sem bonificação");
        vendedor.setNome("Ana Silva");
        verificar(vendedor.getNome().equals("Ana Silva"), "Acesso ao nome herdado");
        LocalDateTime entrada = LocalDateTime.of(2026, 10, 26, 22, 0);
        RegistroPonto ponto = new RegistroPonto(vendedor, entrada);
        verificar(ponto.getSaida() == null, "Ponto aberto");
        boolean rejeitou = false;
        try { ponto.registrarSaida(entrada.minusMinutes(1)); }
        catch (IllegalArgumentException e) { rejeitou = true; }
        verificar(rejeitou, "Deve rejeitar saída anterior à entrada");
        ponto.registrarSaida(entrada.plusHours(8));
        verificar(ponto.getFuncionario() == vendedor, "Funcionário do ponto");
        verificar(ponto.getEntrada().equals(entrada), "Entrada do ponto");
        verificar(ponto.getSaida().equals(entrada.plusHours(8)), "Turno passando da meia-noite");
        rejeitou = false;
        try { ponto.registrarSaida(entrada.plusHours(9)); }
        catch (IllegalStateException e) { rejeitou = true; }
        verificar(rejeitou, "Deve rejeitar saída duplicada");
        System.out.println("Todos os testes passaram: salários, polimorfismo, encapsulamento e ponto.");
    }
}
