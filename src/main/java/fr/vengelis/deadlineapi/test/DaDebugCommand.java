/**
 * Created by Vengelis_.
 * Date: 2/24/2022
 * Time: 2:51 AM
 * Project: DeadlineAPI
 */

package fr.vengelis.deadlineapi.test;

import com.google.gson.JsonParser;
import fr.vengelis.deadlineapi.DeadlineApiPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.json.JSONObject;

public class DaDebugCommand implements CommandExecutor {

    private final DeadlineApiPlugin MAIN = DeadlineApiPlugin.getInstance();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("dadebug")){
//            Bukkit.getServer().broadcastMessage(MAIN.dc.getJobs().getJob("621526e5832c56143c3a2148,621527ed832c56143c3a214b"));

            String ja = new JsonParser().parse(MAIN.dc.getJobs().getJob("621526e5832c56143c3a2148")).getAsJsonArray().get(0).toString();

            JSONObject jo = new JSONObject(ja);

//            Bukkit.getServer().broadcastMessage(jo.toString());
//            Bukkit.getServer().broadcastMessage(jo.get("Props").toString());

            JSONObject jo2 = new JSONObject(jo.get("Props"));

            Bukkit.getServer().broadcastMessage(jo2.toString());
//            JSONObject jo2 = new JSONObject(jo.get("Limits"));
//            Bukkit.getServer().broadcastMessage(jo2.toString());
//            jo2.put("Ex0", "test");

//            jo.put("Props", jo2);
//            Bukkit.getServer().broadcastMessage(jo.toString());
//            Bukkit.getServer().broadcastMessage(jo2.toString());

//            Bukkit.getServer().broadcastMessage(MAIN.dc.getJobs().saveJob(jo.toString()));

            return true;
        } else {
            return false;
        }
    }

}
