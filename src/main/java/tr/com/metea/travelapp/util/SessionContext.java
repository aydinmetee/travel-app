package tr.com.metea.travelapp.util;

public class SessionContext {
    private static final ThreadLocal<SessionInfo> THREAD_LOCAL_SESSION_INFO = new ThreadLocal();

    public static SessionInfo getSessionData() {
        SessionInfo sessionInfo = THREAD_LOCAL_SESSION_INFO.get();
        return sessionInfo;
    }

    public static void setSessionData(SessionInfo sessionInfo) {
        THREAD_LOCAL_SESSION_INFO.set(sessionInfo);
    }

    public static void removeSessionData() {
        THREAD_LOCAL_SESSION_INFO.remove();
    }
}
