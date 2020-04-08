package population;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class DisplayCountriesFrm extends JFrame implements ActionListener {
	String[] countriesArr;
	private JList<String> countryLst;
	
	public DisplayCountriesFrm(ArrayList<WorldBankEntry> data) {
		countriesArr = new String[data.size()];
		Container container = getContentPane();
		for (int i=0; i<data.size(); i++) {
			WorldBankEntry cntRow = data.get(i);
			countriesArr[i] = cntRow.getCountry();
		}
		countryLst = new JList<>(countriesArr);
		JPanel centerPnl = new JPanel();
		centerPnl.add(countryLst);
		container.add(centerPnl, BorderLayout.CENTER);
		setSize(400, 500);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		

	}

}
