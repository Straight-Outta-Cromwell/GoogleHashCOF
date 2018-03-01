package me.cof.googlehash;

public class Ride {

	private int rideNum;
	private static int RIDE_NUMBER; // Concurrent number of ride
	private final int startTime; // Earliest start
	private final int finishTime; // Latest finish
	private int[] startLoc = new int[2]; // [start row, start column]
	private int[] finishLoc = new int[2]; // [finish row, finish column]
	private boolean isFinished = false; // IF the ride has been completed
	private boolean isPickedUp = false;
	private int pickUpTime; // Time ride is picked up
	
	public Ride(int startTime, int finishTime, int[] startLoc, int[] finishLoc) {
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.startLoc = startLoc;
		this.finishLoc = finishLoc;
		rideNum = RIDE_NUMBER + 1;
		RIDE_NUMBER = rideNum;	

	}
	
	public void complete() {
		
		if(startTime == pickUpTime) {
			Main.POINTS += Main.BONUS_VALUE + distance() ;
			
		} else {
			Main.POINTS += distance();
		}
		
	}
	
	public int distance() {
		return (finishLoc[0] - startLoc[0]) + (finishLoc[1] - startLoc[1]);
	}
	
	public void setPickUpTime(int time) {
		this.pickUpTime = time;
	}
	
	public int getPickUpTime() {
		return pickUpTime;
	}
	
	public void setIsPickedUp() {
		isPickedUp = true;
	}
	
	public boolean isPickedUp(){
		return isPickedUp;
	}

	public void setIsFinished() {
		isFinished = true;
	}

	public boolean getIsFinished() {
		return isFinished;
	}

	public int getRideNum() {
		return rideNum;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public int[] getStartLoc() {
		return startLoc;
	}

	public int[] getFinishLoc() {
		return finishLoc;
	}

}
