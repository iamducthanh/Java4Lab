package com.fpoly.dao.impl;

import com.fpoly.dao.GenegicDao;
import com.fpoly.dao.IReportDao;
import com.fpoly.entity.Report;

import java.util.List;

public class ReportDao extends AbstractDao<Report> implements IReportDao {
    @Override
    public List<Report> getListReport() {
        List<Report> listReport = excuteQuery("thongKe", Report.class);
        return listReport.isEmpty() ? null : listReport;
    }
}
