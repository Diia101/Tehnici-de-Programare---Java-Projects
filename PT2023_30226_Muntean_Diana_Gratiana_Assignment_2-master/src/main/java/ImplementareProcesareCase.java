
/**
 * Aceasta clasa are rolul de a implementa algoritmii pentru procesarea caselor
 * @author Diia101
 */
public class ImplementareProcesareCase {

    private Prelucrare casePrelucrate;

    /**
     * constructor cu un parametru
     * Are rolul de a initializa variabila de instanta casePrelucrate cu un obiect de tip Prelucrarea dat ca parametru
     */
    public ImplementareProcesareCase(Prelucrare ob) {
        casePrelucrate = ob; // referinta spre cozile active din sistem
    }

    /**
     * Aceasta metoda are rolul de a distribui clientii care sosesc la casa cu timpul de golire minim sau in cazul in care
     * nu exista nici o casa cu timpul de golire mai mic decat 20s se va deschide o noua casa
     */
    public void distribuireClient(Client cl) {
        boolean gasitCoadaLibera = false;
        int timpMinim = Integer.MAX_VALUE;
        Casa casaInCareIntroduc = null;
    //if(casePrelucrate.getCaseDeschise()!=null) {
        for (Casa c : casePrelucrate.getCaseDeschise()) {
            if (c.getTimpGolire() < 20) {
                gasitCoadaLibera = true;
                if (c.getTimpGolire() < timpMinim) {    //caut casa cu timpul de golire<20 si care are timpul minim
                    timpMinim = c.getTimpGolire();
                    casaInCareIntroduc = c;
                }
            }
        }
    //}
        if (gasitCoadaLibera == true)
        {
            casaInCareIntroduc.adaugaClient(cl);
        } else if (gasitCoadaLibera == false && casePrelucrate.getCaseDeschise().size() < casePrelucrate.getNumarMaximCase()) //daca nu am gasit coada libera
        //dar mai am case disponibile deschid o noua casa
        {
            Casa c = new Casa(casePrelucrate.getCaseDeschise().size());//deschid casa cu indexul urmator
            c.adaugaClient(cl);
            casePrelucrate.adaugaCasa(c);
        }
        else // daca nu mai am case disponibile si timpul de golire al fiecarei case>20 adaug clientul intr-o casa cu timpul cel mai mic de golire
        {
            timpMinim = Integer.MAX_VALUE;
            for (Casa c : casePrelucrate.getCaseDeschise())
            {
                if (c.getTimpGolire() < timpMinim)
                {
                    timpMinim = c.getTimpGolire();
                    casaInCareIntroduc =c;
                }
            }
            casaInCareIntroduc.adaugaClient(cl);
        }
        casePrelucrate.actualizeazaTimpMediuAsteptare();//actualizez timpii de asteptare si golire
        casePrelucrate.actualizeazaTimpTotalGolire();
    }



}

