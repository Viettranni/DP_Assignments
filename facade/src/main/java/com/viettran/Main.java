package com.viettran;

public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();

        String apiUrl = "https://api.chucknorris.io/jokes/random";
        String attribute = "value";

        // Trying the jokes url
        try {
            String joke = facade.getAttributeValueFromJson(apiUrl, attribute);
            System.out.println("Random Chuck Norris Joke:\n" + joke);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }


        // Lets try the other url
        String apiUrl2 = "https://jsonplaceholder.typicode.com/users";

        try {
            // Extracting the name of the first user from the "users" array
            String userName = facade.getAttributeValueFromJson(apiUrl2, "0.name");
            System.out.println("First user's name: " + userName);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}