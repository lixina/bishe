package com.etc.DES;

public class TestDES {
	public static void main(String[] args) throws Exception {
		String str = "C:\\Users\\Administrator\\Desktop\\色阶图\\Rain\\Rain6";
		String t = "";
		System.out.println("加密后：" + (t = EncryUtil.encrypt(str)));
		System.out.println("解密后：" + EncryUtil.decrypt(t));
	}
}
