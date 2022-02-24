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

    public DeadlineConnect(String host, Integer port) {
        String address = host + ":" + port.toString();
        cp = new ConnectionProperty(address);

        System.out.println("CP Created");

        groups = new Groups(cp);

    }

    public Groups getGroups() {
        return this.groups;
    }
}
