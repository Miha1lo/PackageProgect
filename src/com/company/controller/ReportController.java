package com.company.controller;

import com.company.dto.ReportDto;
import com.company.dto.ReportTopDto;
import com.company.model.Store;
import com.company.service.ReportService;
import com.company.view.ReportView;
import com.company.view.ReportViewTop;

public class ReportController {

    public void execute(Store[] stores) {
        ReportService reportService = new ReportService(stores);
        ReportDto report = reportService.build();
        ReportTopDto reportTop = reportService.buildTop(report);
        ReportView view = new ReportView();
        view.printDetails(report);
    }

    public void executeTop(Store[] stores, int numTop) {
        ReportService reportService = new ReportService(stores);
        ReportDto report = reportService.build();
        ReportTopDto reportTop = reportService.buildTop(report);
        ReportViewTop viewTop = new ReportViewTop();
        viewTop.printDetails(reportTop, numTop);
    }
}
