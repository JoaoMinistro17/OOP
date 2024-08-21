package backend;

import java.util.*;

public class RepositorioEmpregados {

    private ArrayList<Empregado> repositorio;

    public RepositorioEmpregados(int tamanho) {
        repositorio = new ArrayList<>(tamanho);
    }

    public void adicionar(Empregado empregado) {
        repositorio.add(empregado);
    }

    public double calcularTotalSalarios() {
        double total = 0;
        for (Empregado e : repositorio) {
            total += e.calcularSalario();
        }
        return total;
    }

    public int calcularTotalKm() {
        int total = 0;
        for (Empregado e : repositorio) {
            if (e instanceof Motorista) {
                total += ((Motorista) e).getKmPercorridos();
            }
        }
        return total;
    }

    public int calcularNumGestores() {
        return calcularNumEmpregadosTipo("Gestor");
    }

    public int calcularNumEmpregadosTipo(String tipo) {
        int total = 0;
        for (Empregado e : repositorio) {
            if (e.getClass().getSimpleName().equals(tipo)) {
                total++;
            }
        }
        return total;
    }

    public boolean verificarEmpregadoExiste(String codigo) {
        return obterFicha(codigo) != null;
    }

    public Empregado obterFicha(String codigo) {
        for (Empregado e : repositorio) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                return e;
            }
        }

        return null;
    }

    public String toString() {
        String texto = "";
        for (Empregado e : repositorio) {
            texto += e + ",";
        }
        return texto;
    }

    public Object clone() {
        RepositorioEmpregados nova = new RepositorioEmpregados(repositorio.size());
        for (Empregado e : repositorio) {
            nova.adicionar(e);
        }
        return nova;

    }

}
