import java.time.LocalDate;
import java.util.Scanner;

class DMart {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        LocalDate date = LocalDate.now();
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        // String YELLOW = "\u001B[33m";

        char carryBag, gen;
        String name, gift = "";
        int itemPrice[] = new int[10];
        int itemQuantity[] = new int[10];
        int totalPrice[] = new int[10];
        double afetr_Discount[] = new double[10];

        int price = 0, AP = 0; // actual price,discounted price
        double DP = 0, discount = 0;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("\t\tWelcome to DMart");
        System.out.println("----------------------------------------------");
        System.out.print("Enter name : ");
        name = s.nextLine();
        System.out.print("Enter gender (M/F): ");

        do {
            gen = s.next().charAt(0);
            if (gen == 'M' || gen == 'm' || gen == 'f' || gen == 'F') {
                break;
            }
            System.out.println(RED + "please Enter M/m or F/f only :" + RESET);
        } while (gen != 'M' && gen != 'm' && gen != 'f' && gen != 'F');

        switch (gen) {
            case 'M':
            case 'm':
                gift = "Ladger Wallet";
                break;

            case 'F':
            case 'f':
                gift = "Cadeberry";
                break;

            default:
                break;
        }

        System.out.println("Enter quantity you have purchase of Items :- ");
        for (int i = 0; i < 10; i++) {
            itemPrice[i] = 10 * (i + 1);
            System.out.print("\nItem-" + (i + 1) + " : ");

            // quantities purchased
            do {
                itemQuantity[i] = s.nextInt();

                if (itemQuantity[i] >= 1 && itemQuantity[i] <= 50) {
                    break;
                }
                System.out.print(RED + "You can ONLY purchase minimum one quantity and maximum 50 quantity " + RESET);
                System.out.print("\nItem-" + (i + 1) + " : ");
            } while (!(itemQuantity[i] >= 1 && itemQuantity[i] <= 50));
            // total price
            totalPrice[i] = itemPrice[i] * itemQuantity[i];
            // discount
            switch ((i + 1)) {
                case 5:
                    discount = 10;
                    break;
                case 10:
                    discount = 15;
                    break;
                default:
                    discount = 0;
                    if (itemQuantity[i] >= 5) {
                        discount = 5;
                    }
                    break;
            }

            afetr_Discount[i] = totalPrice[i] * (1 - discount / 100);

            AP += totalPrice[i];
            DP += afetr_Discount[i];

        }
        System.out.println("_____________________________________________________________");
        // carry bag
        System.out.println("Carry Bag (Y/N) : ");
        do {
            carryBag = s.next().charAt(0);
            if (carryBag == 'Y' || carryBag == 'N' || carryBag == 'y' || carryBag == 'n') {
                break;
            }
            System.out.println(RED + "please Enter Y/y or N/n only :" + RESET);
        } while (carryBag != 'Y' && carryBag != 'N' && carryBag != 'y' && carryBag != 'n');

        System.out.println();

        // print bill
        System.out.println("_____________________________________________________________");
        System.out.println("\t\t\tDMart");
        System.out.println("Name : " + name + "\t\t\t\tDate : " + date);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Items Quantity Price Total After-Discount");

        for (int i = 0; i < 10; i++) {

            System.out.println("Item-" + (i + 1) + "\t " + itemQuantity[i] + "\t " +
                    itemPrice[i] + "\t "
                    + totalPrice[i] + "\t " + afetr_Discount[i]);
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("\t\t\tA.P\tD.P");
        System.out.println("\t\t\t" + AP + "\t" + DP);

        discount = 0;
        if (AP >= 10000) {
            discount = 15;
            DP = AP * (1 - discount / 100);
        } else if (AP >= 5000 && AP < 10000) {
            discount = 10;
            DP = AP * (1 - discount / 100);
        }

        if (discount > 0) {
            System.out.println("After " + discount + "% discount : " + AP + "\t\t" + DP);
            System.out.println("\t\t\t\t" + AP + "\t\t" + DP);
        }
        System.out.println("-------------------------------------------------------------");

        System.out.println(GREEN + "Gift : " + gift + "\t 0.0 \t 0.0" + RESET);

        switch (carryBag) {
            case 'Y':
            case 'y':
                price = 10;
                break;
            case 'N':
            case 'n':
                price = 0;
                break;
            default:
                break;
        }

        System.out.println("Carry Bag : \t\t" + price + "\t " + price);
        System.out.println("GST(10%)\t\t" + AP / 10 + "\t" + AP / 10);
        DP += AP / 10;
        AP += AP / 10;
        AP += price;
        DP += price;
        System.out.println("_____________________________________________________________");

        System.out.println("\t\t\t" + AP + "\t" + DP + " Rs");

        System.out.println("\t\tThank You");
        System.out.println("\t\t To Visit");
        System.out.println("\t\t D-Mart");
        System.out.println("_____________________________________________________________");

        System.out.println(GREEN + "Your bill generated succesfully" + RESET);
        s.close();
    }
}