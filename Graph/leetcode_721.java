package Graph;
import java.util.*;

public class leetcode_721 {
    class DisJoint{
        List<Integer> p = new ArrayList<>();
        List<Integer> s = new ArrayList<>();

        DisJoint(int v){
            for(int i = 0;i<v;i++){
                p.add(i);
                s.add(1);
            }
        }

        int findPar(int n){
            if(n==p.get(n)){
                return n;
            }
            int ulp = findPar(p.get(n));
            p.set(n,ulp);
            return p.get(n);
        }

        void unionBySize(int u, int v){
            int ulp_u = findPar(u);
            int ulp_v = findPar(v);

            if(ulp_u==ulp_v){
                return;
            }

            if(s.get(ulp_u)<s.get(ulp_v)){
                p.set(ulp_u,ulp_v);
                s.set(ulp_v,s.get(ulp_u)+s.get(ulp_v));
            }else{
                p.set(ulp_v,ulp_u);
                s.set(ulp_u,s.get(ulp_u)+s.get(ulp_v));
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        return solve(accounts);
    }

    List<List<String>> solve(List<List<String>> ac){
        int n = ac.size();
        DisJoint ds = new DisJoint(n);
        Map<String,Integer> mp = new HashMap<>();

        for(int i = 0;i<n;i++){
            for(int j = 1;j<ac.get(i).size();j++){
                String mail = ac.get(i).get(j);
                if(mp.containsKey(mail)==false){
                    mp.put(mail,i);
                }else{
                    ds.unionBySize(i,mp.get(mail));
                }
            }
        }

        List<String>[] mergeMail = new ArrayList[n];
        for(int i = 0;i<n;i++){
            mergeMail[i] = new ArrayList<>();
        }

        for(Map.Entry<String,Integer> en : mp.entrySet()){
            String mail = en.getKey();
            int node = ds.findPar(en.getValue());
            mergeMail[node].add(mail);
        }

        List<List<String>> res = new ArrayList<>();

        for(int i = 0;i<n;i++){
            if(mergeMail[i].size()==0)continue;
            Collections.sort(mergeMail[i]);

            List<String> curr = new ArrayList<>();
            curr.add(ac.get(i).get(0));
            for(String it : mergeMail[i]){
                curr.add(it);
            }
            res.add(curr);
        }

        return res;
    }
}
