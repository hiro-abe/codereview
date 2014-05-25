import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 素数クラス
 * 最大値を入力し、その値までの素数を表示する
 * 
 * @param count   配列pNumのインデックス
 * @param maxEra 最大値（ユーザからの入力）
 * @auther "hiro-abe"
 */
public class EratosthenesAbe {

	static int count = 0;
	static int maxEra = 0;

	/*
	 * メインメソッド
	 * @param arg 実行時の引数
	 */
	public static void main(String arg[]) {

		try {
			setMaxEra();
		} catch (NumberFormatException e) {
			System.out.println("不正な値が入力されました");
			return;
		} catch (IOException e) {
			System.out.println("不正な値が入力されました");
			return;
		}

		//自然数であるかの判定
		if (maxEra < 0) {	
			System.out.println("自然数を入力してください");
			return;
		}

		// 素数を格納する配列を用意
		int pNum[] = new int[maxEra];

		getPNum(pNum);
		printPNum(pNum);
	}

	/**
	 * ユーザの入力
	 * 
	 * @throws NumberFormatException　ユーザからの入力値が数字以外の時にthrow
	 * @throws IOException　
	 */
	private static void setMaxEra() throws NumberFormatException , IOException{
		System.out.println("素数リストを出力するプログラムです。\nリストの最大値を整数で入力してください");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		maxEra = Integer.parseInt(str);
	}

	/**
	 * 素数かどうかの判定
	 * 素数である場合は配列に格納
	 * @param pNum 素数を格納するための配列
	 * @return pNum
	 */
	private static int[] getPNum(int[] pNum) {

		if (maxEra < 2) {
			return pNum;
		}
		pNum[count] = 2;
		count++;
		for(int i = 3; i <= maxEra; i+=2) {
			boolean judgePNflag = true;
			for (int j = 2; j < i; j++) {
				if ((i % j) == 0) {
					judgePNflag = false;
					break;
				}
			}
			if (judgePNflag) {
				pNum[count] = i;
				count++;
			}
		}
		return pNum;
	}

	/**
	 * 素数の表示
	 * 
	 * @param pNum 素数を格納する配列
	 */
	private static void printPNum(int[] pNum) {
		for (int i=0; i < count; i++) {
			System.out.print(pNum[i] + " ");
		}
	}
}