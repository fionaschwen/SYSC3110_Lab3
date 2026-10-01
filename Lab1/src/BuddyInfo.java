public class BuddyInfo {
    public String getName() {
        return name;
    }
    public BuddyInfo(String name) {
        this.name = name;
    }
    public BuddyInfo(){
        this("noName");
    }
    private String name;
    public static void main(String[]args){
        BuddyInfo elliott = new BuddyInfo("Elliott");
        System.out.println("Hello " + elliott.getName() + "!");
    }
}
