package com.etc.DES;
/**
 * ���ܽ��ܹ�����
 * @author Bywinkey
 *
 */
public class EncryUtil {
	
	/**
	 * ʹ��Ĭ����Կ����DES����
	 */
	public static String encrypt(String plainText) {
		try {
			return new DES().encrypt(plainText);
		} catch (Exception e) {
			return null;
		}
	}
 
	
	/**
	 * ʹ��ָ����Կ����DES����
	 */
	public static String encrypt(String plainText, String key) {
		try {
			return new DES(key).encrypt(plainText);
		} catch (Exception e) {
			return null;
		}
	}
	
 
	/**
	 * ʹ��Ĭ����Կ����DES����
	 */
	public static String decrypt(String plainText) {
		try {
			return new DES().decrypt(plainText);
		} catch (Exception e) {
			return null;
		}
	}
 
	
	/**
	 * ʹ��ָ����Կ����DES����
	 */
	public static String decrypt(String plainText, String key) {
		try {
			return new DES(key).decrypt(plainText);
		} catch (Exception e) {
			return null;
		}
	}

}
