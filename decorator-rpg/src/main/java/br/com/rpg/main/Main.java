package br.com.rpg.main;

import br.com.rpg.component.Personagem;
import br.com.rpg.concretecomponent.Guerreiro;
import br.com.rpg.concretecomponent.Mago;
import br.com.rpg.concretedecorator.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(" ");
        System.out.println("   RPG — Padrão Decorator (GOF)           ");
        System.out.println("\n");

        Personagem p1 = new Guerreiro("Thorin");
        exibir("Guerreiro base", p1);

        Personagem p2 = new Guerreiro("Thorin");
        p2 = new Espada(p2);
        p2 = new Escudo(p2);
        exibir("Guerreiro com Espada + Escudo", p2);

        Personagem p3 = new Guerreiro("Ragnar");
        p3 = new Armadura(p3);
        p3 = new Escudo(p3);
        p3 = new Amuleto(p3);
        exibir("Guerreiro Full Tanque", p3);

        Personagem p4 = new Mago("Gandalf");
        exibir("Mago base", p4);

        Personagem p5 = new Mago("Gandalf");
        p5 = new Cajado(p5);
        p5 = new Amuleto(p5);
        exibir("Mago com Cajado + Amuleto", p5);

        Personagem p6 = new Mago("Saruman");
        p6 = new Cajado(p6);
        p6 = new Cajado(p6);
        p6 = new Amuleto(p6);
        exibir("Mago Full DPS (Cajado duplo)", p6);

        System.out.println(" ");
        System.out.println("   Demonstração concluída!                ");
        System.out.println(" ");
    }

    private static void exibir(String titulo, Personagem p) {
        System.out.println("► " + titulo);
        System.out.println("  " + p.getDescricao());
        System.out.printf("  ATK total: %d  |  DEF total: %d%n%n", p.getAtaque(), p.getDefesa());
    }
}
