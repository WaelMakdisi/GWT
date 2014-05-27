package hw2.server;

import hw2.client.Calc;
import hw2.shared.FieldVerifier;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class CalcImpl extends RemoteServiceServlet implements
		Calc {

	@Override
	public String ssq(double a, double b, double c)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		double delta=Math.pow(b, 2)-4*a*c;
        double  []result=new double[2];
        result[0]=(-1*b+Math.sqrt(delta))/(2*a);
        result[1]=(-1*b-Math.sqrt(delta))/(2*a);
		return "x1= "+result[0]+"    ,x2 ="+result[1];
		 
	}

	
}
