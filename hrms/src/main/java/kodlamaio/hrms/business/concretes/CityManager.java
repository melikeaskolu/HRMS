package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
//	@Override
//	public Result add(City city) {
//		this.cityDao.save(city);
//	    return new SuccessResult("City has been added.");   //Şehir eklendi
//	}
//
//	@Override
//	public Result update(City city) {
//		this.cityDao.save(city);
//	    return new SuccessResult("City has been updated.");   //Şehir güncellendi
//	}
//
//	@Override
//	public Result delete(int id) {
//		this.cityDao.deleteById(id);
//	    return new SuccessResult("City has been deleted.");   //Şehir silindi
//	}
//
//	@Override
//	public DataResult<City> getById(int id) {
//		return new SuccessDataResult<City>(this.cityDao.getById(id));
//	}
	 
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

}
