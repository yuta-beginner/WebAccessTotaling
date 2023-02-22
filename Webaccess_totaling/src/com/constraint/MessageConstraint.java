package com.constraint;

public interface MessageConstraint {
	public final String ARGS_NOT_ENOUGH_MESSAGE = "引数が足りません。集計対象のログファイルの絶対パスを引数として渡してください。";
	public final String ARGS_MANY_MESSAGE = "引数が多すぎます。一度に集計できるのは1つのファイルのみです。";
	public final String FILE_NOT_EXIST = "引数で指定したログファイルがありません。";
	// propertyファイルでまとめてしまう方がいい。=>お客様が変更できるように。
	// Androidだとres/value/string.xml的な感じでまとめることも可。
}
