
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *Contine un ArrayList de case care sunt disponibile,deschise.
 * Prelucreaza informatiile despre acestea
 * @author Diia101
 */
public class Prelucrare {
    private int nrCaseDisponibile,timpTotalGolireCase;
   // private AtomicInteger timpMediuAsteptare;
   // private BlockingQueue<Casa> caseDeschise;
    double timpMediuAsteptare;   //private AtomicInteger waitingPeriod;
    private ArrayList<Casa> caseDeschise;    //private BlockingQueue<Casa> caseDeschise;

    /**
     * Constructor cu un singur parametru
     * @param nrMaxCase numarul maxim de case care pot fi deschise pentru servirea clientilor
     * Acest constructor pentru inceput initializeaza arraylistul de case cu Casa0.Presupune ca initial este deschisa casa cu
     * indexul 0
     *
     */
    public Prelucrare(int nrMaxCase)
    {
//        this.nrCaseDisponibile=nrMaxCase;
//        Casa c= new Casa(0);//initial prima casa deschisa este cea cu indexul 0
//       // caseDeschise=new BlockingQueue<Casa>();
//        BlockingQueue<Casa> caseDeschise = new ArrayBlockingQueue<Casa>(nrMaxCase+1);
//        caseDeschise.add(c);
//        double timpMediuAsteptare = 0.0;
//        AtomicInteger timpMediuAsteptareInt = new AtomicInteger((int) timpMediuAsteptare);
//        timpTotalGolireCase=0;
        this.nrCaseDisponibile=nrMaxCase;
        caseDeschise=new ArrayList<Casa>(nrMaxCase);
        for(int i=0;i<nrMaxCase;i++)
        {
            Casa c= new Casa(i);//initial prima casa deschisa este cea cu indexul 0
            caseDeschise.add(c);
        }
        timpMediuAsteptare=0.0;
        timpTotalGolireCase=0;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:caseDeschise
     * @return toate casele care sunt deschise la momentul apelarii
     */
    //public ArrayList<Casa> getCaseDeschise()    //BlockingQueue<Casa>
//    public BlockingQueue<Casa> getCaseDeschise()
//    {
//        if(getCaseDeschise()!=null) {
//            return caseDeschise;
//        }
//        else
//    }

//    public BlockingQueue<Casa> getCaseDeschise() {
//        if (caseDeschise == null) {
//            caseDeschise = new LinkedBlockingQueue<>();
//        }
//        return caseDeschise;
//    }
    public ArrayList<Casa> getCaseDeschise()
    {
        return caseDeschise;
    }
    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpTotalGolireCase
     * @return timpul total de golire al caselor care sunt deschise
     */
    public int getTimptotalgolireCase()
    {
        return this.timpTotalGolireCase;
    }
    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpMediuAsteptare
     * @return timpul mediu de asteptare  al caselor care sunt deschise
     */
//    public double getTimpMediuAsteptare()
//    {
//        if (this.timpMediuAsteptare != null) {
//            return this.timpMediuAsteptare.doubleValue();
//        }
//        else {
//            // tratați cazul în care timpMediuAsteptare este nul
//            return 0.0;
//        }
//
//    }

    public double getTimpMediuAsteptare()
    {
        return this.timpMediuAsteptare;
    }
    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:nrCaseDisponibile
     * @return numarul maxim de case care pot fi deschise pt simularea aplicatiei
     */
    public int getNumarMaximCase()
    {
        return nrCaseDisponibile;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpTotalGolireCase.
     * Are rolul de a actualiza timpul de golire al caselor
     */
    public void actualizeazaTimpTotalGolire()
    {
        timpTotalGolireCase=0;
        for(Casa c:caseDeschise)
        {
            c.actualizeazaTimpGolireCasa();
            timpTotalGolireCase+=c.getTimpGolire();
        }
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpMediuAsteptare.
     * Are rolul de a actualiza timpul mediu de asteptare al caselor
     */
//    public void actualizeazaTimpMediuAsteptare()
//    {
//        double timpMediuAsteptare1 = 0.0;
//        AtomicInteger timpMediuAsteptareInt = new AtomicInteger((int) Math.round(timpMediuAsteptare1));
//        int sum=0;
//        for(Casa c:caseDeschise)
//        {
//            c.actualizeazaTimpGolireCasa();
//            sum+=c.getTimpGolire();
//        }
//        timpMediuAsteptare1=(double)sum/(double)caseDeschise.size();//suma timpilor de golire al caselor/nr de case deschise
//        timpMediuAsteptare = new AtomicInteger((int) Math.round(timpMediuAsteptare1));
//    }



    public void actualizeazaTimpMediuAsteptare()
    {
        timpMediuAsteptare=0.0;
        int sum=0;
        for(Casa c:caseDeschise)
        {
            c.actualizeazaTimpGolireCasa();
            sum+=c.getTimpGolire();
        }
        timpMediuAsteptare=(double)sum/(double)caseDeschise.size();//suma timpilor de golire al caselor/nr de case deschise
    }


    /**
     *aceasta metoda are rolul de a deschide o noua casa,adaugand-o in ArrayList-ul caselor deschise
     */
    public void adaugaCasa(Casa c)
    {
        caseDeschise.add(c);
    }

    /**
     *aceasta metoda are rolul de a inchide o casa ,stergand-o din ArrayList-ul caselor deschise
     */
    public void inchideCasa(Casa c)
    {
        caseDeschise.remove(c.getIdCasa());
    }

}
