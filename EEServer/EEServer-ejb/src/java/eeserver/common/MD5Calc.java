/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.common;

/**
 *
 * @author maciek
 */
public class MD5Calc {
    /**
     *
     * @param A word f String to be convereted into MD5 sum
     * @return for the present, it doesn't return proper value :)
     */
    public static Long compute(String s) {
        Long res = new Long(0);
        char[] tab = s.toCharArray();
        for(int a = 0;a<tab.length;a++) {
            byte b = (byte)tab[a];
            res += b;
        }
        return res;
    }
}
