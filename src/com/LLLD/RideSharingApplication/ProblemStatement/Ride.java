package com.LLLD.RideSharingApplication.ProblemStatement;

public class Ride {

    static final int AMT_PER_KM=20;

    int id;
    int origin;
    int destination;
    int noOfSeats;

    RideStatus rideStatus;

    public Ride() {
        id=0;
        origin=0;
        destination=0;
        noOfSeats=0;
        rideStatus=RideStatus.IDLE;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public int getId() {
        return id;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    //Custom functions

    public double calculateFare(boolean isPriorityRider){
        int distance=destination-origin;
        if(noOfSeats < 2 ){
            return distance * AMT_PER_KM * ((isPriorityRider)?0.75:1);
        }

        if (isPriorityRider){
            return  distance * noOfSeats * AMT_PER_KM *0.5;
        }

        //System.out.println("Price : "+distance * noOfSeats * AMT_PER_KM * 0.75);
        return distance * noOfSeats * AMT_PER_KM * 0.75;
    }


}
