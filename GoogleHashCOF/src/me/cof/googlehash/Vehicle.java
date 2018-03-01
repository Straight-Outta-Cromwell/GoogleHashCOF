package me.cof.googlehash;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	
	private int[] currentPosition;
	private int[] targetPosition;
	private List<Ride> completedRides;
	private Ride currentRide;
	
	public Vehicle(){
		currentPosition = new int[]{0, 0};
		completedRides = new ArrayList<Ride>();
		
		// Find the first ride
		FindNewRide();
	}
	
	public void FindNewRide(){
		int highestReward = 0;
		Ride highestRide = null;
		
		for (Ride r : Main.rides){
			if (r.getIsFinished() && r.isPickedUp())
				continue;
			
			int reward = 0;
			int distancePoints = r.distance();
			int distanceToRide = GetDistance(currentPosition, r.getStartLoc());
			
			// The Ride cannot be completed on time
			if (distanceToRide + distancePoints + Main.CURRENT_TIME > r.getFinishTime())
				continue;
			
			reward += distancePoints;
			
			int arrivalTime = distanceToRide + Main.CURRENT_TIME;
			
			if (r.getStartTime() - arrivalTime > 2)
				continue;
			
			if (r.getStartTime() - arrivalTime == 0)
				reward += Main.BONUS_VALUE;
			
			if (reward > highestReward){
				highestReward = reward;
				highestRide = r;
			}
		}
		
		currentRide = highestRide;
		targetPosition = currentRide.getStartLoc();
		
	}
	
	public void MoveTowardsTarget(){
		if (currentPosition == targetPosition){
			if (targetPosition == currentRide.getStartLoc())
				targetPosition = currentRide.getFinishLoc();
			else if (targetPosition == currentRide.getFinishLoc()){
				currentRide.complete();
				FindNewRide();
			}
		}
		
		// Move Right
		if (currentPosition[0] < targetPosition[0]) // Move Right
			currentPosition[0]++;
		else if (currentPosition[0] > targetPosition[0]) // Move Left
			currentPosition[0]--;
		else if (currentPosition[1] < targetPosition[1]) // Move Up
			currentPosition[1]++;
		else if (currentPosition[1] > targetPosition[1]) // Move Down
			currentPosition[1]--;
	}
	
	private int GetDistance(int[] a, int[] b){
		return (int) Math.hypot(a[0] - b[0], a[1] - b[1]);
	}
	
	

}
