package jUnit;

import pol.Polynomial;
import org.junit.Test;

import java.util.Dictionary;
import java.util.Map;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
//import org.junit.jupiter.api.Test;


@RunWith(JUnit4.class)

public class TestJunit {
    @Test
public void testAduna() {
        Polynomial p1 = new Polynomial();
        p1.coefs.put(2, 3.0);
        p1.coefs.put(1, 4.0);
        p1.coefs.put(0, 5.0);

        Polynomial p2 = new Polynomial();
        p2.coefs.put(1, 2.0);
        p2.coefs.put(0, 1.0);

        Polynomial rezultatAsteptat = new Polynomial();
        rezultatAsteptat.coefs.put(2, 3.0);
        rezultatAsteptat.coefs.put(1, 6.0);
        rezultatAsteptat.coefs.put(0, 6.0);

        Polynomial rezultatObtinut = p1.aduna(p2);

        assertEquals(rezultatAsteptat, rezultatObtinut);
    }


        @Test
        public void testScade() {
            Polynomial p1 = new Polynomial();
            p1.coefs.put(2, 2.0);
            p1.coefs.put(3, 5.0);

            Polynomial p2 = new Polynomial();
            p2.coefs.put(2, 1.0);
            p2.coefs.put(0, 1.0);

            Polynomial rezultatAsteptat = new Polynomial();
            rezultatAsteptat.coefs.put(3, 5.0);
            rezultatAsteptat.coefs.put(2, 1.0);
            rezultatAsteptat.coefs.put(0, 1.0);

            Polynomial rezultatObtinut = p1.scade(p2);

            assertEquals(rezultatAsteptat, rezultatObtinut);
        }

    @Test
    public void testInmulteste() {
        Polynomial p1 = new Polynomial();
        p1.coefs.put(2, 3.0);
        p1.coefs.put(1, 4.0);

        Polynomial p2 = new Polynomial();
        p2.coefs.put(1, 2.0);
        p2.coefs.put(0, 1.0);

        Polynomial rezultatAsteptat = new Polynomial();
        rezultatAsteptat.coefs.put(3, 6.0);
        rezultatAsteptat.coefs.put(2, 14.0);
        rezultatAsteptat.coefs.put(1, 4.0);

        Polynomial rezultatObtinut = p1.inmulteste(p2);

        assertEquals(rezultatAsteptat, rezultatObtinut);
    }

    @Test
    public void testDeriveaza() {
        // Create a polynomial with the coefficients: 3x^3 + 2x^2 + 5x + 1
        HashMap<Integer, Double> coefs = new HashMap<>();
        coefs.put(3, 3.0);
        coefs.put(2, 2.0);
        coefs.put(1, 5.0);
        coefs.put(0, 1.0);
        Polynomial p = new Polynomial(coefs);

        // Compute the derivative of the polynomial
        Polynomial deriv = p.deriveaza();

        // Verify that the derivative is correct
        HashMap<Integer, Double> expectedCoefs = new HashMap<>();
        expectedCoefs.put(2, 9.0);
        expectedCoefs.put(1, 4.0);
        expectedCoefs.put(0, 5.0);
        Polynomial expected = new Polynomial(expectedCoefs);
        assertEquals(expected, deriv);
    }

    @Test
    public void testIntegreaza() {
        // Create a polynomial with the coefficients: 3x^2 + 2x + 5
        Map<Integer, Double> coefs = new HashMap<>();
        coefs.put(2, 3.0);
        coefs.put(1, 2.0);
        coefs.put(0, 5.0);
        Polynomial p = new Polynomial(coefs);

        // Compute the integral of the polynomial
        Polynomial integ = p.integreaza();

        // Verify that the integral is correct
        Map<Integer, Double> expectedCoefs = new HashMap<>();
        expectedCoefs.put(3, 1.0);
        expectedCoefs.put(2, 1.0);
        expectedCoefs.put(1, 5.0);
        expectedCoefs.put(0, 0.0);
        Polynomial expected = new Polynomial(expectedCoefs);
        assertEquals(expected, integ);
    }
    @Test
    public void testImparte() {
        Polynomial p1 = new Polynomial();
        p1.coefs.put(2, 3.0);
        p1.coefs.put(1, 4.0);

        Polynomial p2 = new Polynomial();
        p2.coefs.put(1, 2.0);
        p2.coefs.put(0, 1.0);

        Polynomial rezultatAsteptat = new Polynomial();
        rezultatAsteptat.coefs.put(3, 6.0);
        rezultatAsteptat.coefs.put(2, 14.0);
        rezultatAsteptat.coefs.put(1, 4.0);

        Polynomial rezultatObtinut = p1.inmulteste(p2);

        assertEquals(rezultatAsteptat, rezultatObtinut);
    }
    private void assertEquals(Polynomial expected, Polynomial integ) {
    }


}
