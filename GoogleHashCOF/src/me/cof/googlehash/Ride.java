package me.cof.googlehash;

public class Ride {
	
	private int rideNum; 
	private static int RIDE_NUMBER; // Concurrent number of ride
	private final int startTime; // Earliest start
	private final int finishTime; // Latest finish
	private int[] startLoc = new int[2]; // [start row, start column]
	private int[] finishLoc = new int[2]; // [finish row, finish column]
	
	public Ride(int startTime, int finishTime, int[] startLoc, int[] finishLoc){ 
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.startLoc = startLoc;
		this.finishLoc = finishLoc;
		rideNum = RIDE_NUMBER +1;
		RIDE_NUMBER = rideNum;
		
		
		
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

	
