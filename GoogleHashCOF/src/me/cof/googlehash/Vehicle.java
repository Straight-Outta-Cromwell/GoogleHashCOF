package me.cof.googlehash;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {

	private int[] currentPosition;
	private int[] targetPosition;
	private List<Ride> completedRides;
	private Ride currentRide;

	public Vehicle() {
		currentPosition = new int[] { 0, 0 };
		targetPosition = new int[2];
		completedRides = new ArrayList<Ride>();

		// Find the first ride
		FindNewRide();
	}

	public void FindNewRide() {
		// Reset the current Ride, making sure it does not try and complete the same
		// ride twice
		targetPosition = new int[2];
		currentRide = null;

		Ride chosenRide = null;

		chosenRide = FindBestRideFrom(currentPosition);

		// We have found a ride, assign it and give the vehicle the start location
		if (chosenRide != null) {
			currentRide = chosenRide;
			targetPosition[0] = currentRide.getStartLoc()[0];
			targetPosition[1] = currentRide.getStartLoc()[1];
			currentRide.setIsPickedUp();

			// Remove the chosen ride from the list of rides
			Main.rides.remove(chosenRide);
		}

	}

	private Ride FindBestRideFrom(int[] position) {
		int earliestStart = 999;
		Ride earliestStartRide = null;
		int mostPoints = 0;
		Ride mostPointsRide = null;
		int closestStart = 999;
		Ride closestStartRide = null;

		// Loop through every uncompleted ride
		for (Ride r : Main.rides) {
			int lengthOfRide = r.distance(); // How long the ride is
			int distanceFromRide = GetDistance(currentPosition, r.getStartLoc()); // How far away are we from the ride
			int arrivalTime = distanceFromRide + Main.CURRENT_TIME; // At what time will we get to the ride
			int finishTime = arrivalTime + lengthOfRide; // What time will we finish the ride
			int waitTime = r.getStartTime() - arrivalTime;
			int points = 0;

			// Can we finish the job on time, if not. Skip it
			if (finishTime > r.getFinishTime())
				continue;

			// How many points would we get for this ride?

			// Would we get the start bonus
			if (arrivalTime <= r.getStartTime())
				points = 1;

			// Add the length of the ride to the points
			//points += lengthOfRide;

			// Is this ride starting first
			if (r.getStartTime() < earliestStart) {
				earliestStart = r.getStartTime();
				earliestStartRide = r;
			}

			// Does this ride give us the most points
			if (points > mostPoints) {
				mostPoints = points;
				mostPointsRide = r;
			}
			
			// Is this ride the closest to us
			if (((distanceFromRide + waitTime - points)) < (closestStart * 3)) {
				closestStart = distanceFromRide;
				closestStartRide = r;
			}
		}

		return closestStartRide;
	}

	private int GetPointValueForRide(Ride r) {
		int lengthOfRide = r.distance(); // How long the ride is
		int distanceFromRide = GetDistance(currentPosition, r.getStartLoc()); // How far away are we from the ride
		int arrivalTime = distanceFromRide + Main.CURRENT_TIME; // At what time will we get to the ride
		int points = 0;

		// Would we get the start bonus
		if (arrivalTime <= r.getStartTime())
			points += Main.BONUS_VALUE;

		// Add the length of the ride to the points
		points += lengthOfRide;
		
		return points;
	}

	public void MoveTowardsTarget() {
		// Make sure we have a ride
		if (currentRide == null)
			return;

		// Have we reached our destination
		if (currentPosition[0] == targetPosition[0] && currentPosition[1] == targetPosition[1]) {

			// Is the vehicle at the finish location
			if (targetPosition[0] == currentRide.getFinishLoc()[0]
					&& targetPosition[1] == currentRide.getFinishLoc()[1]) {
				// Complete the ride, and find a new one
				Main.COMPLETED_RIDES++;
				currentRide.complete();
				completedRides.add(currentRide);
				FindNewRide();
				return;
			}

			// Is the vehicle at the start location
			if (targetPosition[0] == currentRide.getStartLoc()[0]
					&& targetPosition[1] == currentRide.getStartLoc()[1]) {

				// If the ride cannot be started yet, wait
				if (Main.CURRENT_TIME < currentRide.getStartTime())
					return;

				// Start the ride
				targetPosition[0] = currentRide.getFinishLoc()[0];
				targetPosition[1] = currentRide.getFinishLoc()[1];
			}
		}

		if (currentPosition[0] < targetPosition[0]) // Move Right
			currentPosition[0]++;
		else if (currentPosition[0] > targetPosition[0]) // Move Left
			currentPosition[0]--;
		else if (currentPosition[1] < targetPosition[1]) // Move Up
			currentPosition[1]++;
		else if (currentPosition[1] > targetPosition[1]) // Move Down
			currentPosition[1]--;
	}

	public int GetDistance(int[] a, int[] b) {
		return Math.abs((a[0] - b[0])) + Math.abs((a[1] - b[1]));
	}

	public List<Ride> getCompletedRides() {
		return completedRides;
	}

	public int getAmountOfRides() {
		return completedRides.size();
	}

}
