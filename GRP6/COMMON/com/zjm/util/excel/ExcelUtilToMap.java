package com.zjm.util.excel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


/**
 * excel读取工具，支持2007和2003版本
 * @author wj
 * @version 1.0
 * @date 2016年10月24日 下午3:39:48 
 * Copyright 杭州融都科技股份有限公司  齐鑫投  All Rights Reserved
 * 官方网站：www.erongdu.com
 * 创新一部：rdc@erongdu.com
 * 未经授权不得进行修改、复制、出售及商业使用
 */
public class ExcelUtilToMap {
	
	/**
	 * 读取excel
	 * @param file,传入文件
	 * @return 返回为list<map>,map中key为title，
	 */
	@SuppressWarnings("rawtypes")
	public static List<Map> readExcel(File file){
		List<Map> list = new ArrayList<Map>();
		try {
			InputStream  fis=new FileInputStream(file);
			 if(! fis.markSupported()) {  
				 fis = new PushbackInputStream(fis, 8);  ;
		        }
		        if(POIFSFileSystem.hasPOIFSHeader(fis)) {  
		            return readExcel2003(fis);  
		        }  
		        if(POIXMLDocument.hasOOXMLHeader(fis)) {  
		            return  readExcel2007(fis);  
		        }  
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return list;
	}
	
	
	
    /** 
     * 读取97-2003格式 
     * @param filePath 文件路径 
     * @throws java.io.IOException 
     */  
    @SuppressWarnings("rawtypes")  
    public static List<Map> readExcel2003(InputStream fis) throws IOException{  
        //返回结果集  
        List<Map> valueList=new ArrayList<Map>();  
        try {  
            HSSFWorkbook wookbook = new HSSFWorkbook(fis);  // 创建对Excel工作簿文件的引用  
            HSSFSheet sheet = wookbook.getSheetAt(0);   // 在Excel文档中，第一张工作表的缺省索引是0  
            int rows = sheet.getPhysicalNumberOfRows(); // 获取到Excel文件中的所有行数­  
            Map<Integer,String> keys=new HashMap<Integer, String>();  
            int cells=0;  
            // 遍历行­（第1行  表头） 准备Map里的key  
            HSSFRow firstRow = sheet.getRow(0);  
            if (firstRow != null) {  
                // 获取到Excel文件中的所有的列  
                cells = firstRow.getPhysicalNumberOfCells();  
                // 遍历列  
                for (int j = 0; j < cells; j++) {  
                    // 获取到列的值­  
                    try {  
                        HSSFCell cell = firstRow.getCell(j);  
                        String cellValue = getCellValue(cell);  
                        keys.put(j,cellValue);                        
                    } catch (Exception e) {  
                        e.printStackTrace();      
                    }  
                }  
            }  
            // 遍历行­（从第二行开始）  
            for (int i = 1; i < rows; i++) {  
                // 读取左上端单元格(从第二行开始)  
                HSSFRow row = sheet.getRow(i);  
                // 行不为空  
                if (row != null) {  
                    //准备当前行 所储存值的map  
                    Map<String, Object> val=new HashMap<String, Object>();  
                      
                    boolean isValidRow = false;  
                    // 遍历列  
                    for (int j = 0; j < cells; j++) {  
                        // 获取到列的值­  
                        try {  
                            HSSFCell cell = row.getCell(j);  
                            String cellValue = getCellValue(cell);  
                            val.put(keys.get(j),cellValue);   
                            if(!isValidRow && cellValue!=null && cellValue.trim().length()>0){  
                                isValidRow = true;  
                            }  
                        } catch (Exception e) {  
                            e.printStackTrace();          
                        }  
                    }  
                    //第I行所有的列数据读取完毕，放入valuelist  
                    if(isValidRow){  
                        valueList.add(val);  
                    }  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally {  
            fis.close();  
        }  
        return valueList;  
    }  

    /** 
     * 读取2007-2013格式 
     * @param filePath 文件路径 
     * @return 
     * @throws java.io.IOException 
     */  
    @SuppressWarnings("rawtypes")  
    public static List<Map> readExcel2007(InputStream fis) throws IOException{  
        List<Map> valueList=new ArrayList<Map>();  
        try {  
            XSSFWorkbook xwb = new XSSFWorkbook(fis);   // 构造 XSSFWorkbook 对象，strPath 传入文件路径  
            XSSFSheet sheet = xwb.getSheetAt(0);            // 读取第一章表格内容  
            // 定义 row、cell  
            XSSFRow row;  
            // 循环输出表格中的第一行内容   表头  
            Map<Integer, String> keys=new HashMap<Integer, String>();  
            row = sheet.getRow(0);  
            if(row !=null){  
                for (int j = row.getFirstCellNum(); j <=row.getPhysicalNumberOfCells(); j++) {  
                    // 通过 row.getCell(j).toString() 获取单元格内容，  
                    if(row.getCell(j)!=null){  
                        if(!row.getCell(j).toString().isEmpty()){  
                            keys.put(j, row.getCell(j).toString());  
                        }  
                    }else{  
                        keys.put(j, "K-R1C"+j+"E");  
                    }  
                }  
            }  
            // 循环输出表格中的从第二行开始内容  
            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) {  
                row = sheet.getRow(i);  
                if (row != null) {  
                    boolean isValidRow = false;  
                    Map<String, Object> val = new HashMap<String, Object>();  
					for (int j = row.getFirstCellNum(); j <= row.getPhysicalNumberOfCells(); j++) {

						XSSFCell cell = row.getCell(j);

						if (cell != null) {
							String cellValue = getCellValue(cell);

							val.put(keys.get(j), cellValue);
							if (!isValidRow && cellValue != null && cellValue.trim().length() > 0) {
								isValidRow = true;
							}
						}
					}
  
                    // 第I行所有的列数据读取完毕，放入valuelist  
                    if (isValidRow) {  
                        valueList.add(val);  
                    }  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally {  
            fis.close();  
        }  
  
        return valueList;  
    }  
      
    /** 
     * 文件操作 获取文件扩展名 
     *  
     * @Author: sunny 
     * @param filename 
     *            文件名称包含扩展名 
     * @return 
     */  
    public static String getExtensionName(String filename) {  
        if ((filename != null) && (filename.length() > 0)) {  
            int dot = filename.lastIndexOf('.');  
            if ((dot > -1) && (dot < (filename.length() - 1))) {  
                return filename.substring(dot + 1);  
            }  
        }  
        return filename;  
    }  
  
    /** -----------上传文件,工具方法--------- */  
    private static final int BUFFER_SIZE = 2 * 1024;  
  
    /** 
     *  
     * @param src 
     *            源文件 
     * @param dst 
     *            目标位置 
     */  
    private static void copy(File src, File dst) {  
        InputStream in = null;  
        OutputStream out = null;  
        try {  
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);  
            out = new BufferedOutputStream(new FileOutputStream(dst),  
                    BUFFER_SIZE);  
            byte[] buffer = new byte[BUFFER_SIZE];  
            int len = 0;  
            while ((len = in.read(buffer)) > 0) {  
                out.write(buffer, 0, len);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (null != in) {  
                try {  
                    in.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (null != out) {  
                try {  
                    out.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
  
    /** 
     * 上传copy文件方法(for MultipartFile) 
     * @param savePath 在linux上要保存完整路径 
     * @param newname 新的文件名称， 采用系统时间做文件名防止中文报错的问题 
     * @throws Exception 
     */  
    public static void copy(MultipartFile file,String savePath,String newname) throws Exception {  
        try {  
            File targetFile = new File(savePath,newname);  
            if (!targetFile.exists()) {  
                //判断文件夹是否存在，不存在就创建  
                targetFile.mkdirs();  
            }  
  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
    }  
      
    /**
     * Excel 97 - 03 版本单元格数据读取
     * @param cell
     * @return
     */
    private static String getCellValue(HSSFCell cell) {  
        DecimalFormat df = new DecimalFormat("#");  
        String cellValue=null;  
        if (cell == null)  
            return null;  
        switch (cell.getCellType()) {  
            case HSSFCell.CELL_TYPE_NUMERIC:  
                if(HSSFDateUtil.isCellDateFormatted(cell)){  
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                    cellValue=sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));  
                    break;  
                }  
                cellValue=df.format(cell.getNumericCellValue());  
                break;  
            case HSSFCell.CELL_TYPE_STRING:           
                cellValue=String.valueOf(cell.getStringCellValue());  
                break;  
            case HSSFCell.CELL_TYPE_FORMULA:  
                cellValue=String.valueOf(cell.getCellFormula());  
                break;  
            case HSSFCell.CELL_TYPE_BLANK:  
                cellValue=null;  
                break;  
            case HSSFCell.CELL_TYPE_BOOLEAN:  
                cellValue=String.valueOf(cell.getBooleanCellValue());  
                break;  
            case HSSFCell.CELL_TYPE_ERROR:  
                cellValue=String.valueOf(cell.getErrorCellValue());  
                break;  
        }  
        if(cellValue!=null&&cellValue.trim().length()<=0){  
            cellValue=null;  
        }  
        return cellValue;  
    }  
    /**
     * Excel 07及以上 版本单元格数据读取
     * @param cell
     * @return
     */
    private static String getCellValue(XSSFCell cell) {  
        DecimalFormat df = new DecimalFormat("#.##");  
        String cellValue=null;  
        if (cell == null)  
            return null;  
        switch (cell.getCellType()) {  
            case XSSFCell.CELL_TYPE_NUMERIC:  
                if(HSSFDateUtil.isCellDateFormatted(cell)){  
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                    cellValue=sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));  
                    break;  
                }  
                cellValue=df.format(cell.getNumericCellValue());  
                break;  
            case XSSFCell.CELL_TYPE_STRING:           
                cellValue=String.valueOf(cell.getStringCellValue());  
                break;  
            case XSSFCell.CELL_TYPE_FORMULA:  
                cellValue=String.valueOf(cell.getCellFormula());  
                break;  
            case XSSFCell.CELL_TYPE_BLANK:  
                cellValue=null;  
                break;  
            case XSSFCell.CELL_TYPE_BOOLEAN:  
                cellValue=String.valueOf(cell.getBooleanCellValue());  
                break;  
            case XSSFCell.CELL_TYPE_ERROR:  
                cellValue=String.valueOf(cell.getErrorCellValue());  
                break;  
        }  
        if(cellValue!=null&&cellValue.trim().length()<=0){  
            cellValue=null;  
        }  
        return cellValue;  
    } 
    
    /**
     * 返回表格头部集合
     * @param file
     * @return
     */
    private static Map<Integer, String> getExcelTitle(File file){
    	Map<Integer, String> titleMap = new HashMap<Integer, String>();
    	try {
			InputStream  fis=new FileInputStream(file);
			 if(! fis.markSupported()) {  
				 fis = new PushbackInputStream(fis, 8);  ;
		        }
		        if(POIFSFileSystem.hasPOIFSHeader(fis)) {  
		            return getTitle2003(fis);  
		        }  
		        if(POIXMLDocument.hasOOXMLHeader(fis)) {  
		            return  getTitle2007(fis);  
		        }  
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
    	return titleMap;
    	
    }
    
    /**
     * 获取2003表格头部
     * @param fis
     * @return
     */
    private static Map<Integer, String> getTitle2003(InputStream fis){
    	Map<Integer,String> keys=new HashMap<Integer, String>();  
    	try {
    		 HSSFWorkbook wookbook = new HSSFWorkbook(fis);  // 创建对Excel工作簿文件的引用  
             HSSFSheet sheet = wookbook.getSheetAt(0);   // 在Excel文档中，第一张工作表的缺省索引是0  
             int cells=0;  
             // 遍历行­（第1行  表头） 准备Map里的key  
             HSSFRow firstRow = sheet.getRow(0);  
             if (firstRow != null) {  
                 // 获取到Excel文件中的所有的列  
                 cells = firstRow.getPhysicalNumberOfCells();  
                 // 遍历列  
                 for (int j = 0; j < cells; j++) {  
                     // 获取到列的值­  
                         HSSFCell cell = firstRow.getCell(j);  
                         String cellValue = getCellValue(cell);  
                         keys.put(j,cellValue);                        
                 }  
             }
		} catch (Exception e) {
			e.printStackTrace();
		}
         return keys;
    }
    
    /**
     * 获取2007表格头部
     * @param fis
     * @return
     */
    private static Map<Integer, String> getTitle2007(InputStream fis){
    	Map<Integer,String> keys=new HashMap<Integer, String>();  
    	try {
    		 XSSFWorkbook xwb = new XSSFWorkbook(fis);   // 构造 XSSFWorkbook 对象，strPath 传入文件路径  
             XSSFSheet sheet = xwb.getSheetAt(0);            // 读取第一章表格内容  
             // 定义 row、cell  
             XSSFRow row;  
             // 循环输出表格中的第一行内容   表头  
             row = sheet.getRow(0);  
             if(row !=null){  
                 for (int j = row.getFirstCellNum(); j <=row.getPhysicalNumberOfCells(); j++) {  
                     // 通过 row.getCell(j).toString() 获取单元格内容，  
                     if(row.getCell(j)!=null){  
                         if(!row.getCell(j).toString().isEmpty()){  
                             keys.put(j, row.getCell(j).toString());  
                         }  
                     }else{  
                         keys.put(j, "K-R1C"+j+"E");  
                     }  
                 }  
             }  
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return keys;
    }
    
    
    
    /**
     * 校验规定的excel头部字段顺序以及字段命名
     * @param file
     * @param strs
     * @return
     */
    public static Map<String, Object> checkExcelTitle(File file ,String[] strs){
    	Map<String, Object> retMap = new HashMap<String, Object>();
    	boolean retFlag = true;
    	Map<Integer, String> titleMap = getExcelTitle(file);
    	for (int i = 0; i < strs.length; i++) {
			String title = titleMap.get(i);
			String checkTitle = strs[i];
			if (!checkTitle.equals(title)) {
				retFlag = false;
				break;
			}
		}
    	retMap.put("result", retFlag);
    	if (!retFlag) {
    		StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < strs.length; i++) {
				buffer.append(strs[i]+"-");
			}
			retMap.put("msg", buffer.toString());
		}
    	return retMap;
    }
    
    
    
    @SuppressWarnings("rawtypes")
	public static void main(String[] args) {
    	File file = new File("D:\\User\\jchen\\Downloads\\导出资产.xls");
    	String[] str = new String[]{"员工姓名","岗位工资","绩效工资"};
    	Map<String, Object> map= checkExcelTitle(file, str);
    	System.out.println("表格头部校验:"+String.valueOf(str));
	}
    
}  

