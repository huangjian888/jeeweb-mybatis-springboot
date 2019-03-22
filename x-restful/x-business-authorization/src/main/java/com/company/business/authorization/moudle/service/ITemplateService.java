package com.company.business.authorization.moudle.service;

import javax.servlet.http.HttpServletRequest;

public interface ITemplateService {
    void sendTemplate(HttpServletRequest request, String openId, String formId);
}
