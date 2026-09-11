String n1 = "Is it cold?", n2 = "Is it heavy?", n3 = "Is it long?";

double v1 = 142.7, v2 = 12.52, v3 = 36.9; 

String u1 = "K", u2 = "kg", u3 = "s";

String m1 = n1+"\t"+v1+" "+u1;

System.out.println(m1);

final double absoluteZero = -459.67;

String m2 = n2+"\t"+v2+" "+u2;

String m3 = n3+"\t"+v3+" "+u3;

int s1 = m1.indexOf(' ');

int s2 = m1.indexOf(' ',s1+1);

int s3 = m1.indexOf(' ',s2+1);

int s4 = m1.indexOf(' ',s3+1);

int t1 = m1.indexOf('\t');

String textValue = m1.substring(t1+1,s3);
v1
m1.substring(0,t1).toUpperCase();
m1
int counter = 0;

String measurementsReport = 
  (++counter)+" "+m1+"\n"+
  (++counter)+" "+m2+"\n"+
  (++counter)+" "+m3+"\n";

System.out.println(measurementsReport);
