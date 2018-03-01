package me.cof.googlehash;

public class Ride {
	
	private int startTime; // Earliest start
	private int finishTime; // Latest finish
	private int[] startLoc = new int[2]; // [start row, start column]
	private int[] finishLoc = new int[2]; // [finish row, finish column]
	
	public Ride(int startTime, int finishTime, int[] startLoc, int[] finishLoc){ 
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.startLoc = startLoc;
		this.finishLoc = finishLoc;
		
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

	
