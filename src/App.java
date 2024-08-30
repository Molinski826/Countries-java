import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>(List.of("Bob", "Jim", "Tom"));
        ArrayList<HashSet<String>> countriesVisited = new ArrayList<>();
        countriesVisited.add(new HashSet<>(List.of("England", "France", "Germany")));
        countriesVisited.add(new HashSet<>(List.of("France", "Spain", "Italy")));
        countriesVisited.add(new HashSet<>(List.of("Spain", "Moroco", "Ireland")));

        Scanner scanner = new Scanner(System.in);

        // String sName = names.get(1);
        // HashSet<String> sClasses = countriesVisited.get(1);

        // System.out.println(sName);
        // for (String c : sClasses) {
        // System.out.println(c);
        // }

        while (true) {
            
            System.out.println(names);
            System.out.println(countriesVisited);

            System.out.println("Menu: ");
            System.out.println("1. Search for people who visited a country");
            System.out.println("2. Add a country to a person's set of countries.");
            System.out.println("3. List all Countries a Person has Visited. ");
            System.out.println("4. Quit.");
            System.out.println("Please choose");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                searchPeopleByCountry(names, countriesVisited, scanner);
            } else if (choice.equals("2")) {
                addCountryToPerson(names, countriesVisited, scanner);
            } else if (choice.equals("3")) {
                listCountriesByPerson(names, countriesVisited, scanner);
            } else if (choice.equals("4")) {
                System.out.println("Goodbye.");;
                break;
            } else {
                System.out.println("Invalid. Please try again");
            }

        }
        scanner.close();

    }

    public static void searchPeopleByCountry(ArrayList<String> names, ArrayList<HashSet<String>> countriesVisited,
            Scanner scanner) {
        System.out.println("Enter the country name: ");
        String country = scanner.nextLine();
        boolean found = true;

        for (int i = 0; i < names.size(); i++) {
            if (countriesVisited.get(i).contains(country)) {
                System.out.println(names.get(i));
                found = true;
            }

        }
        if (!found){
             System.out.println("No one has been to " + country);
        }
    }

    public static void addCountryToPerson(ArrayList<String> names, ArrayList<HashSet<String>> countriesVisited,
            Scanner scanner) {
        System.out.println("Enter the Persons Name: ");
        String name = scanner.nextLine();
        int index = name.indexOf(name);

        if (index == -1) {
            System.out.println("Person not found.");
            return;
        }

        System.out.println("Enter the Country Name: ");
        String country = scanner.nextLine();
        countriesVisited.get(index).add(country);
        System.out.println(country + " added to " + name);
    }

    public static void listCountriesByPerson(ArrayList<String> names, ArrayList<HashSet<String>> countriesVisited,
            Scanner scanner) {
        System.out.println("Enter the Persons Name: ");
        String name = scanner.nextLine();
        int index = names.indexOf(name);

        if (index == -1) {
            System.out.println("Person not found.");
            return;
        }

        System.out.println(name + "has visited: " + countriesVisited.get(index));

    }

}
