package pl.pawel.location.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class ReportUtilImpl implements ReportUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportUtilImpl.class);

    @Override
    public void generatePieChart(String path, List<Object[]> data) {
        LOGGER.info("=== Inside generatePieChart() -> path: {}, List: {}", path, data);
        DefaultPieDataset dataset = new DefaultPieDataset();

        for(Object[] objects : data) {
            dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
        }

        JFreeChart chart = ChartFactory.createPieChart3D("Location Type Report", dataset);
        try {
            ChartUtils.saveChartAsJPEG(new File(path+"/pieChart.jpeg"), chart, 300, 300);
        } catch (IOException e) {
            LOGGER.error("=== Exception inside generatePieChart() " + e);
        }
    }
}
