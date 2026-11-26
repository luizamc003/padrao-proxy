package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ColaboradorProxyTest {

    @BeforeEach
    void setUp() {
        BD.addColaborador(new Colaborador(1, "João", "Analista de Sistemas", 6000.0f, 1000.0f));
        BD.addColaborador(new Colaborador(2, "Maria", "Gerente de Vendas", 9000.0f, 2500.0f));
    }

    @Test
    void deveRetornarDadosProfissionaisColaborador() {
        ColaboradorProxy colaborador = new ColaboradorProxy(1);

        assertEquals(Arrays.asList("João", "Analista de Sistemas"), colaborador.obterDadosProfissionais());
    }

    @Test
    void deveRetornarRemuneracaoColaborador() {
        Usuario usuario = new Usuario("Ana", true);
        ColaboradorProxy colaborador = new ColaboradorProxy(2);

        assertEquals(Arrays.asList(9000.0f, 2500.0f), colaborador.obterRemuneracao(usuario));
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoAutorizadoConsultarRemuneracaoColaborador() {
        try {
            Usuario usuario = new Usuario("Joana", false);
            ColaboradorProxy colaborador = new ColaboradorProxy(2);

            colaborador.obterRemuneracao(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Usuário não autorizado", e.getMessage());
        }
    }
}