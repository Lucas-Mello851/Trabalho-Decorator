package br.com.rpg;

import br.com.rpg.component.Personagem;
import br.com.rpg.concretecomponent.Guerreiro;
import br.com.rpg.concretecomponent.Mago;
import br.com.rpg.concretedecorator.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Padrão Decorator — RPG")
class PersonagemDecoratorTest {

    @Test
    @DisplayName("Guerreiro base deve ter ATK 15 e DEF 10")
    void testGuerreiroBase() {
        Personagem p = new Guerreiro("Thorin");
        assertEquals(15, p.getAtaque());
        assertEquals(10, p.getDefesa());
        assertEquals("Thorin", p.getNome());
        assertTrue(p.getDescricao().contains("Guerreiro"));
    }

    @Test
    @DisplayName("Mago base deve ter ATK 20 e DEF 5")
    void testMagoBase() {
        Personagem p = new Mago("Gandalf");
        assertEquals(20, p.getAtaque());
        assertEquals(5, p.getDefesa());
        assertEquals("Gandalf", p.getNome());
        assertTrue(p.getDescricao().contains("Mago"));
    }

    @Test
    @DisplayName("Espada deve adicionar +12 ATK e +2 DEF")
    void testEspada() {
        Personagem p = new Espada(new Guerreiro("X"));
        assertEquals(15 + 12, p.getAtaque());
        assertEquals(10 + 2,  p.getDefesa());
        assertTrue(p.getDescricao().contains("Espada"));
    }

    @Test
    @DisplayName("Escudo deve adicionar +0 ATK e +15 DEF")
    void testEscudo() {
        Personagem p = new Escudo(new Guerreiro("X"));
        assertEquals(15,      p.getAtaque());
        assertEquals(10 + 15, p.getDefesa());
        assertTrue(p.getDescricao().contains("Escudo"));
    }

    @Test
    @DisplayName("Armadura deve adicionar +3 ATK e +20 DEF")
    void testArmadura() {
        Personagem p = new Armadura(new Guerreiro("X"));
        assertEquals(15 + 3,  p.getAtaque());
        assertEquals(10 + 20, p.getDefesa());
        assertTrue(p.getDescricao().contains("Armadura"));
    }

    @Test
    @DisplayName("Cajado deve adicionar +18 ATK e +1 DEF")
    void testCajado() {
        Personagem p = new Cajado(new Mago("X"));
        assertEquals(20 + 18, p.getAtaque());
        assertEquals(5 + 1,   p.getDefesa());
        assertTrue(p.getDescricao().contains("Cajado"));
    }

    @Test
    @DisplayName("Amuleto deve adicionar +8 ATK e +8 DEF")
    void testAmuleto() {
        Personagem p = new Amuleto(new Mago("X"));
        assertEquals(20 + 8, p.getAtaque());
        assertEquals(5 + 8,  p.getDefesa());
        assertTrue(p.getDescricao().contains("Amuleto"));
    }

    @Test
    @DisplayName("Guerreiro com Espada + Escudo deve acumular bônus corretamente")
    void testGuerreiroEspadaEscudo() {
        Personagem p = new Escudo(new Espada(new Guerreiro("Thorin")));
        assertEquals(27, p.getAtaque());
        assertEquals(27, p.getDefesa());
    }

    @Test
    @DisplayName("Guerreiro full tanque (Armadura + Escudo + Amuleto)")
    void testGuerreiroFullTanque() {
        Personagem p = new Guerreiro("Ragnar");
        p = new Armadura(p);
        p = new Escudo(p);
        p = new Amuleto(p);
        assertEquals(26, p.getAtaque());
        assertEquals(53, p.getDefesa());
    }

    @Test
    @DisplayName("Mago com Cajado + Amuleto deve acumular corretamente")
    void testMagoCajadoAmuleto() {
        Personagem p = new Amuleto(new Cajado(new Mago("Gandalf")));
        assertEquals(46, p.getAtaque());
        assertEquals(14, p.getDefesa());
    }

    @Test
    @DisplayName("Cajado duplo deve somar o bônus duas vezes")
    void testCajadoDuplo() {
        Personagem p = new Mago("Saruman");
        p = new Cajado(p);
        p = new Cajado(p);
        assertEquals(56, p.getAtaque());
        assertEquals(7,  p.getDefesa());
    }

    @Test
    @DisplayName("Decorator não deve modificar o objeto original")
    void testOriginalNaoModificado() {
        Personagem original = new Guerreiro("Herói");
        int atkOriginal = original.getAtaque();
        int defOriginal = original.getDefesa();

        Personagem decorado = new Espada(original);
        decorado.getAtaque();

        assertEquals(atkOriginal, original.getAtaque());
        assertEquals(defOriginal, original.getDefesa());
    }

    @Test
    @DisplayName("getNome deve sempre retornar o nome original do personagem")
    void testNomePreservado() {
        Personagem p = new Mago("Merlin");
        p = new Cajado(p);
        p = new Amuleto(p);
        p = new Escudo(p);
        assertEquals("Merlin", p.getNome());
    }
}
