import java.util.Arrays; 

public class BackEnd {
	
	//Some constants FOR THIS PROBLEM!
	public static final int	   N_TITLES				= 7;
	public static final double BOOK_PRICE 			= 42.0;
	public static final int    MAX_DISCOUNT_GROUP 	= 5;
	public static final double DISCOUNT_STEP  		= 0.05;
	
	
	//Results of the computation
	private double totalPrice 		= 0.0;
	private double discount			= 0.0;
	private double discountValue	= 0.0;
	private double finalPrice		= 0.0;
	
	/*
	 * Return the amount of discount based in the amount of different titles
	 */
	private double getDiscoutTitle (int nTitles) {
		int reducedTitles = nTitles-1;
		return (reducedTitles<5)? reducedTitles*DISCOUNT_STEP:(MAX_DISCOUNT_GROUP-1*DISCOUNT_STEP);
	}
	
	/*
	 * Sum all elements of the array
	 */
	private int arraySum (int array[]) {
		int sum = 0;
		for(int element : array) { sum += element;}
		return sum;
	}
	
	/*
	 * Count the non-zeros values of the array
	 */
	private int arrayCountNonZero (int array[]) {
		int nonzeros = 0;
		for(int element : array) {if (element != 0) {nonzeros++;}}
		return nonzeros;
	}
	
	/*
	 * Reverse an array
	 */
	private void arrayReverse (int array[]) {
		int aux, length = array.length;
		for(int i = 0; i < length/2; i++) {
			aux = array[i]; array[i] = array[length-i-1]; array[length-i-1] = aux;
		}
	}
	
	/*
	 * Compute the discount based in the rules
	 */
	private double computeDiscount (int books[]) {
		//Get some important infos of the purchase.
		int nBooks  = arraySum(books);
		int nTitles = arrayCountNonZero(books);
		
	    //Discount's array
	    double[] discounts = new double[N_TITLES-MAX_DISCOUNT_GROUP+1];
	    int[]    discWeig  = new int[N_TITLES-MAX_DISCOUNT_GROUP+1];

	    //Iterate over the titles until the number of titles is less then the maximum discount so aplly the maximum discount.
	    int i = 0; int pivot;
	    while(nTitles > 0) {
	        //Check if there is more title than the maximum discount
	        if(nTitles <= MAX_DISCOUNT_GROUP) {
	            //The discount will be the amount of titles.
	            discounts[i] = getDiscoutTitle(nTitles);
	            discWeig [i] = arraySum(books);
	            break;
	        } else {
	            //Is necessary to create a group of discounts.
	            //First ordering the vector. Highest -> Lowest
	            Arrays.sort(books); arrayReverse(books);
	            //Get the pivot in the last position of the group to get the maximum discount.
	            pivot = books[MAX_DISCOUNT_GROUP-1];
	            //Subtract all the position of the group.
	            for(int j = 0; j < MAX_DISCOUNT_GROUP; j++) {
	            	books[j] -= pivot;
	            }
	            //Store the discount and the weight.
	            discounts[i] = getDiscoutTitle(MAX_DISCOUNT_GROUP);
	            discWeig[i] = pivot*MAX_DISCOUNT_GROUP;
	        }
	            
	        //Recompute the n_title and iterate
	        nTitles = arrayCountNonZero(books);
	        i += 1;
	    }
	    
	    //Aplly the weight in the discounts and get the final discount.
	    double final_discount = 0.0;
	    for(i=0; i<(N_TITLES-MAX_DISCOUNT_GROUP+1); i++) {
	    	final_discount += discounts[i] * discWeig[i];
	    }
	    return (final_discount/(double) nBooks);
	}
	
	/*
	 * Compute totalPrice
	 */
	public void computeTotalPrice(int books[]){
		this.totalPrice = (double) arraySum(books) *  BOOK_PRICE;
	}
	
	/*
	 * Compute totalPrice
	 */
	public void computeAll (int books[]) {
		computeTotalPrice(books);
		this.discount 		= computeDiscount(books);
		this.discountValue 	= this.totalPrice*this.discount;
		this.finalPrice 	= this.totalPrice - this.discountValue;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public double getDiscountValue() {
		return discountValue;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

}
