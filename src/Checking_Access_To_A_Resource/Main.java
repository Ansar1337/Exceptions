package Checking_Access_To_A_Resource;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Login");
        String login = scanner.nextLine();
        System.out.println("Enter the password");
        String password = scanner.nextLine();

        //Checking login and password
        User user = getUserByLoginAndPassword(login, password);

        //Calling methods of user validation
        validateUser(user);

        System.out.println("Access granted");
    }

    public static User[] getUsers() {
        User user1 = new User("jhon", "pass1", "jhon@gmail.com", 24);
        User user2 = new User("mike", "pass2", "mike@gmail.com", 17);
        User user3 = new User("bob", "pass3", "bob@gmail.com", 20);

        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("You are under 18 years old. Access denied");
        } else {
            System.out.println("Access is allowed");
        }
    }
}