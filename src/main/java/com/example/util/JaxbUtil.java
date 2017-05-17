package com.example.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * OBJ和XML互转工具类
 * 
 * @author zhouzy
 *
 */
public class JaxbUtil {

	/**
	 * XML转换为OBJ
	 * 
	 * @param <T> 传入类型
	 * @param xml 需转换为OBJ的XML
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertXml2Obj(String xml, Class<T> c) {
		T rtn = null;
		StringReader sr = null;
		try {
			JAXBContext jc = JAXBContext.newInstance(c);
			Unmarshaller um = jc.createUnmarshaller();
			sr = new StringReader(xml);
			rtn = (T) um.unmarshal(sr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sr != null) {
				sr.close();
			}
		}
		return rtn;
	}

	/**
	 * OBJ转换为XML
	 * 
	 * @param obj
	 *            需转换为XML的对象
	 * @param encoding
	 *            输出格式
	 * @param isFormat
	 *            是否格式化（缩进和换行等）
	 * @return
	 */
	public static String convertObj2Xml(Object obj, String encoding,
			Boolean isFormat) {
		String rtn = null;
		StringWriter sw = null;
		try {
			JAXBContext jc = JAXBContext.newInstance(obj.getClass());
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, isFormat);
			m.setProperty(Marshaller.JAXB_ENCODING, encoding);
			sw = new StringWriter();
			m.marshal(obj, sw);
			rtn = sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sw != null) {
				try {
					sw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return rtn;

	}

}
