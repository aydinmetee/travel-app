package tr.com.metea.travelapp.serviceview.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.dto.AuthUserLoginDTO;
import tr.com.metea.travelapp.dto.AuthUserRegisterDTO;
import tr.com.metea.travelapp.service.impl.AuthUserServiceImpl;
import tr.com.metea.travelapp.serviceview.AuthUserServiceView;


import java.util.Objects;

/**
 * @author Mete Aydin
 * @date 23.10.2021
 */
@Service
@RequiredArgsConstructor
public class AuthUserServiceViewImpl implements AuthUserServiceView {
    private final AuthUserServiceImpl authUserService;

    @Override
    public Boolean login(AuthUserLoginDTO authUserLoginDTO) {
        return authUserService.login(authUserLoginDTO);
    }

    @Override
    public Boolean save(AuthUserRegisterDTO authUserRegisterDTO) {
        final var authUser = authUserService.save(authUserRegisterDTO);
        if (Objects.isNull(authUser)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return authUserService.loadUserByUsername(username);
    }
}
