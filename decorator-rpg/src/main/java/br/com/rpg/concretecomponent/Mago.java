package br.com.rpg.concretecomponent;

import br.com.rpg.component.Personagem;

public class Mago implements Personagem {

    private final String nome;

    public Mago(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getAtaque() {
        return 20;
    }

    @Override
    public int getDefesa() {
        return 5;
    }

    @Override
    public String getDescricao() {
        return "[Mago] " + nome + " | ATK: " + getAtaque() + " | DEF: " + getDefesa();
    }
}
