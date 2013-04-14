package com.exigen.task;

import java.io.*;
/**
 * User: Alex
 * Date: 09.04.13
 */
public class Calculator {

    private File inp, out;

    public Calculator() {
        inp = new File("input.txt");
        out = new File("output.txt");
        if (!out.exists()){
            try {
                out.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void evaluate() throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(inp));
            writer = new BufferedWriter(new FileWriter(out, false));
            Complex complex;
            while ((line = reader.readLine()) != null) {
                if (new Validator().validate(line) && (complex = evaluateElements(line)) != null) {
                    writer.write(line + "=" + complex);
                } else {
                    writer.write(line + "=can't calculate");
                }
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null && writer != null) {
                reader.close();
                writer.close();
            }
        }
    }

    private Complex evaluateElements(String line) {
        String first = line.substring(1, line.indexOf("i)"));
        String second = line.substring(line.indexOf("i)") + 4, line.length() - 2);
        char sign = line.charAt(line.indexOf("i)") + 2);
        Complex complex, firstNum, secondNum;
        if ((firstNum = determineNumber(first)) != null && (secondNum = determineNumber(second)) != null) {
            switch (sign) {
                case '+':
                    complex = firstNum.add(secondNum);
                    break;
                case '-':
                    complex = firstNum.sub(secondNum);
                    break;
                case '*':
                    complex = firstNum.mult(secondNum);
                    break;
                case '/':
                    complex = firstNum.div(secondNum);
                    break;
                default:
                    complex = null;
            }
        } else
            return null;
        return complex;
    }

    public Complex determineNumber(String subLine) {
        int real = 0, imaginary = 0;
        String subIm;
        String subRe;
        try {
            if (!subLine.isEmpty()) {
                if (!subLine.substring(0, subLine.length() - 1).isEmpty()) {
                    if (subLine.endsWith("-")) {
                        imaginary = -1;
                        real = Integer.parseInt(subLine.substring(0, subLine.length() - 1));
                    } else if (subLine.endsWith("+")) {
                        imaginary = +1;
                        real = Integer.parseInt(subLine.substring(0, subLine.length() - 1));
                    } else if (subLine.lastIndexOf("-") > -1 && subLine.lastIndexOf("-") > subLine.lastIndexOf("+")) {
                        subIm = subLine.substring(subLine.lastIndexOf("-"));
                        imaginary = Integer.parseInt(subIm);
                        if (!(subRe = subLine.substring(0, subLine.indexOf(subIm))).isEmpty())
                            real = Integer.parseInt(subRe);
                    } else if (subLine.lastIndexOf("+") > -1 && subLine.lastIndexOf("+") > subLine.lastIndexOf("-")) {
                        subIm = subLine.substring(subLine.lastIndexOf("+"));
                        imaginary = Integer.parseInt(subIm);
                        if (!(subRe = subLine.substring(0, subLine.indexOf(subIm))).isEmpty())
                            real = Integer.parseInt(subRe);
                    } else if (!subLine.contains("-") && !subLine.contains("+")) {
                        imaginary = Integer.parseInt(subLine);
                    } else return null;
                } else {
                    if (subLine.endsWith("-"))
                        imaginary = -1;
                    else if (subLine.endsWith("+"))
                        imaginary = 1;
                    else
                        imaginary = Integer.parseInt(subLine);
                }
            } else {
                imaginary = 1;
            }
            return new Complex(real, imaginary);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
