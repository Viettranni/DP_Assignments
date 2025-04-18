package com.viettran;

public class Main {
    public static void main(String[] args) {
        // Builder
        ComputerBuilder peteTheBuilder = new GamingComputerBuilder();

        // Director
        ComputerDirector director = new ComputerDirector(peteTheBuilder);

        // Building the gaming PC step by step
        director.constructComputer();

        // This is the outcome of the gaming pc
        Computer gamingPC = peteTheBuilder.getComputer();
        System.out.println(gamingPC);

        // Office builder
        ComputerBuilder macObsessedBuilder = new OfficeComputerBuilder();
        
        // Director will call out the builds in a specific order
        ComputerDirector macDirector = new ComputerDirector(macObsessedBuilder);
        macDirector.constructComputer();

        // The final office computer
        Computer macComputer = macObsessedBuilder.getComputer();
        System.out.println(macComputer);
    }
}