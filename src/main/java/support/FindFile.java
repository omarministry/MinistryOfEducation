package support;

import java.io.File;
import java.io.FilenameFilter;

public class FindFile {

	private static final String FILE_DIR="" ;
	private static final String FILE_TEXT_EXT="";


	public String listFile(String folder, String ext) {

		String temp=null;
		GenericExtFilter filter = new GenericExtFilter(ext);

		File dir = new File(folder);

		if(dir.isDirectory()==false){
			System.out.println("Directory does not exists : " + FILE_DIR);
		}

		// list out all the file name and filter by the extension
		String[] list = dir.list(filter);

		if (list.length == 0) {
			System.out.println("no files end with : " + ext);

		}

		for (String file : list) {
			temp = new StringBuffer(FILE_DIR).append(File.separator)
					.append(file).toString();
			System.out.println("file : " + temp);
		}
		return temp;
	}

	// inner class, generic extension filter
	public class GenericExtFilter implements FilenameFilter {

		private String ext;

		public GenericExtFilter(String ext) {
			this.ext = ext;
		}

		public boolean accept(File dir, String name) {
			return (name.endsWith(ext));
		}
	}
}
