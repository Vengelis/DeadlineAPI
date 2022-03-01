/**
 * Created by Vengelis_.
 * Date: 2/24/2022
 * Time: 3:58 AM
 * Project: DeadlineAPI
 */

package fr.vengelis.deadlineapi.deadline;

import com.google.gson.Gson;

import java.util.List;

public class Limits {

    private ConnectionProperty cp;

    public Limits(ConnectionProperty cp) {
        this.cp = cp;
    }

    public String getLimitGroupNames() {
        return this.cp.get("/api/limitgroups?NamesOnly=true");
    }

    public String getLimitGroup(String name) {
        return this.cp.get("/api/limitgroups?Name=" + name.replace(" ", "+"));
    }

    public String getLimitGroups(List<String> names) {
        String script = "/api/limitgroups";
        if(!names.isEmpty()) {
            script = script + "?Names=" + DeadlineUtils.ArrayToCommaSeparatedString(names);
        }
        return this.cp.get(script);
    }

    public String setLimitGroups(String name, String limit, String slaveList, Boolean whitelistFlag, String progress, String excludedSlaves) {
        String body = "{\"Command\":\"set\", \"Name\":\"" + name + '"';
        if(!(limit == null)) {
            body = body + ",\"Limit\":" + limit;
        }
        if(!(whitelistFlag == null)) {
            body = body + ",\"White\":" + whitelistFlag.toString();
        }
        if(!(progress == null)) {
            body = body + ",\"RelPer\":" + progress;
        }
        if(!(slaveList == null)) {
            Gson g = new Gson();
            body = body + ",\"Slaves\":" + g.toJson(slaveList);
        }
        if(!(excludedSlaves == null)) {
            Gson g = new Gson();
            body = body + ",\"SlavesEx\":" + g.toJson(excludedSlaves);
        }
        body = body + '}';
        return this.cp.put("/api/limitgroups", body);
    }

    public String saveLimitGroup(String info) {
        Gson g = new Gson();
        String body = "{\"Command\":\"save\", \"LimitGroup\":" + g.toJson(info) + '}';
        return this.cp.put("/api/limitgroups", body);
    }

    public String deleteLimitGroup(List<String> names) {
        return this.cp.delete("/api/limitgroups?Names=" + DeadlineUtils.ArrayToCommaSeparatedString(names));
    }

    public String resetLimitGroup(String name) {
        String body = "{\"Command\":\"reset\", \"Name\":\"" + name + "\"}";
        return this.cp.put("/api/limitgroups", body);
    }
}
