package app;

//import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.RandomAccessFile;
import java.net.*;
import java.net.URL;

public class Driver {

	public static void main(String[] args) {
		Driver d = new Driver();
		ArrayList<URL> toVisit = new ArrayList<URL>();
		ArrayList<URL> hasVisited = new ArrayList<URL>();
		VisitAction action = new VisitAction() {
			@Override
			public void Visit(URL url) {
				System.out.println(url);
			}
		};
		String url = "http://shalladay-iis1.student.neumont.edu/";
		// "http://www.cartoonnetwork.com/";
		Crawler c = new Crawler(toVisit, hasVisited, 100, action, url);
		c.crawl();
		String fileName =
		// "hasVisitedCN.bin";
		"hasVisited.bin";
//		array.initialize(fileName, hasVisited.size(), longValue);
		PersistentArray array = new PersistentArray(fileName);
		long longValue = array.hashCode();
		for (int x = 0; x < hasVisited.size(); x++) {
			String site = hasVisited.get(x).toString();
			array.set(x, site.hashCode());

		}
		for (int x = 0; x < array.getLength(); x++) {
			System.out.println((x + 1) + ". " + array.get(x));
		}
		array.close();
	}
}
