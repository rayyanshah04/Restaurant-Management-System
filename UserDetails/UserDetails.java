package sem2Project.UserDetails;

import java.util.Scanner;

public class UserDetails {

    public static class User {
        protected String name;
        protected String address;
        protected String phone;

        public User(String name, String address, String phone) {
            this.name = name;
            this.address = address;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getPhone() {
            return phone;
        }
    }

    public static User getUserDetails() {
        Scanner sc = new Scanner(System.in);
        String name;
        String address;
        String phone;

        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter your address: ");
        address = sc.nextLine();
        System.out.println("Enter your phone: ");
        phone = sc.nextLine();

        return new User(name, address, phone);
    }
}
