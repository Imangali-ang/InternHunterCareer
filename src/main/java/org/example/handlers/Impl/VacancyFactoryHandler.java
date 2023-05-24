package org.example.handlers.Impl;

import org.example.handlers.CompanyHandler;
import org.example.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class VacancyFactoryHandler {

    @Autowired
    private ApplicationContext applicationContext;

    public CompanyHandler getInstance(Vacancy vacancy) {
        if (!vacancy.getCity().equals("INTERNATIONAL")) {
            if (vacancy.getVacancyType() == Vacancy.VacancyType.ONLINE) {
                return applicationContext.getBean(OnlineCompanyHandler.class);
            } else {
                return applicationContext.getBean(OfflineCompanyHandler.class);
            }
        } else {
            if (vacancy.getVacancyType() == Vacancy.VacancyType.ONLINE) {
                return applicationContext.getBean(InternationalOnlineFactoryHandler.class);
            } else {
                return applicationContext.getBean(InternationalOfflineCompanyHandler.class);
            }
        }
    }
}
