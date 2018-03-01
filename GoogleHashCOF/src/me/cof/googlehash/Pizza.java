package me.cof.googlehash;

public class Pizza {
	
	private int width;
	private int height;
	private int numIngr; // Amount of each, Tomato and Mushroom
	private int maxSliceSize; // In cells
	
	private char[][] cells; // T - Tomato, M - Mushroom
	
	public Pizza(String filePath){
		
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getNumIngr() {
		return numIngr;
	}

	public void setNumIngr(int numIngr) {
		this.numIngr = numIngr;
	}

	public int getMaxSliceSize() {
		return maxSliceSize;
	}

	public void setMaxSliceSize(int maxSliceSize) {
		this.maxSliceSize = maxSliceSize;
	}

	public char[][] getCells() {
		return cells;
	}

	public void setCells(char[][] cells) {
		this.cells = cells;
	}
	
	
}
