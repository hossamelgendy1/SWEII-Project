package SWProject;

import java.util.ArrayList;


public class Driver implements IDriver, IUser {

    private DriverInfo personalInfo ;
    private ArrayList<String>favoriteAreas = new ArrayList<String>() ;
    private double averageRating = 0;
    private ArrayList<Rating> myRatings = new ArrayList<Rating> () ;
    private ArrayList<Offer>myOffers = new ArrayList<>() ;
    private ArrayList<Ride>favoriteAreaRides = new ArrayList<>() ;


    

    public Driver(DriverInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    @Override
    public void setSuspended(boolean isSuspended) {
        personalInfo.setSuspended(isSuspended);
    }

    public ArrayList<Offer> getMyOffers() {
        return myOffers;
    }

    public void setMyOffers(ArrayList<Offer> myOffers) {
        this.myOffers = myOffers;
    }

    public ArrayList<Rating> getMyRatings() {
        return myRatings;
    }

    public void setMyRatings(ArrayList<Rating> myRatings) {
        this.myRatings = myRatings;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public UserInfo getPersonalInfo() {
        return personalInfo;
    }

    @Override
    public boolean hasFavouriteArea(String area) {
        for(int i = 0 ; i < favoriteAreas.size() ; ++i){
            if( area == favoriteAreas.get(i) ){
                return true ;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Driver [averageRating=" + averageRating + ", favoriteAreaRides=" + favoriteAreaRides
                + ", favoriteAreas=" + favoriteAreas + ", myOffers=" + myOffers + ", myRatings=" + myRatings
                + ", personalInfo=" + personalInfo + "]";
    }

    @Override
    public void recieveRideNotification(Ride ride) {
        this.favoriteAreaRides.add(ride) ;        
    }

    @Override
    public void setPersonalInfo(UserInfo info) {
        this.personalInfo = (DriverInfo) info ;
    }

    @Override
    public void addFavoriteArea(String name) {
        favoriteAreas.add(name) ;        
    }

    @Override
    public void listRidesInFavouriteAreas() {     
        System.out.println(favoriteAreaRides);
    }

    @Override
    public void suggestPrice(Ride ride, double price) {       
        Offer offer = new Offer() ;
        offer.setPrice(price);
        ride.recieveOffer(offer);
    }

    @Override
    public void listRating() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void recieveRating(Rating rating) {
        this.myRatings.add(rating) ; 
        for(int i = 0 ; i < myRatings.size() ; ++i){
            this.averageRating += myRatings.get(i).getValue() ;
        }       
        this.averageRating /= myRatings.size() ;
    }

    @Override
    public void viewMyOffers() {
        System.out.println(myOffers);        
    }

}
