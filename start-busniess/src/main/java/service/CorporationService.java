package service;

import mapper.TsC500035JbxxZtsbFrjcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.TsC500035JbxxZtsbFrjc;

import java.util.List;

/**
 * Created by hldev on 18-1-14.
 */
@Service
public class CorporationService {

    @Autowired
    private TsC500035JbxxZtsbFrjcMapper tsC500035JbxxZtsbFrjcMapper;

    public void create(TsC500035JbxxZtsbFrjc tsC500035JbxxZtsbFrjc) {
        tsC500035JbxxZtsbFrjcMapper.insert(tsC500035JbxxZtsbFrjc);
    }
}
