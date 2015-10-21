package com.qly.dao;

import com.qly.model.Vender;
import java.util.List;
import java.util.Map;

/**
 * Created by Fanyi on 15/10/21.
 */
public interface IVenderDao {
    List<Vender> getVendersByRegionAndCategory(String region, int category_id, String sort);
    List<Vender> getVendersByRegion(String region, String sort);
    List<Vender> getVendersByCategory(int category_id, String sort);
    List<Vender> getVendersByAll(String sort);
    Map<String, Object> getComboVenderById(Long id);
}
