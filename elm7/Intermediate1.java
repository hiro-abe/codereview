package intermediate;

/**
 * 
 * 基数変換クラス
 * １０進数の数を２進数に変換
 * 
 * @author "hiro-abe"
 */
public class Intermediate1 {
	/**
	 * メインメソッド
	 * 実行時の引数srcを受け取り、２進数に変換する
	 * 
	 * @param src 実行時の引数。１０進数の値
	 * @return
	 */
	public static String toBinaryString(int src) {
		if (src < 0) {
			throw new IllegalArgumentException();
		}

		StringBuilder builder = new StringBuilder();
		while(true) {
			builder.append(src % 2);
			src /= 2;
			if(src <= 0){
				break;
			}
		}
		return builder.reverse().toString();
	}
}
