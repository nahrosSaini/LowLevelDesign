package com.LLLD.RideSharingApplication.ProblemStatement;

public class RideSharingApplication {

    public static void main(String args[]){

        Rider rider=new Rider("lucifer");
        Driver driver=new Driver("Daniel");

        rider.createRide(1,50,60,1);
        rider.closeRide();

        rider.updateRide(1,50,60,2);
        rider.closeRide();

        System.out.println("********------------------------------------**********");

        rider.createRide(1,50,60,1);
        rider.withdrawRide(1);
        rider.updateRide(1,50,60,2);
        rider.closeRide();

        System.out.println("********------------------------------------**********");

        rider.createRide(1,50,60,1);
        //rider.withdrawRide(1);
        rider.updateRide(1,50,60,2);
        rider.closeRide();

    }

}
