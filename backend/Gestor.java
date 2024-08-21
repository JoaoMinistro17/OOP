package backend;

import java.io.Serializable;

public class Gestor extends Empregado implements Serializable {

    private double taxaPremio;

    public Gestor() {
        super();
    }

    public Gestor(String nome, String codigo, int numeroDiasTrabalho, double salarioDia, double taxaPremio) {
        super(nome, codigo, numeroDiasTrabalho, salarioDia);
        this.taxaPremio = taxaPremio;
    }

    public double getTaxaPremio() {
        return taxaPremio;
    }

    public void setTaxaPremio(double taxaPremio) {
        this.taxaPremio = taxaPremio;
    }

    public double calcularSalario() {
        return super.calcularSalario() * (1 + taxaPremio);
    }

    public String toString() {
        return super.toString() + " taxaPremio=" + taxaPremio;
    }

    public Object clone() {
        return new Gestor(getNome(), getCodigo(), getNumeroDiasTrabalho(), getSalarioDia(), getTaxaPremio());
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Gestor) {
            Gestor outro = (Gestor) o;
            return outro.getCodigo().equals(getCodigo());
        }
        return false;
    }
}
