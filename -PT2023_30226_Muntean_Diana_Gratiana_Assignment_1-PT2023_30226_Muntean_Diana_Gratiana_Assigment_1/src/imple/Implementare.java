package imple;

import main.Tema1;
import pol.Polynomial;

import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.*;

/**aceasta clasa realizeaza prelucrarea datelor implementand ascultatorii pentru butoane
 * @author Diia101
 */
public class Implementare implements ActionListener
{
    private Tema1 f;
    /**
     * suprascrie metoda actionPerformed din clasa ActionListener
     * si implementeaza ascultatorul pentru butoane
     * @param e evenimentul care intervine in urma apasarii unui buton
     */
    public void actionPerformed(ActionEvent e) {
        String coeficienti;
        Polynomial polinomRezultat;
        Polynomial polinom1;
        Polynomial polinom2;
        String buton = e.getActionCommand();
        coeficienti = f.getPolinom1();

        // Se verifica daca s-au introdus coeficientii primului polinom
        if (!coeficienti.equals("")) {
            try {
                polinom1 = new Polynomial(coeficienti);
            } catch (NumberFormatException ex) {    //exceptie cand nu e numar
                f.setRezultat(ex.getMessage());
                return;
            }

            coeficienti = f.getPolinom2();
            //Se verifica daca s-au introdus coeficientii celui de-al doilea
            if (!coeficienti.equals("")) {
                try {
                    polinom2 = new Polynomial(coeficienti);
                } catch (NumberFormatException ex) {
                    f.setRezultat(ex.getMessage());
                    return;
                }
                if (buton.equals("Add")) {
                    f.setRezultat(polinom1.aduna(polinom2).polinomFinal());
                } else if (buton.equals("Subtract")) {
                    f.setRezultat(polinom1.scade(polinom2).polinomFinal());
                } else if (buton.equals("Multiplicate")) {
                    f.setRezultat(polinom1.inmulteste(polinom2).polinomFinal());
                } else if(buton.equals("Divide")){
                    f.setRezultat(polinom1.imparte(polinom2).polinomFinal());
                } else if (buton.equals("Derivative")) {
                    String[] optiune = {"First polynom", "Second polynom"};
                    int n = JOptionPane.showOptionDialog(f.getFrame(), "Alegeti polinomul pe care doriti sa il derivati", "Deriveaza unul dintre polinoame", 0, 3, null, optiune, "Primul polinom");
                    if (n == 0) {
                        f.setRezultat(polinom1.deriveaza().polinomFinal());
                    } else {
                        f.setRezultat((polinom2.deriveaza().polinomFinal()));
                    }
                } else if (buton.equals("Integration")) {
                    String[] optiune = {"First polynom", "Second polynom"};
                    int n = JOptionPane.showOptionDialog(f.getFrame(), "Alegeti polinomul pe care doriti sa il integrati:", "Integreaza unul dintre polinoame", 0, 3, null, optiune, " pppPrimul polinom");
                    if (n == 0) {
                        f.setRezultat(polinom1.integreaza().polinomFinal());
                    } else {
                        f.setRezultat((polinom2.integreaza().polinomFinal()));
                    }
                }
            }
            else {
                //daca nu au fost introdusi coeficientii polinomului al doilea
                //programul va afisa un mesaj corespunzator
                JOptionPane.showMessageDialog(f.getFrame(), "Introduceti si al doilea polinom!", "Atentie!", 2, null);
            }
        }
        else {
            //daca nu au fost introdusi coeficientii primului
            //deasemenea va fi afisat mesaj corespunzator
            JOptionPane.showMessageDialog(f.getFrame(), "Introduceti primul polinom!", "Atentie!", 2, null);
        }
    }

    public Implementare(Tema1 f) {

        this.f = f;
    }
}




