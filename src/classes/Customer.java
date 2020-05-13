package classes;

import java.util.*;

public class Customer {
    
	private String name;
    
	private Vector<Rental> rentals = new Vector<Rental>();
    
	public Customer (String name){
        this.name = name;
    };
    
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }
    
    public String getName (){
        return this.name;
    }
    
    public String statement() {
        
    	double totalAmount = 0;
        int frequentRenterPoints = 0;
        
        Enumeration<Rental> enum_rentals = rentals.elements();	    
        
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            
            Rental rental = (Rental) enum_rentals.nextElement();

            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(rental.getCharge()) + "\n";
            totalAmount += rental.getCharge();
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }


    
    private double getTotalCharge() 
    {
    	double totalCharge = 0;
    	for(Rental rental : rentals) 
    	{
    		totalCharge = totalCharge + rental.getCharge();
    	}
    	return totalCharge;
    }

}
    