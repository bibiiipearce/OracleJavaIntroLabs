String[] IMPERIAL_UNITS = {"ft","lb","F"};
String[] SI_UNITS = {"s","m","kg","A","K","mol","cd"};
final double ft2m = 0.3048;
final double lb2kg = 0.4536;
String[] notes = {"Is it hot?", null, "Is it heavy?", "Is it long?"};
double[] values = {-43.23, 142.7, 12.52, 36.9};
String[] units = {IMPERIAL_UNITS[2], SI_UNITS[4], IMPERIAL_UNITS[1], IMPERIAL_UNITS[0]};
double convertValue(String unit, double value) {return switch(unit) { case "ft" -> value*ft2m; case "lb" -> value*lb2kg; case "F" -> (value-32)*5/9+273.15; default -> value;};}
String convertUnit(String unit){return switch(unit){case "ft" -> SI_UNITS[1]; case "lb" -> SI_UNITS[2]; case "F" -> SI_UNITS[4]; default -> unit;};}
boolean isImperial (String unit) {for (String u : IMPERIAL_UNITS) { if (u.equals(unit)) { return true;}}return false;}
boolean isSI (String unit) {for (String u : SI_UNITS) { if (u.equals(unit)) { return true;}}return false;}
String processMeasurements(String note, double value, String unit){ note = (note == null) ? "no notes" : note; if (isImperial(unit)) { value = convertValue(unit, value); unit = convertUnit(unit);}return note+'\t'+value+unit;}
String measurementsReport = "Measurements:";
for (int i = 0; i < units.length; i++) { measurementsReport += "\n\t"+(i+1)+" "+processMeasurements(notes[i],values[i],units[i]);}
measurementsReport
System.out.println(measurementsReport)
boolean allUnitsSI = true;
int i = 0;
while (i < units.length && (allUnitsSI = isSI(units[i]))) {i++;}
allUnitsSI