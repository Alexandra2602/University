/**
 * 
 */
package com.services.axis2server;
import java.io.*;

/**
 * @author alexandra
 *
 */
public class RemoteShellService {
private static String OS = System.getProperty("os.name").toLowerCase();
public static String getCommandPrefix() {
if (isWindows())
return "cmd /c ";
else if (isMac() || isUnix() || isSolaris())
return "";
return "";
}
public static boolean isWindows() {
return (OS.indexOf("win") >= 0);
}
public static boolean isMac() {
return (OS.indexOf("mac") >= 0);
}
public static boolean isUnix() {
return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 ||
OS.indexOf("aix") > 0);
}
public static boolean isSolaris() {
return (OS.indexOf("sunos") >= 0);
}
public String test(){
String ret="This works correctly";
try {
return ret;
} catch (Exception e) {
System.out.println(e.getMessage() );
e.printStackTrace();
}
return ret;
}
public String[] executeCommand(String command) {
StringBuffer output = new StringBuffer("");
StringBuffer errors = new StringBuffer("");
try {
Process p = Runtime.getRuntime().exec(getCommandPrefix() +
command);
BufferedReader input = new BufferedReader(new
InputStreamReader(p.getInputStream()));
BufferedReader error = new BufferedReader(new
InputStreamReader(p.getErrorStream()));
String line;
while ((line = input.readLine()) != null) {
output.append(line + "\n");
System.out.println(line);
}
while ((line = error.readLine()) != null) {
errors.append(line);
System.err.println(line);
}
} catch (IOException e1) {
e1.printStackTrace();
}
return new String[] { output.toString(), errors.toString() };
}
}