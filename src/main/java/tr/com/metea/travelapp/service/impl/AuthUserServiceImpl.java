package tr.com.metea.travelapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.AuthUser;
import tr.com.metea.travelapp.dto.AuthUserLoginDTO;
import tr.com.metea.travelapp.dto.AuthUserRegisterDTO;
import tr.com.metea.travelapp.exception.LoginExecutionException;
import tr.com.metea.travelapp.repository.AuthUserRepository;
import tr.com.metea.travelapp.service.AuthUserService;
import tr.com.metea.travelapp.util.MessageUtil;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Mete Aydin
 * @since 23.10.2021
 */
@Service
@RequiredArgsConstructor
public class AuthUserServiceImpl implements AuthUserService, UserDetailsService {
    private final AuthUserRepository authUserRepository;
    private final ModelMapper modelMapper;
    private final MessageUtil messageUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user = authUserRepository.findAuthUserByUsername(username);
        if (Objects.isNull(user)) {
            throw new LoginExecutionException(messageUtil.get("authUser.userNotFound.exception"));
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    @Override
    public Boolean login(AuthUserLoginDTO authUserLoginDTO) {
        final var userDB = authUserRepository.findAuthUserByUsername(authUserLoginDTO.getUsername());
        if (Objects.isNull(userDB)) {
            throw new LoginExecutionException(messageUtil.get("authUser.userNotFound.exception"));
        }
        return userDB.getPassword().equals(authUserLoginDTO.getPassword());
    }

    @Override
    public AuthUser getSessionInfo() {
        final var userinfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return authUserRepository.findAuthUserByUsername(userinfo.getUsername());
    }

    @Override
    public AuthUser save(AuthUserRegisterDTO authUserRegisterDTO) {
        final var user = modelMapper.map(authUserRegisterDTO, AuthUser.class);
        return authUserRepository.save(user);
    }
}
