package mohamedjaouad.u5_w1_d2.runners;


import mohamedjaouad.u5_w1_d2.Enum.StatoOrdine;
import mohamedjaouad.u5_w1_d2.Enum.StatoTavolo;
import mohamedjaouad.u5_w1_d2.entities.Menu;
import mohamedjaouad.u5_w1_d2.entities.Ordine;
import mohamedjaouad.u5_w1_d2.entities.Tavolo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerOrdini implements CommandLineRunner {

    private final Menu menu;
    private final double costoCoperto;

    public RunnerOrdini(Menu menu, @Value("${costo.coperto}") double costoCoperto) {
        this.menu = menu;
        this.costoCoperto = costoCoperto;
    }

    @Override
    public void run(String... args) {

        System.out.println("MENU COMPLETO \n");
        menu.printMenu();

        Tavolo tavolo = new Tavolo(1, 4, StatoTavolo.OCCUPATO);

        Ordine ordine = new Ordine(
                1001,
                StatoOrdine.IN_CORSO,
                2,
                tavolo,
                costoCoperto
        );

        ordine.aggiungiElemento(menu.getPizza().get(0));
        ordine.aggiungiElemento(menu.getDrink().get(1));

        System.out.println("\nORDINE CREATO \n");
        System.out.println(ordine);
    }
}