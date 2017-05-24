package I_Now_Java;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Find_Paliandron_Number {

	private static Logger logger = Logger.getLogger(Find_Paliandron_Number.class.getName());

	public static void main(String[] args) {

		// int multiplyResult = multiplyResult(658, 867);
		int maxNumber = 0;

		for (int i = 999; i >= 100; i--) {
			for (int j = 999; j >= 100; j--) {
				int multiplyResult = multiplyResult(i, j);
				if (maxNumber <= multiplyResult) {
					maxNumber = multiplyResult;
				}
				if (isPalindromic(maxNumber)) {
					logger.log(Level.INFO, "Max palindromic number is " + multiplyResult);
					return;
				}
			}

		}

	}

	public static boolean isPalindromic(int someNumber) {

		boolean isPalindromic = false;

		char[] numberElements = Integer.toString(someNumber).toCharArray();

		int numElementsLenght = numberElements.length / 2;

		int index = numberElements.length - 1;

		for (int i = 0; i < numElementsLenght; i++) {

			if (numberElements[i] == numberElements[index]) {
				index--;
				isPalindromic = true;
			} else {
				return false;
			}

		}

		return isPalindromic;
	}

	public static int multiplyResult(int numberOne, int numberTwo) {

		int result = 0;

		result = numberOne * numberTwo;

		return result;
	}
}
