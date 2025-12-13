
package com.sweetshop.Sweet_Shop_Management.Config;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {
    
    @Autowired
    private  JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) {

        try {
            String header = request.getHeader("Authorization");

            if (header != null && header.startsWith("Bearer ")) {
                String token = header.substring(7);

                if (jwtUtil.validateToken(token)) {
                    String username = jwtUtil.extractUsername(token);
                    String role = jwtUtil.extractRole(token);

                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(
                                    username,
                                    null,
                                    List.of(new SimpleGrantedAuthority("ROLE_" + role))
                            );

                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}