/**
 * Created by Vengelis_.
 * Date: 2/24/2022
 * Time: 3:58 AM
 * Project: DeadlineAPI
 */

package fr.vengelis.deadlineapi.deadline;

public class Plugins {

    private ConnectionProperty cp;

    public Plugins(ConnectionProperty cp) {
        this.cp = cp;
    }

    public String getPluginNames() {
        return this.cp.get("/api/plugins");
    }

    public String getEventPluginNames() {
        return this.cp.get("/api/plugins?EventNames=true");
    }
}
