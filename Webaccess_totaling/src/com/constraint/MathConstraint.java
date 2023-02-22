package com.constraint;

public interface MathConstraint {
	/** 出力結果を5分前に設定するための変数 */
	public final int MINUS_FIVE_MINUTES = -5;
	/** アクセス完了するまで1秒 */
	public final int THOUSAND_MILLI_SECONDS = 1000;
	/** アクセス完了するまで5秒 */
	public final int FIVE_THOUSAND_MILLI_SECONDS = 5000;
	/** 集計対象のログの中で最新のもの */
	public final int LATEST_LOG_NUMBER = 0;
	/** アクセス完了するまでにかかった時間が格納されたインデックス */
	public final int ACCESS_COMPLETE_TIME_INDEX = 2;
	public final int ONE_DAY = 1;
	public final int ZERO_HOUR = 0;
	public final int FIVE_MINUTES = 5;
	public final int TASK_TERM = 300000;
	/** 必要となる引数の個数 */
	public final int NEEDED_ARGS_SIZE = 1;
	/** 引数が0個の際に使用する定数 */
	public final int ZERO_ARGS_SIZE = 0;
	/** 集計対象のログファイルが格納されているArgsのインデックス */
	public final int ARGS_FILE_INDEX = 0;
}
