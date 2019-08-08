package com.june.apps.models;

import java.util.List;

public class Utils {
	/* -- Global Variables -- */
	 /*Content Filtering*/
	 /*White lists*/
	 static String wlAddBaseStr = "10%profiles&#10;WebWL&#10;and&#10;or&#10;url%";
	 static String wlRemoveBaseStr = "3%profiles&#10;WebWL&#10;and&#10;or&#10;url";
	 /*Black lists*/
	 static String blAddBaseStr = "10%profiles&#10;WebBL&#10;and&#10;or&#10;url%";
	 static String blRemoveBaseStr = "3%profiles&#10;WebBL&#10;and&#10;or&#10;url";
	 
	 /*Toggle*/
	static String togglePCBaseStr = "1%Values&#10;WebFilter&#10;ContentFilter&#124;Premium&#10;state%"; /*On / Off*/
    static String toggleSSBaseStr = "1%Values&#10;WebFilter&#10;ContentFilter&#124;Premium&#10;SafeSearch%"; /*True / False*/
	static String toggleQTBaseStr = "1%strategy&#10;WFQuietTime&#10;active%"; /* yes/no */
	 
	/* -- End Global Variables -- */
	
	/* Request Body Validations 
	 * 	** Null checks
	 *  ** Valid Strings check
	 * Room for improvement (Incompatible type checks not implemented)
	 * */
	public static boolean isCiValid(String ci) {
		return !(ci.equals("")) && !(ci==null) && isNumber(ci) && (ci.length()==8);
	}
	
	public static boolean isChangeValid(String change) {
		return (change.equals("turnPCOn") ||change.equals("turnPCOff") || change.equals("turnSSOn") || change.equals("turnSSOff") || change.equals("turnQTOn") || change.equals("turnQTOff") 
				|| change.equals("addSafeSite") || change.equals("removeSafeSite") || change.equals("addUnsafeSite") || change.equals("removeUnsafeSite"));
	}
	
	public static boolean doesContentFiltering(String change) {
		return (change.equals("addSafeSite") || change.equals("removeSafeSite") || change.equals("addUnsafeSite") || change.equals("removeUnsafeSite"));
	}
	
	public static boolean isFilterValid(List<String> filter) {
		return (filter.size()>0);
	}
	
	/* Content Filtering */
	public static String buildURLFilter(String filter, List<String> contentFilter) {
		String changeStr = "";
		if (filter.equals("addSafeSite") || filter.equals("addUnsafeSite")) {
			changeStr = filter.equals("addSafeSite") ? wlAddBaseStr : blAddBaseStr;
			
			for(int i=0; i<contentFilter.size(); i++) {
				if(i == 0) {
					changeStr += contentFilter.get(0);
				} else {
					changeStr += "&#10;" + contentFilter.get(i);
				}
			}
			return changeStr;
		} else {
			changeStr = filter.equals("removeSafeSite") ? wlRemoveBaseStr : blRemoveBaseStr;
			for(int i=0; i<contentFilter.size(); i++) {
				changeStr += "&#10;" + contentFilter.get(i);
			}
			return changeStr;
		}
	}
	/* Normal Toggle */
	public static String buildChangeStr(String change) {
		return (change.equals("turnPCOn") ? togglePCBaseStr + "On" : (change.equals("turnPCOff") ? togglePCBaseStr + "Off" : (
			    change.equals("turnSSOn") ? toggleSSBaseStr + "True" : ( change.equals("turnSSOff") ? toggleSSBaseStr + "False" : (
			    change.equals("turnQTOn") ? toggleQTBaseStr + "yes" : (change.equals("turnQTOff") ? toggleQTBaseStr + "no" : ""
			    ))))));	
	}
	
	public static boolean isNumber(String number) {
		try {
			Long.parseLong(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
}
