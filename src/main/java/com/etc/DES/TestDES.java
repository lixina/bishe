package com.etc.DES;

public class TestDES {
	public static void main(String[] args) throws Exception {
		String str = "C:\\Users\\Administrator\\Desktop\\ɫ��ͼ\\Rain\\Rain6";
		String t = "";
		System.out.println("���ܺ�" + (t = EncryUtil.encrypt(str)));
		System.out.println("���ܺ�" + EncryUtil.decrypt(t));
	}
}
