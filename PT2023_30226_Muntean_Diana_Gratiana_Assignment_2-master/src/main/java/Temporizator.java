
/**
 *Aceasta clasa implementeaza interfata Runnable si astfel suprascrie metoda Run
 * De asemenea preia datele din fereastra si pe baza acestora afiseaza rezultatele
 * rularii
 * @author Diia101
 */
import java.io.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;

public class Temporizator implements Runnable {

    private int counter, nrMaxCase, timpFinal, timpMinimSosire, timpMinimServire, timpMaximSosire, timpMaximServire, indexClient, N;
    private Fereastra fereastra;
    private Prelucrare casePrelucrate;
    private int oraDeVarf;
//public Temporizator(){
//
//}
    public Temporizator(Fereastra fer, int maxCase, int timp, int tMinSos, int tMaxSos, int tMinServ, int tMaxServ, int Nr) {
        timpMaximServire = tMaxServ;
        timpMaximSosire = tMaxSos;
        timpMinimServire = tMinServ;
        timpMinimSosire = tMinSos;
        timpFinal = timp;
        counter = 0;
        N = Nr;
        fereastra = fer;
        this.indexClient = 0;
        nrMaxCase = maxCase;
//        for (int i = 0; i < nrMaxCase; i++)
//        {
//            Temporizator queue = new Temporizator();
//            queue.fereastra = this.fereastra;
//            Thread t = new Thread(queue);
//            t.start();
//        }
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:counter
     *
     * @param c reprezinta valoarea cu care va fi setat counter-ul
     */
    public void setCounter(int c) {
        this.counter = c;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:counter
     *
     * @return counter-ul,adica timpul care s-a scurs din simulare, timpul actual al simualarii
     */
    public int getCounter() {
        return this.counter;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpMaximSosire
     *
     * @return timpul maxim de sosire al unui client introdus de utilizator
     */
    public int getTimpMaximSosire() {
        return this.timpMaximSosire;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpMaximServire
     *
     * @return timpul maxim de servire al unui client introdus de utilizator
     */
    public int getTimpMaximServire() {
        return this.timpMaximServire;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpMinimSosire
     *
     * @return timpul minim de servire al unui client introdus de utilizator
     */
    public int getTimpMinimSosire() {
        return this.timpMinimSosire;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpMinimServire
     *
     * @return timpulminim de sosire al unui client introdus de utilizator
     */
    public int getTimpMinimServire() {
        return this.timpMinimServire;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:timpFinal
     *
     * @return timpul ce reprezinta sfarsitul simularii
     */
    public int getTimpFinal() {
        return this.timpFinal;
    }

    /**
     * Metoda ce permite accesul la variabila de instanta declarata private:casePrelucrate
     *
     * @return toate casele care sunt deschise la momentul apelarii
     */
    public Prelucrare getCoziDeschise() {
        return casePrelucrate;
    }

    /**
     * aceasta metoda are rolul de a incrementa counterul,adica evidentiaza scurgerea timpului
     */
    public void increaseCounter() {
        this.counter++;
    }


    @Override
    public void run()
    {
        File file = new File("C:\\Users\\admin\\IdeaProjects\\PT2023_30226_Muntean_Diana_Gratiana_Assignment_2\\src\\main\\java\\Output.txt");
        file.delete();
        Random generatorNumere = new Random();
        Casa toti_clientii = new Casa(N);
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        String mesaj;
        int []frecventa= new int[1000000];
        int numarClienti=0,numarMaximClienti=0;
        for (int i = 0; i < N; i++) {
            int arrivalTime = timpMinimSosire + generatorNumere.nextInt(timpMaximSosire);
            int servingTime = timpMinimServire + generatorNumere.nextInt(timpMaximServire-timpMinimServire+1);
        //    int servingTime = generatorNumere.nextInt(timpMaximServire) + timpMinimServire-1;
            a.add(arrivalTime);
            b.add(servingTime);
        }
        Collections.sort(a);
        for (int i = 0; i < N; i++) {
            Client clientel = new Client(i, a.get(i), b.get(i));
            toti_clientii.adaugaClient(clientel);
        }
        casePrelucrate = new Prelucrare(nrMaxCase);
        ImplementareProcesareCase procesorCase = new ImplementareProcesareCase(casePrelucrate);
        try
        {
            PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\admin\\IdeaProjects\\PT2023_30226_Muntean_Diana_Gratiana_Assignment_2\\src\\main\\java\\Output.txt", true));
            while (true)
            {
                // așteptăm o secundă
                Thread.sleep(1000);
                // actualizăm timpul curent

                // adăugăm clienții care au ajuns la timpul curent la cozi
                synchronized (this)
                {
                    for (Iterator<Client> iterator = toti_clientii.getClienti().iterator(); iterator.hasNext();) {
                        Client client = iterator.next();
                        if (client.getTimpSosire() == counter)
                        {
                            procesorCase.distribuireClient(client);
                            iterator.remove();
                        }
                    }
                }

                // afișăm informațiile despre cozi și clienți
                writer.println();
                fereastra.adaugaMesaj("\n");
                writer.print("Time " + counter+"\n");
                mesaj ="Time " + counter + "\n";
                fereastra.adaugaMesaj(mesaj);
                writer.print("Waiting clients: ");
                mesaj ="Waiting clients: ";
                fereastra.adaugaMesaj(mesaj);
                for (Client c : toti_clientii.getClienti())
                {
                    writer.print("(" + c.getIdClient() + "," + c.getTimpSosire() + "," + c.getTimpServire() + ");");
                    mesaj="(" + c.getIdClient() + "," + c.getTimpSosire() + "," + c.getTimpServire() + ");";
                    fereastra.adaugaMesaj(mesaj);
                }
                fereastra.adaugaMesaj("\n");
                writer.println();
                for (Casa casa : casePrelucrate.getCaseDeschise())
                {
                    writer.print("Queue " + casa.getIdCasa() + ": ");
                    mesaj="Queue " + casa.getIdCasa() + ": ";
                    fereastra.adaugaMesaj(mesaj);
                    if (casa.getClienti().isEmpty())
                    {
                        writer.print("closed\n");
                        mesaj="closed\n";
                        fereastra.adaugaMesaj(mesaj);
                    }
                    else
                    {
                        for(Client c:casa.getClienti())
                        {
                            frecventa[counter]++;
                            writer.print("("+c.getIdClient() + "," + c.getTimpSosire() + "," + c.getTimpServire()+") \n");
                            mesaj="("+c.getIdClient() + "," + c.getTimpSosire() + "," + c.getTimpServire()+") \n";
                            fereastra.adaugaMesaj(mesaj);
                        }
                    }
                    //writer.println();
                }
                // procesăm clienții din cozile deschise
                synchronized (this)
                {
                    for (Casa casa : casePrelucrate.getCaseDeschise())
                    {
                        if(!casa.getClienti().isEmpty())
                        {
                            Client client = casa.getClienti().get(0);
                            client.setTimpServire(client.getTimpServire() - 1);
                            ////casePrelucrate.actualizeazaTimpTotalGolire();
                            casePrelucrate.actualizeazaTimpMediuAsteptare();
                            if (client.getTimpServire() == 0)
                            {
                                int w = counter - client.getTimpSosire();
                                casePrelucrate.timpMediuAsteptare+=w;
                                casa.getClienti().remove(0);
                            }
                        }
                    }
                }

                // verificăm dacă am terminat
//                if(counter==timpFinal)
//                {
//                    break;
//                }



//                if(numarClienti>numarMaximClienti)
//                {
//                    numarMaximClienti = numarClienti;
//                    oraDeVarf = counter;
//                }


                if (toti_clientii.getClienti().isEmpty())
                {
                    int ok=0;
                    for (Casa casa : casePrelucrate.getCaseDeschise())
                    {
                        if(!casa.getClienti().isEmpty())
                            ok=1;

                    }
                    if(ok==0 || counter==timpFinal)
                    {
                        for(int i=0;i<timpFinal;i++) {
                            if (frecventa[i] > numarMaximClienti) {
                                numarMaximClienti = frecventa[i];
                                oraDeVarf = i;
                            }
                        }
                        writer.print("Cei mai multi clienti : "+numarMaximClienti+" la ora: " +oraDeVarf+"\n");
                        mesaj="Cei mai multi clienti : "+numarMaximClienti+" la ora: "+oraDeVarf+"\n";
                        fereastra.adaugaMesaj(mesaj);
                        casePrelucrate.timpMediuAsteptare = casePrelucrate.timpMediuAsteptare / N;
                        writer.print("Timpul mediu de asteptare : "+casePrelucrate.timpMediuAsteptare);
                        mesaj="Timpul mediu de asteptare : "+casePrelucrate.timpMediuAsteptare;
                        fereastra.adaugaMesaj(mesaj);
                        break;
                    }
                }


                counter++;
            }
            writer.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }


    /*

    public void run() {
        File file = new File("C:\\Users\\admin\\IdeaProjects\\PT2023_30226_Muntean_Diana_Gratiana_Assignment_2\\src\\main\\java\\Output.txt");
        file.delete();
        //BufferedWriter writer = null;
        /*
        try {
            writer = new BufferedWriter(new FileWriter("C:\\Users\\admin\\IdeaProjects\\PT2023_30226_Muntean_Diana_Gratiana_Assignment_2\\src\\main\\java\\Output.txt", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
            /*
        Random generatorNumere = new Random();
        Casa toti_clientii = new Casa(N);
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int arrivalTime = timpMinimSosire + generatorNumere.nextInt(timpMaximSosire); // generate a random arrival time between 0 and 9
            int servingTime = generatorNumere.nextInt(timpMaximServire) + timpMinimServire; // generate a random serving time between 1 and 10
            a.add(arrivalTime);
            b.add(servingTime);
        }
        Collections.sort(a);
        for (int i = 0; i < N; i++) {
            Client clientel = new Client(i, a.get(i), b.get(i));
            toti_clientii.adaugaClient(clientel);
        }
        casePrelucrate = new Prelucrare(nrMaxCase);
        ImplementareProcesareCase procesorCase = new ImplementareProcesareCase(casePrelucrate);
        for (int i = 0; i < toti_clientii.getNumarClienti(); i++) {
            Client cl = toti_clientii.getClienti().get(i);
            procesorCase.distribuireClient(cl);
        }
        try
        {
            PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\admin\\IdeaProjects\\PT2023_30226_Muntean_Diana_Gratiana_Assignment_2\\src\\main\\java\\Output.txt", true));
            for (int i = 0; i < timpFinal; i++)
            {
                // afișează timpul curent
                writer.println("Time " + i + "\n");
                // afișează clienții așteptând în ordinea sosirii
                writer.print("Waiting clients: ");
                for (Client c : toti_clientii.getClienti())
                {
                    if (c.getTimpSosire() > i)
                    {
                        writer.print("(" + c.getIdClient() + "," + c.getTimpSosire() + "," + c.getTimpServire() + "); ");
                    }
                }
                writer.println();
                // afișează starea cozilor
                synchronized (casePrelucrate)
                {
                    for (Casa casa : casePrelucrate.getCaseDeschise())
                    {
                        writer.print("Queue " + casa.getIdCasa() + ": ");
                        if (casa.getClienti().isEmpty())
                        {
                            writer.println("closed");
                        }
                        else
                        {
                            writer.print("(");
                            synchronized (casa.getClienti())
                            {
                                Iterator<Client> iterator = casa.getClienti().iterator();
                                while (iterator.hasNext()) {
                                    Client c = iterator.next();
                                    if (c.getTimpServire() == 0)
                                    {
                                        iterator.remove();
                                    }
                                    else
                                    {
                                        writer.print(c.getIdClient() + "," + c.getTimpSosire() + "," + c.getTimpServire());
                                        c.setTimpServire(c.getTimpServire() - 1);
                                        casePrelucrate.actualizeazaTimpTotalGolire();
                                        casePrelucrate.actualizeazaTimpMediuAsteptare();
                                    }
                                }
                                writer.println(")");
                            }
                        }
                    }
                    writer.println();
                }
                writer.close();
                ///idee nr 1
        /*
        casePrelucrate = new Prelucrare(nrMaxCase);
        ImplementareProcesareCase procesorCase = new ImplementareProcesareCase(casePrelucrate);
        while (!toti_clientii.getClienti().isEmpty()) {
            //Client cl = toti_clientii.getClienti().remove(0);
            //System.out.println(cl.getIdClient() + " " +cl.getTimpSosire()+" "+cl.getTimpServire());
            //}

            for (int i = 0; i < toti_clientii.getNumarClienti(); i++) {
                Client cl = toti_clientii.getClienti().get(i);
                procesorCase.distribuireClient(cl);
                toti_clientii.getClienti().remove(i);
                i--;
            }
            try {
                writer.write("Time " + this.getCounter() + "\n");
                writer.write("Waiting clients: ");
                for (int i = 0; i < toti_clientii.getNumarClienti(); i++) {
                    writer.write("(" + toti_clientii.getClienti().get(i).getIdClient() + "," + toti_clientii.getClienti().get(i).getTimpSosire() + "," + toti_clientii.getClienti().get(i).getTimpServire() + ")");
                    if (i < toti_clientii.getNumarClienti() - 1) {
                        writer.write("; ");
                    }
                }
                writer.write("\n");
                for (Casa casa : casePrelucrate.getCaseDeschise()) {
                    writer.write("Queue " + casa.getIdCasa() + ": ");
                    if(casa.getClienti().isEmpty())
                    {
                        writer.write(" closed\n");
                    }
                    else
                    {
                        for (int j = 0; j < casa.getClienti().size(); j++)
                        {
                            if(!casa.getClienti().isEmpty())
                            {
                                writer.write("(" + casa.getClienti().get(j).getIdClient() + "," + casa.getClienti().get(j).getTimpSosire() + "," + toti_clientii.getClienti().get(j).getTimpServire() + ")");
                            }
                            if (j < casa.getClienti().size() - 1) {
                                writer.write(",");
                            }
                        }
                    }
                    //writer.write("\n");
                }
                writer.write("\n");
                increaseCounter();
                Thread.sleep(1000);
                writer.close();
            /*
            Random generatorNumere1=new Random();
            int timpSosireClientUrmator=0,timpServire;
            Client clientUrmator;
            int timpSosireUltimClient=0;
            //casePrelucrate = new Prelucrare(nrMaxCase);
            //ImplementareProcesareCase procesorCase=new ImplementareProcesareCase(casePrelucrate);
            timpSosireClientUrmator=timpMinimSosire+generatorNumere1.nextInt(timpMaximSosire-timpMinimSosire+1);
            timpSosireClientUrmator+=timpSosireUltimClient;
            timpServire=timpMinimServire + generatorNumere1.nextInt(timpMaximServire-timpMinimServire+1);
            int numarClienti=0,numarMaximClienti=0;




            for(int i=0;i<timpFinal;i++)
            {  //parcurg fiecare casa si analizez situatia ei
                for(Casa casa:casePrelucrate.getCaseDeschise())
                {
                    if(casa.esteDeschisa())
                    {
                        Client cl = casa.getClienti().get(0);//iau primul client din coada(de la casa)
                        if (cl.getTimpServire()==0)
                            casa.eliminaClient();
                        else
                        {
                            cl.setTimpServire(cl.getTimpServire()-1);
                            casePrelucrate.actualizeazaTimpTotalGolire();
                            casePrelucrate.actualizeazaTimpMediuAsteptare();

                        }
                    }

                }
                while (!toti_clientii.getClienti().isEmpty() && toti_clientii.getClienti().get(0).getTimpSosire() == i) {
                    Client client = toti_clientii.getClienti().remove(0);
                    procesorCase.distribuireClient(client);
                }
                //if(casePrelucrate.getCaseDeschise() != null) {
//                   for (Casa casa : casePrelucrate.getCaseDeschise()) {
//                       if (casa.esteDeschisa()) {
//                           //Client cl = casa.getClienti().get(0);
//                           Client cl = casa.getClienti().peek();   // iau primul client din coada(de la casa)
//                           if (cl.getTimpServire() == 0)
//                               casa.eliminaClient();
//                           else {
//                               cl.setTimpServire(cl.getTimpServire() - 1);
//                               casePrelucrate.actualizeazaTimpTotalGolire();
//                               casePrelucrate.actualizeazaTimpMediuAsteptare();
//
//                           }
//                       }
//
//                   }

//                synchronized (casePrelucrate) {
//                    for (Casa casa : casePrelucrate.getCaseDeschise()) {
//                        if (casa.esteDeschisa()) {
//                            Client cl = casa.getClienti().peek(); // iau primul client din coada(de la casa)
//                            if (cl.getTimpServire() == 0)
//                                casa.eliminaClient();
//                            else {
//                                cl.setTimpServire(cl.getTimpServire() - 1);
//                                casePrelucrate.actualizeazaTimpTotalGolire();
//                                casePrelucrate.actualizeazaTimpMediuAsteptare();
//                            }
//                        }
//                    }
//                }



                // }
                if(counter == timpSosireClientUrmator)
                {
                    clientUrmator= new Client(indexClient,timpSosireClientUrmator,timpServire);
                    procesorCase.distribuireClient(clientUrmator);
                    indexClient++;
                    timpSosireUltimClient=counter;
                    timpSosireClientUrmator=timpMinimSosire+generatorNumere.nextInt(timpMaximSosire-timpMinimSosire+1);
                    timpSosireClientUrmator+=timpSosireUltimClient;
                    timpServire=timpMinimServire+generatorNumere.nextInt(timpMaximServire-timpMinimServire+1);

                }

                String mesaj = "Timp: " + this.getCounter() + "\n";
                writer.write("Time "+this.getCounter()+"\n");
                fereastra.adaugaMesaj(mesaj);

                if(this.getCoziDeschise()!=null)
                {
                    mesaj = "\tTimp mediu de asteptare: "+casePrelucrate.getTimpMediuAsteptare()+"\n";
                    writer.write("Timp mediu de asteptare: "+casePrelucrate.getTimpMediuAsteptare()+"\n");
                    fereastra.adaugaMesaj(mesaj);
                    mesaj = "\tTimp total de golire al caselor: "+casePrelucrate.getTimptotalgolireCase()+"\n";
                    writer.write("Timp total de golire al caselor: "+casePrelucrate.getTimptotalgolireCase()+"\n");
                    fereastra.adaugaMesaj(mesaj);
                    mesaj = "\tTimp de sosire urmatorul client: "+timpSosireClientUrmator+"\n";
                    writer.write("Timp de sosire urmatorul client: "+timpSosireClientUrmator+"\n");
                    fereastra.adaugaMesaj(mesaj);
                    mesaj = "Clienti:\n";
                    writer.write("Clienti:\n");
                    fereastra.adaugaMesaj(mesaj);
                    numarClienti = 0;
                    // if(casePrelucrate.getCaseDeschise() != null) {
                    for (Casa c : casePrelucrate.getCaseDeschise()) {
                        mesaj = "\tIndex casa: " + c.getIdCasa() + "\n";
                        writer.write("Index casa: " + c.getIdCasa() + "\n");
                        fereastra.adaugaMesaj(mesaj);
                        int timpPlecare = 0;
//                            while (!c.getClienti().isEmpty()) {
//                                if (numarClienti < N) {
//                                    numarClienti++;
//                                    Client client = c.getClienti().take();
//                                    mesaj = "\tID Client: " + client.getIdClient() + ". Timp Sosire: " + client.getTimpSosire() + ". Timp Servire: " + client.getTimpServire() + "\n";
//                                    fereastra.adaugaMesaj(mesaj);
//                                    timpPlecare += client.getTimpServire();
//                                    mesaj = "\tClientul " + client.getIdClient() + " paraseste casa " + c.getIdCasa() + " in :" + timpPlecare + " secunde\n";
//                                    fereastra.adaugaMesaj(mesaj);
//                                }
//                            }
                        //parcurg fiecare element din  coada c
                        for (int j = 0; j < c.getClienti().size(); j++) {
                            if (numarClienti < N) {
                                numarClienti++;
                                Client client = c.getClienti().get(j);
                             //   Client client = c.getClienti().peek() ;
                                //if (client.getTimpServire() > 0) {
                                    // Client[] clienti = c.getClienti().toArray(new Client[0]);
                                    // Client client = clienti[j];
                                    mesaj = "\tID Client: " + client.getIdClient() + ". Timp Sosire: " + client.getTimpSosire() + ". Timp Servire: " + client.getTimpServire() + "\n";
                                writer.write("ID Client: " + client.getIdClient() + ". Timp Sosire: " + client.getTimpSosire() + ". Timp Servire: " + client.getTimpServire() + "\n");
                                fereastra.adaugaMesaj(mesaj);
                                    timpPlecare += client.getTimpServire();
                                    writer.write("Clientul" + client.getIdClient() + " paraseste casa " + c.getIdCasa() + " in : " + timpPlecare + " secunde \n");
                                    mesaj = "\tClientul " + client.getIdClient() + " paraseste casa " + c.getIdCasa() + " in :" + timpPlecare + " secunde\n";
                                    fereastra.adaugaMesaj(mesaj);
                               // }
//                                else if(client.getTimpServire()==0){
//                                    c.eliminaClient();
//                                }
                            }
                        }
                        if(c.getClienti().isEmpty())
                        {
                            mesaj = "Queue " + c.getIdCasa()+ ": closed\n";
                            fereastra.adaugaMesaj(mesaj);
                            writer.write("Queue " + c.getIdCasa()+ ": closed\n");
                        }
                    }
                    // }
                    if(numarClienti>numarMaximClienti)
                    {
                        numarMaximClienti = numarClienti;
                        oraDeVarf = counter;
                    }
                }
                //fereastra.getLogEvent().repaint();
                increaseCounter();
                Thread.sleep(1000);
            }
            String mesaj="Cei mai multi clienti : "+numarMaximClienti+" la ora: "+oraDeVarf;
            writer.write("Cei mai multi clienti : "+numarMaximClienti+" la ora: "+oraDeVarf + "\n");
            fereastra.adaugaMesaj(mesaj);
            writer.close();
*/

            }
        /*
        catch(InterruptedException e){} catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
/*
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
*/