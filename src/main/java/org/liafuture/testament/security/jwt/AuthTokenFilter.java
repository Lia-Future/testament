package org.liafuture.testament.security.jwt;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthTokenFilter.class);
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtils;

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain) throws ServletException, IOException {
        try {
            final Optional<String> userNameFromJWT = getUserNameFromJWT(request);

            if (userNameFromJWT.isPresent()) {
                final UserDetails userDetails = this.userDetailsService.loadUserByUsername(userNameFromJWT.get());

                final var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (final Exception e) {
            LOGGER.error("Cannot set user authentication: {}", e);
        }

        filterChain.doFilter(request, response);
    }

    private Optional<String> getUserNameFromJWT(final HttpServletRequest request) {
        final String jwt = parseJwt(request);

        if (!isValidJwtToken(jwt)) {
            return Optional.empty();
        }

        return Optional.of(this.jwtUtils.getUserNameFromJwtToken(jwt));
    }


    private boolean isValidJwtToken(final String jwt) {

        return jwt != null && this.jwtUtils.validateJwtToken(jwt);
    }

    private String parseJwt(final HttpServletRequest request) {
        final String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }

        return null;
    }
}
