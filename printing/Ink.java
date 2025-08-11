package printing;


public class Ink {

  public Ink() {}

  public void welcome() {
    System.out.println("\n  =================================");
    System.out.println("==  Welcome to the Pokemon Arena!  ==");
    System.out.println("  ================================= \n");
  } // welcome()

   public void goodbye() {
    System.out.println("\n =================================");
    System.out.println("==   Seen you soon in the Arena!   ==");
    System.out.println("  =================================");
  } // Goodbye()
   public void attackMenu() {
    System.out.println("\n Your turn! Choose your next attack: \n");
    System.out.println("1. Normal");
    System.out.println("2. Heavy");
    System.out.println("3. Special");
    System.out.println("");
   }
   public void line() {
    System.out.println("---------------------------------");
   }



} 