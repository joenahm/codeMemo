import java.io.*;

public class IOTest {
	public static void main(String[] args){
		String[] arr = new String[3];
		arr[0] = "中国";
		arr[1] = "山东";
		arr[2] = "青岛";

		writeLines("A.txt",arr);
		printRead("A.txt");

		int fileNnm = countFiles("/etc");
		System.out.println("etc目录的文件数为："+fileNnm);

		printLineOfFileInPath("/etc");
	}

	private static void writeLines(String fileName, String[] lineArr){
		File file = new File(fileName);
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			for( String line : lineArr ){
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}

			bufferedWriter.close();
			fileWriter.close();

			System.out.println("写入成功！");
		} catch (IOException e) {
			System.err.println("写入失败！");
			e.printStackTrace();
		}
	}

	private static void printRead(String fileName){
		File file = new File(fileName);
		if( file.exists() ){
			try {
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				System.out.print(bufferedReader.readLine());

				String temp;
				while( (temp=bufferedReader.readLine()) != null ){
					System.out.print("-");
					System.out.print(temp);
				}
				System.out.print("\n");


				bufferedReader.close();
				fileReader.close();
			} catch (IOException e){
				System.err.println("糟糕，文件打开失败了！");
				e.printStackTrace();
			}
		}else{
			System.err.println("文件并不存在嘛！");
		}
	}

	private static int countFiles(String path){
		File directory = new File(path);

		if( directory.isDirectory() ){
			int count = 0;
			File[] files = directory.listFiles();

			for( File file : files ){
				if( file.isFile() ){
					count++;
				}
			}

			return count;
		}else{
			System.err.println("这不是个目录！拒绝统计！");

			return -1;
		}
	}

	private static int countLines(String fileName){
		File file = new File(fileName);
		if( file.exists() ){
			int count = 0;
			try {
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				while( bufferedReader.readLine() != null ){
					count++;
				}

				bufferedReader.close();
				fileReader.close();
			} catch (IOException e){
				System.err.println("糟糕，文件打开失败了！");
//				e.printStackTrace();
			}

			return count;
		}else{
			System.err.println("文件并不存在嘛！");

			return -1;
		}
	}

	private static void printLineOfFileInPath(String path){
		File directory = new File(path);

		if( directory.isDirectory() ){
			File[] files = directory.listFiles();

			for( File file : files ){
				if( file.isFile() ){
					System.out.printf("%30s: %d\n",file.getName(),countLines(path+"/"+file.getName()));
				}
			}
		}else{
			System.err.println("这不是个目录！拒绝统计！");
		}
	}
}
