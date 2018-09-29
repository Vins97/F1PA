import java.awt.Dimension;
import java.awt.Toolkit;

public class GUIImplementation {
	private Dimension screenSize;

	public GUIImplementation(Dimension screenSize) {
		super();
		this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	public Dimension newScreenSize() {
		return new Dimension((screenSize.width*3/4),(screenSize.height*3/4));
	}
	
}
