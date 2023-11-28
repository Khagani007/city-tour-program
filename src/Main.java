import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<String>();
        cities.add("Sheki");
        cities.add("Baku");
        cities.add("Ganja");

        tour_cities(cities);


    }

    public static void showAction() {
        String actions = "0 - Show actions\n"
                + "1 - Go to next city\n"
                + "2 - Go to previous city\n"
                + "3 - Exit from program";
        System.out.println(actions);
    }

    public static void tour_cities(LinkedList<String> cities) {
        ListIterator<String> iterator = cities.listIterator();
        int action;
        showAction();

        Scanner scanner = new Scanner(System.in);
        if (!iterator.hasNext()) {
            System.out.println("There is no city...");
        }
        boolean exit = false;
        boolean previous = false;

        while (!exit) {
            System.out.print("Choose an action : ");
            action = scanner.nextInt();
            switch (action) {
                case 0:
                    showAction();
                    break;
                case 1:
                    if (!previous) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        previous = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Going to the city : " + iterator.next());
                    } else {
                        System.out.println("There is not any city to go to...");
                        previous = true;
                    }
                    break;
                case 2:
                    if (previous) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        previous = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Going to the city : " + iterator.previous());

                    } else {
                        System.out.println("City tour started");
                    }
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting Program");
                    break;


            }

        }


    }
}