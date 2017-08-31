package com.big.to.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.big.to.vo.Sample;
import com.big.to.vo.SamplePhone;

@Repository
public interface SampleDAO {
<<<<<<< HEAD
	public List<Sample> sample(Sample sam);
=======
	public List<Sample> sample(Sample mem);
	
	public List<SamplePhone> samplePhone();
	
	public List<SamplePhone> phoneLine(Map<String, Object> map);
	
	public List<String> krnameList();
	
	public List<String> gbList(String krname);
	
	public List<String> conditionsList(Map<String, Object> map);
	
	public List<String> changesList(Map<String, Object> map);
>>>>>>> 036bec28e4b66d3339c01f98ce9d4db4243148cc
}
