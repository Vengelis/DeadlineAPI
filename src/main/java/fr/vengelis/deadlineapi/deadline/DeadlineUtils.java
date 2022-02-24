/**
 * Created by Vengelis_.
 * Date: 2/24/2022
 * Time: 3:48 AM
 * Project: DeadlineAPI
 */

package fr.vengelis.deadlineapi.deadline;

import java.util.List;

public class DeadlineUtils {

    public static String ArrayToCommaSeparatedString(List<String> iterable) {

        if(iterable.isEmpty()){
            return "";
        } else {
            String returnable = "";
            for(String item: iterable){
                returnable = returnable + item + ",";
            }
            return returnable;
        }

    }

}
