public class Experiment {

    private static int counter;
    private int id;
    private String summary;
    private Measurement[] measurements = new Measurement[10];

    public Experiment() {
        this("New Experiment");
    }

    public Experiment(String summary) {
        id = ++counter;
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void addMeasurement(String note, double value, String unit)  {
        try {
            if (measurements[measurements.length-1] != null) {
                throw new Exception("Error: Too many measurements");
            }
            for (int i = 0; i < measurements.length; i++) {
                if (measurements[i] == null) {
                    measurements[i] = new Measurement(note, value, unit);
                    break;
                }
            }
        }catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public String toString() {
        String result = "\nExperiment #"+id+"\n"+summary+"\nMeasurements:";
        for (int i = 0; i < measurements.length; i++) {
            if (measurements[i] == null) { break; }
            result += "\n\t"+(i+1)+" "+measurements[i];
        }
        return result;
    }
}
