package com.exigen.task;

/**
 * User: Alex
 * Date: 09.04.13
 */
public class Complex {
    private double re, im;

    public Complex() {
        re = 0;
        im = 0;
    }

    public Complex(int real, int imaginary) {
        re = real;
        im = imaginary;
    }

    public Complex(double real, double imaginary) {
        re = real;
        im = imaginary;
    }

    public Complex add(Complex num) {
        return new Complex(re + num.getRe(), im + num.getIm());
    }

    public Complex sub(Complex num) {
        return new Complex(re - num.getRe(), im - num.getIm());
    }

    public Complex mult(Complex num) {
        return new Complex(re * num.getRe() - im * num.getIm(),
                           re * num.getIm() + im * num.getRe());
    }

    public Complex div(Complex num) {
        Double real =  (re * num.getRe() + im * num.getIm()) /
                (num.getRe() * num.getRe() + num.getIm() * num.getIm());
        Double imaginary =  (im * num.getRe() - re * num.getIm()) /
                (num.getRe() * num.getRe() + num.getIm() * num.getIm());
        return new Complex(real, imaginary);
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("(");
        if (re != 0) {
            sb.append(re);
            if (im == 1) {
                sb.append("+i)");
            }else if (im > 0) {
                sb.append("+" + im + "i)");
            }else if (im == -1) {
                sb.append("-i)");
            } else if (im == 0) {
                return String.valueOf(re);
            } else
                sb.append(im + "i)");
        }else {
            if (im == 1) {
                sb.append("i)");
            }else if (im > 0) {
                sb.append(im + "i)");
            }else if (im == -1) {
                sb.append("-i)");
            } else if (im == 0) {
                return "0";
            } else
                sb.append(im + "i)");
        }
        return sb.toString();
    }
}
