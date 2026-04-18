package br.com.rpg.concretedecorator;

import br.com.rpg.component.Personagem;
import br.com.rpg.decorator.EquipamentoDecorator;

public class Amuleto extends EquipamentoDecorator {

    public Amuleto(Personagem personagem) {
        super(personagem);
    }

    @Override
    public int getAtaque() {
        return personagem.getAtaque() + 8;
    }

    @Override
    public int getDefesa() {
        return personagem.getDefesa() + 8;
    }

    @Override
    public String getDescricao() {
        return personagem.getDescricao() + " + [Amuleto Ancestral +8ATK/+8DEF]";
    }
}
