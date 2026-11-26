package padroesestruturais.proxy;

import java.util.Arrays;
import java.util.List;

public class Colaborador implements IColaborador {

    private Integer matricula;
    private String nome;
    private String cargo;
    private Float salario;
    private Float bonus;

    public Colaborador(int matricula) {
        this.matricula = matricula;
        Colaborador objeto = BD.getColaborador(matricula);
        this.nome = objeto.nome;
        this.cargo = objeto.cargo;
        this.salario = objeto.salario;
        this.bonus = objeto.bonus;
    }

    public Colaborador(Integer matricula, String nome, String cargo, Float salario, Float bonus) {
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.bonus = bonus;
    }

    public Integer getMatricula() {
        return matricula;
    }

    @Override
    public List<String> obterDadosProfissionais() {
        return Arrays.asList(this.nome, this.cargo);
    }

    @Override
    public List<Float> obterRemuneracao(Usuario usuario) {
        return Arrays.asList(this.salario, this.bonus);
    }
}