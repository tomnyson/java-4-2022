/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tomnyson
 */
@WebFilter("/api/*")
public class FilterJWT implements Filter {

    private static final String AUTH_HEADER_KEY = "Authorization";
    private static final String AUTH_HEADER_VALUE_PREFIX = "Bearer "; // with trailing space to separate token

    private static final int STATUS_CODE_UNAUTHORIZED = 401;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest servletRequest,
            final ServletResponse servletResponse,
            final FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        boolean loggedIn = false;
        try {

            String jwt = getBearerToken(httpRequest);
            if (jwt != null && !jwt.isEmpty()) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

                HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
                httpResponse.setContentLength(0);
                httpResponse.setStatus(STATUS_CODE_UNAUTHORIZED);
        } catch (final Exception e) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.setContentLength(0);
            httpResponse.setStatus(STATUS_CODE_UNAUTHORIZED);
        }
    }

    @Override
    public void destroy() {
    }

    /**
     * Get the bearer token from the HTTP request. The token is in the HTTP
     * request "Authorization" header in the form of: "Bearer [token]"
     */
    private String getBearerToken(HttpServletRequest request) {
        String authHeader = request.getHeader(AUTH_HEADER_KEY);
        if (authHeader != null && authHeader.startsWith(AUTH_HEADER_VALUE_PREFIX)) {
            return authHeader.substring(AUTH_HEADER_VALUE_PREFIX.length());
        }
        return null;
    }

}
