/**
 * Created by Vengelis_.
 * Date: 2/24/2022
 * Time: 3:58 AM
 * Project: DeadlineAPI
 */

package fr.vengelis.deadlineapi.deadline;

public class JobTaskLimit {

    private ConnectionProperty cp;

    public JobTaskLimit(ConnectionProperty cp) {
        this.cp = cp;
    }

    public String getJobTaskLimit() {
        return this.cp.get("/api/jobtesklimit");
    }
}
