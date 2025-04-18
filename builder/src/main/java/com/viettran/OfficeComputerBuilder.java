package com.viettran;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer officeComputer;

    public OfficeComputerBuilder() {
        this.officeComputer = new Computer();
    }

    @Override
    public void buildProcessor() {
        officeComputer.setProcessor("Apple silicone M3 Pro");
    }

    @Override
    public void buildGraphicsCard() {
        officeComputer.setGpu("M3");
    }

   @Override
   public void buildHardDrive() {
        officeComputer.setHardDrive("2TB");
    } 

   @Override
   public void buildOperatingSystem() {
        officeComputer.setOS("MacOS");
    }

   @Override
   public void buildRAM() {
        officeComputer.setRam(36);
    }

   @Override
   public Computer getComputer() {
        return officeComputer;
    }
    
}
