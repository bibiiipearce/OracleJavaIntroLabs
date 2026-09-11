public class Measurement {
    final String[] SI_UNITS = {"s","m","kg","A","K","mol","cd"};
    final String[] IMPERIAL_UNITS = {"ft","lb","F"};
    final double ft2m = 0.3048;
    final double lb2kg = 0.4536;
    String note;
    double value;
    String unit;
   void setMeasurementDetails(String note, double value, String unit) {
       this.note = (note == null) ? "No notes" : note;
       if (isSI(unit)) {
           this.unit = unit;
           this.value = value;
       } else {
           if (isImperial(unit)) {
               this.unit = convertUnit(unit);
               this.value = convertValue(unit, value);
           }
       }
   }
    boolean isSI(String unit) {
        for (String u : SI_UNITS) {
            if (u.equals(unit)) {
                return true;
            }
        }
        return false;
    }
    boolean isImperial(String unit) {
        for (String u : IMPERIAL_UNITS) {
            if (u.equals(unit)) {
                return true;
            }
        }
        return false;
    }
    String convertUnit(String unit) {
        return switch(unit) {
            case "ft" -> SI_UNITS[1];
            case "lb" -> SI_UNITS[2];
            case "F" -> SI_UNITS[4];
            default -> unit;
        };
    }
    double convertValue(String unit, double value) {
        return switch(unit) {
            case "ft" -> value*ft2m;
            case "lb" -> value*lb2kg;
            case "F" -> (value-32)*5/9+273.15;
            default -> value;
        };
    }
}

