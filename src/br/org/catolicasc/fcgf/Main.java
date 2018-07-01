package br.org.catolicasc.fcgf;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author FCGF
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Rsa rsa = new Rsa();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escreva o texto para encriptar com RSA:");

        String toEncrypt = scanner.nextLine();

        System.out.println("Encriptando: " + toEncrypt);

        System.out.println("Em bytes: " + Util.toString(toEncrypt.getBytes()));

        byte[] encrypted = rsa.encrypt(toEncrypt.getBytes());

        System.out.println("Encriptado: " + Util.toString(encrypted));

        byte[] decrypted = rsa.decrypt(encrypted);

        System.out.println("Decriptado: " + Util.toString(decrypted));

        System.out.println("Descriptado em string: " + new String(decrypted));

        System.out.println("Chave pública: " + Arrays.toString(rsa.getPublicKey()));

        System.out.println("Chave privada: " + Arrays.toString(rsa.getPrivateKey()));
    }

}
