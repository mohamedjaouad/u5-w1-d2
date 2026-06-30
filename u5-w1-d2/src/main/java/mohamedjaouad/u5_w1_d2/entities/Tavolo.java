package mohamedjaouad.u5_w1_d2.entities;
import mohamedjaouad.u5_w1_d2.Enum.StatoTavolo;

public class Tavolo {

        private int numero;
        private int maxCoperti;
        private StatoTavolo stato;

        public Tavolo(int numero, int maxCoperti, StatoTavolo stato) {
            this.numero = numero;
            this.maxCoperti = maxCoperti;
            this.stato = stato;
        }

        public int getNumero() {
            return numero;
        }

        public int getMaxCoperti() {
            return maxCoperti;
        }

        public StatoTavolo getStato() {
            return stato;
        }

        @Override
        public String toString() {
            return "Tavolo{" +
                    "numero=" + numero +
                    ", maxCoperti=" + maxCoperti +
                    ", stato=" + stato +
                    '}';
        }
    }


