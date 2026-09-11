public class Experiment {
    private String summary;
    private Measurement[] measurements = new Measurement[10];

    public Experiment() {
        this("New Experiment");
    }

    public Experiment(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void addMeasurement(String note, double value, String unit)  {
        for (int i = 0; i < measurements.length; i++) {
            if (measurements[i] == null) {
                measurements[i] = new Measurement(note, value, unit);
                break;
            }
        }
    }
    public String experimentReport() {
        String result = "\n"+summary+"\nMeasurements:";
        for (int i = 0; i < measurements.length; i++) {
            if (measurements[i] == null) { break; }
            result += "\n\t"+(i+1)+" "+measurements[i].getNote()+"\t"+measurements[i].getValue()+" "+measurements[i].getUnit();
        }
        return result;
    }
}
