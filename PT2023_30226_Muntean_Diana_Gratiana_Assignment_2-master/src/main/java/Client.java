
/**
 *
 * Aceasta clasa are rolul de a furniza informatiile ce caracterizeaza fiecare client in parte
 * @author Diia101
 */
public class Client {
    private int idClient,timpSosire,timpServire;

    /**
     * constructor cu 3 parametri.
     * Are rolul de a construi un client cu toate datele ce-l caracterizeaza
     * @param id reprezinta id-ul clientului care tocmai a fost creat
     * @param timpSos  reprezinta timpul de sosire al clientului care tocmai a fost creat
     * @param timpServ  reprezinta timpul de servire al clientului care tocmai a fost creat
     */
    public Client(int id,int timpSos,int timpServ)
    {
        idClient=id;
        timpSosire=timpSos;
        timpServire=timpServ;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:idCLient,setand valoarea
     * acesteia cu valoarea transmisa la apel
     * @param id valoarea cu care va fi setat id-ul clientului referit
     */
    public void setIdClient(int id)
    {
        this.idClient=id;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:idClient
     * @return id-ul clientului referit
     */
    public int getIdClient()
    {
        return this.idClient;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpSosire,setand valoarea
     * acesteia cu valoarea transmisa la apel
     * @param timp valoarea cu care va fi setat timpul de sosire al clientului referit
     */
    public void setTimpSosire(int timp)
    {
        this.timpSosire=timp;
    }
    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:idClient
     * @return timpul de sosire al clientului referit
     */
    public int getTimpSosire()
    {
        return this.timpSosire;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpServire,setand valoarea
     * acesteia cu valoarea transmisa la apel
     * @param timp valoarea cu care va fi setat timpul de servire al clientului referit
     */
    public void setTimpServire(int timp)
    {
        this.timpServire=timp;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpServire
     * @return timpul de servire al clientului referit
     */
    public int getTimpServire()
    {
        return this.timpServire;
    }

}

