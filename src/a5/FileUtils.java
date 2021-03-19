package a5;

import java.io.File;

public class FileUtils {

	/**
	 * Returns a file (not directory) of the given name located at or within
	 * fileOrDirectory, according to the file's getName() method. If fileOrDirectory
	 * has the given name, it itself is returned. Returns null if no matching file
	 * is found. If multiple files match the given name, any of them may be
	 * returned.
	 *
	 * @param name            the string name of the file to find (not including the
	 *                        file path)
	 * @param fileOrDirectory the file or directory to start searching from
	 * @return a File f located at or within fileOrDirectory that has the provided
	 *         input name, or null if no such file is found.
	 */
	public static File findFile(String name, File fileOrDirectory) {
		// Base case
		if (fileOrDirectory != null) {
			if (fileOrDirectory.getName().equals(name)) {
				return fileOrDirectory;
			}
		}
		// Recursive case
		if (fileOrDirectory != null) {
			if (fileOrDirectory.isDirectory()) {
				for (File f : fileOrDirectory.listFiles()) {
					File myFile = findFile(name, f);
					if (myFile != null) {
						return myFile;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns a file (not directory) located at or within fileOrDirectory that has
	 * been edited most recently, according to the file's lastModified() method. If
	 * fileOrDirectory does not contain any files, returns null If multiple files
	 * were last modified at the same time, any of them may be returned.
	 *
	 * @param fileOrDirectory the file or directory to start searching from
	 * @return a File f located at or within FileOrDirectory which contains the
	 *         largest value of f.lastModified()
	 */
	public static File findLatestFile(File fileOrDirectory) {
		// Base case
		if (fileOrDirectory != null) {
			if (fileOrDirectory.isFile()) {
				return fileOrDirectory;
			}

			// Recursive case
			if (fileOrDirectory.isDirectory()) {
				File[] dir = fileOrDirectory.listFiles();
				if (dir.length == 0) {
					return null;
				}
				File compare = dir[0];
				for (File f : dir) {
					File fileLatest = findLatestFile(f);
					if (fileLatest != null) {
						if (fileLatest.lastModified() > compare.lastModified() || compare.isDirectory()) {
							compare = fileLatest;
						}
					}
				}
				if (compare.isDirectory()) {
					return null;
				} else {
					return compare;
				}
			}
		}
		return null;
	}
}
