
package mypet;

/**
 *
 * @author Jordan
 */
public class MyPet {

  
  private String[] checklist; 
  private int count;     


  
  public MyPet() {
    this.checklist = new String[10];
    this.count = 0;
  }

  
  public boolean add(String item) {
    if (this.count == this.checklist.length) {
      return false;  //can't add to full list
    }else {
      this.checklist[count] = item;
      this.count++;
      return true;
    }
  }

  
  public int getSize() {
    return count;
  }

  
  public String remove(int index) {
    if (index < 1 || index > this.count) {
      return null;  
    }else {
      index--;  
      String deleted = this.checklist[index];
      
      for (int i = index; i < this.count - 1; i++) {
        this.checklist[i] = this.checklist[i + 1];
      }
      this.count--;  
      return deleted;
    }
  }

  
  public String toString() {
    String output = "Item:\n";
    for (int i = 0; i < this.count; i++) {
      output += (i + 1) + ". " + this.checklist[i] + "\n";
    }
    return output;
  }



  /**
   * menu
   */
  
  public static void main(String[] args) {

    java.util.Scanner keybd = new java.util.Scanner(System.in);
    MyPet list = new MyPet();

    int choice = 1;
    while (choice != 0) {
      
      System.out.println();
      System.out.println(list); 

      
      System.out.println("MENU:");
      System.out.println("1 - Add item");
      System.out.println("2 - Remove last item");
      System.out.println("3 - Remove specific item");
      System.out.println("0 - Quit");
      System.out.print("Enter your menu choice: ");

      
      try {
        choice = keybd.nextInt();
        keybd.nextLine();  
        switch (choice) {
          case 1:  
            System.out.print("Enter the thing you need to do for your pet: ");
            String task = keybd.nextLine();
            boolean added = list.add(task);
            if (!added) {
              System.out.println("Sorry, but this checklist is already full!");
            }
            break;

          case 2:  
            String removed = list.remove(list.getSize());
            if (removed != null) {
              System.out.println("Removed: " + removed);
            }else {
              System.out.println("The checklist is already empty.");
            }
            break;

          case 3:  
            System.out.print("Enter the index of the item to remove: ");
            int index = keybd.nextInt();
            removed = list.remove(index);
            if (removed != null) {
              System.out.println("Removed: " + removed);
            }else {
              System.out.println("There is no item to be removed at index " +
                  index + ".");
            }
            break;

          case 0:
            System.out.println("Goodbye!");
            break;

          default:
            System.out.println("Sorry, but " + choice + " is not one of " +
                "the menu choices. Please try again.");
            break;
        }
      }catch (java.util.InputMismatchException ime) {
        System.out.println("Sorry, but you must enter a number.");
        keybd.nextLine();  
      }
    }
  }

}