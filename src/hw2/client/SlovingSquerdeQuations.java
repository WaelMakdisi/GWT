package hw2.client;

import hw2.shared.FieldVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;


public class SlovingSquerdeQuations implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final CalcAsync greetingService = GWT
			.create(Calc.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Label errorLabel = new Label();

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel);
		
		final TextBox a = new TextBox();
		horizontalPanel.add(a);
		a.setWidth("35px");
		
		Label lblX = new Label("X^2+");
		lblX.setStyleName("dialogVPanel");
		horizontalPanel.add(lblX);
		
		final TextBox b = new TextBox();
		horizontalPanel.add(b);
		b.setWidth("35px");
		
		 Label lblNewLabel = new Label("+X+");
		lblNewLabel.setStyleName("dialogVPanel");
		horizontalPanel.add(lblNewLabel);
		
		final TextBox c = new TextBox();
		horizontalPanel.add(c);
		c.setWidth("35px");
		
		Label label = new Label("         ");
		horizontalPanel.add(label);
		
		Button btnNewButton = new Button("=");
		horizontalPanel.add(btnNewButton);
		btnNewButton.setSize("37px", "33px");
		
		Label lblNewLabel_1 = new Label("");
		horizontalPanel.add(lblNewLabel_1);
		
		final Label r = new Label("...");
		horizontalPanel.add(r);
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final double a1=Double.valueOf( a.getText());
				final double b1=Double.valueOf( b.getText());
				final double c1=Double.valueOf( c.getText());

				greetingService.ssq(a1, b1, c1, new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
                        r.setText(result);
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				} 
						
						);	
			}
			
		});



	


	}
}
