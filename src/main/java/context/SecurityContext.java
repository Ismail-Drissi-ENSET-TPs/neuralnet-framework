package context;

public class SecurityContext {
    public static String username;
    public static String password;
    public static String[] roles;

    public static void authenticate(String u, String p, String[] r){
        username = u;
        password = p;
        roles = r;
    }

    public static boolean hasRole(String role){
        if (roles == null) return false;
        for (var r: roles){
            if(r.equals(role)){
                return true;
            }
        }
        return false;
    }
}
