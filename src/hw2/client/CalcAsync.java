package hw2.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface CalcAsync {
	

	void ssq(double a, double b, double c, AsyncCallback<String> callback);
	
	
	
}
