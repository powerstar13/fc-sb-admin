package com.study.fcsbadmin.ifs;

import com.study.fcsbadmin.model.network.Header;

public interface CrudInterface<Req, Res> {
    Header<Res> create(Header<Req> request); // TODO: Request object 추가

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);
}
