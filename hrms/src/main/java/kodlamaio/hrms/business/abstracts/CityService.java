package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.City;

public interface CityService {

//	Result add(City city);
//	Result update(City city);
//	Result delete(int id);
//	DataResult<City> getById(int id);

    DataResult<List<City>> getAll();

}
