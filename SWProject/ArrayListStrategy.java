package SWProject;

import java.util.ArrayList;

public class ArrayListStrategy implements ISystemDataStrategy {
    private ArrayList<IPassenger> passengers;
    private ArrayList<IDriver> drivers;
    private ArrayList<IRegistrationRequest> registrations;
    private ArrayList<IOffer> offers;
    private ArrayList<IRide> rides;
    private ArrayList<IRating> ratings;
    private IAdmin admin;

    public ArrayListStrategy(){
        passengers = new ArrayList<IPassenger>();
        drivers = new ArrayList<IDriver>();
        registrations = new ArrayList<IRegistrationRequest>();
        offers = new ArrayList<IOffer>();
        rides = new ArrayList<IRide>();
        ratings = new ArrayList<IRating>();
        admin = new Admin("admin", "0000");
    }

    @Override
    public boolean displayAllRegistrations() {
        for(int i=0; i < registrations.size(); i++){
            System.out.println((i+1) +":"+ registrations.get(i));
        }
        if (registrations.size() == 0)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean addRegistrationRequest(IRegistrationRequest registrationRequest) {
        return registrations.add(registrationRequest);
    }

    @Override
    public boolean addDriver(IDriver driver) {
        return drivers.add(driver);
    }

    @Override
    public boolean addPassenger(IPassenger passenger) {
        return passengers.add(passenger);
    }
    
    @Override
    public boolean addOffer(IOffer offer) {
        return offers.add(offer);
    }

    @Override
    public boolean addRide(IRide ride) {
        return rides.add(ride);
    }

    @Override
    public boolean addRating(IRating rating) {
        return ratings.add(rating);
    }

    @Override
    public IRegistrationRequest getRegistrationRequest(int index) {
        return registrations.get(index);
    }

    @Override
    public IDriver getDriver(String username) {
        for (IDriver driver : drivers){
            if (driver.getPersonalInfo().getUsername().equals(username)){
                return driver;
            }    
        }
        return null;
    }

    @Override
    public IPassenger getPassenger(String username) {
        for (IPassenger passenger : passengers){
            if (passenger.getPersonalInfo().getUsername().equals(username)){
                return passenger;
            }              
        }
        return null;
    }

    @Override
    public IAdmin getAdmin(String username) {
        if (admin.getUsername().equals(username))
            return admin;
        return null;
    }

    @Override
    public ArrayList<IDriver> getDriversWithFavouriteArea(String area) {
        ArrayList<IDriver> driversWithFavouriteArea = new ArrayList<>();
        for (IDriver driver : drivers){
            if (driver.hasFavouriteArea(area)){
                driversWithFavouriteArea.add(driver);
            }
        }
        return driversWithFavouriteArea;
    }

    @Override
    public ArrayList<IOffer> getOffersOfPassenger(IPassenger passenger) {
        ArrayList<IOffer> offersOfPassenger = new ArrayList<>();
        for (IOffer iOffer : offers) {
            if (iOffer.getItsRide().getItsPassenger().equals(passenger))
                offersOfPassenger.add(iOffer);
        }
        return offersOfPassenger;
    }

    @Override
    public boolean removeRegisrationRequest(IRegistrationRequest registrationRequest) {
        return registrations.remove(registrationRequest);
    }
    
}