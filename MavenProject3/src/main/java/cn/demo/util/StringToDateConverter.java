package cn.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * string向Date转换的转换器
 * @author Administrator
 *
 */
public class StringToDateConverter implements Converter<String, Date>{
    
	private String datePattern;
	
	public StringToDateConverter(){}
	
	public StringToDateConverter(String datePattern){
		this.datePattern = datePattern;
	}
	
	public Date convert(String source) {
		Date date = null;
		try {
			date=new SimpleDateFormat(datePattern).parse(source);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
