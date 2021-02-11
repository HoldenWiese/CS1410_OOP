package a3;

import java.util.Arrays;
import java.util.Scanner;

public class SmoothSounds {

	/**
	 * This method returns a double[] of our .wav audio file.
	 * 
	 * @return A double[] of "asyouwish.wav".
	 */
	public static double[] loadSound() {
		double[] samples = StdAudio.read("asyouwish.wav");
		return samples;
	}

	/**
	 * This method takes a double[]. Then it calls the play method from StdAudio
	 * class to play a sound using double[] sounds param.
	 * 
	 * @param sound This is a double[] containing an encoded sound.
	 */
	public static void playSound(double[] sound) {
		StdAudio.play(sound);
	}

	/**
	 * This method uses a scanner to collect an int input from the user.
	 * 
	 * @return int that the user types in
	 */
	public static int getIntFromUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a non-negative integer and press enter:");
		int userInt = input.nextInt();
		input.close();
		return userInt;
	}

	/**
	 * This method will repeatedly smooth a double array by averaging each element
	 * by it's surrounding elements. This method utilizes the Loops.smoothArray
	 * method. A new array is returned from this method.
	 * 
	 * @param array This is the array that we will use to create a smoothed version.
	 * @param n This is the number of time the array will be smoothed.
	 * @return A new double[] is returned. The input array is not altered.
	 */
	public static double[] repeatedlySmooth(double[] array, int n) {
		double[] smoothedArray = Loops.smoothArray(array);
		for (int i = 0; i < n - 1; i++) {
			smoothedArray = Loops.smoothArray(smoothedArray);
		}

		if (n == 0) {
			return array;
		} else {
			return smoothedArray;
		}
	}

	public static void main(String[] args) {
		System.out.println("How many times do you want to smooth the audio file?");
		int userInput = getIntFromUser();
		playSound(loadSound());
		double[] smoothSound = repeatedlySmooth(loadSound(), userInput);
		playSound(smoothSound);
	}
}
