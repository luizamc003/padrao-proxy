package padroesestruturais.proxy;

import java.util.List;

public class ColaboradorProxy implements IColaborador {

    private Colaborador colaborador;

    private Integer matricula;

    public ColaboradorProxy(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public List<String> obterDadosProfissionais() {
        if (this.colaborador == null) {
            this.colaborador = new Colaborador(this.matricula);
        }
        return this.colaborador.obterDadosProfissionais();
    }

    @Override
    public List<Float> obterRemuneracao(Usuario usuario) {
        if (!usuario.isRh()) {
            throw new IllegalArgumentException("Usuário não autorizado");
        }
        if (this.colaborador == null) {
            this.colaborador = new Colaborador(this.matricula);
        }
        return this.colaborador.obterRemuneracao(usuario);
    }
}