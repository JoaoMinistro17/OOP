package backend;

public class ListaEmpregados {

    private Empregado[] lista;
    private int numeroEmpregados;

    public ListaEmpregados(int tamanho) {
        lista = new Empregado[tamanho];
    }

    public void adicionar(Empregado empregado) {
        lista[numeroEmpregados] = empregado;
        numeroEmpregados++;
    }

    public double calcularTotalSalarios() {
        double total = 0;
        for (int i = 0; i < numeroEmpregados; i++) {
            Empregado e = lista[i];
            total += e.calcularSalario();
        }
        return total;
    }

    public int calcularTotalKm() {
        int total = 0;
        for (int i = 0; i < numeroEmpregados; i++) {
            Empregado e = lista[i];
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
        for (int i = 0; i < numeroEmpregados; i++) {
            Empregado e = lista[i];
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
        for (int i = 0; i < numeroEmpregados; i++) {
            Empregado e = lista[i];
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                return e;
            }
        }

        return null;
    }

    public String toString() {
        String texto = "";
        for (int i = 0; i < numeroEmpregados; i++) {
            Empregado e = lista[i];
            texto += e + ",";
        }
        return texto;
    }

    public Object clone() {
        ListaEmpregados nova = new ListaEmpregados(lista.length);
        for (int i = 0; i < numeroEmpregados; i++) {
            Empregado e = lista[i];
            nova.adicionar(e);
        }
        return nova;

    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof ListaEmpregados) {
            ListaEmpregados outra = (ListaEmpregados) o;
            return outra.numeroEmpregados == numeroEmpregados;
        }
        return false;
    }
}
