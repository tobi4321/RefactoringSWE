package classes;

import java.util.*;

public class Customer {
    
	private String name;
    
	private List<Rental> rentals = new ArrayList<>();
    
	public Customer (String name){
        this.name = name;
    };
    
    public void addRental(Rental rental) {
        rentals.add(rental);
    }
    
    public String getName (){
        return this.name;
    }
    
    public String statement() {
        
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        for(Rental rental : rentals) 
        {
        	result += "\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        }
        
        result += "Amount owed is " + String.valueOf(this.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(this.getTotalFrequentRenterPoints()) + " frequent renter points";
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
    private int getTotalFrequentRenterPoints() 
    {
    	int points = 0;
    	for(Rental rental : rentals) 
    	{
    		points += rental.getFrequentRenterPoints();
    	}
    	return points;
    }

}
    