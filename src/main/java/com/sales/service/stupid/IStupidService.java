package com.sales.service.stupid;

import com.sales.model.Stupid;
import com.sales.service.IGeneralService;

import javax.servlet.http.HttpServletResponse;

public interface IStupidService extends IGeneralService<Stupid> {
    Stupid register(HttpServletResponse httpServletResponse);
}
