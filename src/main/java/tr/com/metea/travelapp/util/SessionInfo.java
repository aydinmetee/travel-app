package tr.com.metea.travelapp.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class SessionInfo implements Cloneable, Serializable {
    private String userId;
    private String email;


    @Override
    public SessionInfo clone() {
        var cloneSessionInfo = new SessionInfo();
        cloneSessionInfo.setUserId(this.userId);
        cloneSessionInfo.setEmail(this.email);

        return cloneSessionInfo;
    }
}
