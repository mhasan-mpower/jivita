package utils;

import java.util.StringTokenizer;


/**
 * The Class StringUtil.
 */
public class StringUtil {
    
    /**
     * Title Case.
     * 
     * @param str
     *            Input String
     * @return the string after fixing case
     */
    public static String titleCase(String str) {
    
        StringTokenizer st = new StringTokenizer(str, "_");
        
        String out = "", tmp;
        while (st.hasMoreTokens()) {
            tmp = st.nextToken();
            if (out != "") out += " ";
            out += tmp.charAt(0) + tmp.substring(1).toLowerCase();
        }
        
        return out;
        
    }
    
}