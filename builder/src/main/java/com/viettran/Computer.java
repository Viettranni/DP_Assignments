package com.viettran;

public class Computer {
    private String processor;
    private int ram;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    // This would automatically print even when this object is being just called
    @Override
    public String toString() {
        String one = "The computer has the following SPECS: ";
        String two = "CPU: " + processor + ", RAM size: " + ram + " GB , Hard drive: " + hardDrive + ", GPU: " + graphicsCard + " and the Operating System: " + operatingSystem;

        return one + two;
    }

    public void setProcessor(String cpu) {
        this.processor = cpu;
    }

    public void setRam(int ramSize) {
        this.ram = ramSize;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGpu(String gpu) {
        this.graphicsCard = gpu;
    }

    public void setOS(String OS) {
        this.operatingSystem = OS;
    }

}