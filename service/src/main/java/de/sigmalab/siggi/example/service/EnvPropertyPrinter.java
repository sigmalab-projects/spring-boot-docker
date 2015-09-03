package de.sigmalab.siggi.example.service;

import java.util.Map;

/**
 * @author  jbellmann
 */
public class EnvPropertyPrinter {

    public void print() {
        boolean foundone = false;
        for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
            if (entry.getKey().startsWith("SIG_EX")) {
                foundone = true;
                System.out.println("" + entry.getKey() + " : Value" + entry.getValue());
            }
        }

        if (!foundone) {
            System.out.println("THERE WAS NO ENV STARTING WITH 'SIG_EX'");
        }
    }

}
