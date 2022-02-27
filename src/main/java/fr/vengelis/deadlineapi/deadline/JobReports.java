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

    public String getAllJobReports(String id) {
        return this.cp.get("/api/jobreports?JobID=" + id);
    }

    public String getJobErrorReports(String id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=error");
    }

    public String getJobLogReports(String id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=log");
    }

    public String getJobRequeueReports(String id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=requeue");
    }

    public String getJobHistoryEntries(String id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=history");
    }

    public String getAllJobReportsContents(String id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=allcontents");
    }

    public String getAllJobErrorReportsContents(String id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=allerrorcontents");
    }

    public String getAllJobLogReportsContents(String id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=alllogcontents");
    }

    public String getAllJobRequeueReportContents(String id) {
        return this.cp.get("/api/jobreports?JobID=" + id + "&Data=allrequeuecontents");
    }

    public String getJobErrorReportContents(String jobId, String reportId) {
        return this.cp.get("/api/jobreports?JobID=" + jobId + "&ReportID=" + reportId + "&Data=errorcontents");
    }

    public String getJobLogReportContents(String jobId, String reportId) {
        return this.cp.get("/api/jobreports?JobID" + jobId + "&ReportID=" + reportId + "&Data=logcontents");
    }

    public String getJobRequeueReportContents(String jobId, String reportId) {
        return this.cp.get("/api/jobreports?JobID=" + jobId + "&ReportID=" + reportId + "&Data=requeuecontents");
    }
}
