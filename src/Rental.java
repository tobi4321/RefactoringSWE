class Rental {
    
	private Movie movie;
    
	private int daysRented;
    
	public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    
	public int getDaysRented() {
        return daysRented;
    }
    
	public Movie getMovie() {
        return movie;
    }
	
    private double getCharge() {
        
    	double totalCharge = 0;
        
    	switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
            	totalCharge += 2;
                if (this.getDaysRented() > 2)
                	totalCharge += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
            	totalCharge += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
            	totalCharge += 1.5;
                if (this.getDaysRented() > 3)
                	totalCharge += (this.getDaysRented() - 3) * 1.5;
                break;
        }
        return totalCharge;
    }
}