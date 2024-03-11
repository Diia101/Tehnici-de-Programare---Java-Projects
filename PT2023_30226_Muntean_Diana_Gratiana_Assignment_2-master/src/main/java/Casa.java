
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Aceasta clasa are rolul de a adauga clienti la coada unei case
 * si de a-i elimina dupa ce au fost serviti
 * @author Diia101
 */
public class Casa {
    private int idCoada,timpGolire;
    ArrayList<Client> clienti;
   // private BlockingQueue<Client> clienti;

    /**
     * constructor cu un parametru.
     * Are rolul de a construi o casa, avand ca index valoarea parametrului transmis in apel
     * @param indexCoada id-ul casei care va fi construita
     */
    public Casa(int indexCoada)
    {
        this.idCoada=indexCoada;
        this.timpGolire=0; //timp golire initial 0
        clienti=new ArrayList<Client>();//initial casa nu are nici un client
      //  BlockingQueue<Client> clienti = new ArrayBlockingQueue<Client>(1000000);
    }
    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:idCoada
     * @return indexul casei referite
     */
    public int getIdCasa()
    {
        return this.idCoada;
    }
    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpGolire,setand valoarea
     * acesteia cu valoarea transmisa la apel
     * @param timp  timpul cu care va fi setata variabila de instanta timpGolire
     */

    public void setTimpGolire(int timp)
    {
        this.timpGolire=timp;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpGolire
     * @return timpul dupa care casa referita va fi goala,adica toti clientii din cadrul acesteia au fost serviti
     */
    public int getTimpGolire()
    {
        return this.timpGolire;
    }

    /**
     * Metoda ce permite adaugarea unui nou client in casa referita
     * @param cl reprezinta un obiect de tip Client.acesta va fi asignat casei referite
     * In momentul introducerii unui client se va actualiza si timpul de golire al casei
     */
//    public void adaugaClient(Client cl)
//    {
//        clienti.add(cl);
//        timpGolire+=cl.getTimpServire();
//    }

//    public void adaugaClient(Client cl) {
//        if (clienti == null) {
//            clienti = new LinkedBlockingQueue<Client>();
//        }
//        clienti.add(cl);
//        timpGolire+=cl.getTimpServire(); //la timpul de golire al casei se adauga si timpul de servire al clientului adaugat
//    }


    public void adaugaClient(Client cl)
    {
        clienti.add(cl);
        timpGolire+=cl.getTimpServire();//la timpul de golire al casei se adauga si timpul de servire al clientului adaugat
    }
    /**
     * Metoda ce permite eliminarea unui client din casa referita
     * In momentul eliminarii unui client se va actualiza si timpul de golire al casei
     * Se elimina intotdeauna primul client adica cel cu indexul 0 respectand principiul FIFO
     */
//    public Client eliminaClient()
//    {
//        //Client cl=new Client(this.clienti.get(0).getIdClient(),this.clienti.get(0).getTimpSosire(),this.clienti.get(0).getTimpServire());
//        Client cl = this.clienti.peek();
//        if (cl != null) {
//            cl = new Client(cl.getIdClient(), cl.getTimpSosire(), cl.getTimpServire());
//        }
//
//        // Client cl=clienti.get(0);
//
//        timpGolire -= cl.getTimpServire();
//        clienti.remove();
//        return cl;
//    }

    public Client eliminaClient()
    {
        Client cl=new Client(this.clienti.get(0).getIdClient(),this.clienti.get(0).getTimpSosire(),this.clienti.get(0).getTimpServire());

        // Client cl=clienti.get(0);

        timpGolire -= cl.getTimpServire();
        clienti.remove(0);
        return cl;
    }


    /**
     * Metoda ce verifica daca casa referita este deschisa sau nu
     * @return o valoare booleana.In cazul in care returneaza true ,casa referita este deschisa in caz contrar este inchisa
     */
    public boolean esteDeschisa()
    {
        if( this.clienti.isEmpty())//nu are nici un client daca arrayList-ul de clienti este vid
            return false;
        return true;
    }

    /**
     * Metoda ce asigura accesul la clientii dintr-o casa
     * @return clientii care sunt asignati casei referite
     */
   //public ArrayList<Client> getClienti()
    public ArrayList<Client> getClienti()
    {
        return  clienti;
    }
    /**
     * Metoda ce asigura accesul la numarul clientilor dintr-o casa
     * @return numarul clientilor care sunt asignati casei referite
     */
    public int getNumarClienti()
    {
        return clienti.size();
    }

    /**
     * aceasta metoda realizeaza reactualizarea timpului de golire al casei referite prin insumarea timpilor de servire al clientilor
     * care se afla in aceasta
     */
    void actualizeazaTimpGolireCasa()
    {
        timpGolire = 0;
        for(Client c: clienti)
        {
            timpGolire += c.getTimpServire();
        }
    }
}
