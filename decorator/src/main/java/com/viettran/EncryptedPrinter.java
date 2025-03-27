package com.viettran;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptedPrinter extends PrinterDecorator {
    BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

    // private Printer printer;
    private String encryptedMessage;

    public EncryptedPrinter(Printer printer) {
        super(printer);
        textEncryptor.setPassword("Spiderman");
    }

    public void print(String message) {
        encryptedMessage = textEncryptor.encrypt(message);
        super.print(encryptedMessage);
        System.out.println("Also Decrypted message: ");
        String decryptedMessage = textEncryptor.decrypt(encryptedMessage);
        super.print(decryptedMessage);
    }
}
