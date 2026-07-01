package mohamedjaouad.u5_w1_d2;

import mohamedjaouad.u5_w1_d2.entities.*;
import mohamedjaouad.u5_w1_d2.Enum.StatoOrdine;
import mohamedjaouad.u5_w1_d2.Enum.StatoTavolo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class U5W1D2ApplicationTests {

    @Autowired
    private Menu menu;

    @Autowired
    private Topping prosciutto;

    @Autowired
    private Topping salame;
    
    @Test
    void testPizzaBase() {
        Pizza p = new Pizza("Base", 7.00, 700);

        System.out.println("Pizza base: prezzo = " + p.getPrice() + ", calorie = " + p.getCalories());

        assertEquals(7.00, p.getPrice());
        assertEquals(700, p.getCalories());
    }

    @Test
    void testMenuNonVuoto() {
        System.out.println("Numero pizze nel menu: " + menu.getPizza().size());
        System.out.println("Numero bevande nel menu: " + menu.getDrink().size());
        System.out.println("Numero topping nel menu: " + menu.getTopping().size());

        assertFalse(menu.getPizza().isEmpty());
        assertFalse(menu.getDrink().isEmpty());
        assertFalse(menu.getTopping().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(doubles = {5.00, 7.00, 9.50})
    void testPrezziMultipli(double prezzoBase) {
        Pizza p = new Pizza("ParamPizza", prezzoBase, 500);

        System.out.println(" prezzo base: " + prezzoBase);

        assertEquals(prezzoBase, p.getPrice());
    }

    @Test
    void testOrdineSemplice() {
        Tavolo t = new Tavolo(1, 4, StatoTavolo.OCCUPATO);

        Ordine ordine = new Ordine(1, StatoOrdine.IN_CORSO, 2, t, 2.00);

        ordine.aggiungiElemento(menu.getPizza().get(0));

        double expected = 2 * 2.00 + menu.getPizza().get(0).getPrice();

        System.out.println("Totale ordine calcolato: " + ordine.getTotale());
        System.out.println("Totale atteso: " + expected);

        assertEquals(expected, ordine.getTotale());
    }

}
