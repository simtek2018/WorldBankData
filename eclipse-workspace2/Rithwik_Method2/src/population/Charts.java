package population;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class Charts extends JFrame {

	private static final long serialVersionUID = 1L;

	public Charts(ArrayList<WorldBankEntry> data) {
		PieDataset dataset = createDataset(data);
		JFreeChart ch = ChartFactory.createPieChart3D("Populate", dataset);
		ChartPanel chartPanel = new ChartPanel(ch);
		ch.removeLegend();
		chartPanel.setPreferredSize(new Dimension(500, 300));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(chartPanel);
		setVisible(true);
		pack();
		
	}

	private PieDataset createDataset(ArrayList<WorldBankEntry> data) {
		DefaultPieDataset chartData = new DefaultPieDataset();
		
		for (WorldBankEntry k : data) {
			
			chartData.setValue(k.getCountry(), k.getTotPopulation());
		}
		return chartData;
	}
}
