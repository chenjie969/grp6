package com.zjm.util;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
/**
 * Function : zip解压缩
 */
public class ZipDecompressing {
	private static final Logger logger = LoggerFactory.getLogger(ZipDecompressing.class);

	static int k = 1; // 定义递归次数变量
	public ZipDecompressing() {}


	/**
	 * 解压缩
	 * @param zipFileName ZIP文件名包含全路径
	 * @param files 文件列表
	 */
	public static List<String> zip(String outPath,File files) {
		List<String> fileList=new ArrayList<>();
		long startTime=System.currentTimeMillis();  
		try {  
			ZipInputStream Zin=new ZipInputStream(new FileInputStream(files));//输入源zip路径  
			BufferedInputStream Bin=new BufferedInputStream(Zin);  
			String Parent=outPath; //输出路径（文件夹目录）  
			File Fout=null;  
			ZipEntry entry;  
			try {  
				while((entry = Zin.getNextEntry())!=null && !entry.isDirectory()){  
					Fout=new File(Parent,entry.getName());  
					if(!Fout.exists()){  
						(new File(Fout.getParent())).mkdirs();  
					}  
					FileOutputStream out=new FileOutputStream(Fout);  
					BufferedOutputStream Bout=new BufferedOutputStream(out);  
					int b;  
					while((b=Bin.read())!=-1){  
						Bout.write(b);  
					}  
					Bout.close();  
					out.close();  
					fileList.add(Fout.getPath());
					System.out.println(Fout+"解压成功");      
				}  
				Bin.close();  
				Zin.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		} catch (FileNotFoundException e) {  
			e.printStackTrace();  
		}  
		long endTime=System.currentTimeMillis();  
		System.out.println("耗费时间： "+(endTime-startTime)+" ms");  
		return fileList;
	}  
	
}