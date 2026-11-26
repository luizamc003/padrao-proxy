package padroesestruturais.proxy;

import java.util.List;

public interface IColaborador {
    List<String> obterDadosProfissionais();
    List<Float> obterRemuneracao(Usuario usuario);
}