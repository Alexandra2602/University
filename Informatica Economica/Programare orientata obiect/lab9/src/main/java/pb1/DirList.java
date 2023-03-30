/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pb1;
import java.io.*; // pentru functionalitati legate de io
import java.util.*;
import java.util.regex.*;

/**
 *
 * @author alexandra
 */
public class DirList {
public static void main(String[] args) {
File path = new File("."); // creaza un obiect de tip File care reprezinta toate fisierele din directorul curent
String[] list;
if(args.length == 0)
list = path.list();
else
list = path.list(new DirFilter(args[0]));
Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
for(String dirItem : list)
System.out.println(dirItem);
}
}
class DirFilter implements FilenameFilter {
private Pattern pattern;
public DirFilter(String regex) {
pattern = Pattern.compile(regex); // se creaza un pattern din expresia regulata furnizata la intrare
}
public boolean accept(File dir, String name) { // metoda din interfata care trebuie suprascrisa
return pattern.matcher(name).matches();
}
}
