//Bryan Montalvo Ramos
//COP-3330C-24217
//2/22/2025

import java.util.*;
// This class is set up to have a pre-determine list and a  list asked to be filled in by the User.
// This also contains the different procedures the list will go through to transform the information.
/*Collection is an interface for Java, while Collections is a utility class that allows you to
manipulate the data as shown below */

public class Anime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> animeList = new ArrayList<>();// pre-determine list printed out prior to user input.
        animeList.add("One-piece");
        animeList.add("Bleach");
        animeList.add("Naruto");
        animeList.add("Dragon-Ball");
        animeList.add("Dragon-Ball Z");
        animeList.add("Death Note");
        System.out.println(animeList);

        List<String> userList = new ArrayList<>();

            //Instructions for the user input
        System.out.println(" Instructions ");
        System.out.println(" Please enter the name of the anime one at a time. ");
        System.out.println(" When you are done with the list of Anime, please write STOP to end the program. ");

        while (userList.size()<8) {// saves the user input and moves on to next line if the inputs meets criteria.
            System.out.println("Enter an anime title "+ userList.size());
            String anime = sc.next();



            if (anime.equalsIgnoreCase("STOP")) {
                break;  // stops the program when STOP is entered
            }
            //prevents duplicates
            if (!containsIgnoreCase(userList, anime)) {
                userList.add(anime);
            } else {
                System.out.println("The anime is already in the list. Try again.");
            }
        }
        // print method
        printList(animeList, "Anime List:");
        printList(userList, "User List:");

        //Collection methods utilized including shuffle, sort, reversed
        // changing the list to array and back to a list and finally a fill method to fill the list with the pre-determined values

        // Sorting method to find length
        String longest = Collections.max(animeList, Comparator.comparingInt(String::length));
        String shortest = Collections.min(animeList, Comparator.comparingInt(String::length));

        // Print statistics
        System.out.println("\nTotal Entries: " + animeList.size());
        System.out.println("Longest Entry: " + longest);
        System.out.println("Shortest Entry: " + shortest);

        // Shuffle the list
        Collections.shuffle(animeList);
        System.out.println("\nShuffled Anime List:");
        printList(animeList, "");
        // Rotates list by -1
        Collections.rotate(animeList, -1);
        System.out.println("\nRotate Anime List by -1 position");
        printList(animeList, "");

        // Reverse the list
        Collections.reverse(animeList);
        System.out.println("\nReversed Anime List:");
        printList(animeList, "");
        // Collections sorted by alphabetical order
        Collections.sort(animeList);
        System.out.println("\n Sorted Anime List:");
        printList(animeList, "");
        Collections.sort(userList);
        System.out.println("\nSorted User List:");

        //changes AnimeList to an Array
        String[] animeArray = animeList.toArray(new String[0]);
        System.out.println("Anime List Converted to an Array:");
        System.out.println(Arrays.toString(animeArray));
        String[] userArray = userList.toArray(new String[0]);
        System.out.print("userList converted to an Array: ");
        System.out.println(Arrays.toString(userArray));
        // changes Array to List
        List<String> newAnimeList = new ArrayList<>(Arrays.asList(animeArray));
        System.out.println(" Array Converted Back to List:");
        printList(newAnimeList, "");
        List<String> newUserList = new ArrayList<>(Arrays.asList(userArray));
        System.out.println(" User List Converted Back to List:");
        printList(newUserList, "");

        // Fills in the anime list with a pre-determine value
        Collections.fill(userList, "Unknown");

        if (userList.isEmpty()) { // Corrected condition (removed semicolon)
            System.out.println("User list is empty. Default values applied.");
        }

        System.out.println("\nFilled Anime List:");
        printList(animeList, "");

        //compares pre-determined list and user input
        compare(
                Arrays.asList("One-piece", "Bleach", "Naruto", "Dragon-Ball", "Dragon-Ball Z"),
                animeList
        );
        searchAnime(newAnimeList, sc);


        sc.close();// closes scanner which stops user input
    }
    // compares the size of both list and gives you an adequate comparison.
    public static void compare(List<String> predefinedList, List<String> userList) {
        if (predefinedList.size() > userList.size()) {
            System.out.println("The predefined anime list has " + (predefinedList.size() - userList.size()) + " more entries.");
        } else if (userList.size() > predefinedList.size()) {
            System.out.println("User anime list has " + (userList.size() - predefinedList.size()) + " more entries.");
        } else {
            System.out.println("Both lists are equal in number of entries.");
        }

        // Find common anime in both lists
        List<String> commonAnime = new ArrayList<>();
        for (String anime : userList) {
            if (containsIgnoreCase(predefinedList, anime)) {
                commonAnime.add(anime);
            }
        }

    }
    public static void searchAnime(List<String> list, Scanner sc) {
        System.out.print(" Enter an anime name to search: ");
        String searchAnime = sc.next();
        System.out.println(" Searching in a list of " + list.size()+"entries");

        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(searchAnime)) {
                System.out.println( searchAnime + " found at position: " + (i + 1));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println( searchAnime + " not found in the list.");
        }
    }


    // Helper method to check for duplicates and ignores the input
    private static boolean containsIgnoreCase(List<String> list, String word) {
        for (String s : list) {
            if (s.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }

    // Method to print list with a header
    private static void printList(List<String> list, String header) {
        if (!header.isEmpty()) {
            System.out.println("\n" + header);
        }
        for (String item : list) {
            System.out.println(item);
        }
    }
}