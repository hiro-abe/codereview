import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * じゃんけんクラス
 * じゃんけんの手を数字で選択し、コンピュータと対戦する
 * 
 * @author "hiro-abe"
 */
public class RPS {
	static final int ROCK_NUM = 1;
	static final int PAPER_NUM = 2;
	static final int SCISSORS_NUM = 3;
	/*
	 * メインメソッド
	 * 
	 * @param 実行時の引数
	 */
	public static void main(String[] args) {

		System.out.println("じゃんけんをしましょう！");
		System.out.println("１：グー、　２：チョキ　３：パー");
		int userHand = 0;
		Random rdm = new Random();

		// ユーザの手の入力
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean isFinish = false;
		while (!isFinish) {
			try {
				// コンピュータの手（ランダム）
				int comHandNum = rdm.nextInt(3) + 1;
				//ユーザの手（入力）
				String str = br.readLine();
				userHand = Integer.parseInt(str);
				//正しい入力範囲かの確認
				if (userHand == ROCK_NUM || userHand == PAPER_NUM || userHand == SCISSORS_NUM) {
					// 出した手を確認
					System.out.println("あなたは：" + getHandName(userHand) + "　コンピュータは：" + getHandName(comHandNum));
					// 終了と勝ち負けの判定
					isFinish = isNotDraw(userHand, comHandNum);
				} else {
					System.out.println("１〜３で入力してください！");
				}
			} catch (NumberFormatException e) {
				System.out.println("１〜３で入力してください！");
			} catch (IOException e) {
				System.out.println("予期せぬエラーが発生しました");
				return;
			}
		}

	}

	static String getHandName(int hand) {
		switch (hand) {
		case ROCK_NUM:
			return "グー";
		case PAPER_NUM:
			return "チョキ";
		case SCISSORS_NUM:
			return "パー";
		default:
			return "";
		}
	}
	/*
	 *終了判定と勝ち負けの判定を行う。
	 *ユーザの勝ちor負けならtrueを、あいこならfalseを返す
	 *
	 *@param userHand ユーザの手
	 *@param comHnad コンピュータの手
	 */
	static boolean isNotDraw(int userHand, int comHand) {
		if (userHand == comHand) {
			indicateResult("あいこ\nあいこで。。。");
			return false;
		} else if ((userHand - comHand + 3) % 3 == 1) {
			indicateResult("コンピュータの勝ち");
			return true;
		} else {
			indicateResult("あなたの勝ち");
			return true;
		}
	}
	static void indicateResult(String result) {
		System.out.println("結果は。。。" + result);
	}
}