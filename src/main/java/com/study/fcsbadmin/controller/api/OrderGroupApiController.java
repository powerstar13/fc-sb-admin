package com.study.fcsbadmin.controller.api;

import com.study.fcsbadmin.controller.CrudController;
import com.study.fcsbadmin.model.entity.OrderGroup;
import com.study.fcsbadmin.model.network.request.OrderGroupApiRequest;
import com.study.fcsbadmin.model.network.response.OrderGroupApiResponse;
import com.study.fcsbadmin.service.OrderGroupApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/orderGroup")
@Slf4j
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {
}
