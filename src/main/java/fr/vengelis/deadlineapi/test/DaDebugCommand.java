/**
 * Created by Vengelis_.
 * Date: 2/24/2022
 * Time: 2:51 AM
 * Project: DeadlineAPI
 */

package fr.vengelis.deadlineapi.test;

import fr.vengelis.deadlineapi.DeadlineApiPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DaDebugCommand implements CommandExecutor {

    private final DeadlineApiPlugin MAIN = DeadlineApiPlugin.getInstance();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("dadebug")){
            Bukkit.getServer().broadcastMessage(MAIN.dc.getGroups().addGroup("test2"));
            return true;
        } else {
            return false;
        }
    }

}
