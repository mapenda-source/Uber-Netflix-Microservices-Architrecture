package com.mapenda.architecture_netflix_uber.service;

import com.mapenda.architecture_netflix_uber.entity.MS;
import com.mapenda.architecture_netflix_uber.repository.MicroservicesPageRepository;
import com.mapenda.architecture_netflix_uber.repository.MicroservicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MicroserviceService implements MicroserviceServiceInterface {


    private MicroservicesRepository microservicesRepository;

    @Autowired
    private MicroservicesPageRepository pg;

    @Autowired
    public MicroserviceService(MicroservicesRepository microservicesRepository)
    {
        this.microservicesRepository=microservicesRepository;
    }


    public List<MS> findAll() {
        return microservicesRepository.findAll();
    }

    public void save(MS OBJ) {

        microservicesRepository.save(OBJ);
    }

    public void deleteById(int theId) {

        microservicesRepository.deleteById(theId);
    }

    public MS findById(int theId) {

        return microservicesRepository.findById(theId);
    }



//	public List<Microservices> findByMicroentity1(String seq)
//	{
//		return microservicesRepository.findBymicroentity1(seq);
//	}

    public List<MS> findPage(Integer pageNo, Integer pageSize, String sortBy)
    {
        PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy) );

        Page<MS> pagedResult = pg.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return null;
        }
    }


}
