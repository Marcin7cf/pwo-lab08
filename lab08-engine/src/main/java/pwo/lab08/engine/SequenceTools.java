package pwo.lab08.engine;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class SequenceTools {

    private static String getTerms(SequenceGenerator sg,
            int from, int to, String sep) {

        //int i = from, stop = to, step = from > to ? -1 : 1;
        int i = from, stop = to, step = 1;

        String terms = "";
        if (from > to) {
            i = to;
            stop = from;
        }
        var termsL = new ArrayList<BigDecimal>();

        while (true) {
            //terms += sg.getTerm(i) + sep;
            termsL.add(sg.getTerm(i));
            if (i == stop) {
                if (from > to) {
                    Collections.reverse(termsL);
                }
                for (BigDecimal value : termsL) {
                    terms += value.toString() + sep;
                }
                return terms.trim();
            }
            i += step;
        }
    }

    public static String getTermsAsColumn(SequenceGenerator sg, int from, int to) {
        return getTerms(sg, from, to, "\n");
    }

    public static String getTermsAsLine(SequenceGenerator sg,
            int from, int to) {
        return getTerms(sg, from, to, " ");
    }

    public static boolean writeToFile(SequenceGenerator sg,
            int from, int to, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))) {
            writer.write(getTermsAsColumn(sg, from, to));
        } catch (IOException ex) {
            return false;
        }

        return true;
    }
}
