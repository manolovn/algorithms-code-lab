package dev.manolovn.accountsmerge;

import java.util.*;

/**
 * source: https://leetcode.com/problems/accounts-merge/
 * difficulty: MEDIUM
 * topic: DFS + UNION-FIND
 */
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> acc : accounts) {
            String name = "";
            for (String email : acc) {
                if (name.equals("")) {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x -> new ArrayList<>()).add(acc.get(1));
                graph.computeIfAbsent(acc.get(1), x -> new ArrayList<>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack<>();
                stack.push(email);
                List<String> comp = new ArrayList<>();
                while (!stack.empty()) {
                    String node = stack.pop();
                    comp.add(node);
                    for (String nei : graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(comp);
                comp.add(0, emailToName.get(email));
                ans.add(comp);
            }
        }

        return ans;
    }
}
