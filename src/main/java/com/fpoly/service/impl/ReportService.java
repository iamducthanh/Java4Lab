package com.fpoly.service.impl;

import com.fpoly.dao.impl.ReportDao;
import com.fpoly.entity.Report;
import com.fpoly.service.IReportService;

import javax.inject.Inject;
import java.util.List;

public class ReportService implements IReportService {
    @Inject
    private ReportDao reportDao;

    @Override
    public List<Report> getListReport() {
        return reportDao.getListReport();
    }
}
