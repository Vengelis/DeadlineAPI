/**
 * Created by Vengelis_.
 * Date: 2/24/2022
 * Time: 3:58 AM
 * Project: DeadlineAPI
 */

package fr.vengelis.deadlineapi.deadline;

public class MaximumPriority {

    private ConnectionProperty cp;

    public MaximumPriority(ConnectionProperty cp) {
        this.cp = cp;
    }

    public String getMaximumPriority() {
        return this.cp.get("/api/maximumpriority");
    }
}
