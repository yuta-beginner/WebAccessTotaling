package com.display;

import com.constraint.MessageConstraint;

public class DisplayManager implements MessageConstraint{
	
	// javadocは出力する。
	
	// 実行環境の改行コード取得
	// 改行コードを実行環境ごとの特定の文字列と思えば、固定値として扱える。（Java上のルール）
	private final String NEW_LINE_CODE = System.lineSeparator();
	
	/**
	 * 引数が足りない際のメッセージ
	 * @param なし
	 * @return なし
	 */
	public void showArgsNotEnoughMessage() {
		System.out.println(ARGS_NOT_ENOUGH_MESSAGE);
	}
	
	/**
	 * 引数が多すぎる際のメッセージ
	 * @param なし
	 * @retrun なし
	 */
	
	public void showArgsManyMessage() {
		System.out.println(ARGS_MANY_MESSAGE);
	}
	
	/**
	 * 引数で指定したログファイルが存在しないメッセージ
	 * @param なし
	 * @return なし
	 */
	public void showFileNotExistMessage() {
		System.out.println(FILE_NOT_EXIST);
	}
	
	/**
	 * 
	 * @param totalingLog
	 * @return なし
	 */
	public void showResultLog(String[] totalResult) {
		for (int i = 0; i < totalResult.length; i++) {
			System.out.print(totalResult[i]);
			if (i < totalResult.length - 1) {
				System.out.print("\t");
			}
		}
		// 実行環境に応じた改行
		System.out.print(NEW_LINE_CODE);
	}
}
