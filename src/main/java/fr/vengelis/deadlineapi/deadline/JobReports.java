/**
 * Created by Vengelis_.
 * Date: 2/24/2022
 * Time: 3:57 AM
 * Project: DeadlineAPI
 */

package fr.vengelis.deadlineapi.deadline;

public class JobReports {

    private ConnectionProperty cp;

    public JobReports(ConnectionProperty connectionProperty) {
        this.cp = connectionProperty;
    }

    public String getAllJobReports(Long id) {
        return this.cp.get("/api/jobreports?JobID=" + id);
    }

    public String getJobErrorReports(Long id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=error");
    }

    public String getJobLogReports(Long id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=log");
    }

    public String getJobRequeueReports(Long id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=requeue");
    }

    public String getJobHistoryEntries(Long id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=history");
    }

    public String getAllJobReportsContents(Long id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=allcontents");
    }

    public String getAllJobErrorReportsContents(Long id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=allerrorcontents");
    }

    public String getAllJobLogReportsContents(Long id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=alllogcontents");
    }

    public String getAllJobRequeueReportContents(Long id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=allrequeuecontents");
    }

    public String getJobErrorReportContents(Long jobId, Long reportId) {
        return this.cp.get("/api/jobreports?JobID=" + jobId + "&ReportID=" + reportId + "&Data=errorcontents");
    }

    public String getJobLogReportContents(Long jobId, Long reportId) {
        return this.cp.get("/api/jobreports?JobID" + jobId + "&ReportID=" + reportId + "&Data=logcontents");
    }

    public String getJobRequeueReportContents(Long jobId, Long reportId) {
        return this.cp.get("/api/jobreports?JobID=" + jobId + "&ReportID=" + reportId + "&Data=requeuecontents");
    }
}
