package tr.com.metea.travelapp.serviceview;

import org.springframework.security.core.userdetails.UserDetails;
import tr.com.metea.travelapp.dto.AuthUserLoginDTO;
import tr.com.metea.travelapp.dto.AuthUserRegisterDTO;


/**
 * @author Mete Aydin
 * @date 23.10.2021
 */
public interface AuthUserServiceView {
    Boolean login(AuthUserLoginDTO authUserLoginDTO);

    Boolean save(AuthUserRegisterDTO authUserRegisterDTO);

    UserDetails loadUserByUsername(String username);
}
