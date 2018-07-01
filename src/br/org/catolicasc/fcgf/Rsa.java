package br.org.catolicasc.fcgf;

import java.math.BigInteger;

import java.util.Random;

/**
 *
 * @author FCGF
 */
public class Rsa implements IRsa {

    private final BigInteger N;

    private final BigInteger e;

    private final BigInteger d;

    private static final int BIT_LENGTH = 1024; //100

    public Rsa() {

        super();

        Random random = new Random();

        BigInteger p = BigInteger.probablePrime(BIT_LENGTH, random);

        BigInteger q = BigInteger.probablePrime(BIT_LENGTH, random);

        N = p.multiply(q);

        BigInteger z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.probablePrime(BIT_LENGTH / 2, random);

        while (z.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(z) < 0) {
            e.add(BigInteger.ONE);
        }

        d = e.modInverse(z);
    }

    public Rsa(BigInteger e, BigInteger d, BigInteger N) {
        super();

        this.e = e;

        this.d = d;

        this.N = N;
    }

    public BigInteger[] getPublicKey() {
        return new BigInteger[]{e, N};
    }

    public BigInteger[] getPrivateKey() {
        return new BigInteger[]{d, N};
    }

    @Override
    public byte[] encrypt(byte[] message) {
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }

    @Override
    public byte[] decrypt(byte[] message) {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }

}
