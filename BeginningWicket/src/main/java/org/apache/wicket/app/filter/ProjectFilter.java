package org.apache.wicket.app.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.wicket.protocol.http.WicketFilter;

@WebFilter(value = "/*", initParams = { @WebInitParam(name = "applicationClassName", value ="org.apache.wicket.app.cfg.WicketApplication"),
@WebInitParam(name="filterMappingUrlPattern", value="/*") })
public class ProjectFilter extends WicketFilter {

}
