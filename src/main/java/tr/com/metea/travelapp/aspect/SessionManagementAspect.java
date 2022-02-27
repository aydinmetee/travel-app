package tr.com.metea.travelapp.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tr.com.metea.travelapp.service.AuthUserService;
import tr.com.metea.travelapp.util.SessionContext;
import tr.com.metea.travelapp.util.SessionInfo;

@Aspect
@RequiredArgsConstructor
@Component
public class SessionManagementAspect {

    private static final Logger LOG = LoggerFactory.getLogger(SessionManagementAspect.class);
    private final AuthUserService authUserService;


    @Before("execution(* tr.com.metea.travelapp.service.ProfileService.*(..)) || " +
            "execution(* tr.com.metea.travelapp.service.CrewMasterService.*(..)) || " +
            "execution(* tr.com.metea.travelapp.service.CrewDetailService.*(..)) || " +
            "execution(* tr.com.metea.travelapp.service.BikeService.*(..)) || " +
            "execution(* tr.com.metea.travelapp.service.TripDetailService.*(..)) || " +
            "execution(* tr.com.metea.travelapp.service.TripMasterService.*(..))")
    public void setSessionData(JoinPoint joinPoint) {
        LOG.info("[ Executed method {} ]", joinPoint.toString());
        final var sessionInfo = new SessionInfo();
        final var authUser = authUserService.getSessionInfo();
        sessionInfo.setUserId(authUser.getId());
        sessionInfo.setEmail(authUser.getEmail());
        SessionContext.setSessionData(sessionInfo);
    }

    @After("execution(* tr.com.metea.travelapp.endpoint.ProfilesController.*(..)) || " +
            "execution(* tr.com.metea.travelapp.endpoint.CrewController.*(..)) || " +
            "execution(* tr.com.metea.travelapp.endpoint.TripController.*(..))")
    public void clearSessionData() throws Throwable {
        LOG.info("[ Executed method AFTER ]");
    }

}
