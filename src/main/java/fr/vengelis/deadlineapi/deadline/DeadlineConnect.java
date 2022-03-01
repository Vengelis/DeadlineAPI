/**
 * Created by Vengelis_.
 * Date: 2/24/2022
 * Time: 2:54 AM
 * Project: DeadlineAPI
 */

package fr.vengelis.deadlineapi.deadline;

import fr.vengelis.deadlineapi.interfaces.IDeadlineConnect;

public class DeadlineConnect implements IDeadlineConnect {

    private ConnectionProperty cp;
    private Groups groups;
    private JobReports jobReports;
    private Jobs jobs;
    private JobTaskLimit jobTaskLimit;
    private Limits limits;

    private MaximumPriority maximumPriority;

    public DeadlineConnect(String host, Integer port) {
        String address = host + ":" + port.toString();
        cp = new ConnectionProperty(address);

        System.out.println("CP Created");

        groups = new Groups(cp);
        jobReports = new JobReports(cp);
        jobs = new Jobs(cp);
        jobTaskLimit = new JobTaskLimit(cp);
        limits = new Limits(cp);

        maximumPriority = new MaximumPriority(cp);

    }

    public Groups getGroups() {
        return this.groups;
    }

    public JobReports getJobReports() {
        return jobReports;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public JobTaskLimit getJobTaskLimit() {
        return jobTaskLimit;
    }

    public Limits getLimits() {
        return limits;
    }



    public MaximumPriority getMaximumPriority() {
        return maximumPriority;
    }
}
