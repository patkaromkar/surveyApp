package com.regulus.app.survey.util;

import org.apache.log4j.Logger;

/**
 * This is a utility class which will contain utility methods that will be required by the SA's DAL
 * @author Omkar P
 *
 */
public class SADALUtil {

	private static final Logger logger = Logger.getLogger(SADALUtil.class);
	
	/**
	 * This method generates a random word which is alphanumeric containing only as many characters as
	 * specified in the argument = "noOfCharacters"
	 * 
	 * @param noOfCharacters
	 * @return
	 */
	public static String getRandomWord(int noOfCharacters) {
		logger.debug("Start of getRandomWord()");
		final char[] charSeqGen = new char[noOfCharacters];
		
		for (int i = 0; i < noOfCharacters; i++) {
			int j = (int)(65 + (Math.random()*(123-65)));
			charSeqGen[i] = (char)j;
			
		}
		
		final String s = new String(charSeqGen);

		logger.debug("End of getRandomWord()");
		return s;
	}
}
