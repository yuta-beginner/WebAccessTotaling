package com.total;

import java.util.ArrayList;

import com.constraint.FormatConstraint;
import com.constraint.MathConstraint;

public class TotalData implements MathConstraint, FormatConstraint{
	/** タブ文字で分けた1行のログ */
	ArrayList<String[]> detailedTotalingLog = new ArrayList<String[]>();
	/** 集計結果 */
	private String[] totalResult = new String[3];

	public void setDetailedTotalingLog(ArrayList<String> totalingLog) {
		int totalingLogSize = totalingLog.size();
		for (int i = 0; i < totalingLogSize; i++) {
			detailedTotalingLog.add(totalingLog.get(i).split(TAB_SPACE));
		}
	}

	public ArrayList<String[]> getDetailedTotalingLog(){
		return detailedTotalingLog;
	}

	/**
	 * 
	 */
	public void sortDetailedTotalingLog() {
		int underOneSecNumber = 0;
		int betweenOneSecToFiveSec = 0;
		int overFiveSec = 0;

		int detailedTotalingLogSize = detailedTotalingLog.size();
		if (detailedTotalingLogSize > 0) {
			for (int i = 0; i < detailedTotalingLogSize; i++) {
				String[] eachDetailedTotalingLog = detailedTotalingLog.get(i);
				int accessCompleteTime = Integer.parseInt(eachDetailedTotalingLog[ACCESS_COMPLETE_TIME_INDEX]);
				if (accessCompleteTime < THOUSAND_MILLI_SECONDS) {
					underOneSecNumber++;
				} else if (accessCompleteTime > FIVE_THOUSAND_MILLI_SECONDS) {
					overFiveSec++;
				} else {
					betweenOneSecToFiveSec++;
				}
			}
		}
		
		for (int i = 0; i < totalResult.length; i++) {
			switch(i) {
			case 0:
				totalResult[i] = Integer.valueOf(underOneSecNumber).toString();
				break;
			case 1:
				totalResult[i] = Integer.valueOf(betweenOneSecToFiveSec).toString();
				break;
			case 2:
				totalResult[i] = Integer.valueOf(overFiveSec).toString();
				break;
			}
		}
	}
	
	public String[] getTotalResult() {
		return totalResult;
	}
	
	public void clearDetailedTotalingLog() {
		detailedTotalingLog.clear();
	}
}
