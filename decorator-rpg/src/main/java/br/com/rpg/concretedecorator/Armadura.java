package br.com.rpg.concretedecorator;

import br.com.rpg.component.Personagem;
import br.com.rpg.decorator.EquipamentoDecorator;

public class Armadura extends EquipamentoDecorator {

    public Armadura(Personagem personagem) {
        super(personagem);
    }

    @Override
    public int getAtaque() {
        return personagem.getAtaque() + 3;
    }

    @Override
    public int getDefesa() {
        return personagem.getDefesa() + 20;
    }

    @Override
    public String getDescricao() {
        return personagem.getDescricao() + " + [Armadura +3ATK/+20DEF]";
    }
}
