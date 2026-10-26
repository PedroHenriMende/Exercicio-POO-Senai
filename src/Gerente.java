public class Gerente extends Funcionario {
    private double salarioMinimo;
    private double bonificacao;

    public Gerente(String nome, String cpf, double salarioMinimo, double bonificacao) {
        super(nome, cpf);
        this.salarioMinimo = salarioMinimo;
        this.bonificacao = bonificacao;
    }

    @Override
    public double calcularSalario() {
        return (6 * salarioMinimo) + bonificacao;
    }

    public double getSalarioMinimo() { return salarioMinimo; }
    public void setSalarioMinimo(double valor) { salarioMinimo = valor; }
    public double getBonificacao() { return bonificacao; }
    public void setBonificacao(double bonificacao) { this.bonificacao = bonificacao; }
}
