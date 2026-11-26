package padroesestruturais.proxy;

public class Usuario {
    private String nome;
    private boolean rh;

    public Usuario(String nome, boolean rh) {
        this.nome = nome;
        this.rh = rh;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isRh() {
        return rh;
    }

    public void setRh(boolean rh) {
        this.rh = rh;
    }
}