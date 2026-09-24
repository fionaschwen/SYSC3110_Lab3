import java.util.ArrayList;

public class AddressBook {
    private ArrayList<BuddyInfo> buddies;

    public AddressBook()
    {
        buddies = new ArrayList<BuddyInfo>();
    }
    public void addBuddy(BuddyInfo b)
    {
        buddies.add(b);
    }
    public void removeBuddy(BuddyInfo b)
    {
        buddies.remove(b);
    }

    public static void main(String[]args)
    {
        System.out.println("Address book.");
        BuddyInfo bud = new BuddyInfo("Jacob");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(bud);
        addressBook.removeBuddy(bud);
    }


}
