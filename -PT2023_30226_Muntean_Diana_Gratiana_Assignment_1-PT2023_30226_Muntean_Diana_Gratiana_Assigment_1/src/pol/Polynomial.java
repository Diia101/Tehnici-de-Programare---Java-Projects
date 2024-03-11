package pol;

import java.util.HashMap;
import java.util.Map;

/**
 * In aceasta clasa realizam operatiile asupra polinoamelor, dupa citirea acestora
 */
public class Polynomial {

    public HashMap<Integer, Double> coefs;
    private int grad;
    private Polynomial pRezultat;

    // Contructor fara parametru, initializeaza polinomul null

    public Polynomial()
    {
        coefs = new HashMap<>();
    }

    /**
     * Constructor cu parametri care imi construieste un polinom cu coeficienti intregi
     * corespunzatori elementelor HashMap-ului transmis ca parametru
     *
     * @param p HashMap care contine coeficientii polinomului
     */

    public Polynomial(Map<Integer, Double> p) {
        grad = p.size() - 1;
        coefs = new HashMap<>(grad+1);
        int i = 0;
        for (Double coef : p.values()) {
            coefs.put(i++, coef);
        }
    }


    /**
     * Constructor cu un parametru construieste un polinom cu coeficientii
     * transmisi prin parametru de tip String
     *
     * @param polinom string ce contine coeficientii unui polinom
     */
    public Polynomial(String polinom) throws NumberFormatException {
        String[] coefsString = polinom.split(" ");
        grad = coefsString.length - 1;
        coefs = new HashMap<>(grad+1);

        int i = 0;
        for (String coefString : coefsString) {
            try {
                double coef = Double.parseDouble(coefString);
                coefs.put(i, coef);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Nu ati introdus bine coeficientii!!");
            }
            i++;
        }
    }



    /** Metoda aduna polinomul referit la cel transmis ca parametru
     * @param polin2 este polinomul care se va aduna la cel referit
     * @return pRezultat retine rezultatul operatiei dintre polinomul referit si cel transmis
     * ca parametru
     */


    public Polynomial aduna(Polynomial polin2) {
        Polynomial rezultat = new Polynomial();
        rezultat.grad = Math.max(this.grad, polin2.grad);
        rezultat.coefs = new HashMap<>();

        for (Map.Entry<Integer, Double> entry : this.coefs.entrySet()) {
            double coef = entry.getValue();
            rezultat.coefs.put(entry.getKey(), coef);
        }

        for (Map.Entry<Integer, Double> entry : polin2.coefs.entrySet()) {
            double coef = entry.getValue();
            double suma = rezultat.coefs.getOrDefault(entry.getKey(), 0.0) + coef;
            rezultat.coefs.put(entry.getKey(), suma);
        }

        return rezultat;
    }



    /** Metoda scade polinomul referit la cel transmis ca parametru
 * @param polin2 este polinomul care se va aduna la cel referit
 * @return pRezultat retine rezultatul operatiei dintre polinomul  si cel transmis
 *      * ca parametru
 *      */


    public Polynomial scade(Polynomial polin2) {
        Map<Integer, Double> coefsRezultat = new HashMap<Integer, Double>();

        for (Map.Entry<Integer, Double> entry : coefs.entrySet()) {
            int i = entry.getKey();
            double coef = entry.getValue();
            if (polin2.coefs.containsKey(i)) {
                double diferenta = coef - polin2.coefs.get(i);
                if (diferenta != 0) {
                    coefsRezultat.put(i, diferenta);
                }
            } else {
                coefsRezultat.put(i, coef);
            }
        }

        for (Map.Entry<Integer, Double> entry : polin2.coefs.entrySet()) {
            int i = entry.getKey();
            double coefPolin2 = entry.getValue();
            if (i > grad && coefPolin2 != 0) {
                coefsRezultat.put(i, -coefPolin2);
            }
        }

        return new Polynomial(coefsRezultat);
    }



    /** Metoda inmulteste polinomul referit la cel transmis ca parametru
 * @param polin2 este polinomul care se va inmulti la cel referit
 * @return pRezultat retine rezultatul operatiei dintre polinomul referit si cel transmis
 * ca parametru
 */


    public Polynomial inmulteste(Polynomial polin2) {
        Polynomial pRezultat = new Polynomial();
        pRezultat.grad = this.grad + polin2.grad; //gradul produsului = suma gradelor celor 2 polinomiale care se inmultesc
        pRezultat.coefs = new HashMap<>();
        for(Integer grade : pRezultat.coefs.keySet()){
            pRezultat.coefs.put(grade, 0.0);
        }
      int i=0;
        int j;
        while (i <= this.grad) {
            j = 0;
            while (j <= polin2.grad) {
                double coeficient = this.coefs.getOrDefault(i, 0.0) * polin2.coefs.getOrDefault(j, 0.0);
                int putere = i + j;
                pRezultat.coefs.put(putere, pRezultat.coefs.getOrDefault(putere, 0.0) + coeficient);
                j++;
            }
            i++;
        }

        return pRezultat;
    }



    /**Metoda imparte polinomul referit la cel transmis ca parametru
 *
 * @param divisor este polinomul care imparte polinomul referit
 * @return vectorul pRezultat contine restul si catul operatiei
 */

    public Polynomial imparte(Polynomial divisor) {
        if (divisor.grad < 0) {
            throw new IllegalArgumentException("Divizorul nu poate fi nul.");
        }
        if (this.grad < divisor.grad) {
            return new Polynomial();
        }

        // itereaza prin toate gradele
        for (int grad = this.grad; grad >= divisor.grad; grad--) {
            Double thisCoef = this.coefs.get(grad);
            if (thisCoef == null) {
                // daca coeficientul nu exista, il adaugam cu valoarea 0
                thisCoef = 0.0;
                this.coefs.put(grad, thisCoef);
            }

            Double divisorCoef = divisor.coefs.get(divisor.grad);
            if (divisorCoef == null) {
                // daca coeficientul nu exista, il adaugam cu valoarea 0
                divisorCoef = 0.0;
                divisor.coefs.put(divisor.grad, divisorCoef);
            }

            double coef = thisCoef / divisorCoef;
            Polynomial cat = new Polynomial();
            cat.coefs.put(grad - divisor.grad, coef);
            Polynomial produs = divisor.inmulteste(cat);
            this.scade(produs);
        }


        return this;
    }


    public Polynomial deriveaza() {
        HashMap<Integer, Double> coefsDeriv = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : coefs.entrySet()) {
            int putere = entry.getKey();
            Double coeficient = entry.getValue();
            if (putere > 0) {
                coefsDeriv.put(putere - 1, coeficient * putere);
            }
        }
        return new Polynomial(coefsDeriv);
    }


    public Polynomial integreaza() {
        Map<Integer, Double> coefsMap = new HashMap<>();
        double var;
        for (Map.Entry<Integer, Double> entry : this.coefs.entrySet()) {
            coefsMap.put(entry.getKey() + 1, entry.getValue());
        }
        coefsMap.put(0, 0.0);

        Polynomial pRezultat = new Polynomial(coefsMap);

        for (Map.Entry<Integer, Double> entry : pRezultat.coefs.entrySet()) {
            int key = entry.getKey();
            if (key != 0) {
                var = entry.getValue() / key;
                pRezultat.coefs.put(key, (double) var);
            }
        }
        return pRezultat;
    }



    /**
 * Aceasta metoda realizeaza convertirea coeficientilor intregi ai
 * polinomului in sir de caractere, de asemenea realizeaza modelul
 * polinomului sub forma (de ex:x^2+2x+3 )care va fi afisat in caseta de
 * text :rezultat
 *
 * @return sir polinomul scris sub o forma inteligibila
 */
public String polinomFinal() {
    String sir = "";
    boolean ok = false; // initial nu s-a afisat nimic
    int i=grad;
    while(i>0){
        if (coefs.containsKey(i) && coefs.get(i) != 0) {
            sir = sir.concat(Double.toString(coefs.get(i)));
            sir = sir.concat("*X^");
            sir = sir.concat(Double.toString(i));
            ok = true;
        }
        if (coefs.containsKey(i - 1) && coefs.get(i - 1) > 0) {
            sir = sir.concat("+");
        }
        i--;
    }
    if (coefs.containsKey(0) && (coefs.get(0) != 0 || !ok)) {
        sir = sir.concat(Double.toString(coefs.get(0)));
    }
    return sir;
}


}
