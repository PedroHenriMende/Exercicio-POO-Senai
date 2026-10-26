import java.time.LocalDateTime;
import java.util.Objects;

public class RegistroPonto {
    private final Funcionario funcionario;
    private final LocalDateTime entrada;
    private LocalDateTime saida;

    public RegistroPonto(Funcionario funcionario, LocalDateTime entrada) {
        this.funcionario = Objects.requireNonNull(funcionario, "Informe o funcionário.");
        this.entrada = Objects.requireNonNull(entrada, "Informe a entrada.");
    }

    public void registrarSaida(LocalDateTime saida) {
        Objects.requireNonNull(saida, "Informe a saída.");
        if (this.saida != null) {
            throw new IllegalStateException("A saída já foi registrada.");
        }
        if (saida.isBefore(entrada)) {
            throw new IllegalArgumentException("A saída não pode ser anterior à entrada.");
        }
        this.saida = saida;
    }

    public Funcionario getFuncionario() { return funcionario; }
    public LocalDateTime getEntrada() { return entrada; }
    public LocalDateTime getSaida() { return saida; }
}
