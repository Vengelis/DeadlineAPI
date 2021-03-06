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

    public DeadlineConnect(String host, Integer port) {
        String address = host + ":" + port.toString();
        cp = new ConnectionProperty(address);

        System.out.println("CP Created");

        groups = new Groups(cp);
        jobReports = new JobReports(cp);
        jobs = new Jobs(cp);

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
}
