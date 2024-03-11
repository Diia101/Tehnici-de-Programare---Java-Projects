
/**
 *Aceasta clasa realizeaza interfata cu utilizatorul
 * @author Diia101
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Fereastra extends JFrame{
    private JLabel tMaxSosire;
    private JLabel tMinSosire;
    private JLabel tMaxServire;
    private JLabel tMinServire;
    private JLabel nrMaxcozi;
    private JLabel tSimulare;
    private JLabel nrClienti;

    private JButton run;
    private JTextField FMinSosire;
    private JTextField FMaxSosire;
    private JTextField FMinServire;
    private JTextField FMaxServire;
    private JTextField FCozi;
    private JTextField FSimulare;
    private JTextField FNrClienti;

    private JTextArea logEvent;
    private JPanel continutFereastra;

    /**
     * constructor fara parametru .Realizeaza construirea unei ferestre (Interfata -
     * utilizator)
     */
    public Fereastra()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Simulare Cozi");
        this.setResizable(false);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.initializeazaFereastra();
        this.run.addActionListener(new ListenerRun(this));
    }

    /**
     * Seteaza pozitiile pentru elementele din fereastra si le adauga in aceasta
     */
    public void initializeazaFereastra()
    {
        tMinSosire=new JLabel("Timp minim de sosire(in s):");
        tMaxSosire=new JLabel("Timp maxim de sosire(in s):");
        tMinServire=new JLabel("Timp minim de servire(in s):");
        tMaxServire=new JLabel("Timp maxim de servire(in s):");
        nrMaxcozi=new JLabel("Numar maxim de cozi:");
        tSimulare=new JLabel("Timpul de simulare(in s):");
        nrClienti=new JLabel("Numar clienti: ");

        run=new JButton("Incepe simularea");
        FMinServire=new JTextField();
        FMaxServire=new JTextField();
        FMinSosire=new JTextField();
        FMaxSosire=new JTextField();
        FCozi=new JTextField();
        FSimulare=new JTextField();
        FNrClienti=new JTextField();
        logEvent = new JTextArea();
        logEvent.setEditable(false);
        JScrollPane scroll = new JScrollPane(logEvent);
        logEvent.setLineWrap(true);

        Color culoare=new Color(250,200,230);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        continutFereastra=new JPanel();
        continutFereastra.setSize(800, 600);
        continutFereastra.setLayout(null);
        continutFereastra.setBackground(culoare);

        nrClienti.setSize(160,30);
        nrClienti.setLocation(30,0);
        continutFereastra.add(nrClienti);
        FNrClienti.setSize(90,30);
        FNrClienti.setLocation(60,25);
        continutFereastra.add(FNrClienti);

        tMinSosire.setSize(160,30);
        tMinSosire.setLocation(30,55);
        continutFereastra.add(tMinSosire);
        FMinSosire.setSize(90,30);
        FMinSosire.setLocation(60,80);
        continutFereastra.add(FMinSosire);

        tMaxSosire.setSize(160,30);
        tMaxSosire.setLocation(30,120);
        continutFereastra.add(tMaxSosire);
        FMaxSosire.setSize(90,30);
        FMaxSosire.setLocation(60,150);
        continutFereastra.add(FMaxSosire);

        tMinServire.setSize(160,30);
        tMinServire.setLocation(30,195);
        continutFereastra.add(tMinServire);
        FMinServire.setSize(90,30);
        FMinServire.setLocation(60,225);
        continutFereastra.add(FMinServire);

        tMaxServire.setSize(165,30);
        tMaxServire.setLocation(30,270);
        continutFereastra.add(tMaxServire);
        FMaxServire.setSize(90,30);
        FMaxServire.setLocation(60,300);
        continutFereastra.add(FMaxServire);

        nrMaxcozi.setSize(160,30);
        nrMaxcozi.setLocation(30,345);
        continutFereastra.add(nrMaxcozi);
        FCozi.setSize(90,30);
        FCozi.setLocation(60,375);
        continutFereastra.add(FCozi);

        tSimulare.setSize(160,30);
        tSimulare.setLocation(30,420);
        continutFereastra.add(tSimulare);
        FSimulare.setSize(90,30);
        FSimulare.setLocation(60,450);
        continutFereastra.add(FSimulare);



        run.setSize(150,30);
        run.setLocation(30,500);
        continutFereastra.add(run);

        scroll.setSize(500,500);
        scroll.setLocation(250,40);
        continutFereastra.add(scroll);

        this.add(continutFereastra);
        this.repaint();

    }




    /**

     * Aceasta clasa are rolul de a implementa ascultatorul pentru butonul de incepere a simularii
     * In momentul in care toate datele de intrare au fost introduse thread-ul este pornit
     */
    public class ListenerRun implements ActionListener
    {
        private Fereastra f;
        public ListenerRun(Fereastra f)
        {
            this.f = f;
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int timpMinimSosire=0,timpMinimServire=0,timpMaximSosire=0,timpMaximServire=0,nrCase=0,timpPtSimulare=0,N=0;
            run.setEnabled(false);
            boolean gataPentruSimulare=true;
            try
            {
                timpMinimSosire = Integer.parseInt(FMinSosire.getText());
            }
            catch(Exception exceptie)
            {
                JOptionPane.showMessageDialog(null,"Nu ati introdus corect timpul minim de sosire");
                run.setEnabled(true);
                gataPentruSimulare=false;

            }

            try
            {
                timpMaximSosire = Integer.parseInt(FMaxSosire.getText());
            }
            catch(Exception exceptie)
            {
                JOptionPane.showMessageDialog(null,"Nu ati introdus corect timpul maxim de sosire");
                run.setEnabled(true);
                gataPentruSimulare=false;

            }

            try
            {
                timpMinimServire = Integer.parseInt(FMinServire.getText());
            }
            catch(Exception exceptie)
            {
                JOptionPane.showMessageDialog(null,"Nu ati introdus corect timpul minim de servire");
                run.setEnabled(true);
                gataPentruSimulare=false;

            }

            try
            {
                timpMaximServire = Integer.parseInt(FMaxServire.getText());
            }
            catch(Exception exceptie)
            {
                JOptionPane.showMessageDialog(null,"Nu ati introdus corect timpul maxim de servire");
                run.setEnabled(true);
                gataPentruSimulare=false;
            }

            try
            {
                nrCase = Integer.parseInt(FCozi.getText());
            }
            catch(Exception exceptie)
            {
                JOptionPane.showMessageDialog(null,"Nu ati introdus corect numarul de cozi");
                run.setEnabled(true);
                gataPentruSimulare=false;
            }

            try
            {
                timpPtSimulare = Integer.parseInt(FSimulare.getText());
            }
            catch(Exception exceptie)
            {
                JOptionPane.showMessageDialog(null,"Nu ati introdus corect timpul pentru simulare");
                run.setEnabled(true);
                gataPentruSimulare=false;
            }
            try
            {
                N = Integer.parseInt(FNrClienti.getText());
            }
            catch(Exception exceptie)
            {
                JOptionPane.showMessageDialog(null,"Nu ati introdus corect numarul de clienti");
                run.setEnabled(true);
                gataPentruSimulare=false;

            }

            if (gataPentruSimulare)
            {
                //String mesaj;
                run.setEnabled(false);
                Temporizator temp=new Temporizator(f,nrCase,timpPtSimulare,timpMinimSosire,timpMaximSosire,timpMinimServire,timpMaximServire,N);
                Thread t = new Thread(temp);
                t.start();
            }


        }
    }

    /**
     * Aceasta metoda are rolul de a adauga mesaje in logEvent
     * @param  mesaj reprezinta mesajul care va fi afisat pe fereastra in logEvent
     */
    public void adaugaMesaj(String mesaj)
    {
        this.logEvent.append(mesaj);
    }

    /**
     * Aceasta metoda are rolul de a returna in spatiul din fereastra unde se vor afisa rezultatele
     * @return logEvent-ul din fereastra aplicatiei unde se tiparesc datele de iesire
     */
    public JTextArea getLogEvent()
    {
        return this.logEvent;
    }

}

