package backend;

import java.io.Serializable;

public class Empregado implements Comparable<Empregado>, Serializable {

    private String nome;
    private String codigo;
    private int numeroDiasTrabalho;
    private double salarioDia;

    public Empregado() {

    }

    public Empregado(String nome, String codigo, int numeroDiasTrabalho, double salarioDia) {
        this.nome = nome;
        this.codigo = codigo;
        this.numeroDiasTrabalho = numeroDiasTrabalho;
        this.salarioDia = salarioDia;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getNumeroDiasTrabalho() {
        return numeroDiasTrabalho;
    }

    public double getSalarioDia() {
        return salarioDia;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNumeroDiasTrabalho(int numeroDiasTrabalho) {
        this.numeroDiasTrabalho = numeroDiasTrabalho;
    }

    public void setSalarioDia(double salarioDia) {
        this.salarioDia = salarioDia;
    }

    public double calcularSalario() {
        return numeroDiasTrabalho * salarioDia;
    }

    public String toString() {
        return "codigo=" + codigo + " nome=" + nome + " salarioDia=" + salarioDia + " numeroDiasTrabalho=" + numeroDiasTrabalho;
    }

    public int compareTo(Empregado o) {
        if (o == null) {
            return -1;
        }
        return (codigo.equals(o.codigo)) ? 0 : -1;

    }

}
