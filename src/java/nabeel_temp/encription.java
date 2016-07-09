/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nabeel_temp;

import java.security.MessageDigest;

/**
 *
 * @author NABEEL
 */
public class encription {

    private static final int key = 2184, ckey = 841521;

    private encription() {
    }
    static encription e = null;

    public static encription createObject() {
        if (e == null) {
            e = new encription();
        }
        return e;
    }

    private String encriptionPreProcessing(int value) {

        String m = "" + (value / 10 + 14) + (value % 10 + 14);
        return "" + (new Integer(m) + key);
    }

    private int decriptionPrePrecessing(String value) {

        int k = new Integer(value) - key;
        return (k / 100 - 14) * 10 + (k % 100 - 14);
    }

    private String encriptionGen(String value) {
        int length = value.length();
        int data[] = new int[length], p[] = new int[length / 2], checksum, length_1 = length - 1, lengthBY2 = length / 2;
        String encript;
        encript = encriptionPreProcessing(length);
        checksum = new Integer(encript);
        for (int i = 0; i < length; i++) {
            int k = (int) value.charAt(i);

            data[i] = (65 <= k && k <= 90) ? k - 55 : (97 <= k && k <= 122) ? k - 61 : k + 14;

        }
        int temp = 0;
        for (int i = 0; i < length_1; i++) {
            p[temp++] = new Integer((new Integer(data[i])).toString() + (new Integer(data[++i])).toString()) + key;

        }
        for (int i = 0; i < lengthBY2; i++) {
            encript += p[i];
            checksum += p[i];
        }
        checksum += ckey;
        encript += checksum;

        return encript;
    }

    private String decreptionGen(String value) {
        String reid = "";

        int length = decriptionPrePrecessing(value.substring(0, 4));
        value = value.substring(4);
        length = length * 2;
        for (int i = 0; i < length; i++) {
            char i1 = value.charAt(i);

            char i2 = value.charAt(++i);

            char i3 = value.charAt(++i);

            char i4 = value.charAt(++i);

            int m = new Integer(new Character(i1).toString() + new Character(i2).toString() + new Character(i3).toString() + new Character(i4).toString());

            m = m - key;

            int k = m / 100;
            int l = m % 100;

            char p = (char) ((10 <= k && k <= 35) ? k + 55 : (36 <= k && k <= 61) ? k + 61 : k - 14);

            char q = (char) ((10 <= l && l <= 35) ? l + 55 : (36 <= l && l <= 61) ? l + 61 : l - 14);//(char) ((10 <= l && l <= 35) ? l + 55 : l + 61);

            reid = reid + (new Character(p).toString()) + (new Character(q).toString());
        }
        return reid;
    }

    private boolean validaterGen(String value) {
        int lenght = decriptionPrePrecessing(value.substring(0, 4)) + 2;
        lenght = lenght * 2;
        int pre = value.length();
        if ((pre > lenght) && (pre - lenght < 9)) {
            int checksum = Integer.parseInt(value.substring(lenght));

            int inchecksum = 0;
            boolean b = false;
            for (int i = 0; i < lenght; i++) {
                char i1 = value.charAt(i);
                char i2 = value.charAt(++i);
                char i3 = value.charAt(++i);
                char i4 = value.charAt(++i);
                int m = new Integer(new Character(i1).toString() + new Character(i2).toString() + new Character(i3).toString() + new Character(i4).toString());
                inchecksum += m;
            }
            inchecksum += ckey;

            if (inchecksum == checksum) {
                b = true;
            }

            return b;
        } else {
            return false;
        }

    }

    public static String Password(String data) {
        StringBuffer sb = new StringBuffer();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(data.getBytes("UTF-8"));
            byte[] digestBytes = messageDigest.digest();

            String hex = null;

            for (int i = 0; i < digestBytes.length; i++) {
                //Convert it to positive integer and then to Hex String

                hex = Integer.toHexString(0xFF & digestBytes[i]);

                //Append "0" to the String to made it exactly 128 length (SHA-512 alogithm)
                if (hex.length() < 2) {
                    sb.append("0");
                }
                sb.append(hex);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return new String(sb);
    }

    public String encription(String value) {
        return encriptionGen(value);
    }

    public String decreption(String value) {
        return decreptionGen(value);
    }

    public boolean validater(String value) {
        return validaterGen(value);
    }

//    public static void main(String op[]) {
//        encription eg = new encription();
//
//        // encriprionGenral eg = new encriprionGenral();
//      //  String m = eg.encription("NabeelAbdullahAnsari");
//
//      //  System.out.println(m);//eg.decription("520284468446844684468437888944"));//4UI0000000009mssdefgtyhjuascdrfjnh".equals("4UI0000000009mssdefgtyhjuascdrfjnh"));
//        System.out.println(eg.validater("3706470285518447865158205820582058205823904681"));
//       //  m = eg.decreption(m);
//       // System.out.println(m);
//
//    }

}
