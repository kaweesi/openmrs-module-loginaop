package org.openmrs.module.loginaop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.openmrs.User;
import org.springframework.stereotype.Repository;

@Aspect
@Repository("loginaop.LoginAdvice")
public class LoginAdvice {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@AfterReturning(pointcut = "execution(* org.openmrs.api.context.Context.authenticate(..))", returning = "user")
	public void loginAuthenticator(Object user) {
		if (user != null) {
			log.info("::::::::> successful login: " + ((User) user).getUsername());
		} else {
			log.error("::::::::> failed login");
		}
	}
}
