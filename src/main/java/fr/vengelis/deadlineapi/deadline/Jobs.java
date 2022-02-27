/**
 * Created by Vengelis_.
 * Date: 2/24/2022
 * Time: 3:57 AM
 * Project: DeadlineAPI
 */

package fr.vengelis.deadlineapi.deadline;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.scoreboard.Objective;
import org.json.simple.JSONArray;

import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Jobs {

    private ConnectionProperty cp;

    public Jobs(ConnectionProperty cp) {
        this.cp = cp;
    }

    public String getJobIds() {
        return this.cp.get("/api/jobs?IdOnly=true");
    }

    public String getJobs(List<String> ids) {
        String script = "/api/jobs";
        if(!(ids == null)){
            script = script + "?JobID=" + DeadlineUtils.ArrayToCommaSeparatedString(ids);
        }
        return this.cp.get(script);
    }

    public String calculateJobStatistics(String jobId) {
        return this.cp.get("/api/jobs?JobID=" + jobId + "&Statistics=true");
    }

    public String getJobsInState(List<String> states) {
        return this.cp.get("/api/jobs?States=" + DeadlineUtils.ArrayToCommaSeparatedString(states));
    }

    public String getJob(String id) {
        return this.cp.get("/api/jobs?JobID=" + id);
    }

    public String getJob(List<String> ids) {
        return this.cp.get("/api/jobs?JobID=" + DeadlineUtils.ArrayToCommaSeparatedString(ids));
    }

    public String saveJob(String jobData) {
        JsonObject jsonData = new JsonParser().parse(jobData).getAsJsonObject();
        String body = "{\"Command\":\"save\", \"Job\":" + jsonData + "}";
        return this.cp.put("/api/jobs", body);
    }

    public String suspendJob(String id) {
        String body = "{\"Command\":\"suspend\", \"JobID\":\"" + id + "\"}";
        return this.cp.put("/api/jobs", body);
    }

    public String suspendJobNonRenderingTasks(String id) {
        String body = "{\"Command\":\"suspendnonrendering\", \"JobID\":\"" + id + "\"}";
        return this.cp.put("/api/jobs", body);
    }

    public String resumeJob(String id) {
        String body = "{\"Command\":\"resume\", \"JobID\":\"" + id + "\"}";
        return this.cp.put("/api/jobs", body);
    }

    public String resumeFailedJob(String id) {
        String body = "{\"Command\":\"resumefailed\", \"JobID\":\"" + id + "\"}";
        return this.cp.put("/api/jobs", body);
    }

    public String deleteJob(String id) {
        return this.cp.delete("/api/jobs?JobID=" + id);
    }

    public String requeueJob(String id) {
        String body = "{\"Command\":\"requeue\", \"JobID\":\"" + id + "\"}";
        return this.cp.put("/api/jobs", body);
    }

    public String archiveJob(String id) {
        String body = "{\"Command\":\"archive\", \"JobID\":\"" + id + "\"}";
        return this.cp.put("/api/jobs", body);
    }

    public String importJob(String file) {
        String body = "{\"Command\":\"import\", \"File\":\"" + file + "\"}";
        return this.cp.put("/api/jobs", body);
    }

    public String pendJob(String id) {
        String body = "{\"Command\":\"pend\", \"JobID\":\"" + id + "\"}";
        return this.cp.put("/api/jobs", body);
    }

    public String releasePendingJob(String id) {
        String body = "{\"Command\":\"releasepending\", \"JobID\":\"" + id + "\"}";
        return this.cp.put("/api/jobs", body);
    }

    public String completeJob(String id) {
        String body = "{\"Command\":\"complete\", \"JobID\":\"" + id + "\"}";
        return this.cp.put("/api/jobs", body);
    }

    public String failedJob(String id) {
        String body = "{\"Command\":\"fail\", \"JobID\":\"" + id + "\"}";
        return this.cp.put("/api/jobs", body);
    }

    public String updateJobSubmissionDate(String id) {
        String body = "{\"Command\":\"updatesubmissiondate\", \"JobID\":\"" + id + "\"}";
        return this.cp.put("/api/jobs", body);
    }

    public String submitJobFiles(String info, String plugin, String[] aux, Boolean idOnly) {
        return this.cp.post("/api/jobs", buildJobSubmission(info, plugin, aux, idOnly));
    }

    public String submitJob(String info, String plugin, String[] aux, Boolean idOnly) {
        Gson g = new Gson();
        String body = "{\"JobInfo\":" + g.toJson(info) + ",\"PluginInfo\":" + g.toJson(plugin) + ",\"AuxFiles" + g.toJson(aux);
        if(idOnly){
            body += ",\"IdOnly\":true";
        }
        body += "}";
        return this.cp.post("/api/jobs", body);
    }

    public String submitJobs(String[] jobs, String dependant) {
        Gson g = new Gson();
        String body = "\"Jobs\":" + g.toJson(jobs) + ",\"Dependant\":\"" + dependant.toLowerCase() + "\"}";
        return this.cp.post("/api/jobs", body);
    }

    public String setJobMachineLimit(String id, String limit, String slaveList, Boolean whitelistFlag) {
        Gson g = new Gson();
        String body = g.toJson("{\"Command\":\"setjobmachinelimit\",\"JobID\":" + id + ", \"Limit\":" + limit + ", \"SlaveList\":" + slaveList + ",\"WhiteListFlag\":" + whitelistFlag + "}");
        return this.cp.put("/api/jobs", body);
    }

    public String addSlavesToJobMachineLimitList(String id, String slaveList) {
        Gson g = new Gson();
        String body = g.toJson("{\"Command\":\"addslavestojobmachinelimitlist\",\"JobID\":" + id + ", \"SlaveList\":" + slaveList + "}");
        return this.cp.put("/api/jobs", body);
    }

    public String removeSlaveFromJobMachineLimitList(String id, String slaveList) {
        Gson g = new Gson();
        String body = g.toJson("{\"Command\":\"removeslavesfromjobmachinelimitlist\",\"JobID\":" + id + ", \"SlaveList\":" + slaveList + "}");
        return this.cp.put("/api/jobs", body);
    }

    public String setJobMachineLimitListedSlaves(String id, String slaveList) {
        Gson g = new Gson();
        String body = g.toJson("{\"Command\":\"setjobmachinelimitlistedslaves\",\"JobID\":" + id + ", \"SlaveList\":" + slaveList + "}");
        return this.cp.put("/api/jobs", body);
    }

    public String setJobMachineLimitWhiteListFlag(String id, Boolean whitelistFlag) {
        Gson g = new Gson();
        String body = g.toJson("{\"Command\":\"setjobmachinelimitwhitelistflag\",\"JobID\":" + id + ", \"WhiteListFlag\":" + whitelistFlag + "}");
        return this.cp.put("/api/jobs", body);
    }







    public String buildJobSubmission(String info, String plugins, String[] aux, Boolean idOnly) {

        String infoText = fileRead(info);
        String pluginText = fileRead(plugins);
        Gson g = new Gson();
        String body = "{\"JobInfo\":" + infoText + ",\"PluginInfo\":" + pluginText + ",\"AuxFiles" + g.toJson(aux);
        if(idOnly){
            body += ",\"IdOnly\":true";
        }
        body += "}";
        return body;

    }


    public String fileRead(String fileLocation) {

        String obj = "{";

        try{
            URI uri = Objects.requireNonNull(this.getClass().getResource(fileLocation)).toURI();
            List<String> lines = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());

            for(String line: lines){
                line = line.replace("\n", "");
                line = line.replace("\t", "");

                String[] tokens = line.split("=",1);
                if(tokens.length == 2){
                    obj = obj + tokens[0] + "\":\"" + tokens[1] + "\",";
                }
            }
            obj = StringUtils.chop(obj) + "}";
            return obj;
        }catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

}
