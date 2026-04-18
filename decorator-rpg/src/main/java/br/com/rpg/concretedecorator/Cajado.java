package br.com.rpg.concretedecorator;

import br.com.rpg.component.Personagem;
import br.com.rpg.decorator.EquipamentoDecorator;

public class Cajado extends EquipamentoDecorator {

    public Cajado(Personagem personagem) {
        super(personagem);
    }

    @Override
    public int getAtaque() {
        return personagem.getAtaque() + 18;
    }

    @Override
    public int getDefesa() {
        return personagem.getDefesa() + 1;
    }

    @Override
    public String getDescricao() {
        return personagem.getDescricao() + " + [Cajado Mágico +18ATK/+1DEF]";
    }
}
