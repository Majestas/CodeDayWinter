
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class DisplayUtil {

	public static JScrollPane customizeComponentJScrollPane(JScrollPane scrollPane, JPanel viewport){
		scrollPane = new JScrollPane();	
        scrollPane.getVerticalScrollBar().setUnitIncrement(5);
        scrollPane.add(viewport);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(viewport.getWidth(), 300));
        scrollPane.setViewportView(viewport);
		
		return scrollPane;
	}

	
	
	public static Dimension getScreenResolution(){
		return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	}
}
