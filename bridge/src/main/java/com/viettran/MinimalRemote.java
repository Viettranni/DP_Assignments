package com.viettran;

public class MinimalRemote implements Remote {
    protected Device device;
    private int beforeMute;
    private int currentVolume;

    public MinimalRemote(Device device) {
        this.device = device;
    }

    public void mute() {
        currentVolume = device.getVolume();
        
        // First checks if the volume is not muted
        if (currentVolume != 0) {
            // Remembers the previous volume level
            beforeMute = device.getVolume();
            device.setVolume(0);
            System.out.println("Muted, current volume: " + device.getVolume());
        } else {
            device.setVolume(beforeMute);
            System.out.println("Unmuted, current volume: " + device.getVolume());
        }
    }

    @Override
    public void power() {
        System.out.println("MinimalRemote: power toggle");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeUp() {
        // No volume up in this remote
        throw new UnsupportedOperationException("volumeUp not supported");
    }

    @Override
    public void volumeDown() {
        // No volume down in this remote
        throw new UnsupportedOperationException("volumeDown not supported");
    }

    @Override
    public void channelDown() {
        // Not supported
        throw new UnsupportedOperationException("channelDown not supported");
    }

    @Override
    public void channelUp() {
        // Not supported
        throw new UnsupportedOperationException("channelUp not supported");
    }
}
