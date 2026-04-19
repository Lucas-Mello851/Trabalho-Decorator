package br.com.rpg.decorator;

import br.com.rpg.component.Personagem;

public abstract class EquipamentoDecorator implements Personagem {

    protected final Personagem personagem;

    public EquipamentoDecorator(Personagem personagem) {
        this.personagem = personagem;
    }

    @Override
    public String getNome() {
        return personagem.getNome();
    }

    @Override
    public int getAtaque() {
        return personagem.getAtaque();
    }

    @Override
    public int getDefesa() {
        return personagem.getDefesa();
    }

    @Override
    public String getDescricao() {
        return personagem.getDescricao();
    }
}
