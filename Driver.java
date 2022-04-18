public class Driver{

    public static void main(String[] args){
        VendingMachine vm = new VendingMachine();
        vm.insertQuarter(); 
        vm.insertDime();
        vm.insertNickel();
        vm.insertNickel();
       
       
        System.out.println("The selected item is BBQ Chips of 0.80 value");
        vm.selectItem(4);
        
        System.out.println("The selected item is York peppermint of 0.15 value");
        vm.selectItem(3);
        
        System.out.println("The selected item is Snickers of 0.45 value");
        vm.selectItem(1);
        
        System.out.println("The selected item is M&M Candy of 0.60 value");
        vm.selectItem(2);
        
    }
}