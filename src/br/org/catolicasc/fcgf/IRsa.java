package br.org.catolicasc.fcgf;

/**
 *
 * @author FCGF
 */
public interface IRsa {

    byte[] decrypt(byte[] message);

    byte[] encrypt(byte[] message);

}
