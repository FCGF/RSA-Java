package br.org.catolicasc.fcgf;

/**
 *
 * @author FCGF
 */
public final class Util {

    private Util(){
        super();
    }
    
    public static String toString(byte[] encrypted) {
        StringBuilder bytes = new StringBuilder();
        for (byte b : encrypted) {
            bytes.append(Byte.toString(b));
        }
        return bytes.toString();
    }

}
