package fr.vengelis.deadlineapi;

import fr.vengelis.deadlineapi.deadline.DeadlineConnect;
import fr.vengelis.deadlineapi.test.DaDebugCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class DeadlineApiPlugin extends JavaPlugin {

    private static DeadlineApiPlugin instance;

    // TODO: Start of Debug Zone

    public DeadlineConnect dc;

    // TODO: End of Debug Zone
    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onDisable() {
        getLogger().warning("DeadlineAPI has been disabled. Dependent plugins may generate errors!");
    }

    @Override
    public void onEnable() {

        // TODO: Start of Debug Zone

        dc = new DeadlineConnect("localhost", 8081);
        getCommand("dadebug").setExecutor(new DaDebugCommand());

        // TODO: End of Debug Zone

        getLogger().info("DeadlineAPI has been enabled.");
    }

    public static DeadlineApiPlugin getInstance() {
        return instance;
    }
}
