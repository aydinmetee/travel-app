package tr.com.metea.travelapp.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metea.travelapp.dto.AuthUserLoginDTO;
import tr.com.metea.travelapp.dto.AuthUserRegisterDTO;
import tr.com.metea.travelapp.dto.TokenResponseDTO;
import tr.com.metea.travelapp.serviceview.AuthUserServiceView;
import tr.com.metea.travelapp.util.JwtUtil;

import javax.validation.Valid;

/**
 * @author Mete Aydin
 * @date 23.10.2021
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthUserServiceView authUserServiceView;
    private final AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> creteToken(@RequestBody AuthUserLoginDTO authUserLoginDTO) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authUserLoginDTO.getUsername(),
                authUserLoginDTO.getPassword()));

        final var authUser = authUserServiceView.loadUserByUsername(authUserLoginDTO.getUsername());

        final var response = new TokenResponseDTO();
        response.setAccessToken(jwtUtil.generateToken(authUser));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@Valid @RequestBody AuthUserRegisterDTO authUserRegisterDTO) {
        return ResponseEntity.ok(authUserServiceView.save(authUserRegisterDTO));
    }
}
