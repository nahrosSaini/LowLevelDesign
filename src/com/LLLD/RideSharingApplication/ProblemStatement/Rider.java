package com.LLLD.RideSharingApplication.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class Rider extends Person{

    List<Ride> completedRides=new ArrayList<>();

    Ride currentRide=null;

    public Rider(String name) {
        this.name=name;
    }

    public void createRide(int id,int origin,int destination,int noOfSeats){
        if(origin>=destination){
            System.out.println("INVALID_INPUT : : please check the origin and destination values entered");
            return;
        }

        currentRide=new Ride();
        currentRide.setId(id);
        currentRide.setOrigin(origin);
        currentRide.setDestination(destination);
        currentRide.setNoOfSeats(noOfSeats);
        currentRide.setRideStatus(RideStatus.CREATED);

    }

    public void updateRide(int id,int origin,int destination,int noOfSeats){

        if(currentRide.getRideStatus() == RideStatus.WITHDRAWN){
            System.out.println("INVALID_UPDATE : : Can't update the ride. Ride was Withdrawn");
            return;
        }

        if(currentRide.getRideStatus() == RideStatus.COMPLETE){
            System.out.println("INVALID_UPDATE : : Can't update the ride. Ride was Completed");
            return;
        }

        createRide(id, origin, destination, noOfSeats);

    }

    public void withdrawRide(int id){

        if (currentRide.getId()!=id){
            System.out.println("INVALID_INPUT : : Wrong ride Id. Can't withdraw Ride");
            return;
        }

        if (currentRide.getRideStatus() != RideStatus.CREATED){
            System.out.println("INVALID_ATTEMPT : : Ride is in progress. Can't withdraw Ride");
            return;
        }

        currentRide.setRideStatus(RideStatus.WITHDRAWN);

    }

    public double closeRide(){

        if (currentRide.getRideStatus() != RideStatus.CREATED){
            System.out.println("INVALID_ATTEMPT : : Ride is in progress. Can't withdraw Ride");
            return 0;
        }

        currentRide.setRideStatus(RideStatus.COMPLETE);
        completedRides.add(currentRide);

        System.out.println(" Total Fare : "+ currentRide.calculateFare(completedRides.size() >=10));

        return currentRide.calculateFare(completedRides.size()>=10);

    }


}
