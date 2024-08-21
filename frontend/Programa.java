package frontend;

import backend.Empregado;
import backend.Gestor;
import backend.Motorista;
import backend.Sistema;

public class Programa {

    private final Sistema sistema = new Sistema();
    private final Consola consola = new Consola();

    private void adicionarMotorista() {
        String codigo = consola.lerString("Introduza o código");
        String nome = consola.lerString("Introduza o nome");
        int numeroDiasTrab = consola.lerInteiro("Introduza num. dias trabalho");
        double salarioDia = consola.lerInteiro("Introduza o salario dia");
        int numeroKm = consola.lerInteiro("Introduza num. km percorridos");

        sistema.getEmpregados().adicionar(new Motorista(nome, codigo, numeroDiasTrab, salarioDia, numeroKm));
        consola.escrever("Motorista adicionado com sucesso");
    }

    private void adicionarGestor() {
        String codigo = consola.lerString("Introduza o código");
        String nome = consola.lerString("Introduza o nome");
        int numeroDiasTrab = consola.lerInteiro("Introduza num. dias trabalho");
        double salarioDia = consola.lerDecimal("Introduza o salario dia");
        double taxaPremio = consola.lerInteiro("Introduza taxa premio");

        sistema.getEmpregados().adicionar(new Gestor(nome, codigo, numeroDiasTrab, salarioDia, taxaPremio));
        consola.escrever("Gestor adicionado com sucesso");
    }

    private void definirPrecoKm() {
        Motorista.setPrecoKm(consola.lerDecimal("Introduza o valor por km"));
        consola.escrever("Preco por Km alterado com sucesso");
    }

    private void calcularTotalSalarios() {
        consola.escrever("Total de salarios a pagar: "
                + sistema.getEmpregados().calcularTotalSalarios());
    }

    private void calcularKmPercorridos() {
        consola.escrever("Total de KM Percorridos: "
                + sistema.getEmpregados().calcularTotalKm());
    }

    private void calcularNumGestores() {
        consola.escrever("Total de gestores: " + sistema
                .getEmpregados().calcularNumGestores());
    }

    private void calcularNumEmpregadosTipo() {
        String tipo = consola.lerString("Introduza o tipo do empregado");
        consola.escrever("Total de empregados do tipo '" + tipo + ": "
                + sistema.getEmpregados().calcularNumEmpregadosTipo(tipo));
    }

    private void verificarEmpregadoExiste() {
        String codigo = consola.lerString("Introduza o codigo do empregado");
        consola.escrever("Existe codigo '" + codigo + "': "
                + (sistema.getEmpregados().verificarEmpregadoExiste(codigo) ? "Sim" : "Nao"));
    }

    private void fichaEmpregado() {
        String codigo = consola.lerString("Introduza o codigo do empregado");
        Empregado empregado = sistema.getEmpregados().obterFicha(codigo);
        if (empregado != null) {
            consola.escrever(empregado.toString());
        } else {
            consola.escrever("Nao existe um empregado com esse codigo");
        }
    }

    private void guardarFicheiroTexto() {
        String nomeFicheiro = consola.lerString("Introduza o nome do ficheiro");
        try {
            sistema.getEmpregados().guardarFicheiroTexto(nomeFicheiro);
            consola.escrever("Ficheiro guardado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel criar o ficheiro: "
                    + ex.getLocalizedMessage());
        }
    }

    private void guardarFicheiroDados() {
        String nomeFicheiro = consola.lerString("Introduza o nome do ficheiro");
        try {
            sistema.getEmpregados().guardarFicheiroDados(nomeFicheiro);
            consola.escrever("Ficheiro guardado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel criar o ficheiro: "
                    + ex.getLocalizedMessage());
        }
    }

    private void guardarFicheiroObjectos() {
        String nomeFicheiro = consola.lerString("Introduza o nome do ficheiro");
        try {
            sistema.getEmpregados().guardarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro guardado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel criar o ficheiro: "
                    + ex.getLocalizedMessage());
        }
    }

    private void carregarFicheiroObjectos() {
        String nomeFicheiro = consola.lerString("Introduza o nome do ficheiro");
        try {
            sistema.getEmpregados().carregarFicheiroObjetos(nomeFicheiro);
            consola.escrever("Ficheiro carregado");
        } catch (Exception ex) {
            consola.escrever("Não foi possivel carregar o ficheiro: "
                    + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Programa programa = new Programa();

        int opcao;
        String[] opcoes = {
            "Criar motorista",
            "Criar gestor",
            "Definir preco Km",
            "Calcular o total salarios pagar",
            "Calcular o total de kms percorridos pelos motoristas",
            "Calcular o número total de gestores da empresa",
            "Calcular o total de empregados do tipo dado como String",
            "Verificar se um empregado com código “X” existe",
            "Devolver a ficha de um empregado dado o seu código",
            "Gravar a instância num ficheiro de texto",
            "Gravar a instância num ficheiro de dados",
            "Gravar a instância num ficheiro de objetos",
            "Ler a instância a partir de um ficheiro de objetos",
            "Sair"};

        do {
            opcao = programa.consola.lerInteiro(opcoes);

            switch (opcao) {
                case 1:
                    programa.adicionarMotorista();
                    break;
                case 2:
                    programa.adicionarGestor();
                    break;
                case 3:
                    programa.definirPrecoKm();
                    break;
                case 4:
                    programa.calcularTotalSalarios();
                    break;
                case 5:
                    programa.calcularKmPercorridos();
                    break;
                case 6:
                    programa.calcularNumGestores();
                    break;
                case 7:
                    programa.calcularNumEmpregadosTipo();
                    break;
                case 8:
                    programa.verificarEmpregadoExiste();
                    break;
                case 9:
                    programa.fichaEmpregado();
                    break;
                case 10:
                    programa.guardarFicheiroTexto();
                    break;
                case 11:
                    programa.guardarFicheiroDados();
                    break;
                case 12:
                    programa.guardarFicheiroObjectos();
                    break;
                case 13:
                    programa.carregarFicheiroObjectos();
            }
        } while (opcao != opcoes.length);

    }
}
