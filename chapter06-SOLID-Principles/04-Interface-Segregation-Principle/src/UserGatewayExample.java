import java.util.*;

// General user operations
interface UserGateway {
    void signIn();
    void signOut();
    String getUserName();
}

// User operations related to banks
interface UserBankGateway extends UserGateway {
    List<String> getBankList();
    boolean addBank(String bankName);
    boolean removeBank(String bankName);
}

// User operations related to addresses
interface UserAddressGateway extends UserGateway {
    List<String> getAddressList();
    boolean addAddress(String address);
    boolean removeAddress(String address);
    String getMainAddress();
}

// Implementation of UserBankGateway
class UserBankGatewayImpl implements UserBankGateway {
    @Override
    public void signIn() {
        System.out.println("Signing in...");
    }

    @Override
    public void signOut() {
        System.out.println("Signing out...");
    }

    @Override
    public String getUserName() {
        return "John Doe";
    }

    @Override
    public List<String> getBankList() {
        return Arrays.asList("Bank A", "Bank B");
    }

    @Override
    public boolean addBank(String bankName) {
        System.out.println("Adding bank: " + bankName);
        return true;
    }

    @Override
    public boolean removeBank(String bankName) {
        System.out.println("Removing bank: " + bankName);
        return true;
    }
}

// Implementation of UserAddressGateway
class UserAddressGatewayImpl implements UserAddressGateway {
    @Override
    public void signIn() {
        System.out.println("Signing in...");
    }

    @Override
    public void signOut() {
        System.out.println("Signing out...");
    }

    @Override
    public String getUserName() {
        return "Alice Smith";
    }

    @Override
    public List<String> getAddressList() {
        return Arrays.asList("Address 1", "Address 2");
    }

    @Override
    public boolean addAddress(String address) {
        System.out.println("Adding address: " + address);
        return true;
    }

    @Override
    public boolean removeAddress(String address) {
        System.out.println("Removing address: " + address);
        return true;
    }

    @Override
    public String getMainAddress() {
        return "Address 1";
    }
}

// UserProcessor class using the interfaces
class UserProcessor {
    public void addUserBank(UserBankGateway userGateway) {
        userGateway.signIn();
        userGateway.addBank("BCA");
        userGateway.signOut();
    }

    public void addUserAddress(UserAddressGateway userGateway) {
        userGateway.signIn();
        userGateway.addAddress("Lubuk Sikarah");
        userGateway.signOut();
    }

    public void printUserName(UserGateway userGateway) {
        userGateway.signIn();
        System.out.println("userName = " + userGateway.getUserName());
        userGateway.signOut();
    }
}

// Main class demonstrating usage
class UserGatewayExample {
    public static void main(String[] args) {
        UserProcessor processor = new UserProcessor();

        // Example usage with UserBankGateway
        System.out.println("=== UserBankGateway Example ===");
        UserBankGateway bankGateway = new UserBankGatewayImpl();
        processor.addUserBank(bankGateway);

        // Example usage with UserAddressGateway
        System.out.println("\n=== UserAddressGateway Example ===");
        UserAddressGateway addressGateway = new UserAddressGatewayImpl();
        processor.addUserAddress(addressGateway);

        // Example usage with UserGateway (for printing user name)
        System.out.println("\n=== UserGateway Example ===");
        UserGateway userGateway = new UserBankGatewayImpl(); // Using UserBankGateway implementation for simplicity
        processor.printUserName(userGateway);
    }
}