package String;

public class leetcode_468 {
    public String validIPAddress(String queryIP) {
        return validIp(queryIP);
    }
    String validIp(String s){
        if(s.contains(".")){
            String []ipv4 = s.split("\\.",-1);
            if(ipv4.length==4){
                return isIPV4(ipv4);
            }
            return "Neither";
        }else if(s.contains(":")){

            String []ipv6 = s.split("\\:",-1);
            if(ipv6.length==8){
                return isIPV6(ipv6);
            }
        }
        return "Neither";

    }

    String isIPV4(String[]arr){
        boolean is = false;
        for(String s : arr){
            if(s.length()==0 || s.length()>=4){
                return "Neither";
            }

            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) return "Neither";
            }

            if (s.length() > 1 && s.charAt(0) == '0') return "Neither";

            int val = Integer.parseInt(s);
            if (val < 0 || val > 255) return "Neither";
        }

        return "IPv4";
    }

    String isIPV6(String[] arr){

        for(String s : arr){
            if(!isHexa(s) || s.length()>4){
                return "Neither";
            }
        }

        return "IPv6";
    }

    boolean isHexa(String s){
        return s.matches("^[0-9A-Fa-f]+$");
    }
}
