import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class MainTurnGUI {

	protected Shell shell;
	private Text OutText;
	private Text InText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainTurnGUI window = new MainTurnGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(658, 447);
		shell.setText("\u05D4\u05D7\u05DC\u05E4\u05EA \u05DB\u05D9\u05D5\u05D5\u05DF \u05D8\u05E7\u05E1\u05D8");
		
		Label label = new Label(shell, SWT.NONE);
		label.setAlignment(SWT.RIGHT);
		label.setBounds(492, 37, 108, 18);
		label.setText("\u05D4\u05DB\u05E0\u05E1 \u05D8\u05E7\u05E1\u05D8");
		
		OutText = new Text(shell, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.RIGHT | SWT.MULTI);
		OutText.setBounds(34, 91, 196, 196);
		
		InText = new Text(shell, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.RIGHT | SWT.MULTI);
		InText.setBounds(404, 91, 196, 196);
		
		Button TurnText = new Button(shell, SWT.NONE);
		TurnText.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String out = new String();
				String In = InText.getText();
				int ind;
				do  {
					String inTemp;
					ind = In.indexOf("\r\n");
					if (ind > 0)
						inTemp = In.substring(0,ind);
					else
						inTemp = In;				
					String outTemp = new String();
					for (int i=0;i<inTemp.length();i++){
						outTemp = outTemp + inTemp.charAt(inTemp.length()-i-1);
					}
					out = out + outTemp;
					if (ind>0) {
							out = out + "\r\n";
							In = In.substring(ind+2);
					} 
				} while (ind > 0);
				OutText.setText(out);
			}
		});
		TurnText.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.BOLD));
		TurnText.setBounds(262, 159, 108, 40);
		TurnText.setText("\u05D4\u05E4\u05D5\u05DA");

	}
}
