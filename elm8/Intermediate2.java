package intermediate;

import java.util.ArrayList;

/**
 * 重複を取り除いた配列を返すクラス
 * 
 * @author "hiro-abe"
 * 
 */
public class Intermediate2 {
	/*
	 * 実行時の引数srcを受け取り、値の重複を取り除く
	 * 
	 * @param src 実行時の引数。１０進数の数値
	 * 
	 * @return 値が０の場合は配列をそのまま返す。それ以外は重複した値を除いた配列を返す。
	 * @throws NuLLPointerException nullが渡された場合に例外を投げる
	 */
	public static int[] uniq(int[] src) {
		
		if (src == null) {
			throw new NullPointerException();
		}
		if (src.length == 0) {
			return src;
		}

		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(src[0]);
		for (int i = 1; i < src.length; i++) {
			if (src[i] != src[i - 1]) {
				array.add(src[i]);
			}
		}
		int matcher[] = new int[array.size()];
		for (int i = 0; i < array.size(); i++) {
			matcher[i] = array.get(i);
		}
		return matcher;
	}
}
