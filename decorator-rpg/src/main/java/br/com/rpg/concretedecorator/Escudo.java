package br.com.rpg.concretedecorator;

import br.com.rpg.component.Personagem;
import br.com.rpg.decorator.EquipamentoDecorator;

public class Escudo extends EquipamentoDecorator {

    public Escudo(Personagem personagem) {
        super(personagem);
    }

    @Override
    public int getDefesa() {
        return personagem.getDefesa() + 15;
    }

    @Override
    public String getDescricao() {
        return personagem.getDescricao() + " + [Escudo +15DEF]";
    }
}
