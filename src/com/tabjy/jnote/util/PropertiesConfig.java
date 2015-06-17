package com.tabjy.jnote.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesConfig {

	/**
	 * ����KEY����ȡ�ļ���Ӧ��ֵ
	 * @param filePath �ļ�·�������ļ����ڰ���·�������磺java/util/config.properties
	 * @param key ��
	 * @return key��Ӧ��ֵ
	 */
	public static String readData(String key) {
		String filePath = System.getProperty("java.io.tmpdir")+"/com.tabjy.jnote/config.properties";
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			props.load(in);
			in.close();
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * �޸Ļ���Ӽ�ֵ�� ���key���ڣ��޸�, ��֮����ӡ�
	 * @param filePath �ļ�·�������ļ����ڰ���·�������磺java/util/config.properties
	 * @param key ��
	 * @param value ����Ӧ��ֵ
	 */
	public static void writeData(String key, String value) {
		String filePath = System.getProperty("java.io.tmpdir")+"/com.tabjy.jnote/config.properties";
		Properties prop = new Properties();
		try {
			File file = new File(filePath);
			if (!file.exists())
				file.createNewFile();
			InputStream fis = new FileInputStream(file);
			prop.load(fis);
			//һ��Ҫ���޸�ֵ֮ǰ�ر�fis
			fis.close();
			OutputStream fos = new FileOutputStream(filePath);
			prop.setProperty(key, value);
			//���棬������ע��
			prop.store(fos, "Update '" + key + "' value");
			fos.close();
		} catch (IOException e) {
			System.err.println("Visit " + filePath + " for updating " + value + " value error");
		}
	}
}