package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class EncryptUtil {
    public static String getPasswordEncrypt(String plain_p, String salt){
        String ret = "";
        // 引数の文字がなければ空の文字列を返す
        if(plain_p != null && !plain_p.equals("")){
            byte[] bytes;
            // ソルト文字列で暗号化
            String password = plain_p + salt;
            try{
                bytes = MessageDigest.getInstance("SHA-256").digest(password.getBytes());
                ret = DatatypeConverter.printHexBinary(bytes);
            }catch(NoSuchAlgorithmException ex){}
        }
        return ret;
    }
}
