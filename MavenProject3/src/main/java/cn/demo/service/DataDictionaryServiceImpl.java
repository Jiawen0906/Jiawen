package cn.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.demo.dao.DataDictionaryMapper;
import cn.demo.entity.DataDictionary;

@Service("dataDictionaryService")
@Transactional
public class DataDictionaryServiceImpl implements DataDictionaryService {
	
	@Resource
	private DataDictionaryMapper mapper;
	
	public List<DataDictionary> getDataDictionaryList(String typeCode)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.getDataDictionaryList(typeCode);
		
	}

}
