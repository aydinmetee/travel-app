package tr.com.metea.travelapp.service;


import tr.com.metea.travelapp.domain.AuthUser;
import tr.com.metea.travelapp.dto.AuthUserLoginDTO;
import tr.com.metea.travelapp.dto.AuthUserRegisterDTO;

/**
 * @author Mete Aydin
 * @date 23.10.2021
 */
public interface AuthUserService {
    Boolean login(AuthUserLoginDTO authUserLoginDTO);

    AuthUser getSessionInfo();

    AuthUser save(AuthUserRegisterDTO authUserRegisterDTO);

}
