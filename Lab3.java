package EBI;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Lab3 {

    public static void main(String[] args) {
        ComplexNumber x = new ComplexNumber(new BigDecimal("4.0"), new BigDecimal("4.0"));
        ComplexNumber y = new ComplexNumber(new BigDecimal("2.0"), new BigDecimal("2.0"));

        ComplexNumber result;

        result = x.subComplex(y);
        System.out.println("x real after subtraction: " + result.getRe());
        System.out.println("x img after subtraction: " + result.getIm());



        result = x.mulComplex(y);
        System.out.println("x real after multiplication: " + result.getRe());
        System.out.println("x img after multiplication: " + result.getIm());

        result = x.divComplex(y);
        System.out.println("x real after division: " + result.getRe());
        System.out.println("x img after division: " + result.getIm());

        result = x.addComplex(y);
        System.out.println("x real after division: " + result.getRe());
        System.out.println("x img after division: " + result.getIm());


    }

    public static class ComplexNumber {
        final private BigDecimal Re;
        final private BigDecimal Im;

        // Constructor
        public ComplexNumber(BigDecimal Re, BigDecimal Im) {
            this.Re = Re;
            this.Im = Im;
        }

        // Getter for Re
        public BigDecimal getRe() {
            return Re;
        }



        // Getter for Im
        public BigDecimal getIm() {
            return Im;
        }



        public ComplexNumber addComplex(ComplexNumber num) {
            BigDecimal newRe = this.Re.add(num.Re);
            BigDecimal newIm = this.Im.add(num.Im);
            return new ComplexNumber(newRe, newIm);
        }

        public ComplexNumber subComplex(ComplexNumber num) {
            BigDecimal newRe = this.Re.subtract(num.Re);
            BigDecimal newIm = this.Im.subtract(num.Im);
            return new ComplexNumber(newRe, newIm);
        }

        public ComplexNumber mulComplex(ComplexNumber num) {
            BigDecimal newRe = this.Re.multiply(num.Re).subtract(this.Im.multiply(num.Im));
            BigDecimal newIm = this.Re.multiply(num.Im).add(this.Im.multiply(num.Re));
            return new ComplexNumber(newRe, newIm);
        }

        public ComplexNumber divComplex(ComplexNumber num) {
            BigDecimal denominator = num.Re.multiply(num.Re).add(num.Im.multiply(num.Im));
            BigDecimal newRe = (this.Re.multiply(num.Re).add(this.Im.multiply(num.Im))).divide(denominator, RoundingMode.HALF_UP);
            BigDecimal newIm = (this.Im.multiply(num.Re).subtract(this.Re.multiply(num.Im))).divide(denominator, RoundingMode.HALF_UP);
            return new ComplexNumber(newRe, newIm);
        }
    }
}
