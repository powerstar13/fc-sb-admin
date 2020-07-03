package com.study.fcsbadmin.controller.api;

import com.study.fcsbadmin.controller.CrudController;
import com.study.fcsbadmin.model.entity.Item;
import com.study.fcsbadmin.model.network.request.ItemApiRequest;
import com.study.fcsbadmin.model.network.response.ItemApiResponse;
import com.study.fcsbadmin.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {
}
