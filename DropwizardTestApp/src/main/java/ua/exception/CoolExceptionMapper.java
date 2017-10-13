package ua.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class CoolExceptionMapper implements ExceptionMapper<CoolException>{

	private static final Logger LOGGER = LoggerFactory.getLogger(CoolException.class);
	

	@Override
	public Response toResponse(CoolException e) {
		LOGGER.warn(e.getMessage());
		return Response.status(e.getStatus()).entity(new Object() {
			private String message = e.getMessage();

			public String getMessage() {
				return message;
			}
			
		}).build();
	}
}
