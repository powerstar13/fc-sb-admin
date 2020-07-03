package com.study.fcsbadmin.controller.api;

import com.study.fcsbadmin.controller.CrudController;
import com.study.fcsbadmin.model.entity.Partner;
import com.study.fcsbadmin.model.network.request.PartnerApiRequest;
import com.study.fcsbadmin.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {
}
