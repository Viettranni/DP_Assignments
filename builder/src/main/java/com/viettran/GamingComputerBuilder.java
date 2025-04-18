package com.viettran;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer gamingComputer;

    public GamingComputerBuilder() {
        this.gamingComputer = new Computer();
    }

    @Override
    public void buildProcessor() {
        gamingComputer.setProcessor("AMD Ryzen 2800");
    }

    @Override
    public void buildGraphicsCard() {
        gamingComputer.setGpu("RTX 5080");
    }

   @Override
   public void buildHardDrive() {
        gamingComputer.setHardDrive("1TB");
    } 

   @Override
   public void buildOperatingSystem() {
        gamingComputer.setOS("Windows");
    }

   @Override
   public void buildRAM() {
        gamingComputer.setRam(38);
    }

   @Override
   public Computer getComputer() {
        return gamingComputer;
    }
    
}
