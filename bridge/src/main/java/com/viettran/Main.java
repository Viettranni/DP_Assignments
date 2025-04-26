package com.viettran;

public class Main {
    public static void main(String[] args) {
        // Create a TV device
        Device tv = new TV();

        // Basic Remote section
        System.out.println("=== Using BasicRemote ===");
        Remote basicRemote = new BasicRemote(tv);
        basicRemote.power();
        basicRemote.volumeUp();
        basicRemote.channelUp();

        System.out.println("\n--------------------------\n");

        // Minimal Remote section
        System.out.println("=== Using MinimalRemote with Mute Feature ===");
        MinimalRemote minimalRemote = new MinimalRemote(tv);
        minimalRemote.power(); 

        System.out.println("Muting...");
        minimalRemote.mute(); 
        System.out.println("Volume after mute: " + tv.getVolume());

        System.out.println("Unmuting...");
        minimalRemote.mute(); 
        System.out.println("Volume after unmute: " + tv.getVolume());

        // Only wrap volumeUp() because it throws
        try {
            minimalRemote.volumeUp();
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught unsupported operation: " + e.getMessage());
        }
    }
}


