package backend;

import java.io.Serializable;

public class Motorista extends Empregado implements Serializable  {

    private int kmPercorridos;
    private static double precoKm;

    public Motorista() {
        super();
    }

    public Motorista(String nome, String codigo, int numeroDiasTrabalho, double salarioDia, int kmPercorridos) {
        super(nome, codigo, numeroDiasTrabalho, salarioDia);
        this.kmPercorridos = kmPercorridos;
    }

    public int getKmPercorridos() {
        return kmPercorridos;
    }

    public void setKmPercorridos(int kmPercorridos) {
        this.kmPercorridos = kmPercorridos;
    }

    public static double getPrecoKm() {
        return precoKm;
    }

    public static void setPrecoKm(double precoKm) {
        Motorista.precoKm = precoKm;
    }

    public double calcularSalario() {
        return super.calcularSalario() + kmPercorridos * precoKm;
    }

    public String toString() {
        return super.toString() + " kmPercorridos=" + kmPercorridos;
    }
}
