package app;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Enter with contract data ");
            
        System.out.print("Number of contract: ");            
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), dtf);

        System.out.print("Contract value: ");
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, date, totalValue);
        
        System.out.println("Enter the number of installments: ");
        int parcels = sc.nextInt();
            
        ContractService contractService = new ContractService(new PaypalService());
            
        contractService.proccessContract(contract, parcels);
        

        sc.close();
        
    }
}
