package com.ms.plantilla.commsplantilla.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.plantilla.commsplantilla.handler.response.ResponseOk;
import com.ms.plantilla.commsplantilla.service.IService.IPlantillaService;
import com.ms.plantilla.commsplantilla.utils.GenericsConstanst;

@RestController
@RequestMapping(GenericsConstanst.URI_BASE)
public class PlantillaController {

    @Autowired
    private IPlantillaService plantillaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PlantillaController.class);

    @GetMapping(GenericsConstanst.URL_GET_ALL)
    public ResponseOk controllerGetAll() {
        LOGGER.info("comienza proceso ...init");
        return plantillaService.rerResponseOk();
    }

}
