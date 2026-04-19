package br.com.rpg.concretedecorator;

import br.com.rpg.component.Personagem;
import br.com.rpg.decorator.EquipamentoDecorator;

public class Espada extends EquipamentoDecorator {

    public Espada(Personagem personagem) {
        super(personagem);
    }

    @Override
    public int getAtaque() {
        return personagem.getAtaque() + 12;
    }

    @Override
    public int getDefesa() {
        return personagem.getDefesa() + 2;
    }

    @Override
    public String getDescricao() {
        return personagem.getDescricao() + " + [Espada +12ATK/+2DEF]";
    }
}
