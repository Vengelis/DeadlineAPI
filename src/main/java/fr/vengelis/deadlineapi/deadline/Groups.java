/**
 * Created by Vengelis_.
 * Date: 2/24/2022
 * Time: 2:43 AM
 * Project: DeadlineAPI
 */

package fr.vengelis.deadlineapi.deadline;

import fr.vengelis.deadlineapi.interfaces.IGroups;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import java.util.List;

public class Groups implements IGroups {

    private ConnectionProperty cp;

    public Groups(ConnectionProperty connectionProperty) {
        this.cp = connectionProperty;
    }

    public String getGroupNames() {
        return cp.get("/api/groups");
    }

    public String addGroup(String name) {
        String body = "{\"Group\":\"" + name + "\"}";
        return cp.post("/api/groups", body);
    }

    public String addGroups(List<String> names) {
        String body = "{\"Group\":\"" + JSONArray.toJSONString(names) + "\"}";
        return cp.post("/api/groups", body);
    }

    public String purgeGroups(String replacementGroup, List<String> groups, Boolean overwrite) {
        String body = "{\"ReplacementGroup\":\"" +replacementGroup+ "\", \"Group\":" +JSONArray.toJSONString(groups)+ ", \"OverWrite\":" + JSONValue.toJSONString(overwrite) +'}';
        return cp.put("/api/groups", body);
    }

    public String deleteGroup(String name) {
        return cp.delete("/api/groups?Group=" + name.replace(' ', '+'));
    }

    public String deleteGroups(List<String> names) {
        return cp.delete("/api/groups?Group=" + DeadlineUtils.ArrayToCommaSeparatedString(names).replace(' ', '+'));
    }
}
