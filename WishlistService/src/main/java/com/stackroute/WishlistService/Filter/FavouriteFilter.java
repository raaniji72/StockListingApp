package com.stackroute.WishlistService.Filter;
 
 
import java.io.IOException;
 
 
import org.springframework.http.HttpMethod;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
 
public class FavouriteFilter extends GenericFilter{
 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		HttpServletRequest httpreq=(HttpServletRequest) request;
		HttpServletResponse httpres=(HttpServletResponse) response;
		httpres.setHeader("Access-Control-Allow-Origin", "*");
		httpres.setHeader("Access-Control-Allow-Headers", "*");
		httpres.setHeader("Access-Control-Allow-Credentials", "true");
		httpres.setHeader("Access-Control-Allow-Methods","POST,GET,PUT,DELETE,OPTIONS");
		//to handle preflight request for the first time which is raised by webbrowser ,when UI is based on script
		if (httpreq.getMethod().equals(HttpMethod.OPTIONS.name()))
		{
			chain.doFilter(httpreq, httpres);
		}
		else
		{
		String headerinfo=httpreq.getHeader("Authorization");
		System.out.println(headerinfo);
		if( (headerinfo==null) || (!headerinfo.startsWith("Bearer")))
		{
			throw new ServletException("JWT Token is missing");
		}
		String mytoken=headerinfo.substring(7);

		try
		{
		JwtParser jwtparser=(JwtParser) Jwts.parser().setSigningKey("secret");
		Jwt jwtobj=	jwtparser.parse(mytoken);
		Claims claimobj=(Claims) jwtobj.getBody();
		System.out.println("User logged in " + claimobj.getSubject() + " his role is " + claimobj.getAudience() );
				HttpSession sess=httpreq.getSession();
				sess.setAttribute("username", claimobj.getSubject());
		}
		catch(SignatureException e)
		{
			throw new ServletException("Invalid siganature / token ");
		}
		catch(MalformedJwtException  e)
		{
		 throw new ServletException("Someone illegally modified token");	
		}

		chain.doFilter(httpreq, httpres);
		}
	}
 
}