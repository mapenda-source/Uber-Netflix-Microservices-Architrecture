package com.mapenda.architecture_netflix_uber.jwt.filter;

import com.mapenda.architecture_netflix_uber.jwt.JWTUtil;
import com.mapenda.architecture_netflix_uber.security.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    JWTUtil jwtutil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authizationHeader=request.getHeader("Authorization");

        System.out.println("AuthizationHeader->"+authizationHeader);

        String username=null;
        String jwt=null;

        if(authizationHeader!=null && authizationHeader.startsWith("Micro")) {
            jwt=authizationHeader.substring(6);
            username=jwtutil.extractUsername(jwt);

            System.out.println("JWT->"+jwt);
            System.out.println("Username->"+username);
        }

        System.out.println("doFilterInternal");
        System.out.println("doFilterInternal");


        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {

            UserDetails userDetails=this.myUserDetailsService.loadUserByUsername(username);

            System.out.println("Token is Before Valid");
            System.out.println("Token is Before Valid");
            if(jwtutil.validateToken(jwt, userDetails))
            {
                System.out.println("Token is Valid");
                System.out.println("Token is Valid");
                System.out.println("Token is Valid");
                System.out.println("Token is Valid");
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource()
                        .buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }

}
