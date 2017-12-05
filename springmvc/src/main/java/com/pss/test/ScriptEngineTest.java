package com.pss.test;

import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * This is used to test invoke js function in java app.
 * 
 * @author songsong.peng
 *
 */
public class ScriptEngineTest {
	
	private static final String JAVA_SCRIPT = "javascript";
	
	private static final String JS_FUNCTION_NAME = "caculateValues";
	
	private static final String JS_FILE_LOCATION = "com/pss/resource/testjsruner.js";
	
	public static void main(String[] args) throws ScriptException, NoSuchMethodException {
		//New an scriptEngineManager instance
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		
		//Get scriptEngine from the scriptEngineManager
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(JAVA_SCRIPT);
		
		//Get the js reader
		Reader reader = new InputStreamReader(ScriptEngineTest.class.getClassLoader().getResourceAsStream(JS_FILE_LOCATION));
		scriptEngine.eval(reader);
		
		//Convert the java engine to Invocable
		Invocable invocalbe = (Invocable)scriptEngine;
		
		//Invoke the method to get return result
		Double result = (Double)invocalbe.invokeFunction(JS_FUNCTION_NAME, 2,9);
		BigDecimal finalResult = new BigDecimal(result.toString());
		System.out.println(finalResult.intValue());
	}
	
}
