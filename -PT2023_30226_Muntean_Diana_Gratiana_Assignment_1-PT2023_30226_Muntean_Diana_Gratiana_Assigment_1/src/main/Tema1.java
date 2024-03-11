    package main;

    import imple.Implementare;

    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JTextArea;
    import javax.swing.JTextField;
    import java.awt.Color;

    //interfata
    public class Tema1{

        private JTextField polinom1;
        private JTextField polinom2;
        private JTextField rezultat;
        private JFrame frame;
        private JButton butSuma;
        private JButton butDiferenta;
        private JButton butProdus;
        private JButton butDerivare;
        private JButton butDivide;
        private JButton butPutere;
        private JButton butEgalitate;
        private JButton butInmScalar;
        private JButton butImpScalar;
        private JButton butIntegreaza;
        private JTextArea text;

        /**
         * constructor fara parametru Construirea unei ferestre (Interfata -
         * utilizator)
         */
        public Tema1()
        {
            //stabilirea proprietatilor ferestrei
            //stabileste dimensiunile si pozitionarea

            frame = new JFrame ("Polynom Calculator (Muntean Diana-Gratiana)");

            JLabel titlu =  new JLabel ("Polynomial Calculator");
            JLabel labelPolin1 = new JLabel("First Pol.Polynomial = ");
            JLabel labelPolin2 = new JLabel ("Second Pol.Polynomial =  ");
            JLabel labelRezultat = new JLabel ("Result :");

            Implementare evenimentButon = new Implementare(this);

            polinom1 = new JTextField();
            polinom2 = new JTextField();
            rezultat = new JTextField();

            butSuma = new JButton("Add");
            butSuma.addActionListener(evenimentButon);

            butDiferenta = new JButton ("Subtract");
            butDiferenta.addActionListener(evenimentButon);

            butProdus = new JButton ("Multiplicate");
            butProdus.addActionListener(evenimentButon);

            butDerivare = new JButton ("Derivative");
            butDerivare.addActionListener(evenimentButon);

            butDivide = new JButton("Divide");
            butDivide.addActionListener(evenimentButon);

            butIntegreaza = new JButton("Integration");
            butIntegreaza.addActionListener(evenimentButon);

            text = new JTextArea();    //introduce si afiseaza text

            //Setam dimensiunile componentelor si pozitionarea acestora

            titlu.setBounds(350,10,500,20); //setBounds seteaza latimea si inaltimea
            labelPolin1.setBounds(70,160,200,20);
            labelPolin2.setBounds(70,190,200,20);
            labelRezultat.setBounds(200,430,500,20);
            polinom1.setEditable(true); //permite utilizatorului sa modifice
            polinom1.setBounds(260,160,600,20);
            polinom2.setEditable(true);
            polinom2.setBounds(260,190,600,20);
            rezultat.setBounds(300,430,500,20);
            butSuma.setBounds(200, 280, 230, 20);
            butDiferenta.setBounds(500, 280, 230, 20);
            butProdus.setBounds(200, 310, 230, 20);
            butDivide.setBounds(500, 310, 230, 20);
            butDerivare.setBounds(200, 340, 230, 20);
            butIntegreaza.setBounds(500, 340, 230, 20);


            text.setBounds(150, 45, 600, 90);
            text.setText(" Introduceti 2 polinoame"
                    + "\n Introducerea acestora se face pe baza coeficientilor de la gradul cel mai mic spre cel mai mare"
                    + "\n\n De exemplu pentru a introduce polinomul 4X^3 + 3X^2 + 2X^1 + 1"
                    + "\n se va introduce:  1 2 3 4 ");
            text.setEditable(false);
            frame.setBackground(Color.PINK);
            //Adaugarea componentelor in fereastra
            frame.add(titlu);
            frame.add(labelPolin1);
            frame.add(labelPolin2);
            frame.add(labelRezultat);
            frame.add(polinom1);
            frame.add(polinom2);
            frame.add(rezultat);
            frame.add(butSuma);
            frame.add(butProdus);
            frame.add(butDiferenta);
            frame.add(butDivide);
            frame.add(butDerivare);
            frame.add(butIntegreaza);
            frame.add(text);


            frame.setSize(900, 550);  //seteaza dim calculatorului
            frame.setResizable(true); //pot reedimensiona fereastra calc
            frame.setLayout(null); //permit setarea cu setbounds componentele
            frame.setLocationRelativeTo(null); //centrez pe ecran
            frame.setVisible(true);
        }


        /**
         * aceasta metoda realizeaza citirea primului polinom introdus de utilizator
         * in caseta text
         *
         * @return primul polinom introdus de utilizator
         */

        public String getPolinom1()
        {
            return polinom1.getText();
        } //returneaza stringul ce contine coeficientii introdusi in JTextField: polinom1


        /**
         * aceasta metoda realizeaza citirea celui de-al doilea polinom introdus de
         * utilizator in caseta text
         *
         * @return al doilea polinom introdus de utilizator
         */
        public String getPolinom2() {
            return polinom2.getText();
        }//returneaza stringul ce contine coeficientii introdusi in JTextField : polinom2


        /**
         * aceasta metoda seteaza mesajul care va fi afisat in sectiunea rezultat a
         * ferestrei ce asigura interfata-utilizator
         */
        public void setRezultat(String polinom) {
            rezultat.setText(polinom);
        }// afiseaza rezultatul operatiei sub forma 4X^2+2X^1+1

        /**
         * @return this.frame fereastra curenta in care se lucreaza
         */
        public JFrame getFrame() {
            return this.frame;
        }// folosita pentru a avea acces la variabila instanta privata frame


        public static void main(String[] args) {
            new Tema1();
        }

    }
