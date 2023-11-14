import java.util.Scanner;
public class RestaurantCheckManager {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double sale = 0;
        double tip = 0;
        double total = 0;
        int checks = 0;
        System.out.println("hi welcome to the check manager. you will have to enter check details one at a time");
        do {
            System.out.print("please enter the sale amount: ");
            double tempSale = in.nextDouble();
            System.out.print("please enter the tip amount (if blank, put 0): ");
            double tempTip = in.nextDouble();
            System.out.print("please enter the total amount (if blank, put 0): ");
            double tempTotal = in.nextDouble();
            //edge cases
            if(tempTotal == 0) {
                tempTotal = tempSale + tempTip;
            } else if(tempTotal < tempSale) {
                tempTip = 0;
                tempTotal = tempSale;
            } else if(tempTotal != tempSale + tempTip) {
                tempTip = tempTotal - tempSale;
            }
            sale += tempSale;
            tip += tempTip;
            total += tempTotal;
            checks += 1;
            System.out.printf("the total sales so far is $%.2f\nthe total tips so far is $%.2f\nthe number of checks is %d.\n", sale, tip, checks);
            in.nextLine();
            System.out.print("do you want to stop? ");
            String stop = in.nextLine();
            if(stop.equalsIgnoreCase("y") || stop.equalsIgnoreCase("yes")) {
                break;
            }
        } while(true);
        System.out.printf("you served %d people today.\nthe total sales amount is $%.2f\nthe total pooled tip amount is $%.2f\nthe total amount is $%.2f\n", checks, sale, tip, total);
        //tips
        System.out.print("how many servers were working today? ");
        int servers = in.nextInt();
        double serverTip = (tip * 0.6)/servers;
        double chefTip = tip * 0.125;
        double sousTip = tip * 0.075;
        double aidTip = tip * 0.05;
        double kitchenTip = chefTip + sousTip + aidTip;
        double busserTip = tip * 0.1;
        double hostTip = tip * 0.05;
        System.out.printf("of the $%.2f total tips:\neach server will get $%.2f\nthe kitchen will get $%.2f,\n  the chef receiving $%.2f\n  the sous chef receiving $%.2f\n  the kitchen aid receiving $%.2f\nthe busser will get $%.2f\nthe host will get $%.2f", tip, serverTip, kitchenTip, chefTip, sousTip, aidTip, busserTip, hostTip);
    }
}
