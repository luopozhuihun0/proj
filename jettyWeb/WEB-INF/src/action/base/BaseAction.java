package action.base;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements Preparable, SessionAware, ServletRequestAware, ServletResponseAware{

	protected SessionMap<String, Object> session;
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	@Override
	public void prepare(){
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.session = (SessionMap<String, Object>) map;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
	
	public String test() {
		request.setAttribute("h", "hello world");
		return SUCCESS;
	}
}
