package backend;

public class Sistema {

    private final MapEmpregados repositorioEmpregados;

    public Sistema() {
        repositorioEmpregados = new MapEmpregados();
    }

    public MapEmpregados getEmpregados() {
        return repositorioEmpregados;
    }

}
