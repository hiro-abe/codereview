import java.util.Calendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * カレンダークラス
 * 年と月を入力し、カレンダー（曜日と日にち）を揃えて表示する
 * 
 * author "hiro-abe"
 */
public class Calendar_abe {
	/**
	 * メインメソッド
	 *
	 */
	public static void main(String arg[]){

		//ユーザによる年と月の入力
		String str;
		int year, month;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("カレンダーを出力します。\n年を入力してください。");

		try {
			str = br.readLine();
			year = Integer.parseInt(str);
			System.out.println("月を入力してください");
			str = br.readLine();
			month = Integer.parseInt(str);
		}catch(NumberFormatException e){
			System.out.println("入力形式が正しくありません。");
			return;
		}catch(IOException e) {
			System.out.println("入力形式が正しくありません。");
			return;
		}
		//年の入力範囲が正しいかの判定(1〜)
		if (year < 1){
			System.out.println("年は自然数を入力してください。");
			return;
		}
		//月の入力範囲が正しいかの判定(1月〜１２月)
		if (month > 12 && month < 1){
			System.out.println("月は1〜１２の間で入力してください。");
			return;
		}
		System.out.println("年：" + year + "　月：" + month);

		//カレンダークラスのインスタンス作成
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month-1,1);
		int startDotw = getStartDotw(calendar);
		int maxDate = getMaxDate(calendar);
		//曜日を表示
		System.out.println("日 月 火 水 木 金 土");
		//最初の日を表示するまでの間隔を作成
		makeSpace(startDotw);
		//日数表示
		displayDate(startDotw-1,maxDate);
		System.out.println();
	}

	public static int getStartDotw(Calendar calendar){
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	public static int getMaxDate(Calendar calendar){
		return calendar.getActualMaximum(Calendar.DATE);
	}

	public static void makeSpace(int startDotw){
		for(int i=1; i<startDotw; i++){
			System.out.print("   ");
		}
	}

	/**
	 * 曜日に合わせて日付を表示
	 * 
	 * @param startDotw　月初めの曜日
	 * @param maxDate 最終日
	 */
	public static void displayDate(int startDotw , int maxDate){
		for (int i=1; i <= maxDate;){
			for(int j=1; (j+startDotw) <= 7 && i <= maxDate; j++){
				if(i < 10){
					System.out.print(" ");
				}
				System.out.print(i+" ");
				i++;

			}
			if (startDotw != 0){
				startDotw = 0;
			}
			System.out.println();
		}
	}
}