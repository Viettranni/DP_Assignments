package com.viettran;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptedPrinter implements Printer {
    BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

    private Printer printer;
    private String encryptedMessage;

    public EncryptedPrinter(Printer printer) {
        this.printer = printer;

        textEncryptor.setPassword("My Secret Password");
    }

    public void print(String message) {
        encryptedMessage = textEncryptor.encrypt(message);
        printer.print(encryptedMessage);
    }

    public void decryptPrint() {
        String decryptedMessage = textEncryptor.decrypt(encryptedMessage);
        printer.print(decryptedMessage);
    }
}
