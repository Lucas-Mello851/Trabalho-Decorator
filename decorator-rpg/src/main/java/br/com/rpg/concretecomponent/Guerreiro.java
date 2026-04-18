package br.com.rpg.concretecomponent;

import br.com.rpg.component.Personagem;

public class Guerreiro implements Personagem {

    private final String nome;

    public Guerreiro(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getAtaque() {
        return 15;
    }

    @Override
    public int getDefesa() {
        return 10;
    }

    @Override
    public String getDescricao() {
        return "[Guerreiro] " + nome + " | ATK: " + getAtaque() + " | DEF: " + getDefesa();
    }
}
