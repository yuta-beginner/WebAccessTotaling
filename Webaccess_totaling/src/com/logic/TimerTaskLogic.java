package com.logic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import com.constraint.FormatConstraint;
import com.display.DisplayManager;
import com.total.DataManager;
import com.total.TotalData;

public class TimerTaskLogic extends TimerTask implements FormatConstraint{
	private DisplayManager displayManager = new DisplayManager();
	private DataManager dataManager = new DataManager();
	private TotalData totalData = new TotalData();
	SimpleDateFormat logicSdf = new SimpleDateFormat(YEAR_MONTH_DAY_FORMAT);
	File logFile;
	String logFilePath;
	Date executionDate;
	String strExecutionDate;
	Date currentDate;
	String strCurrentDate;
	Logic logic;

	public TimerTaskLogic(String logFilePath, Date executionDate, Logic logic){
		this.logFilePath = logFilePath;
		this.executionDate = executionDate;
		this.logic = logic;
	}

	public void run() {
		
	    logFile = new File(logFilePath);

		strExecutionDate = logicSdf.format(executionDate);
		currentDate = new Date();
		strCurrentDate = logicSdf.format(currentDate);

		if (strCurrentDate.equals(strExecutionDate) && logFile.exists()) {

			dataManager.setLogDownLoadTime();

			dataManager.readLogFile(logFilePath);

			if (dataManager.getAccessLog().size() > 0) {
				dataManager.setTotalingLog();

				dataManager.setLastLatestLog();

				totalData.setDetailedTotalingLog(dataManager.getTotalingLog());
			}

			totalData.sortDetailedTotalingLog();
			String[] tr = totalData.getTotalResult();

			dataManager.setResultLog(tr);

			// コンソールにログ集計結果を出力
			displayManager.showResultLog(dataManager.getResultLog());
			dataManager.clearAccessLog();
			dataManager.clearTotalingLog();
			totalData.clearDetailedTotalingLog();
		} else if(!logFile.exists()) {
			displayManager.showFileNotExistMessage();
			logic.finish();
		} else {
			logic.finish();
		}
	}
}
