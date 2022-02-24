package fr.vengelis.deadlineapi.interfaces;

import java.util.List;

public interface IGroups {

    String getGroupNames();

    String addGroup(String name);

    String addGroups(List<String> names);

    String purgeGroups(String replacementGroup, List<String> groups, Boolean overwrite);

    String deleteGroup(String name);

    String deleteGroups(List<String> names);
}
