package stPackage;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.sql.SQLException;
import java.sql.ResultSet;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

public class SQLUtil {

    private static Logger logger = Logger.getLogger("sttest");    

    /**
     * Loads any type of text file and returns string content
     * 
     * @return StringBuffer with file content
     * @throws IOException in case the file isn't found
     */
    private static StringBuffer readFile( String fName ) throws IOException {
    
        char charBuf[] = new char[256];
        int  charLen = 0;
        FileReader fr;

        StringBuffer stringBuf = new StringBuffer();

        try{
            fr = new FileReader( fName );
        } catch(FileNotFoundException e) {
            throw new IOException("Cannot find request file : " + fName);
        }

        while ((charLen = fr.read(charBuf)) > 0)
            for (int c = 0; c < charLen; c++)
                stringBuf.append(charBuf[c]);

        fr.close();

        return stringBuf;
    }

    private static String replaceKeysInFile( String fileName, Map dict ) throws IOException {

	logger.debug("SQLUtil::replaceKeysInFile(" + fileName + "," + (dict!=null?dict.size():0) + ")");

        StringBuffer fileContent = readFile( fileName );
        String tempContent = fileContent.toString();

	logger.debug("SQLUtil::replaceKeysInFile:file content \"" + tempContent + "\"");

	if (dict!=null) {

        //replace keys with values
        Set keySet = dict.keySet();
        Iterator keyIterator = keySet.iterator();
        String currentKey;
        String currentValue;
        Pattern patt;
        Matcher match;

        while(keyIterator.hasNext()) {

            currentKey = (String) keyIterator.next();

	    logger.debug("SQLUtil::replaceKeysInFile:current key \"" + currentKey + "\"");

            if ( (currentValue = (String) dict.get(currentKey)) == null )
		logger.warn("SQLUtil::replaceKeysInFile:no value corresponding for  key \"" + currentKey + "\"");
	    else {

		logger.debug("SQLUtil::replaceKeysInFile:replacing \"" + currentKey + "\" with \"" + currentValue + "\"");
                
		Pattern keyP = Pattern.compile("\\$" + currentKey + "\\$");
		Matcher m = keyP.matcher(tempContent);
		tempContent = m.replaceAll(currentValue);
	    }
        }
	}

        return tempContent;
    }

    public static int executeUpdate(String fName, Map transMap) throws IOException, NamingException, SQLException {
	logger.debug("SQLUtil::executeUpdate(" + fName + "," + (transMap!=null?transMap.size():0) + ")");
	String queryString = replaceKeysInFile( fName, transMap );
	logger.debug("SQLUtil - SQL statement:" + queryString);
	BaseDAO oneDAO = new BaseDAO();
	return oneDAO.execUpdateStatement( queryString );
    }

    public static ResultSet executeQuery(String fName, Map transMap) throws IOException, NamingException, SQLException {
	logger.debug("SQLUtil::executeUpdate(" + fName + "," + (transMap!=null?transMap.size():0) + ")");
	String queryString = replaceKeysInFile( fName, transMap );
	logger.debug("SQLUtil - SQL statement:" + queryString);
	BaseDAO oneDAO = new BaseDAO();
	return oneDAO.execQueryStatement( queryString );
    }

}
