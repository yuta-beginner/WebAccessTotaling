package com.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import com.constraint.FormatConstraint;
import com.constraint.MathConstraint;
import com.display.DisplayManager;

public class Logic implements MathConstraint, FormatConstraint{
	// コマンドラインで受け取った引数
	private String[] clArgs;
	private TimerTaskLogic timerTaskLogic;
	private Logic mLogic = this;
	private Timer time = new Timer();
	private DisplayManager displayManager = new DisplayManager();
	

	public Logic(String[] args){
		this.clArgs = args;
	}

	public void start() {
		if (clArgs.length == NEEDED_ARGS_SIZE) {
			
			SimpleDateFormat sdf = new SimpleDateFormat(YEAR_MONTH_DAY_TWENTY_FOUR_HOUR_MINUTE_FORMAT);

			//日時を格納するためのDateクラスを宣言(現在時刻)
			Date date = new Date();

			Calendar ca = Calendar.getInstance();

			// caに現在日時をセットする。
			ca.setTime(date);

			// caに現在日時+1日（翌日）をセットする。
			ca.add(Calendar.DATE, ONE_DAY);
			ca.set(Calendar.HOUR_OF_DAY,ZERO_HOUR);
			ca.set(Calendar.MINUTE, FIVE_MINUTES);
			
			String strDate = sdf.format(ca.getTime());

			try {
				Date nextDate = sdf.parse(strDate);
				timerTaskLogic = new TimerTaskLogic(clArgs[ARGS_FILE_INDEX], nextDate, mLogic);
				time.schedule(timerTaskLogic, nextDate, TASK_TERM);
			} catch (ParseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} else if (clArgs.length <= ZERO_ARGS_SIZE) {
			displayManager.showArgsNotEnoughMessage();
			finish();
		} else {
			displayManager.showArgsManyMessage();
			finish();
		}
	}
	
	public void finish() {
		time.cancel();
	}
}
