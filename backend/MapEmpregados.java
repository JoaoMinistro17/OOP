package backend;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class MapEmpregados {
    //private HashMap<Integer, Empregado> repositorio;

    private HashMap<String, Empregado> repositorio;

    public MapEmpregados() {
        repositorio = new HashMap<>();
    }

    public void adicionar(Empregado empregado) {
        repositorio.put(empregado.getCodigo(), empregado);
    }

    public double calcularTotalSalarios() {
        double total = 0;
        for (Empregado e : repositorio.values()) {
            total += e.calcularSalario();
        }
        return total;
    }

    public int calcularTotalKm() {
        int total = 0;
        for (Empregado e : repositorio.values()) {
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
        for (Empregado e : repositorio.values()) {
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
        for (Empregado e : repositorio.values()) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                return e;
            }
        }

        return null;
    }

    public String toString() {
        String texto = "";
        for (Empregado e : repositorio.values()) {
            texto += e + ",";
        }
        return texto;
    }

    public Object clone() {
        RepositorioEmpregados nova = new RepositorioEmpregados(repositorio.size());
        for (Empregado e : repositorio.values()) {
            nova.adicionar(e);
        }
        return nova;

    }

    public void guardarFicheiroTexto(String nomeFicheiro) throws Exception {
        FileWriter fstream = new FileWriter(nomeFicheiro);
        BufferedWriter out = new BufferedWriter(fstream);

        for (Empregado e : repositorio.values()) {
            out.write(e.toString() + "\n");
        }

        out.close();
        fstream.close(); 
    }

    public void guardarFicheiroDados(String nomeFicheiro) throws Exception {

        if (repositorio.isEmpty()) return;

        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        for (Empregado e : repositorio.values()) {
            if (e instanceof Gestor) {
                Gestor g = (Gestor) e;
                dos.writeUTF(g.getClass().getSimpleName());
                dos.writeUTF(g.getCodigo());
                dos.writeUTF(g.getNome());
                dos.writeInt(g.getNumeroDiasTrabalho());
                dos.writeDouble(g.getSalarioDia());
                dos.writeDouble(g.getTaxaPremio());

            } else if (e instanceof Motorista) {
                Motorista m = (Motorista) e;
                dos.writeUTF(m.getClass().getSimpleName());
                dos.writeUTF(m.getCodigo());
                dos.writeUTF(m.getNome());
                dos.writeInt(m.getNumeroDiasTrabalho());
                dos.writeDouble(m.getSalarioDia());
                dos.writeDouble(m.getKmPercorridos());
                dos.writeDouble(Motorista.getPrecoKm());
            }
        }

        dos.close();
        bos.close();
        fos.close();
    }

    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(repositorio);

        oos.close();
        fos.close();
    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        repositorio = (HashMap<String, Empregado>) oin.readObject();
        oin.close();
        file.close();
    }

}
