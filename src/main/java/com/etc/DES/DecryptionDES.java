package com.etc.DES;
/**
 * DES����
 */
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DecryptionDES {
	
	 private static final String DES_ALGORITHM = "DES";

	 public static String decryption(String secretData, String secretKey) throws Exception {

	        Cipher cipher = null;
	        
	        try {
	            //
	            cipher = Cipher.getInstance("DES/ECB/NoPadding");
	            cipher.init(Cipher.DECRYPT_MODE, generateKey(secretKey));
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            throw new Exception("NoSuchAlgorithmException", e);
	        } catch (NoSuchPaddingException e) {
	            e.printStackTrace();
	            throw new Exception("NoSuchPaddingException", e);
	        } catch (InvalidKeyException e) {
	            e.printStackTrace();
	            throw new Exception("InvalidKeyException", e);

	        }

	        try {

	            byte[] buf = cipher.doFinal(hexStr2Bytes(secretData));

	            return new String(buf,"utf-8");

	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new Exception("IllegalBlockSizeException", e);
	        }
	    }
	    public static byte[] hexStr2Bytes(String src){  
	        /*������ֵ���й淶������*/  
	        src = src.trim().replace(" ", "").toUpperCase(Locale.US);  
	        //����ֵ��ʼ��  
	        int m=0,n=0;  
	        int iLen=src.length()/2; //���㳤��  
	        byte[] ret = new byte[iLen]; //����洢�ռ�  

	        for (int i = 0; i < iLen; i++){  
	            m=i*2+1;  // 1
	            n=m+1;// 2
	            //String aa =(Integer.decode("0x" + src.substring(i*2, m))+src.substring(m,n)) & 0xFF;
	            ret[i] = (byte)(Integer.decode("0x"+ src.substring(i*2, m) + src.substring(m,n)) & 0xFF);  
	        }  
	        return ret;  
	    }  

	    /**
	     * ���������Կ
	     * 
	     * @param secretKey
	     * @return
	     * @throws NoSuchAlgorithmException
	     * @throws InvalidKeySpecException
	     * @throws InvalidKeyException
	     */
	    private static SecretKey generateKey(String secretKey)throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
	        DESKeySpec keySpec = new DESKeySpec(secretKey.getBytes());
	        keyFactory.generateSecret(keySpec);
	        return keyFactory.generateSecret(keySpec);
	    }
	    
	    public static void main(String[] args) {
	    	 String secretData = "Mi5WasKXCNu6W+o60ko/sQ==";
	    	 String secretKey = " Strong!@";
	    	 try {
				String result = decryption(secretData, secretKey);
				System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
