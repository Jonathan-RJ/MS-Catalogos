package com.ms.plantilla.commsplantilla.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ms.plantilla.commsplantilla.handler.exceptions.collections.HandlerRequestException401;
import com.ms.plantilla.commsplantilla.handler.response.ResponseOk;
import com.ms.plantilla.commsplantilla.service.IService.IPlantillaService;

@Service
public class PlantillaServiceImpl implements IPlantillaService {

    @Override
    public ResponseOk rerResponseOk() {
        int val = 0;
        if (val == 1) {
            return ResponseOk.builder().mensaje("jhggh").folio("ydhuihuidcf").build();
        }
        List<String> list = new ArrayList<>();
        list.add("xdxd");
        throw new HandlerRequestException401("hj", "jjhd", "hhd", list);
    }

}
