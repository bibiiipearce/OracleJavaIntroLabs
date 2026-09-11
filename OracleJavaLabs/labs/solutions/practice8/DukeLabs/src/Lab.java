public class Lab {
    public static void main(String[] args) {
        Experiment e1 = new Experiment();
        e1.addMeasurement("Initial weight",24.57,"kg");
        e1.addMeasurement("Imperial unit check",42,"lb");
        e1.addMeasurement("Quite Cold",-33.6,"F");
        e1.addMeasurement("In a few seconds",4,"s");
        e1.addMeasurement("A few moments later",33,"s");
        e1.addMeasurement("A few more moments later",15,"s");
        e1.addMeasurement("Extra weight",50.4,"kg");
        e1.addMeasurement("0.1 kg of water",5.55,"mol");
        e1.addMeasurement("Electric current",5,"A");
        e1.addMeasurement("Close to 12 lumens",1,"cd");

        Experiment e2 = new Experiment("Measure Distance");
        e2.addMeasurement("Quite close",12.5,"m");
        e2.addMeasurement("Imperial unit check",12.5/0.3048, "ft");
        e2.addMeasurement(null,5,"ft");

        System.out.println(e1.experimentReport());
        System.out.println(e2.experimentReport());

        e1.setSummary("Measured different things");
        System.out.println(e1.experimentReport());

        e1.addMeasurement("Final weight",12,"kg");
        System.out.println(e1.experimentReport());

        e2.addMeasurement("Wrong unit",12.5,"x");
        System.out.println(e2.experimentReport());

//        e2.measurements[0].note = null;
//        System.out.println(e2.experimentReport());
    }
}
