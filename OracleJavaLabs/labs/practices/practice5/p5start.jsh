String[] IMPERIAL_UNITS = {"ft","lb","F"};
String[] SI_UNITS = {"s","m","kg","A","K","mol","cd"};
final double ft2m = 0.3048;
final double lb2kg = 0.4536;

String[] notes = {"Is it hot?", "Is it cold?", "Is it heavy?", "Is it long?"};
double[] values = {-43.23, 142.7, 12.52, 36.9};
String[] units = {IMPERIAL_UNITS[2], SI_UNITS[4], IMPERIAL_UNITS[1], IMPERIAL_UNITS[0]};

for (int i = 0; i < values.length; i++) {
    String unit = units[i]; 
    for (String u : IMPERIAL_UNITS) {
        if (u.equals.(unit)) {
            switch(unit) {
                case "ft": 
                    values[i] = values[i]*ft2m; 
                    units[i] = SI_UNITS[1]; 
                    break; 
                case "lb": 
                    values[i] = values[i]*lb2kg; 
                    units[i] = SI_UNITS[2]; 
                    break; 
                case "F": 
                    values[i] = (values[i]-32)*5/9+273.15; 
                    units[i] = SI_UNITS[4];
            }
            break;
        }
    }
}