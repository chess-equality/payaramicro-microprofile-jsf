package org.chessequality.payaramicro.microprofile.jsf;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 */
@ApplicationPath("/data")
@ApplicationScoped
public class JsfRestApplication extends Application {
}
