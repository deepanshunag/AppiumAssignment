package appiumtests;

import org.json.JSONObject;

public class jsonData extends Calculator{
	JSONObject obj = JSONUtils.getJSONObjectFromFile("obj.json");
	int number = obj.getInt("Number");
	String string1 = obj.getString("String1");
	String string2 = obj.getString("String2");
	String string3 = obj.getString("String3");
	String string4 = obj.getString("String4");
	String string5 = obj.getString("String5");
	String string6 = obj.getString("String6");
	String string7 = obj.getString("String7");
	String string8 = obj.getString("String8");
	String string9 = obj.getString("String9");
	String string10 = obj.getString("String10");
	String string11 = obj.getString("String11");
	String string12 = obj.getString("String12");
	boolean bool = obj.getBoolean("Boolean");
}
