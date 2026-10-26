public class Vendedor extends Funcionario {
    private double salarioMinimo;
    private double comissao;
    private int numeroVendas;

    public Vendedor(String nome, String cpf, double salarioMinimo,
                    double comissao, int numeroVendas) {
        super(nome, cpf);
        this.salarioMinimo = salarioMinimo;
        this.comissao = comissao;
        this.numeroVendas = numeroVendas;
    }

    @Override
    public double calcularSalario() {
        return salarioMinimo + (comissao * numeroVendas);
    }

    public double getSalarioMinimo() { return salarioMinimo; }
    public void setSalarioMinimo(double valor) { salarioMinimo = valor; }
    public double getComissao() { return comissao; }
    public void setComissao(double comissao) { this.comissao = comissao; }
    public int getNumeroVendas() { return numeroVendas; }
    public void setNumeroVendas(int numeroVendas) { this.numeroVendas = numeroVendas; }
}
