/**
 * ヒストグラムクラス 実行時に引数を指定
 * その数だけ＊を表示し、ヒストグラムを表現
 * 
 * @author "hiro-abe"
 */
public class HistogramAbe {
	/**
	 * メインメソッド
	 * 
	 * @param arg 実行時の引数
	 */
	public static void main(String arg[]) {
		int inputArray[] = null;
		try {
			inputArray = parseIntArray(arg);
		} catch (NumberFormatException e) {
			System.out.println("引数に指定できるのは数値のみです");
			return;
		} catch (IllegalArgumentException e) {
			System.out.println("引数に指定できるのは自然数（正の整数）のみです");
			return;
		}
		int currentMax = maxValue(inputArray);
		printAsterisk(currentMax, inputArray);
	}
	/**
	 * 実行時の引数をString型からint型へ変換する関数
	 * 
	 * @param arg　実行時の引数の配列(String型)
	 * @return　int型へ変換した実行時の引数
	 * @throws NumberFormatException 引数が数字以外の場合
	 * @throws IllegalArgumentException 引数が0以下の場合
	 */
	private static int[] parseIntArray(String arg[]) throws NumberFormatException {
		int inputArray[] = new int[arg.length];
		for (int i = 0; i < arg.length; i++) {
			inputArray[i] = Integer.parseInt(arg[i]);
			if (inputArray[i] < 1) {
				throw new IllegalArgumentException();
			}
		}
		return inputArray;
	}
	
	/**
	 * inputArrayの最大値をcurrentMaxへ代入する関数
	 * 
	 * @param inputArray 変換後の実行時の引数の配列(int型)
	 * @return 実行時の引数の最大値
	 */
	private static int maxValue(int inputArray[]) {
		int currentMax = 0;
		for (int data : inputArray) {
			currentMax = Math.max(currentMax, data);
		}
		return currentMax;
	}
	
	/**
	 * アスタリスクを表示して、ヒストグラムを表現する関数
	 * 
	 * @param currentMax　実行時の引数の最大値
	 * @param inputArray　後の実行時の引数の配列
	 */
	private static void printAsterisk(int currentMax, int inputArray[]) {
		int t = currentMax;
		for (int i = 0; i < currentMax; i++) {
			for (int j = 0; j < inputArray.length; j++) {
				if (inputArray[j] >= t) {
					System.out.print("＊　");
				} else {
					System.out.print("　　");
				}
			}
			System.out.println();
			t--;
		}

	}
}