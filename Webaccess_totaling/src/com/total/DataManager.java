package com.total;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.constraint.FormatConstraint;
import com.constraint.MathConstraint;

public class DataManager implements MathConstraint, FormatConstraint{
	/** アクセスログをダウンロードした時間 */
	private String logDownloadTime;
	/** 直前にダウンロードしたログファイルの最新のログ */
	private String lastLatestLog;
	/** ダウンロードしてきたアクセスログ */
	private ArrayList<String> accessLog = new ArrayList<String>();
	/** 集計対象のログ */
	private ArrayList<String> totalingLog = new ArrayList<String>();
	/** 集計結果 */
	private String[] resultLog = new String[4];

	public void setLogDownLoadTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, MINUS_FIVE_MINUTES);
		SimpleDateFormat df = new SimpleDateFormat(TWENTY_FOUR_HOUR_MINUTE_FORMAT);
		logDownloadTime = df.format(calendar.getTime());
	}

	public String getLogDownloadTime() {
		return logDownloadTime;
	}

	public void setLastLatestLog() {
		if (totalingLog.size() > 0) {
			lastLatestLog = totalingLog.get(LATEST_LOG_NUMBER);
		}
	}

	public String getLastLatestLog() {
		return lastLatestLog;
	}

	public void readLogFile(String logFilePath) {
		File eucjpFile = new File(logFilePath);
		try {
			FileInputStream input = new FileInputStream(eucjpFile);
			InputStreamReader stream = new InputStreamReader(input, EUCJP_FILE_FORMAT);
			BufferedReader buffer = new BufferedReader(stream);

			String line;
			while((line = buffer.readLine()) != null) {
				accessLog.add(line);
			}
			buffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getAccessLog(){
		return accessLog;
	}

	public void setTotalingLog() {
		if (accessLog.size() > 0) {
			boolean isLast = false;
			int size = accessLog.size() - 1;
			for (int i = size; i >= 0; i--) {
				String eachLog = accessLog.get(i);
				if (eachLog.equals(lastLatestLog)) {
					isLast = true;
					break;
				} else {
					totalingLog.add(eachLog);
				}
			}
		}
	}

	public ArrayList<String> getTotalingLog() {
		return totalingLog;
	}


	public void setResultLog(String[] totalResult) {
		for (int j = 0; j < resultLog.length; j++) {
			int totalResultIndex = j - 1;
			switch(j) {
			case 0:
				resultLog[j] = logDownloadTime;
				break;
			case 1:
				resultLog[j] = totalResult[totalResultIndex];
				break;
			case 2:
				resultLog[j] = totalResult[totalResultIndex];
				break;
			case 3:
				resultLog[j] = totalResult[totalResultIndex];
				break;
			}
		}
	}

	public String[] getResultLog() {
		return resultLog;
	}

	public void clearAccessLog() {
		accessLog.clear();
	}

	public void clearTotalingLog() {
		totalingLog.clear();
	}
}