package service;

import model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProvinceService extends IGeneralService<Province> {
    Page<Province> findAll(Pageable pageable);
}
