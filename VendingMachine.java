public class VendingMachine {
    private int numberQuarters;
    private int numberDimes;
    private int numberNickels;
    private double moneyInsertedByCustomer;
    private static final boolean TESTING  = true;
    
    public VendingMachine()
    {
        numberQuarters = 20;
        numberDimes = 35;
        numberNickels = 10;
        moneyInsertedByCustomer = 0;
    }

    public VendingMachine(int pNumberQuarters, int pNumberDimes, int pNumberNickels)
    {
        numberQuarters = pNumberQuarters;
        numberDimes = pNumberDimes;
        numberNickels = pNumberNickels;
        moneyInsertedByCustomer = 0;
    }

    public void insertQuarter()
    {
        numberQuarters += 1;
        moneyInsertedByCustomer = moneyInsertedByCustomer + 0.25;
    }

    public void insertDime()
    {
        numberDimes += 1;
        moneyInsertedByCustomer = moneyInsertedByCustomer + 0.10;
    }

    public void insertNickel()
    {
        numberNickels += 1;
        moneyInsertedByCustomer = moneyInsertedByCustomer + 0.05;
    }
    
    public double getTotalChange()
    { 
        double quartersCalculation = numberQuarters * 0.25;
        double dimesCalculation = numberDimes * 0.10;
        double nickelsCalculation = numberNickels * 0.05;
        double totalChangeInMachine = quartersCalculation + dimesCalculation + nickelsCalculation;
        return totalChangeInMachine;
    }

    public boolean canDispense(double changeDue)
    {
        double totalChangeMachine = getTotalChange();
        if (totalChangeMachine >= changeDue)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void dispenseChange(double changeDue)
    {   int quartersChange = 0;
        int dimesChange = 0;
        int nickelsChange = 0;
        
        if (canDispense(changeDue)) 
        {   quartersChange = (int) (changeDue / 0.25); 
            double DimesIntermediate = changeDue - (quartersChange * 0.25);
            dimesChange = (int)(DimesIntermediate / 0.10);
            double NickelsIntermediate = changeDue - ((quartersChange * 0.25) + (dimesChange * 0.10));
            nickelsChange = (int) (Math.round(NickelsIntermediate / 0.05));
            
            if(quartersChange > 0 && dimesChange > 0 && nickelsChange > 0) 
            {   
                System.out.println(quartersChange+ " quarter(s), " + dimesChange + " dime(s), " + nickelsChange + " nickel(s)");
            }
            else if(quartersChange == 0 && dimesChange > 0 && nickelsChange > 0)  
            {
                System.out.println(dimesChange + " dime(s), " + nickelsChange + " nickel(s)"); 
            }
            else if(quartersChange > 0 && dimesChange == 0 && nickelsChange > 0) 
            {  
                System.out.println(quartersChange + " quarter(s), " + nickelsChange + " nickel(s)");
            }
            else if(quartersChange > 0 && dimesChange > 0 && nickelsChange == 0)
            {
                System.out.println(quartersChange + " quarter(s), " + dimesChange + " dime(s)");
            }
            else if(quartersChange == 0 && dimesChange == 0 && nickelsChange > 0)
            {
                System.out.println(nickelsChange + " nickel(s)");
            }
            else if(quartersChange > 0 && dimesChange == 0 && nickelsChange == 0)
            {
                System.out.println(quartersChange + " quarter(s)");
            }
            else if(quartersChange == 0 && dimesChange > 0 && nickelsChange == 0)
            {
                System.out.println(dimesChange + " dime(s)");
            }
            else if (quartersChange == 0 && dimesChange == 0 && nickelsChange == 0)
            {
                System.out.println("No change");
            }
        } 
        else
        {
            System.out.println("Out of order");
        } 

        numberDimes = numberDimes - dimesChange;  
        numberNickels = numberNickels - nickelsChange; 
        numberQuarters = numberQuarters - quartersChange;  
        
    }    
    
    public void selectItem(int itemNumber)
    {
        double itemPrice = 0.00;
        String itemName = "";
       
        if (itemNumber == 1)
        {
            itemPrice = 0.45;
            itemName = "Snickers bar";
        }
        else if (itemNumber == 2)
        {
            itemPrice = 0.60;
            itemName = "M&M candy";
        }
        else if (itemNumber == 3)
        {
            itemPrice = 0.15;
            itemName = "York peppermint";
        }
        else if (itemNumber == 4)
        {
            itemPrice = 0.80;
            itemName = "BBQ chips";
        }
        if(TESTING){
            System.out.println("Money inserted by the customer is: " + moneyInsertedByCustomer);
        }
        
        if (moneyInsertedByCustomer >= itemPrice)
        {
            System.out.println(itemName);
            double changeDue = moneyInsertedByCustomer - itemPrice;
            dispenseChange(changeDue);
            
        }
        else
        {
            System.out.println("Insufficient amount");
        }
    }
}