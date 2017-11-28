package server.utility;

import server.config.Config;

public class Encryption {

    /**
     * Kryptering skal kunne slås til og fra i configfilen
     * <p>
     * Fremgansmåde:
     * <p>
     * Klienten sender et krypteret Json objekt til serveren.
     * Krypteringen hos klienten medfører, at objektet ikke længere er JSON, men blot en ciffertekst.
     * Derfor skal cifferteksten parses til JSON, således at serveren kan modtage det.
     * Det modtagede JSON objekt unparses fra JSON til ciffertekst, således at det kan dekrypteres.
     * Efter objektet er dekrypteret er det igen JSON.
     * Herefter unparses objektet fra JSON igen, således at vi kan bruge objektet i serveren.
     */

    /**
     * Method responsible for encrypting a string using the XOR encryption
     * @param input the string to be encrypted
     * @return the encrypted string if encryption is toggled
     */
    public String encryptXOR(String input) {
        if (Config.getENCRYPTION()) {
            char[] key = {'Y', 'O', 'L', 'O'}; //Can be any chars, and any length array
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                output.append((char) (input.charAt(i) ^ key[i % key.length]));
            }

            return output.toString();
        }
        else{
            return input;
        }
    }

    //method to decrypt a string parsed as Json


}

