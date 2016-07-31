package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class PersistentArray {
	private RandomAccessFile file;
	private static final int offsetValue = 8;

	public static void initialize(String arrayFileName, int arraySize, long initialValue) {
		RandomAccessFile file;
		try {
			file = new RandomAccessFile(arrayFileName, "rws");
			file.setLength(arraySize);
			for (int x = 0; x < arraySize; x++) {
				file.seek(x * offsetValue);
				file.writeLong(initialValue);
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public PersistentArray(String arrayFileName) {
		try {
			file = new RandomAccessFile(arrayFileName, "rws");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void set(int index, long value) {
		try {
			file.seek(index * offsetValue);
			file.writeLong(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long get(int index) {
		long value = -1;
		try {
			file.seek(index * offsetValue);
			value = file.readLong();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public long getLength() {
		long value = 0;
		try {
			value = file.length();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public void close() {
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void delete(String arrayFileName) {
		File chosenfile = new File(arrayFileName);
		chosenfile.delete();

	}
}
